package com.teach.edu.core.entityVo;

import com.teach.edu.core.entity.Homework;
import com.teach.edu.core.entity.Myhomework;
import com.teach.edu.core.entity.WxUser;
import com.teach.edu.core.service.WxUserService;
import lombok.Data;

import java.util.List;

/**
 * @ClassName MyhomeworkVo
 * @Author lvhoushuai(tsxylhs @ outlook.com)
 * @Date 2020-03-26
 **/
@Data
public class MyhomeworkVo   {
    private Myhomework myhomeworks;
    private WxUser wxUser;
    private Homework homework;


}
