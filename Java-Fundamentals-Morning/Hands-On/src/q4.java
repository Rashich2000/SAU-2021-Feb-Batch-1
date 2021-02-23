import java.io.*; 

class Emp implements Serializable {
	
	private static final long serialversionUID = 129348938L; 
		transient int a; 
		int roll; 
		String fname;
		String lname;
		int age; 
	
		
	public Emp(String fname, String lname, int age, int roll, int a) 
	{ 
			this.fname = fname;
			this.lname=lname;
			this.age = age; 
			this.roll=roll;
			this.a = a; 
	} 

} 

public class q4 { 
	public static void printdata(Emp object1) 
	{ 
		System.out.println("Fname = " + object1.fname); 
		System.out.println("Lname = " + object1.lname); 
		System.out.println("age = " + object1.age); 
		System.out.println("roll = " + object1.roll); 
		System.out.println("a = " + object1.a); 
	} 

	public static void main(String[] args) 
	{ 
		Emp object = new Emp("Rashi","Chhajer", 20, 2, 1000); 
		String filename = "rashi.txt"; 
		// Serialization 
		try { 
			// Saving of object in a file 
			FileOutputStream file = new FileOutputStream(filename); 
			ObjectOutputStream out = new ObjectOutputStream(file); 
			// Method for serialization of object 
			out.writeObject(object); 
			out.close(); 
			file.close();
			System.out.println("Object has been serialized\n"
							+ "Data before Deserialization."); 
			printdata(object); 

			// value of static variable changed 
			//object.b = 2000; 
		} 

		catch (IOException ex) { 
			System.out.println("IOException is caught"); 
		} 

		object = null; 

		// Deserialization 
		try { 

			// Reading the object from a file 
			FileInputStream file = new FileInputStream 
										(filename); 
			ObjectInputStream in = new ObjectInputStream 
										(file); 

			// Method for deserialization of object 
			object = (Emp)in.readObject(); 

			in.close(); 
			file.close(); 
			System.out.println("Object has been deserialized\n" + "Data after Deserialization."); 
			printdata(object); 

			// System.out.println("z = " + object1.z); 
		} 

		catch (IOException ex) { 
			System.out.println("IOException is caught"); 
		} 

		catch (ClassNotFoundException ex) { 
			System.out.println("ClassNotFoundException is caught"); 
		} 
	} 
} 
