package singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Example {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException,
			IOException, ClassNotFoundException, CloneNotSupportedException {

//		Samosa s1=new Samosa();
//		Samosa s2=new Samosa();
//		System.out.println(s1.hashCode());
//		System.out.println(s2.hashCode());
//		Samosa samosa = Samosa.getSamosa();
//		Samosa samosa2 = Samosa.getSamosa();
//	System.out.println(samosa.hashCode());
//		System.out.println(samosa2.hashCode());
////
//		System.out.println(Jalebi.getJalebi().hashCode());
////
//		System.out.println(Jalebi.getJalebi().hashCode());
//		

		/*
		 * Break singleton pattern :1 1.Reflection Api to break Singleton pattern break
		 * singleton pattern. solution: s1->if object is there throw exception inside
		 * constructor. s2->use enum
		 * 
		 * 2.Deserialization solution: s1->implement readResolve method
		 * 
		 * 3.Cloning
		 */

		//// Reflection api to break Singleton pattern :------------->

		// System.out.println(samosa.hashCode());
//		Constructor<Samosa> constructor = Samosa.class.getDeclaredConstructor();
//		constructor.setAccessible(true);
//		Samosa s2 = constructor.newInstance();
//		System.out.println(s2.hashCode());
//		
		// Samosa s1 = Samosa.Instance;
		// Samosa s2 = Samosa.Instance;

//		System.out.println(s1.hashCode());
//		
//		Constructor<Samosa> constructor = Samosa.class.getDeclaredConstructor();
//		constructor.setAccessible(true);
//		Samosa s2 = constructor.newInstance();
//		System.out.println(s2.hashCode());
//		System.out.println(s2.hashCode());

		// deserialization:---------------------->

//		ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("abc.file"));
//		oss.writeObject(samosa);
//		System.out.println("serialization done");
//
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("abc.file"));
//		Samosa s2 = (Samosa) ois.readObject();
//		System.out.println(s2.hashCode());
//
//		Object s3 = samosa.clone();
//		System.out.println(s3.hashCode());

	}

}
