package com.kamal.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kamal.table.Question;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

public class FeatchMode {
	 
	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Session session=factory.openSession();
		Transaction ts=session.beginTransaction();
		Question q=(Question) session.get(Question.class,123);
		System.out.println(q.getQuestionId());
		System.out.println(q.getQuestion());
		//lazy(by default) to eager loading go to Question class and use - : @OneToMany(mappedBy="question",fetch = FetchType.EAGER)
		//System.out.println(q.getAnswer().size());
		ts.commit();
		session.close();
		factory.close();
	}
}
