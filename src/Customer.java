/**
* @author Brett Allen
* @created Jan 19, 2017, at 4:27:38 PM
* */

package application;

public class Customer {
	
	//Main account information
	private String username;
	private String email;
	private String password;
	
	//Customer demographics
	private String firstName;
	private String lastName;
	private int age;
	
	//Customer residence information
	private String streetAddress;
	private String city;
	private String state;
	private String country;
	
	//Customer phone numbers
	private String homePhone;
	private String mobilePhone;
	private String workPhone;
	private String faxNumber;
	
	public Customer(){
		username = "BallenDev";
		firstName = "Brett";
		lastName = "Allen";
		age = 22;
		streetAddress = "123 Main Street";
		city = "Columbia";
		state = "Maryland";
		country = "United States";
		homePhone = "410-381-7482";
		mobilePhone = "443-812-0896";
		workPhone = "410-318-2700";
		faxNumber = "410-123-4567";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	
	/**
	 * Resets all of the customer's attributes to null (initial state)
	 * Meant to be called when the customer has logged out and the customer's data should
	 * be erased from memory
	 * */
	public void reset(){
		username = "";
		firstName = "";
		lastName = "";
		age = 0;
		streetAddress = "";
		city = "";
		state = "";
		country = "";
		homePhone = "";
		mobilePhone = "";
		workPhone = "";
		faxNumber = "";
	}
}
