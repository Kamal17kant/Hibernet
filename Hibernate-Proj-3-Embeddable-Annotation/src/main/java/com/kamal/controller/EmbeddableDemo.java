package com.kamal.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kamal.table.Certificate;
import com.kamal.table.Student;

public class EmbeddableDemo {
  public static void main(String[] args) {
	  SessionFactory factory =new Configuration().configure().buildSessionFactory();
	   
	   Student st =new Student();
	   st.setId(111);
	   st.setName("kamal");
	   st.setCity("raniganj");
	   
	   Certificate cft=new Certificate();
	   cft.setCourse("angular");
	   cft.setDuration("2 Month");
	   st.setCerti(cft);
	   
	   Student st2 =new Student();
	   st2.setId(112);
	   st2.setName("kant prakash");
	   st2.setCity("gaya");
	   
	   Certificate cft2=new Certificate();
	   cft2.setCourse("java");
	   cft2.setDuration("1.5 Month");
	   st2.setCerti(cft2);
	   System.out.println(st);
	   System.out.println(st2);
	   Session session=factory.openSession();
	   Transaction ts=session.beginTransaction();
	   session.save(st);
	   session.save(st2);
	   ts.commit();
	   session.close();
	  factory.close();
}
}
