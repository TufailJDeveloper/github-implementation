package factory;

public class WebDeveloper implements Employee {

	@Override
	public int salary() {
		System.out.println("Get web developers salary");
		return 70000;
	}

}
