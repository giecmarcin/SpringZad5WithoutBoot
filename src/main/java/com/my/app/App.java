package com.my.app;

import com.my.app.dao.PersonDao;
import com.my.app.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Hello world!
 *
 */

@Service
public class App
{


    public static void main( String[] args )
    {

        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        PersonDao personDao = (PersonDao) context.getBean("PersonDao");
        Person p = personDao.savePerson(new Person("da","da"));
        System.out.println(p.getId());

    }
}
