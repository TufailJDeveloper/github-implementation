package Prototype;

public class NetworkConnection implements Cloneable {
	private String ip;
	private String importantData;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getImportantData() {
		return importantData;
	}

	public void setImportantData(String importantData) {
		this.importantData = importantData;
	}

	public void loadVeryUmportantData() throws InterruptedException {
		this.importantData = "very important data";
		Thread.sleep(5000);
		// it will take 5 minutes

	}

	@Override
	public String toString() {
		return this.ip + " : " + this.importantData;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	

}
