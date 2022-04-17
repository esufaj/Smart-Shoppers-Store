import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainLogins {
	public ArrayList<User> logins = new ArrayList<User>();
	public String path;
	
	public void load(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			User user = new User();
			//name,id,email,password
			user.setName(reader.get("name"));
			user.setId(Integer.valueOf(reader.get("id")));
			user.setEmail(reader.get("email"));
			user.setPassword(reader.get("password"));
			user.setstoreID(Integer.valueOf(reader.get("storeID")));
			user.setPermissions(reader.get("permissions"));
			logins.add(user);
		}
	}
	
	
	public void update(String path) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
				//name,id,email,password
				csvOutput.write("name");
				csvOutput.write("id");
		    	csvOutput.write("email");
				csvOutput.write("password");
				csvOutput.write("storeID");
				csvOutput.write("permissions");
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(User u: logins){
					csvOutput.write(u.getName());
					csvOutput.write(String.valueOf(u.getId()));
					csvOutput.write(u.getEmail());
					csvOutput.write(u.getPassword());
					csvOutput.write(String.valueOf(u.getstoreID()));
					csvOutput.write(u.getPermissions());
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	public static void main(String [] args) throws Exception{
		String path = "C:\\Users\\PC\\Desktop\\logins.csv";
		MaintainLogins maintain = new MaintainLogins();
	
		maintain.load(path);
		for(User u: maintain.logins){
			System.out.println(u.toString());
		}
		
		User newUser = new User("username", 1, "email@email.com", "password", 1,"Customer");
		maintain.logins.add(newUser);
		
		maintain.update(path);
	}
}
