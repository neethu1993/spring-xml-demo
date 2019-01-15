package com.stackroute.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
/*BeanPostProcessorDemoBean implements BeanPostProcessor with postProcessBeforeInitialization method and postProcessAfterInitialization method*/
public class BeanPostProcessorDemoBean implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Inside postProcessBeforeInitialization "+ beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Inside postProcessAfterInitialization " + beanName);
        return bean;
    }
}
