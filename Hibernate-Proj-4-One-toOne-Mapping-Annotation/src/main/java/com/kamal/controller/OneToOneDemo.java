package com.kamal.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kamal.table.Answer;
import com.kamal.table.Question;

public class OneToOneDemo {
	 
	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Question que=new Question();
		que.setQuestionId(123);
		que.setQuestion("What is java ?");
		
		Answer ans=new Answer();
		ans.setAnswerId(111);
		ans.setAnswer("Java is a high level programming language based On OOP'");
		que.setAnswer(ans);
		
		Session session=factory.openSession();
		Transaction ts=session.beginTransaction();
		session.save(que);
		session.save(ans);
		ts.commit();
		session.close();
		factory.close();
	}
}
