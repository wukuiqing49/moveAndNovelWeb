package com.wu.smybatis.controller;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@RestController
public class FileProcessCotroller {
    @GetMapping("/download")
    public void downLoad(HttpServletResponse response) throws UnsupportedEncodingException, FileNotFoundException {
//        String filename = "Order-1.0.0.1-release.apk";
//        //项目的绝对路径
////        String filePath = ResourceUtils.getURL("classpath:").getPath() + "/app";
//        String filePath = System.getProperty("user.dir") + "/src/main/resources/app";
//        File file = new File(filePath + "/" + filename);

        //服务器方法
        String filename = "Order-1.0.0.1-release.apk";
        String filePath = "/usr/local/workplace/";
        File file = new File(filePath + filename);
        if (file.exists()) {
            response.setContentType("application/octet-stream");
            response.setHeader("content-type", "application/octet-stream");

            //显示进度
            response.setHeader("Content-Length", "" + file.length());
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(filename, "utf8"));

            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                System.out.println("filedown-----------------完成");
            } catch (Exception e) {
                System.out.println("filedown------------------" + e.getMessage());
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        }
    }


    @GetMapping("/download/{apkName}")
    public void downApk(@PathVariable String apkName, HttpServletResponse response) throws UnsupportedEncodingException, FileNotFoundException {
//        String filename = "Order-1.0.0.1-release.apk";
//        //项目的绝对路径
////        String filePath = ResourceUtils.getURL("classpath:").getPath() + "/app";
//        String filePath = System.getProperty("user.dir") + "/src/main/resources/app";
//        File file = new File(filePath + "/" + filename);

        //服务器方法
        String filename = "Order-1.0.0.1-release.apk";
        if (null != apkName && !"".equals(apkName)) {
            filename = apkName;
        }
        String filePath = "/usr/local/workplace/";
        File file = new File(filePath + filename);
        if (file.exists()) {
            response.setContentType("application/octet-stream");
            response.setHeader("content-type", "application/octet-stream");

            //显示进度
            response.setHeader("Content-Length", "" + file.length());
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(filename, "utf8"));

            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                System.out.println("filedown-----------------完成");
            } catch (Exception e) {
                System.out.println("filedown------------------" + e.getMessage());
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        }
    }
}
