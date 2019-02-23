package com.lg.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

//import org.springframework.util.ClassUtils;

/**
 * @类名称: FileUtil
 * @作者: 段聪祺
 * @创建时间: 2018/10/31 16:24
 * @说明: 图片上传删除
 */
@Slf4j
@Component
public class FileUtil {
    /** 要保存的文件名 */
    protected static String prefix;
    /** 服务器本地保存路径 */
    protected static String picPath;
    /** 后缀 */
    protected static String suffix;
    /** 图片上传位置 */
    //private final static String UPLOADPATH = "static/Data/upload/tpsc/";
    private  static String upLoadPath;
    @Value("${yqb.upload.path}")
    public void setUpLoadPath(String uploadpath){
        upLoadPath = uploadpath;
    }
    /**
     * @作者: 段聪祺
     * @功能描述: 获取上传文件的保存名称、服务器本地保存路径、后缀，拼接成文件地址
     * @时间: 2018/11/1 9:32
     * @参数:
     * @返回值: java.lang.String
     **/
    public  static String getPicNamePathSuffix(HttpServletRequest request) {
        // 根据系统时间生成上传后保存的文件名
        long now = System.currentTimeMillis();
        prefix = String.valueOf(now);
        //获取项目名路径
       // String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        //获取配置文件中图片上传到的位置
        //picPath = path + upLoadPath + DateUtil.dateTo8String(new Date()) + "/";
        picPath =  upLoadPath + DateUtil.dateTo8String(new Date()) + "/";
        // 根据真实路径创建目录文件
        File picSaveFile = new File(picPath);
        if (!picSaveFile.exists()) {
            try {
                picSaveFile.mkdirs();
            } catch (Exception e) {
                log.error(e.getLocalizedMessage(), e);
            }
        }
        // 文件的后缀
        suffix = ".jpg";
        return picPath + prefix + suffix;
    }
    /**
     * @作者: 段聪祺
     * @功能描述: 图片上传并返回图片地址
     * @时间: 2018/11/1 10:19
     * @参数:  * @param file
     * @返回值: java.lang.String
     **/
    public static String fileUpload(MultipartFile img,HttpServletRequest request){
        if (!img.isEmpty()) {
            try {
                String fileNamess = getPicNamePathSuffix(request);
                //创建文件
                File file = new File(fileNamess);
                //通过流的形式复制文件
                FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
                //返回文件地址
                //return fileNamess.substring(fileNamess.lastIndexOf("D"));
                return fileNamess.substring(fileNamess.lastIndexOf("s")+1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
