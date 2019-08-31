package com.lh.utils;


import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

/**
 * Created by CHLaih on 2018/4/24.
 */
public class FileUploadUtil {


        // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）
        public final static String IMG_PATH_PREFIX = "static/upload/imgs";

        public static File getImgDirFile(){

            // 构建上传文件的存放 "文件夹" 路径
            String fileDirPath = new String("src/main/resources/" + IMG_PATH_PREFIX);

            File fileDir = new File(fileDirPath);
            if(!fileDir.exists()){
                // 递归生成文件夹
                fileDir.mkdirs();
            }
            return fileDir;
        }


}
