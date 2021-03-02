package com.accolite.hibernate_manyToOne;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.accolite.hibernate_manyToOne.Employee1;
import com.accolite.hibernate_manyToOne.Department;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
 		System.out.println("Employee1 Details:\n");
		Employee1 emp1=new Employee1();
		System.out.println("ID: ");
		emp1.setId(sc.nextInt());
		sc.nextLine();
		System.out.println("Name: ");
		emp1.setName(sc.nextLine());
		System.out.println("Designation: ");
		emp1.setDesignation(sc.nextLine());
		
		System.out.println("Department Details:\n");
		Department dept1=new Department();
		System.out.println("Dept ID: ");
		dept1.setDeptId(sc.nextInt());
		sc.nextLine();
		System.out.println("Dept Name: ");
		dept1.setDeptName(sc.nextLine());
		System.out.println("\nAdding..");
		
		emp1.setDept(dept1);
		Configuration con=new Configuration().configure().addAnnotatedClass(Employee1.class).addAnnotatedClass(Department.class);
 		SessionFactory sf=con.buildSessionFactory();
 		Session session= sf.openSession();
 		Transaction tx=session.beginTransaction();
		session.save(emp1);
		session.save(dept1);
		tx.commit();
		
		
		
		
    }
}
