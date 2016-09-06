package com.my.app;

import com.my.app.dao.ContactDao;
import com.my.app.dao.PersonDao;
import com.my.app.model.Contact;
import com.my.app.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        PersonDao personDao =  context.getBean("personDaoImpl", PersonDao.class);
        ContactDao contactDao = context.getBean("contactDaoImpl", ContactDao.class);

        String personFirstname = UUID.randomUUID().toString();
        String personLastname = UUID.randomUUID().toString();
        Person person = new Person(personFirstname,personLastname);

        //personDao.savePerson(person);
        List<Contact> contacts = new ArrayList<>();
        for(int i=0; i<3; i++){
            String type = UUID.randomUUID().toString();
            String value = UUID.randomUUID().toString();
            contacts.add(new Contact(type,value));
        }

        Person personFromDb = personDao.savePersonWithContacts(person, contacts);
        System.out.println(personFromDb.toString());
        List<Contact> contactsFromDb = contactDao.findContactByPerson(personFromDb);
        for (Contact c : contactsFromDb){
            System.out.println(c.toString());
        }
    }
}
