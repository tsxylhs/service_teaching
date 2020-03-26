package com.teach.edu.core.service.Imp;

import com.alibaba.fastjson.JSON;
import com.edu.common.code.model.Result;


import com.github.pagehelper.util.StringUtil;
import com.teach.edu.core.entity.WxUser;
import com.teach.edu.core.entity.WxUserExample;
import com.teach.edu.core.mapper.WxUserMapper;
import com.teach.edu.core.service.WxUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * @ClassName WxUserServiceImp
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
@Service
@Log4j2
public class WxUserServiceImp implements WxUserService {
    @Autowired
    WxUserMapper wxUserMapper;




    @Override
    public Result list() {
        WxUserExample example = new WxUserExample();
        WxUserExample.Criteria c = example.createCriteria();
        example.setOrderByClause("created_at desc");
        List<WxUser> WxUserlist = wxUserMapper.selectByExample(example);
        return Result.ok(WxUserlist);
    }

    @Override
    public WxUser get(long id) {
        return wxUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int add(WxUser notes) {
        Date now = new Date();
        notes.setCreatedAt(now);
        notes.setUpdatedAt(now);

        return wxUserMapper.insert(notes);
    }

    @Override
    public int update(WxUser notes) {
        return wxUserMapper.updateByPrimaryKey(notes);
    }

    @Override
    public int delete(long id) {
        return wxUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Result CheckLogin(WxUser wxUser) {
         String WX_AUTH_LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session";// 获取access_token url
          String WX_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo";// 获取用户信息 url
         String WX_APP_ID="wxc3240d4782d531c8";// appId
         String WX_APP_KEY="f3279986025deb60d98626a5520e146b";// AppSecret
        Map<String, Object> outputMap = new HashMap<String,Object>();
        if(StringUtil.isEmpty(wxUser.getCode())) {
            outputMap.put("success", false);
            outputMap.put("msg", "必要参数错误");
            return Result.notFound();
        }
        //获取授权 access_token
        StringBuffer loginUrl = new StringBuffer();
        loginUrl.append(WX_AUTH_LOGIN_URL).append("?appid=")
                .append(WX_APP_ID).append("&secret=")
                .append(WX_APP_KEY).append("&js_code=").append(wxUser.getCode())
                .append("&grant_type=authorization_code");
        System.out.println("-----带有CODE--的URL---"+loginUrl.toString());
        String loginRet = this.httpRequest(loginUrl.toString(),"GET",null);
        System.out.println("返回信息---------"+loginRet);
         JSONObject grantObj= JSON.parseObject(loginRet);
        String errcode = grantObj.getString("errcode");
        if (!StringUtils.isEmpty(errcode))
        {
            log.error("------微信登录错误------"+loginRet);
            outputMap.put("success", false);
            outputMap.put("msg", "登录失败");
            return Result.notFound();
        }
        String openId = grantObj.getString("openid");
        if (StringUtils.isEmpty(openId))
        {
            log.error("------微信登录获取OpenId错误------"+loginRet);
            outputMap.put("success", false);
            outputMap.put("msg", "登录失败");
            return Result.notFound();
        }
        wxUser.setOpenId(openId);
        WxUserExample wxe=new WxUserExample();
       WxUserExample.Criteria c= wxe.createCriteria();
       c.andOpenIdEqualTo(openId);
        long i=wxUserMapper.countByExample(wxe);
        if (i>0){
            return Result.ok(wxUser);
        }else{
            wxUser.setId(new Random().nextLong());
            wxUser.setCreatedAt(new Date());
            wxUser.setUpdatedAt(new Date());
            wxUserMapper.insert(wxUser);
            return Result.ok(wxUser);
        }
    }



    //处理http请求  requestUrl为请求地址  requestMethod请求方式，值为"GET"或"POST"
    public  String httpRequest(String requestUrl,String requestMethod,String outputStr){
        StringBuffer buffer=null;
        try{
            URL url=new URL(requestUrl);
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod(requestMethod);
            conn.connect();
            //往服务器端写内容 也就是发起http请求需要带的参数
            if(null!=outputStr){
                OutputStream os=conn.getOutputStream();
                os.write(outputStr.getBytes("utf-8"));
                os.close();
            }

            //读取服务器端返回的内容
            InputStream is=conn.getInputStream();
            InputStreamReader isr=new InputStreamReader(is,"utf-8");
            BufferedReader br=new BufferedReader(isr);
            buffer=new StringBuffer();
            String line=null;
            while((line=br.readLine())!=null){
                buffer.append(line);
            }
            log.info("[weixin]: do get request({}), and get response({}).", url, buffer.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
        return buffer.toString();
    }



}
