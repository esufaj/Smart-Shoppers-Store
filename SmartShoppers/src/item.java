
public class item {

	int itemID;
	String name;
	String size;
	String category;
	double price;
	boolean isItemAvailable;
	int numTimesViewed;
	int aisleNumber;
	Boolean onSale;
	String description;
	
	
	
	public item(int itemID,String name,String size,String category,
			double price,boolean isItemAvailable,int numTimesViewed,int aisleNumber, Boolean onSale, String description) {
		
		this.itemID = itemID;
		this.name = name;
		this.size = size;
		this.category = category;
		this.price = price;
		this.isItemAvailable = isItemAvailable;
		this.numTimesViewed = numTimesViewed;
		this.aisleNumber = aisleNumber;
		this.onSale = onSale;
		this.description = description;
	}
	
	public item() {
		
	}
	
	public int getitemID() {
		return itemID;
	}
	
	public void setitemID(int itemID) {
		this.itemID = itemID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean getisItemAvailable() {
		return isItemAvailable;
	}
	
	public void setItemAvailability(boolean isItemAvailable) {
		this.isItemAvailable = isItemAvailable;
	}
	
	public int getnumTimesViewed() {
		return numTimesViewed;
	}
	
	public void setnumTimesViewed(int numTimesViewed) {
		this.numTimesViewed = numTimesViewed;
	}
	
	public int getAisleNumber() {
		return aisleNumber;
	}
	
	public void setAisleNumber(int aisleNumber) {
		this.aisleNumber = aisleNumber;
	}
	
	public boolean getonSale() {
		return onSale;
	}
	
	public void setonSale(boolean onSale) {
		this.onSale = onSale;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
