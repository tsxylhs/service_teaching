package com.teach.edu.admin.controller;

import com.edu.common.code.model.Result;
import com.edu.common.code.page.PageRequest;
import com.teach.edu.core.entity.Homework;
import com.teach.edu.core.entity.Materials;
import com.teach.edu.core.entity.Myhomework;
import com.teach.edu.core.service.HomeworkService;
import com.teach.edu.core.service.MyhomeworkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Random;
import java.util.UUID;

/**
 * @ClassName MyhomeWorkController
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
@RestController
@Log4j2
@RequestMapping("myhomework")
@Api(value = "用于我的作业逻辑处理")
public class MyhomeWorkController {
    @Autowired
    MyhomeworkService myhomeworkService;
    @Autowired
    HomeworkService homeworkService;

    IdGenerator idGenerator;

    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取信息")
    @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "long")
    public Result get(@PathVariable Long id) {
        return Result.ok(myhomeworkService.get(id));
    }

    @PutMapping("/")
    @ApiOperation(value = "更新我的作业内容")
    @ApiImplicitParam(paramType = "update", name = "Myhomework", required = true, dataType = "homework")
    public Result update(@RequestBody Myhomework homework) {
        return Result.ok(myhomeworkService.update(homework));
    }

    @PostMapping("/list")
    @ApiOperation(value = "获取我的作业列表")
    public Result userList(@RequestBody PageRequest pageRequest) {
        return myhomeworkService.list();
    }

    @PostMapping("/add")
    @ApiOperation(value = "完成上传我的作业")
    public Result add(@RequestParam(value = "file", required = true) MultipartFile file, HttpServletRequest request) {
        Myhomework myhomework = new Myhomework();
        log.info(request.getParameter("userId"));
        myhomework.setUserId(Long.parseLong(request.getParameter("userId")));
        myhomework.setHomeworkId(Long.parseLong(request.getParameter("homeworkId")));
        myhomework.setUserName(request.getParameter("userName"));
        myhomework.setHomeworkDesc(request.getParameter("name"));
        myhomework.setClassName(request.getParameter("className"));
        try {
            if (!file.isEmpty()) {
                String originalFilename = file.getOriginalFilename();
                String fileNameSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
//                统一为小写
                fileNameSuffix = fileNameSuffix.toLowerCase();
                String uuid = UUID.randomUUID().toString();
                String tempFileName = uuid + fileNameSuffix;

//              临时存储路径
                String videoPath = "/tmp/";
//              暂存
                //file.transferTo(new File(videoPath + tempFileName));
//              临时文件
               // File tempFile = new File(videoPath + tempFileName);
                savePic(file.getInputStream(), file.getOriginalFilename());
                String url = videoPath + tempFileName;
                myhomework.setHomeworkUrl(url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
         myhomework.setId(new Random().nextLong());
        myhomeworkService.add(myhomework);
        return Result.ok();
    }
    @GetMapping("/download/{id}")
    @ApiOperation(value = "下载文件")
    public void download(@PathVariable Long id)throws IOException {
        Myhomework myhomework= myhomeworkService.getHomeworkId(id);
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = requestAttributes.getResponse();
        // 设置信息给客户端不解析
        log.info(myhomework.getHomeworkDesc());
        String type = new MimetypesFileTypeMap().getContentType(myhomework.getHomeworkDesc());
        // 设置contenttype，即告诉客户端所发送的数据属于什么类型
        response.setHeader("Content-type","application/msword");
        // 设置编码
        String hehe = new String(myhomework.getHomeworkDesc().getBytes("utf-8"), "iso-8859-1");
        // 设置扩展头，当Content-Type 的类型为要下载的类型时 , 这个信息头会告诉浏览器这个文件的名字和类型。
        response.setHeader("Content-Disposition", "attachment;filename=" + hehe);

        // 发送给客户端的数据
        OutputStream outputStream = response.getOutputStream();
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        // 读取filename
        bis = new BufferedInputStream(new FileInputStream(new File("./tmp/"+myhomework.getHomeworkDesc())));
        int i = bis.read(buff);
        while (i != -1) {
            outputStream.write(buff, 0, buff.length);
            outputStream.flush();
            i = bis.read(buff);
        }


    }


    private void savePic(InputStream inputStream, String fileName) {

        OutputStream os = null;
        try {
            String path = "./tmp";
            // 2、保存到临时文件
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件

            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
