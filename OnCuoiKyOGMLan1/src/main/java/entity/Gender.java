package entity;



public enum Gender {
 Male,
 Female;

	private String gender;
	
	private Gender() {
		// TODO Auto-generated constructor stub
	}

	private Gender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}
 
	
}
