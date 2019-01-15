package com.stackroute.demo;

import org.springframework.beans.factory.InitializingBean;

public class BeanLifecycleDemoBean implements InitializingBean {
    public void afterPropertiesSet() throws Exception {
        System.out.println("Inside afterPropertiesSet");
    }
    public void customInit() throws Exception{
        System.out.println("Inside customInit");
    }
    public void customDestroy() throws Exception{
        System.out.println("Inside customDestroy");
    }
}
