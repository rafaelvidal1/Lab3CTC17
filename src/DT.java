import java.util.ArrayList;
import java.util.List;

public class DT {
	
	
	public static void main(String[] args) {
		Exemplo e1 = new Exemplo("M", "a��o", 19, 0, 4);
		Exemplo e2 = new Exemplo("M", "fic��o", 35, 0, 2);
		Exemplo e3 = new Exemplo("F", "romance", 20, 2, 5);
		Exemplo e4 = new Exemplo("M", "a��o", 50, 0, 3);
		Exemplo e5 = new Exemplo("F", "com�dia", 28, 4, 4);
		
		List<Exemplo> exemplos = new ArrayList<Exemplo>();
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
