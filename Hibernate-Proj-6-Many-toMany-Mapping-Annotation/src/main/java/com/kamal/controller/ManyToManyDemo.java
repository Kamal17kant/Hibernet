package com.kamal.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kamal.table.Emps;
import com.kamal.table.Projects;

public class ManyToManyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Emps emp1 = new Emps();
		Emps emp2 = new Emps();
		emp1.setEmpId(1234);
		emp1.setEmpName("kamal");
		emp2.setEmpId(1235);
		emp2.setEmpName("kant");

		Projects proj1 = new Projects();
		Projects proj2 = new Projects();
		proj1.setProjId(1232);
		proj1.setProjName("online shopping portal");
		proj2.setProjId(1233);
		proj2.setProjName("faculty profile mgmt");

		List<Emps> emplist = new ArrayList<>();
		List<Projects> projlist = new ArrayList<>();
		emplist.add(emp1);
		emplist.add(emp2);
		projlist.add(proj1);
		projlist.add(proj2);

		emp1.setProject(projlist);
		proj1.setEmploy(emplist);
		Session s = factory.openSession();
		Transaction ts = s.beginTransaction();
		s.save(emp1);
		s.save(emp2);
		s.save(proj1);
		s.save(proj2);
		ts.commit();
		s.close();
		factory.close();
	}
}
