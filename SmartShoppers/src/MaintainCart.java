import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainCart {
	
	
	public ArrayList<Cart> cartitems = new ArrayList<Cart>();
	public String path;
	
	
	public void load(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			Cart cart = new Cart();
			//int quantity = 0;
			//name,id,email,password
			cart.setitemID(Integer.valueOf(reader.get("itemID")));
			cart.setName(reader.get("name"));
			cart.setSize(reader.get("size"));
			cart.setCategory(reader.get("category"));
			cart.setPrice(Double.valueOf(reader.get("price")));
			cart.setItemAvailability(Boolean.parseBoolean(reader.get("isitemavailable")));
			cart.setnumTimesViewed(Integer.valueOf(reader.get("numtimesviewed")));
			cart.setAisleNumber(Integer.valueOf(reader.get("aislenumber")));
			cart.setonSale(Boolean.parseBoolean(reader.get("onsale")));
			cart.setDescription((reader.get("description")));
			cart.setQuantity(Integer.parseInt(reader.get("quantity")));
			cartitems.add(cart);
		}
	}
	
	
	public void update(String path) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
				//name,id,email,password
				csvOutput.write("itemID");
				csvOutput.write("name");
		    	csvOutput.write("size");
				csvOutput.write("category");
				csvOutput.write("price");
				csvOutput.write("isitemavailable");
				csvOutput.write("numtimesviewed");
				csvOutput.write("aislenumber");
				csvOutput.write("onsale");
				csvOutput.write("description");
				csvOutput.write("quantity");
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(Cart c: cartitems){
				   
				
					csvOutput.write(String.valueOf(c.getitemID()));
					csvOutput.write(c.getName());
					csvOutput.write(c.getSize());
					csvOutput.write(c.getCategory());
					csvOutput.write(String.valueOf(c.getPrice()));
					csvOutput.write(String.valueOf(c.getisItemAvailable()));
					csvOutput.write(String.valueOf(c.getnumTimesViewed()));
					csvOutput.write(String.valueOf(c.getAisleNumber()));
					csvOutput.write(String.valueOf(c.getonSale()));
					csvOutput.write(c.getDescription());
					csvOutput.write(String.valueOf(c.getQuantity()));
					
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
	
	
	/*public void writeheaders(String path) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
				//name,id,email,password
				csvOutput.write("itemID");
				csvOutput.write("name");
		    	csvOutput.write("size");
				csvOutput.write("category");
				csvOutput.write("price");
				csvOutput.write("isitemavailable");
				csvOutput.write("numtimesviewed");
				csvOutput.write("aislenumber");
				csvOutput.write("onsale");
				csvOutput.write("description");
				csvOutput.write("quantity");
				csvOutput.endRecord();

				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}*/
	public static void main(String [] args) throws Exception{
		//String path = "C:\\Users\\PC\\Desktop\\user.csv";
		//MaintainUser maintain = new MaintainUser();
	
		//maintain.load(path);
		//for(User u: maintain.users){
		//	System.out.println(u.toString());
		//}
		
		//User newUser = new User("username", 1, "email@email.com", "password", 1, "Customer");
		//maintain.users.add(newUser);
		
		//maintain.update(path);
	}
}
