package com.accolite.hibernate_ecommerce;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
 		System.out.println("Product Details:\n");
 		
		Product prod1=new Product();
		System.out.println("ID: ");
		prod1.setPid(sc.nextInt());
		sc.nextLine();			
		System.out.println("\nProduct Name: ");
		prod1.setProductName(sc.nextLine());
		//sc.nextLine();
		
		
		Product prod2=new Product();
		System.out.println("\nID: ");
		prod2.setPid(sc.nextInt());
		sc.nextLine();			
		System.out.println("\nProduct Name: ");
		prod2.setProductName(sc.nextLine());
		//sc.nextLine();
		
 		System.out.println("Categories Details:\n");
 		
		Categories cat1=new Categories();
		System.out.println("\nID: ");
		cat1.setCid(sc.nextInt());
		sc.nextLine();			
		System.out.println("\nCategory Name: ");
		cat1.setCategoryName(sc.nextLine());
		
		Categories cat2=new Categories();
		System.out.println("\nID: ");
		cat2.setCid(sc.nextInt());
		sc.nextLine();			
		System.out.println("\nCategory Name: ");
		cat2.setCategoryName(sc.nextLine());
		
		cat1.setProd(prod1);
		prod1.getCat().add(cat1);
		cat2.setProd(prod2);
		prod2.getCat().add(cat2);
		
			//sc.nextLine();
 		
 		
 		System.out.println("Supplier Details:\n");
		Supplier sup1=new Supplier();
		System.out.println("\nID: ");
		sup1.setSid(sc.nextInt());
		sc.nextLine();			
		System.out.println("\nSupplier Name: ");
		sup1.setSupplierName(sc.nextLine());
			//sc.nextLine();
		Supplier sup2=new Supplier();
		System.out.println("\nID: ");
		sup2.setSid(sc.nextInt());
		sc.nextLine();			
		System.out.println("\nSupplier Name: ");
		sup2.setSupplierName(sc.nextLine());
		
		sup1.getCat().add(cat1);
		sup2.getCat().add(cat2);
		cat1.getSup().add(sup1);
		cat2.getSup().add(sup2);
		
		sup1.getProd().add(prod1);
		sup2.getProd().add(prod2);
		prod1.getSup().add(sup1);
		prod2.getSup().add(sup2);
		
		Configuration con=new Configuration().configure().addAnnotatedClass(Product.class).addAnnotatedClass(Supplier.class).addAnnotatedClass(Categories.class);
 		SessionFactory sf=con.buildSessionFactory();
 		Session session= sf.openSession();
 		Transaction tx=session.beginTransaction();
 		
		session.save(prod1);
		session.save(prod2);
		session.save(sup1);
		session.save(sup2);
		session.save(cat1);
		session.save(cat2);
		tx.commit();
	

 		
    }
}
