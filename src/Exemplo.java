
public class Exemplo {
	String gender;
	String age;
	String occupation;
	String zip;
	String movieid;
	String genres;
	int rate;
	
	Exemplo(String gender,
				String age,
				String occupation,
				String zip,
				String movieid,
				String genres,
				int rate){
		this.gender=gender;
		this.age=age;
		this.occupation=occupation;
		this.zip=zip;
		this.movieid=movieid;
		this.genres=genres;
		this.rate=rate;
	}
	
	public String getAtributeValue(String s) {
		if(s == "gender") return this.gender;
		if(s == "age") return this.age;
		if(s == "ocupation") return this.occupation;
		if(s == "zip") return this.zip;
		if(s == "movieid") return this.movieid;
		if(s == "genres") return this.genres;
		return null;
	}

}
