package singleton;

public class Jalebi {

	
//Eager way of creating singleton object      //In eager way static varaibles will initialize first
	//during class loading it will get initialized
	private static Jalebi jalebi = new Jalebi();

	public static Jalebi getJalebi() {
		return jalebi;
	}

}
