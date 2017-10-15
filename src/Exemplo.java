
public class Exemplo {
	String gender;
	String genre;
	String age,occupation;
	int rate;
	
	Exemplo(String gender, String genre, String age, String occupation, int rate){
		this.gender=gender;
		this.genre=genre;
		this.age=age;
		this.occupation=occupation;
		this.rate=rate;
	}
	
	public String getAtributeValue(String s) {
		if(s == "gender") return this.gender;
		if(s == "genre") return this.genre;
		if(s == "age") return this.age;
		if(s == "occupation") return this.occupation;
		return null;
	}

}
