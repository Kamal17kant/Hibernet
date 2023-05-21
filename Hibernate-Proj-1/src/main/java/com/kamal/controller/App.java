package com.kamal.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kamal.table.Address;
import com.kamal.table.Student;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project is running" );
//        Configuration cfg= new Configuration();
//        cfg.configure("hibernate.cfg.xml");
//        SessionFactory factory=cfg.buildSessionFactory();
       SessionFactory factory =new Configuration().configure().buildSessionFactory(); 
       //creating object of student class
       Student st=new Student();
       st.setId(111);
       st.setName("kamal");
       st.setCity("Raniganj");
       System.out.println(st);
       //System.out.println(factory.isClosed());
       //creating Object of Address class
        Address add=new Address();
        add.setStreet("street1");
        add.setCity("Raniganj");
        add.setOpen(true);
        add.setAddedDate(new Date());
        add.setX(1234.233);
        //Reeding image
        FileInputStream fis=new FileInputStream("src/main/java/kamal.jpg"); 
        byte[] data=new byte[fis.available()];
        fis.read(data);
        add.setImage(data);
       Session session=factory.openSession ();
       Transaction ts=session.beginTransaction();
       session.save(st);
       session.save(add);
       ts.commit();
       session.close();
    }
}
