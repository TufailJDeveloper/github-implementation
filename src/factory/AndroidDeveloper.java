package factory;

public class AndroidDeveloper implements Employee {

	@Override
	public int salary() {
		System.out.println("Get android developer Salary");
		return 50000;
	}

}
