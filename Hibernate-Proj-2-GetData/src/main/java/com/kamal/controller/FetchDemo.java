package com.kamal.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kamal.table.Address;
import com.kamal.table.Student;

public class FetchDemo {
	public static void main(String[] args) {
			
		 SessionFactory factory =new Configuration().configure().buildSessionFactory(); 
		 Session session= factory.openSession();
		 //get data of student id 111
		// Student str=(Student)session.get(Student.class,111);
		 Student str=(Student)session.load(Student.class,111);
		 System.out.println(str);
		 Address add=(Address)session.get(Address.class,1);
		 System.out.println(add.getStreet());
		 System.out.println(add.getCity());
		 System.out.println(add.getAddedDate());
		 session.close();
		 factory.close();
	}
}
