/**
 * From the aware-interface branch of spring-xml-demo repo create a bean-lifecycle
 * branch.
 * Add a BeanLifecycleDemoBean class in com.stackroute.demo that implements
 * InitializingBean and DisposableBean.
 * Override the required methods to print out messages.
 * Define BeanLifecycleDemoBean as a bean in beans.xml.
 * Run the application and observe the result.Add two methods customInit() and customDestroy() to the BeanLifecycleDemoBean
 * class and print out custom messages.
 * In the BeanLifecycleDemoBean bean definition, in beans.xml, set the customInit()
 * and customDestroy() methods to be called.
 * Run the application.
 * Push the code to bean-lifecycle branch.
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

        //Used ApplicationContext for movieB
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Movie movie3 = (Movie)context.getBean("movieB");
        Actor actor3 = movie3.getActor();
        System.out.println(actor3.getName() + " " + actor3.getGender()+ " " + actor3.getAge());

        //Created Another ApplicationContext with beanlifecycledemo and called afterPropertiesSet method inside try-catch block
        ApplicationContext context1 = new ClassPathXmlApplicationContext("beans.xml");
        BeanLifecycleDemoBean beanLifecycleDemoBean = (BeanLifecycleDemoBean)context1.getBean("beanlifecycledemo");
        try {
            beanLifecycleDemoBean.afterPropertiesSet();
        }catch (Exception e){
            System.out.println(e);
        }

        //Call to destroy
        ((ClassPathXmlApplicationContext) context).close();
    }
}
