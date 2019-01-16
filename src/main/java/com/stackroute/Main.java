/**
 * From the bean-lifecycle branch of spring-xml-demo repo create a bean-post-
 * processor branch.
 * Add a BeanPostProcessorDemoBean class in com.stackroute.demo that implements
 * BeanPostProcessor
 * Override the required methods to print out messages.
 * Define BeanLifecycleDemoBean as a bean in beans.xml.
 * Run the application and observe the result.
 * Push the code to bean-post-processor branch.
 */
package com.stackroute;

import com.stackroute.demo.BeanLifecycleDemoBean;
import com.stackroute.domain.Actor;
import com.stackroute.domain.Movie;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main {
    public static void main(String[] args) {

        System.out.println();
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Movie movie3 = (Movie)context.getBean("movieB");
        Actor actor3 = movie3.getActor();
        System.out.println(actor3.getName() + " " + actor3.getGender()+ " " + actor3.getAge());

        //ApplicationContext object with beanlifecycledemo
        ApplicationContext context1 = new ClassPathXmlApplicationContext("beans.xml");
        BeanLifecycleDemoBean beanLifecycleDemoBean = (BeanLifecycleDemoBean)context1.getBean("beanLifeCycleDemo");
        try {
            beanLifecycleDemoBean.afterPropertiesSet();
        }catch (Exception e){
            System.out.println(e);
        }
        ((ClassPathXmlApplicationContext) context).close();
    }
}
