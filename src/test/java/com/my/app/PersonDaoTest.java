package com.my.app;

import com.my.app.dao.ContactDao;
import com.my.app.dao.PersonDao;
import com.my.app.model.Contact;
import com.my.app.model.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by Marcin on 05.09.2016.
 */
@Service
public class PersonDaoTest {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private ContactDao contactDao;

    @Test
    public void testSavePerson(){
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        System.out.println(context);
        contactDao.saveContact(new Contact("32","32"));
        //Person p = personDao.savePerson(new Person("32","321"));
       // System.out.println(p.getId());
    }
}
