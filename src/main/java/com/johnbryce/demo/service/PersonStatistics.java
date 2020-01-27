package com.johnbryce.demo.service;

import com.johnbryce.demo.beans.Person;
import com.johnbryce.demo.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonStatistics {

    @Autowired
    private PersonDAO dao;

    public double avgAge(){
        double result=0;
        int counter=0;
        for(Person p:dao.getAll()){
            counter++;
            result+=p.getAge();
        }
        if(counter==0)
            return 0;
        return result/counter;
    }

    public Person getById(long id){
        return dao.getById(id);
    }
}
