package com.johnbryce.demo.dao;

import com.johnbryce.demo.beans.Forum;
import com.johnbryce.demo.beans.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ForumDAOUnitTest {
    @Autowired
        private ForumDAO repo;

        @Test
        public void testForumAvgAge(){

        	Person p1=new Person();
            p1.setName("Newbe 1");
            p1.setGender("male");
            p1.setAge(-10);

            Person p2=new Person();
            p2.setName("Newbe 2");
            p2.setGender("Female");
            p2.setAge(-10);


            Collection<Person> ppl = new ArrayList<Person>();
            ppl.add(p1);
            ppl.add(p2);


            Forum f = new Forum("New Forum", ppl);
            assertEquals(1,repo.addForum(f));

        }
}
