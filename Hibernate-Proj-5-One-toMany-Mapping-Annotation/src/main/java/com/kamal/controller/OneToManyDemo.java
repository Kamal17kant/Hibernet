package com.kamal.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kamal.table.Answer;
import com.kamal.table.Question;

public class OneToManyDemo {
	 
	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Question q1=new Question();
		q1.setQuestionId(123);
		q1.setQuestion("What is java ?");
		
		Answer ans1=new Answer();
		ans1.setAnswerId(111);
		ans1.setAnswer("Java is a high level programming language based On OOP'S");
		ans1.setQuestion(q1);
		Answer ans2=new Answer();
		ans2.setAnswerId(112);
		ans2.setAnswer("Java has support collection through which we can perform many operation");
		ans2.setQuestion(q1);
		Answer ans3=new Answer();
		ans3.setAnswerId(113);
		ans3.setAnswer("Java has many frame work");
		ans3.setQuestion(q1);
		List<Answer> list=new ArrayList<>();
		list.add(ans1);
		list.add(ans2);
		list.add(ans3);
		q1.setAnswer(list);
		Session session=factory.openSession();
		Transaction ts=session.beginTransaction();
		session.save(q1);
		session.save(ans1);
		session.save(ans2);
		session.save(ans3);
		ts.commit();
		session.close();
		factory.close();
	}
}
