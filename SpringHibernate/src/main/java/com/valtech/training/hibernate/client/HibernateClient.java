package com.valtech.training.hibernate.client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.valtech.training.hibernate.Account;
import com.valtech.training.hibernate.Address;
import com.valtech.training.hibernate.AtmTx;
import com.valtech.training.hibernate.BankAccount;
import com.valtech.training.hibernate.BankAccountId;
import com.valtech.training.hibernate.ChequeTx;
import com.valtech.training.hibernate.Customer;
import com.valtech.training.hibernate.Employee;
import com.valtech.training.hibernate.Registration;
import com.valtech.training.hibernate.TellerTx;
import com.valtech.training.hibernate.Tx;
import com.valtech.training.hibernate.User;

public class HibernateClient {

	public static void main(String[] args) throws Exception {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
//		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//		cfg.addAnnotatedClass(Employee.class);
//
//		// addAnnotated class returns configuration so it is possible to do
//		cfg.addAnnotatedClass(Tx.class).addAnnotatedClass(ChequeTx.class).addAnnotatedClass(TellerTx.class)
//				.addAnnotatedClass(AtmTx.class);
//		
//		cfg.addAnnotatedClass(Customer.class).addAnnotatedClass(Address.class);
//		cfg.addAnnotatedClass(Account.class);
//		
//		cfg.addAnnotatedClass(Registration.class); //no need to add embedded class
//		
//		cfg.addAnnotatedClass(BankAccount.class);
		cfg.addAnnotatedClass(User.class);
		
		SessionFactory sesFac = cfg.buildSessionFactory();
		Session ses = sesFac.openSession();
		Transaction tr = ses.beginTransaction();
		
		User test = (User) ses.get(User.class, 1);
		System.out.println(test.getFirstName());
//		test.setFirstName("Chandan");
		
		SessionFactory sesFac2 = cfg.buildSessionFactory();
		Session ses2 = sesFac2.openSession();
		Transaction tr2 = ses2.beginTransaction();
		User test2 = (User) ses2.get(User.class, 1);
		System.out.println(test2.getFirstName());

//		ses.persist(new BankAccount(new BankAccountId("Sb",1),30000));
//		BankAccountId id = new BankAccountId("Sb",1);
//		BankAccount bank = (BankAccount) ses.load(BankAccount.class, id);
		
//		ses.persist(new Employee("galeej", df.parse("15-08-1947"), 200000, 'F', false));
		
		
//		ses.save(new Tx(100));
//		ses.save(new ChequeTx(2000,123123,34435));
//		ses.save(new TellerTx(3000,123,345));
//		ses.save(new AtmTx(5000, 789));
//		
//		ses.createQuery("from Tx tx").list().forEach(t -> System.out.println(t));
		
		
//		Customer ct = new Customer("micheal",23);
//		ses.save(ct);
//		Address add = new Address("Mystreet","Mycity", 56069);
//		add.setCustomer(ct);
//		ses.save(add);
//		
//		Account acc = new Account(56000.5, "savings");
//		Tx tx1 = new Tx(1000);
//		Tx tx2 = new ChequeTx(2000,123123,34435);
//		Tx tx3 = new TellerTx(3000,123,345);
//		Tx tx4 = new  AtmTx(5000, 789);
//		
//		Account acc1 = new Account(1000,"CA");
//		Tx tx5 = new ChequeTx(3000,24134,44545);
//		
//		Customer cust1 = new Customer("Ted",25);
//		Address add1  = new Address("Jayanagar","Bengaluru",560050);
//		Customer cust2 = new Customer("Peppa",30);
//		Address add2= new Address("French Town","Pondicherry",847484);
//		ses.persist(acc);
//		ses.persist(tx1);
//		ses.persist(tx2);
//		ses.persist(tx3);
//		ses.persist(tx4);
//		
//		ses.persist(cust1);
//		ses.persist(cust2);
//		ses.persist(tx5);
//		ses.persist(acc1);
//		ses.persist(add1);
//		ses.persist(add2);
//
//		acc.addTx(tx1);
//		acc.addTx(tx2);
//		acc.addTx(tx3);
//		acc.addTx(tx4);
//		
//		acc1.addTx(tx5);
//		acc1.addCustomer(cust2);
//		acc.addCustomer(cust2);
//		acc.addCustomer(cust1);
//		acc.addTx(tx5);
//		acc1.addCustomer(cust1);
//		
//		add1.setCustomer(cust1);
//		add2.setCustomer(cust2);
//		cust1.setAddress(add1);
//		cust2.setAddress(add2);
		
		//QUERYING
//		ses.createQuery("select tx from Tx tx").list().forEach(t -> System.out.println(t));
//		ses.createQuery("select distinct(tx.account) from Tx tx").list().forEach(t -> System.out.println(t));
//		Query query = ses.createQuery("SELECT DISTINCT c FROM Customer c join c.accounts a join a.tx t where t.amount = ? ");
//		query.setFloat(0, 3000);
//		query.list().forEach(t -> System.out.println(t));
		
		
		
//		Query query = ses.getNamedQuery("Tx.findAllByCityAndAmountGreaterThan");
//		//Query query = ses.createQuery("select t from Tx t join t.account.customers c where c.address.city = ? and t.amount > ?");
//		query.setString(0, "Bengaluru");
//		query.setFloat(1,1000);
//		query.list().forEach(t -> System.out.println(t));
		
		tr.commit();
		ses.close();
		sesFac.close();
		
		tr2.commit();
		ses2.close();
		sesFac2.close();

	}
}
