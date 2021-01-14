package com.copysun.eureka.eurekaserver;

import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author CopySun
 * @date 2020/12/25 11:18
 * @Description
 */
public class Demo {

    public static void main(String[] args) {
        Demo demo=new Demo();
        InputStream inputStream = demo.getClass().getResourceAsStream("/pipeNetworkProcess.zip");
        byte[] bytes = new byte[0];
        try {
            bytes = FileCopyUtils.copyToByteArray(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = Base64Utils.encodeToString(bytes);
        System.out.println(s);
    }

}
