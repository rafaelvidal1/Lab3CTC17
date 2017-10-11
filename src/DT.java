import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DT {
	ArrayList<String> atributos = new ArrayList<String>();
	ArrayList<Exemplo> exemplos = new ArrayList<Exemplo>();
	
	public DT() {
		atributos.add("gender");
		atributos.add("age");
		atributos.add("ocupation");
		atributos.add("genres");
	}
	
	public NohArvore aprendizagemEmArvoreDeDecisao(ArrayList<Exemplo> ex, ArrayList<String> atrib, int m) {
		
		NohArvore noh = new NohArvore();
		if(ex.size() == 0) {
			noh.atributo = "rate";
			noh.resp.add(Integer.toString(m));
			noh.filhos = null;
		}
		if(this.sameRate(ex)) {
			noh.atributo = "rate";
			noh.resp.add(Integer.toString(ex.get(0).rate));
			noh.filhos = null;
		}
		if(atrib.size() == 0) {
			noh.atributo = "rate";
			noh.resp.add(Integer.toString(this.valorDaMaioria(ex)));
			noh.filhos = null;
		}
		
		
		ArrayList<String> atributosAux = new ArrayList<String>();
		ArrayList<Exemplo> exemplosAux = new ArrayList<Exemplo>();
		for(int i = 0; i < atrib.size(); i++) {
			atributosAux.add(atrib.get(i));
		}
		for(int i = 0; i < atrib.size(); i++) {
			exemplosAux.add(ex.get(i));
		}
		return null;
	}
	
	public String escolherAtributo(ArrayList<String> _atributos, ArrayList<Exemplo> _exemplos) {
		double entropia=0;
		String melhor="";
		for(int i = 0; i<_atributos.size();i++) {
			double entropiaAux=0;
			List<String> resp = new ArrayList<String>();
			List<Integer> somaResp = new ArrayList<Integer>();
			for(int j=0 ; j<_exemplos.size();j++) {
				switch(_atributos.get(i)) {
					case "Gender":
						if(resp.contains(_exemplos.get(j).gender)) {
							somaResp.add(resp.indexOf(_exemplos.get(j).gender), somaResp.get(resp.indexOf(_exemplos.get(j).gender))+1);
						}
						else {
							resp.add(_exemplos.get(j).gender);
							somaResp.add(resp.indexOf(_exemplos.get(j).gender), 1);
						}
					case "Genre":
						if(resp.contains(_exemplos.get(j).genre)) {
							somaResp.add(resp.indexOf(_exemplos.get(j).genre), somaResp.get(resp.indexOf(_exemplos.get(j).genre))+1);
						}
						else {
							resp.add(_exemplos.get(j).genre);
							somaResp.add(resp.indexOf(_exemplos.get(j).genre), 1);
						}
					case "Age":
						if(resp.contains(_exemplos.get(j).age)) {
							somaResp.add(resp.indexOf(_exemplos.get(j).age), somaResp.get(resp.indexOf(_exemplos.get(j).age))+1);
						}
						else {
							resp.add(_exemplos.get(j).age);
							somaResp.add(resp.indexOf(_exemplos.get(j).age), 1);
						}
					case "Occupation":
						if(resp.contains(_exemplos.get(j).occupation)) {
							somaResp.add(resp.indexOf(_exemplos.get(j).occupation), somaResp.get(resp.indexOf(_exemplos.get(j).occupation))+1);
						}
						else {
							resp.add(_exemplos.get(j).occupation);
							somaResp.add(resp.indexOf(_exemplos.get(j).occupation), 1);
						}
				}
			}
			
			for(i=0;i<resp.size();i++) {
				entropiaAux=entropiaAux + (-somaResp.get(i)/_exemplos.size())*Math.log(somaResp.get(i)/_exemplos.size());
			}
			
			if(entropiaAux>entropia) {
				entropia=entropiaAux;
				melhor=_atributos.get(i);
			}
		}
		
		return melhor;
		
	}
	
	public int valorDaMaioria(ArrayList<Exemplo> ex) {
		int[] ocor = new int[6];
		for(int i = 0; i < ex.size(); i++) {
			ocor[ex.get(i).rate]++;
		}
		int max = 0, maxval = 0;
		for(int i = 0; i< 6; i++) {
			if(ocor[i] > maxval) {
				max = i;
				maxval = ocor[i];
			}
		}
		return max; 
	}
	
	public boolean sameRate(ArrayList<Exemplo> ex) {
		int aux = ex.get(0).rate;
		for(int i = 1; i < ex.size(); i++)
			if(ex.get(i).rate != aux) return false;
		return true;		
	}
	
	public void lerDoArquivo() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("/home/spider/Programas/Eclipse/Workspace/Lab3CTC17/src/Exemplos.txt"));
		String line;
		while((line = in.readLine()) != null){
		    //System.out.println(line);
		    this.exemplos.add(new Exemplo(line.split(";")[0], 
		    		line.split(";")[3], 
		    		line.split(";")[1], 
		    		line.split(";")[2], 
		    		Integer.parseInt(line.split(";")[4])));
		    //System.out.println(line.split(";")[0]+ line.split(";")[3]+line.split(";")[1]+line.split(";")[2]+Integer.parseInt(line.split(";")[4]));
		}
		in.close();
	}
	
	public static void main(String[] args) throws IOException {
		Exemplo e1 = new Exemplo("M", "a��o", "19", "0", 4);
		Exemplo e2 = new Exemplo("M", "fic��o", "35", "0", 2);
		Exemplo e3 = new Exemplo("F", "romance", "20", "2", 5);
		Exemplo e4 = new Exemplo("M", "a��o", "50", "0", 3);
		Exemplo e5 = new Exemplo("F", "com�dia", "28", "4", 4);
		
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
		
		DT dt = new DT();
		dt.lerDoArquivo();
		
		
	}

}
