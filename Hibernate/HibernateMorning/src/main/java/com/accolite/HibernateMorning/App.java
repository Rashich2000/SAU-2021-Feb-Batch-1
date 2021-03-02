package com.accolite.HibernateMorning;


import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


class MyException extends Exception{
	String exception_message;
	MyException(String em) {
		this.exception_message=em;
	}
	public String toString(){ 
		return ("Exception: "+this.exception_message);
	 }
}

public class App 
{
    public static void main( String[] args )
    {
    	
    	Scanner sc = new Scanner(System.in);
    	int choice;
    	
    	do {
    	System.out.println("Choices:\n1.Add Employee\n2.Update Employee By Id\n3.Delete Employee (Cannot be recovered once deleted)\n4.Get All Employee\n5.Get Employee by ID\n6.Exit\nEnter your Choice: ");
    	choice=sc.nextInt();
    	Configuration con=new Configuration().configure().addAnnotatedClass(Employee.class);
 		SessionFactory sf=con.buildSessionFactory();
 		Session session= sf.openSession();
 		Transaction tx=session.beginTransaction();
 		
 		switch(choice) {
 		case 1: Employee emp=new Employee();
 				try {
 					sc.nextLine();
 					
 					System.out.println("ID: ");
 					emp.setId(sc.nextInt());
 					sc.nextLine();
 					
 					
 					System.out.println("First Name: ");
 					emp.setFname(sc.nextLine());
 					//sc.nextLine();
 					
 					System.out.println("Last Name: ");
 					emp.setLname(sc.nextLine());
 					
 					System.out.println("Date of Birth: ");
 					emp.setDoB(sc.nextLine());
 					
 					System.out.println("Enter Age(2 digits) ");
 					int age=sc.nextInt();
 					sc.nextLine();
 					
 					int length = String.valueOf(age).length();
 					if(length<2 || length>2) {
 						throw new MyException("Age should be 2 digits");
 					}
 					else {
 						emp.setAge(age);
 					}
 					
 					System.out.println("Salary: ");
 					emp.setSalary(sc.nextInt());
 					sc.nextLine();
 					
 					System.out.println("Designation");
 					emp.setDesignation(sc.nextLine());
 					
 					System.out.println("\nProcessing..\n");
 					
 				}
 				catch(MyException exp){
 			 		System.out.println(exp) ;
 				}
 				session.save(emp);
 				tx.commit();
 				break;
 		case 2:
 			System.out.println("Employee to Update? ");
 			int id1=sc.nextInt();
 			System.out.println("Update:\n1.First Name\n2.Last Name\n3.DOB\n4.Age\n5.Salary\n6.Designation\nEnter Choice: ");
 			int choice_update=sc.nextInt();	
 			sc.nextLine();
 			switch(choice_update)
        	{
        		case 1:
        			System.out.println("Change First Name to: ");
        			String fnameNew=sc.nextLine();
        			Query q1 = session.createQuery("Update Employee e SET e.fname=:fnameNew where e.id=:id1");
        			q1.setParameter("fnameNew",fnameNew);
        			q1.setParameter("id1", id1);
        			q1.executeUpdate();
        			System.out.println("First Name updated.");
        			tx.commit();
            		break;
            	
        		case 2:
        			System.out.println("Change Last Name to: ");
        			String lnameNew=sc.nextLine();
        			Query q2 = session.createQuery("Update Employee SET lname=:lnameNew where id=:id1");
        			q2.setParameter("lnameNew",lnameNew);
        			q2.setParameter("id1", id1);
        			q2.executeUpdate();
        			System.out.println("Last Name updated.");
        			tx.commit();
            		break;
            		
        		case 3:
        			System.out.println("Change Date of Birth to: ");
        			String dobNew=sc.nextLine();
        			Query q3 = session.createQuery("Update Employee SET DoB=:dobNew where id=:id1");
        			q3.setParameter("dobNew",dobNew);
        			q3.setParameter("id1", id1);
        			q3.executeUpdate();
        			System.out.println("Date of Birth updated.");
        			tx.commit();
            		break;
            	
        		case 4:
        			System.out.println("Change Age to: ");
        			Integer ageNew=sc.nextInt();
        			sc.nextLine();
        			Query q4 = session.createQuery("Update Employee SET age=:ageNew where id=:id1");
        			q4.setParameter("ageNew",ageNew);
        			q4.setParameter("id1", id1);
        			q4.executeUpdate();
        			System.out.println("Age updated.");
        			tx.commit();
            		break;
            		
        		case 5:
        			System.out.println("Change Salary to: ");
        			Integer salaryNew=sc.nextInt();
        			sc.nextLine();
        			Query q5 = session.createQuery("Update Employee SET salary=:salaryNew where id=:id1");
        			q5.setParameter("salaryNew",salaryNew);
        			q5.setParameter("id1", id1);
        			q5.executeUpdate();
        			System.out.println("Salary updated.");
        			tx.commit();
            		break;
        		case 6:
        			System.out.println("Change Designation to: ");
        			String designationNew=sc.nextLine();
        			Query q6 = session.createQuery("Update Employee SET designation=:designationNew where id=:id1");
        			q6.setParameter("designationNew",designationNew);
        			q6.setParameter("id1", id1);
        			q6.executeUpdate();
        			System.out.println("Designation updated.");
        			tx.commit();
            		break;
     			
        		default:
        			System.out.println("Invalid Choice. Try again.");
        			break;	
        	}
        	System.out.println("\n");
            break;
 		case 3:
 			System.out.println("Employee to Remove? ");
 			int id2=sc.nextInt();
			sc.nextLine();
			Query qdel = session.createQuery("Delete from Employee where id= :id2");
			qdel.setParameter("id2",id2);
			qdel.executeUpdate();
    		System.out.println("Deleted.");
    		tx.commit();
    		System.out.println("\n");
            break;
 		case 4:
 			System.out.println("All Employees:\n");
 			Query qsel=session.createQuery("from Employee");
 			List<Employee> emplist=qsel.getResultList();
 			for(Employee e:emplist) {
 				System.out.println(e);
 			}
 			System.out.println("\n");
 			break;
 		case 5:
        	//Employee fetchedID=null;
        	System.out.println("Enter ID whose records to be fetched");
            int id3=sc.nextInt();
            sc.nextLine();
        	Employee emp_=(Employee) session.get(Employee.class, id3);
        	System.out.println(emp_.toString());
        	System.out.println("\n");
        	break;
 			
 		case 6:
 			break;
 		default:
            System.out.println("Invalid choice!");
            exit(0);
    	
    	}
    	}while(choice!=6);
    	
    	
    }

	private static void exit(int i) {
		// TODO Auto-generated method stub
		
	}
}
