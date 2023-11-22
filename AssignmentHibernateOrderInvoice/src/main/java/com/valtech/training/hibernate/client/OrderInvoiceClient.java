package com.valtech.training.hibernate.client;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.valtech.training.hibernate.assignment.Address;
import com.valtech.training.hibernate.assignment.Customers;
import com.valtech.training.hibernate.assignment.Items;
import com.valtech.training.hibernate.assignment.ItemsVendors;
import com.valtech.training.hibernate.assignment.OrderDescription;
import com.valtech.training.hibernate.assignment.Orders;
import com.valtech.training.hibernate.assignment.Vendors;

public class OrderInvoiceClient {

	public static void main(String[] args) throws Exception {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		cfg.addAnnotatedClass(Customers.class).addAnnotatedClass(Address.class).addAnnotatedClass(Vendors.class);
		cfg.addAnnotatedClass(Items.class);
		cfg.addAnnotatedClass(Orders.class);
		cfg.addAnnotatedClass(OrderDescription.class);
		
		
		SessionFactory sesFac = cfg.buildSessionFactory();
		Session ses = sesFac.openSession();
		Transaction tr = ses.beginTransaction();
		
		Customers cus1 = new Customers(1,"micheal","micheal@mail.com",23,"9485948556");
		
		Orders order1 = new Orders(1,df.parse("23-10-2023"));
		
		Address add = new Address("Lake street","Bengaluru","Karnataka", 560069);
		Address add2 = new Address("Brigade street","Mumbai","Maharashtra", 480001);
		Address add3 = new Address("27 North street","Hydrabad","Telangana", 610001);
		Address add4 = new Address("Mg Road","Kolar","Karnataka",540003);
		
		Items item1 = new Items(1,"Smart Tv","Smart Plasma TV, built in Alexa",60000);
		Items item2= new Items(2,"Smart Phone","The foldable smartphone",95090);
		Items item3 = new Items(3,"Orange Cake","Small delicious cakes",20);
		
		Vendors vendor1 = new Vendors(1,"Reliance");	
		Vendors vendor2 = new Vendors(2,"Britania");
		Vendors vendor3 = new Vendors(3,"Nestle");

		OrderDescription od1 = new OrderDescription(1,order1,item1,3);

		//Orders -> Customers
		cus1.addOrders(order1);
		//Address -> Customers
		cus1.setAddress(add);
		//Address -> Vendors
		vendor1.setAddress(add2);
		vendor2.setAddress(add3);
		vendor3.setAddress(add4);
		//Items -> Vendors
		vendor2.addItems(item2);
		vendor2.addItems(item3);
		
		
		ses.persist(cus1);
		ses.persist(add);
		ses.persist(add2);
		ses.persist(add3);
		ses.persist(add4);
		ses.persist(vendor1);
		ses.persist(vendor2);
		ses.persist(vendor3);
		ses.persist(add2);
		ses.persist(item1);
		ses.persist(item2);
		ses.persist(item3);
		ses.persist(order1);
		ses.persist(od1);
		
		
		System.out.println("Loading");
		tr.commit();
		ses.close();
		sesFac.close();
		
		//QUERYING
//		ses.createQuery("select items from Items items").list().forEach(it -> System.out.println(it));

	}
}
