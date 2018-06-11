package com.sinosoft.cpyy;

import com.sinosoft.cpyy.config.fastjson.FastJsonAutoTypeConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 创建时间：2018/六月/05
 *
 * @author 卢俊宇[lujunyu@sinosoft.com.cn]
 * 类名：Application
 * 描述：SpringBoot启动类
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 添加 FastJson 的 autoType 白名单
     */
    @Bean
    public FastJsonAutoTypeConfig fastJsonAutoTypeConfig() {
        return new FastJsonAutoTypeConfig("com.sinosoft.cpyy.model");
    }
}
