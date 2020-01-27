package com.johnbryce.demo;

import com.johnbryce.demo.beans.Forum;
import com.johnbryce.demo.beans.Person;
import com.johnbryce.demo.dao.ForumDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);


        //PersonDAO personDAO = ctx.getBean(PersonDAO.class);
//        ForumDAO forumDAO = ctx.getBean(ForumDAO.class);
//
//        Forum f1 = new Forum("John Bryce", Arrays.asList(new Person("Eden", 40), new Person("Kobi", 32)));
//
//        Forum f2 = new Forum("BMC Group", Arrays.asList(new Person("Moshe", 29), new Person("Dave", 51),
//                new Person("Gil", 29), new Person("Yevgeni", 28), new Person("Itzik", 38)));
//
//        forumDAO.addForum(f1);
//        forumDAO.addForum(f2);


        System.out.println("Go");

    }

}
