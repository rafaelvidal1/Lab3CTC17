import java.util.ArrayList;
import java.util.List;

public class DT {
	
	
	public static void main(String[] args) {
		exemplo e1 = new exemplo("M", "ação", 19, 0, 1999, 4);
		exemplo e2 = new exemplo("M", "ficção", 35, 0, 1995, 2);
		exemplo e3 = new exemplo("F", "romance", 20, 2, 1999, 5);
		exemplo e4 = new exemplo("M", "ação", 50, 0, 1996, 3);
		exemplo e5 = new exemplo("F", "comédia", 28, 4, 1990, 4);
		
		List<exemplo> exemplos = new ArrayList<exemplo>();
		exemplos.add(e1);
		exemplos.add(e2);
		exemplos.add(e3);
		exemplos.add(e4);
		exemplos.add(e5);
		
		List<String> atributos = new ArrayList<String>();
		atributos.add("gender");
		atributos.add("genre");
		atributos.add("age");
		atributos.add("occupation");
		atributos.add("year");
		atributos.add("classifier");
		
		int padrao=3;
		
		
	}

}
