
public class User {
	public String name;
	public int id;
	public String email;
	public String password;
	public int storeID;
	public String permissions;
	
	public User(String name, int id, String email, String password, int storeID, String permissions) {
		super();
		this.name = name;
		this.id = id;
		this.email = email;
		this.password = password;
		this.storeID = storeID;
		this.permissions = permissions;
	}
	
	public User(){
		super();
	}
	
	public String getPermissions() {
		return permissions;
	}
	
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	
	public int getstoreID() {
		return storeID;
	}
	
	public void setstoreID(int storeID) {
		this.storeID = storeID;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", email=" + email + ", password=" + password + "]";
	}
	
}
