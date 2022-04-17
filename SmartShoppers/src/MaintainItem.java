import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainItem {
	public ArrayList<item> items = new ArrayList<item>();
	public String path;
	
	public void load(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			item item = new item();
			//name,id,email,password
			item.setitemID(Integer.valueOf(reader.get("itemID")));
			item.setName(reader.get("name"));
			item.setSize(reader.get("size"));
			item.setCategory(reader.get("category"));
			item.setPrice(Double.valueOf(reader.get("price")));
			item.setItemAvailability(Boolean.parseBoolean(reader.get("isitemavailable")));
			item.setnumTimesViewed(Integer.valueOf(reader.get("numtimesviewed")));
			item.setAisleNumber(Integer.valueOf(reader.get("aislenumber")));
			item.setonSale(Boolean.parseBoolean(reader.get("onsale")));
			item.setDescription((reader.get("description")));
			items.add(item);
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


				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(item i: items){
					csvOutput.write(String.valueOf(i.getitemID()));
					csvOutput.write(i.getName());
					csvOutput.write(i.getSize());
					csvOutput.write(i.getCategory());
					csvOutput.write(String.valueOf(i.getPrice()));
					csvOutput.write(String.valueOf(i.getisItemAvailable()));
					csvOutput.write(String.valueOf(i.getnumTimesViewed()));
					csvOutput.write(String.valueOf(i.getAisleNumber()));
					csvOutput.write(String.valueOf(i.getonSale()));
					csvOutput.write(i.getDescription());
					
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	public static void main(String [] args) throws Exception{
		String path = "C:\\Users\\PC\\Desktop\\items.csv";
		MaintainItem maintain = new MaintainItem();
	
		maintain.load(path);
		
		
		//User newUser = new User("username", 1, "email@email.com", "password", 1);
		//maintain.users.add(newUser);
		
		//maintain.update(path);
	}
}
