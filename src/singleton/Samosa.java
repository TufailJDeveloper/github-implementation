package singleton;

import java.io.Serializable;

public class Samosa implements Serializable {
//	private static Samosa samosa;
//
//	private Samosa() {
//		 if(samosa!=null) {
//		
	//	throw new RuntimeException("you are trying to break singleton pattern");
		// }

	}

	// lazy way of creating singleton object
//	public static Samosa getSamosa() {
//		if (samosa == null) {
//			samosa = new Samosa();
//
//		}
//		return samosa;

		////// t1 t2

//	public static Samosa getSamosa() {
//		if (samosa == null) {
//			synchronized (Samosa.class) {
//				samosa = new Samosa();
//
//			}
//
//		}
//		return samosa;
//
//	}
//

//	}
//}

//	public Object readResolve() {
//		return samosa;
//	}
//
//	@Override
//	public Object clone() throws CloneNotSupportedException {
//		return samosa;
//
//	}
//}



/*
 * 1.Constructor private 2.create Object with the help of method 3.create field
 * to store object is private
 * 
 * 
 */
