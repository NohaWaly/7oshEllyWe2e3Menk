

public class Userinfo {
	public Integer user_id;
	public String first_name;
	public String last_name;
	public String email;
	public String phone;
	public String address;
	public String password;

	public Userinfo(

			String first_name, String last_name, String email, String phone, String address, String password) {
		// TODO Auto-generated constructor stub
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.phone = phone;
		this.password = password;
		System.out.println("i'm in constructor for signup");

	}

	public Userinfo(String email, String password) {
		this.email = email;
		this.password = password;
		System.out.println("i'm in constructor for login");
	}

}
