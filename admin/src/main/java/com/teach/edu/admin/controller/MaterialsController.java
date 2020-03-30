package com.teach.edu.admin.controller;

import com.edu.common.code.model.Result;
import com.edu.common.code.page.PageRequest;
import com.teach.edu.admin.model.NoteVo;
import com.teach.edu.core.entity.Materials;
import com.teach.edu.core.entity.Myhomework;
import com.teach.edu.core.service.MaterialsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Random;
import java.util.UUID;

/**
 * @ClassName MaterialsController
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-24
 **/
@RestController
@Log4j2
@RequestMapping("materials")
@Api(value = "用于学习资料的逻辑处理")
public class MaterialsController {
    @Autowired
    MaterialsService materialsService;

    IdGenerator idGenerator;

    @GetMapping("/{id}")
    @ApiOperation(value = "根据Id获取信息")
    @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "long")
    public Result get(@PathVariable Long id) {
        return Result.ok(materialsService.get(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "更新资料")
    @ApiImplicitParam(paramType = "update", name = "Materials", required = true, dataType = "materials")
    public Result update(@RequestBody Materials materials) {
        return Result.ok(materialsService.update(materials));
    }

    @PostMapping("/add")
    @ApiOperation(value = "完成上传我的资料")
    public Result add(@RequestParam(value = "file", required = true) MultipartFile file, HttpServletRequest request) {
        Materials matterials = new Materials();
        log.info(request.getParameter("userId"));

        try {
            if (!file.isEmpty()) {
                String originalFilename = file.getOriginalFilename();
                String fileNameSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
//                统一为小写
                fileNameSuffix = fileNameSuffix.toLowerCase();
                String uuid = UUID.randomUUID().toString();
                String tempFileName = uuid + fileNameSuffix;
                matterials.setMaterialsDesc(originalFilename);
//              临时存储路径
                String videoPath = "/tmp/";
//              暂存
                //file.transferTo(new File(videoPath + tempFileName));
//              临时文件
                // File tempFile = new File(videoPath + tempFileName);
                savePic(file.getInputStream(), file.getOriginalFilename());
                String url = videoPath + tempFileName;
                matterials.setMaterialsUrl(url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        matterials.setId(new Random().nextLong());
        materialsService.add(matterials);
        return Result.ok();
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除资料")
    @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "long")
    public Result Delete(@PathVariable Long id) {
        return Result.ok(materialsService.delete(id));
    }


    @PostMapping("/list")
    @ApiOperation(value = "获取作业列表")
    public Result userList(@RequestBody PageRequest pageRequest) {
        return materialsService.list();
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
