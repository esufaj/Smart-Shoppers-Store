import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainStore {
	public ArrayList<Stores> stores = new ArrayList<Stores>();
	public String path;
	
	public void load(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			Stores store = new Stores();
			store.setstoreID(Integer.valueOf(reader.get("storeid")));
			store.setName(reader.get("name"));
			store.setAddress(reader.get("address"));
			store.setDistance(Float.valueOf(reader.get("distance")));
			store.setOpening(reader.get("opening"));
			store.setClosing(reader.get("closing"));
			stores.add(store);
		}
	}
	
	
	public void update(String path) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
				
				csvOutput.write("storeid");
				csvOutput.write("name");
		    	csvOutput.write("address");
				csvOutput.write("distance");
				csvOutput.write("opening");
				csvOutput.write("closing");
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(Stores s: stores){
					csvOutput.write(String.valueOf(s.getstoreID()));
					csvOutput.write(s.getName());
					csvOutput.write(s.getAddress());
					csvOutput.write(String.valueOf(s.getDistance()));
					csvOutput.write(s.getOpening());
					csvOutput.write(s.getClosing());
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public Stores getStoreByID(int storeid) {
		for(Stores s: stores) {
			if(s.getstoreID() == storeid) {
				return s;
			}
		}
		return null;
	}
	public static void main(String [] args) throws Exception{
		//String path = "C:\\Users\\PC\\Desktop\\user.csv";
		//MaintainStore maintain = new MaintainStore();
	
		//maintain.load(path);
		//for(User u: maintain.users){
		////	System.out.println(u.toString());
		//}
		
		//User newUser = new User("username", 1, "email@email.com", "password", 1, "Customer");
		////maintain.users.add(newUser);
		
		//maintain.update(path);
	}
}
