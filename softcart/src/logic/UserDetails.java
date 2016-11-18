package logic;

public class UserDetails {

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Long id;
	private String username,fname,lname,password,email,role;
	private int status;
	
	public int isStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserDetails(Long id, String username,String password, String email, String role) {
		super();
		this.id = id;
		this.username = username;
		
		this.password = password;
		this.email = email;
		this.role = role;
	}
	
	
}
