package entiy;

public class User {
	private int id;
	private String username;
	private String pwd;
	private String name;
	private String tel;
	private String gender;
	public User(){
		
	}
	public User(int id, String username, String pwd, String name, String tel,
			String gender) {
		super();
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.name = name;
		this.tel = tel;
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
