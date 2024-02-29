package Prototype;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("creating object using prototype");
		NetworkConnection networkConnection = new NetworkConnection();
		networkConnection.setIp("192.168.4.4");
		networkConnection.loadVeryUmportantData();
		System.out.println(networkConnection);

		//NetworkConnection networkConnection2 = null;
		try {
			NetworkConnection networkConnection2 = (NetworkConnection) networkConnection.clone();
			NetworkConnection networkConnection3 = (NetworkConnection) networkConnection.clone();
		
			System.out.println(networkConnection2);
			System.out.println(networkConnection3);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}

	}

}


