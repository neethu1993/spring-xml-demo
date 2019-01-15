/**
 * From the master branch of spring-xml-demo repo create a constructor-injection
 * branch.
 * Add constructor to the Actor class to initialize with name and gender, and age
 * Create three beans of type Actor in the bean definition file.
 * Use constructor-based injection in the bean definition file (beans.xml) to inject property values in
 * each of the three beans via name, index, and type respectively.
 * For the Movie bean, use constructor based object injection in the bean definition file
 * (beans.xml) to inject an Actor bean.
 * In the Main class, look up Movie bean using ApplicationContext and print out Author
 * information.
 * Use the same ApplicationContext to again look up the same Movie bean.
 * Print out the equality result of the two Movie beans.
 * System.out.println(beanA==beanB);
 * Change the scope of the Movie bean in beans.xml to prototype and run the application again.
 * Note the output.
 * Replace id of the Movie bean with name having two values, like this:<bean name=”MovieA, MovieB” ........>
 * Update the code in Main to get the Movie bean by its two different name.
 * Push the code to constructor-injection branch.
 */
package com.stackroute;

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

        //Used Application context with name having two values
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Movie movie3 = (Movie)context.getBean("movieA");
        Actor actor3 = movie3.getActor();
        System.out.println(actor3.getName() + " " + actor3.getGender()+ " " + actor3.getAge());

        //Using same context to get beans of other name
        Movie movie4 = (Movie)context.getBean("movieC");
        Actor actor4 = movie4.getActor();
        System.out.println(actor4.getName() + " " + actor4.getGender()+ " " + actor4.getAge());

        //Comparing the objects
        System.out.println(movie3==movie4);

    }
}
