package factory;

//This class will contain Factory methods which will return the employee object based on input
public class EmployeeFactory {

	public static Employee getEmployee(String empType) {
		if (empType.trim().equalsIgnoreCase("Android Developer")) {
			return new AndroidDeveloper();
		} else if (empType.trim().equalsIgnoreCase("Web Developer")) {
			return new WebDeveloper();
		} else
			return null;

	}

}
