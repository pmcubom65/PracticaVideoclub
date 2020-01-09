package modelo;

public class Miembro {
	
	private String membership_number;
	private String full_names;
	private String gender;
	private String date_of_birth;
	private String physical_address;
	private String postal_address;
	private String contact_number;
	private String email;
	public Miembro(String membership_number, String full_names, String gender, String date_of_birth,
			String physical_address, String postal_address, String contact_number, String email) {
		
		this.membership_number = membership_number;
		this.full_names = full_names;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.physical_address = physical_address;
		this.postal_address = postal_address;
		this.contact_number = contact_number;
		this.email = email;
	}
	
	public Miembro(){}

	public String getMembership_number() {
		return membership_number;
	}

	public void setMembership_number(String membership_number) {
		this.membership_number = membership_number;
	}

	public String getFull_names() {
		return full_names;
	}

	public void setFull_names(String full_names) {
		this.full_names = full_names;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getPhysical_address() {
		return physical_address;
	}

	public void setPhysical_address(String physical_address) {
		this.physical_address = physical_address;
	}

	public String getPostal_address() {
		return postal_address;
	}

	public void setPostal_address(String postal_address) {
		this.postal_address = postal_address;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Miembro [membership_number=" + membership_number + ", full_names=" + full_names + ", gender=" + gender
				+ ", date_of_birth=" + date_of_birth + ", physical_address=" + physical_address + ", postal_address="
				+ postal_address + ", contact_number=" + contact_number + ", email=" + email + "]";
	}
	
	
	

}
