
public class Stores {
	
	public int storeid;
	public String name;
	public String address;
	public float distance;
	String opening;
	String closing;
	
	public Stores(int storeid, String name, String address, float distance, String opening, String closing) {
		super();
		this.storeid = storeid;
		this.name = name;
		this.address = address;
		this.distance = distance;
		this.opening = opening;
		this.closing = closing;
	}
	
	public Stores(){
		super();
	}
	
	
	public int getstoreID() {
		return storeid;
	}
	
	public void setstoreID(int storeid) {
		this.storeid = storeid;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}
	
	public String getOpening() {
		return opening;
	}
	
	public void setOpening(String opening) {
		this.opening = opening;
	}
	
	public String getClosing() {
		return closing;
	}
	
	public void setClosing(String closing) {
		this.closing = closing;
	}

}
