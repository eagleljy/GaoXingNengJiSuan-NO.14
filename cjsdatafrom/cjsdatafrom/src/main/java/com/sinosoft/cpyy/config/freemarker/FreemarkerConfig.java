package com.sinosoft.cpyy.config.freemarker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.annotation.PostConstruct;

/**
 * 创建时间：2018/六月/05
 *
 * @author 卢俊宇[lujunyu@sinosoft.com.cn]
 * 类名：FreemarkerConfig
 * 描述：FreemarkerConfig
 */
@Configuration
public class FreemarkerConfig {
    private final org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver resolver;

    @Autowired
    public FreemarkerConfig(FreeMarkerViewResolver resolver) {
        this.resolver = resolver;
    }

    @PostConstruct
    public void setSharedVariable() {
        resolver.setSuffix(".ftl");
        resolver.setCache(false);
        resolver.setRequestContextAttribute("request");
        resolver.setOrder(0);
        resolver.setExposeRequestAttributes(true);
        resolver.setExposeSessionAttributes(true);
    }
}
