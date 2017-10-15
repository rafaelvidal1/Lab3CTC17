import java.io.BufferedReader;
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
		atributos.add("zip");
		atributos.add("movieid");
		atributos.add("genres");
	}

	public NohArvore aprendizagemEmArvoreDeDecisao(ArrayList<Exemplo> ex, ArrayList<String> atrib, int padrao) {

		NohArvore noh = new NohArvore();
		if (ex.size() == 0) {
			noh.atributo = "rate";
			noh.resp.add(Integer.toString(padrao));
			noh.filhos = null;
			return noh;
		}
		if (this.sameRate(ex)) {
			noh.atributo = "rate";
			noh.resp.add(Integer.toString(ex.get(0).rate));
			noh.filhos = null;
			return noh;
		}
		if (atrib.size() == 0) {
			noh.atributo = "rate";
			noh.resp.add(Integer.toString(this.valorDaMaioria(ex)));
			noh.filhos = null;
			return noh;
		}

		ArrayList<String> atributosAux = new ArrayList<String>();
		ArrayList<Exemplo> exemplosAux = new ArrayList<Exemplo>();
		for (int i = 0; i < atrib.size(); i++) {
			atributosAux.add(atrib.get(i));
		}
		for (int i = 0; i < ex.size(); i++) {
			exemplosAux.add(ex.get(i));
		}

//		System.out.println(atributosAux.size());
//		System.out.println(exemplosAux.size());
//
		String melhor = escolherAtributo(atributosAux, exemplosAux);

		System.out.println("O melhor é " + melhor);

		atributosAux.remove(atributosAux.indexOf(melhor));

		// for(int i = 0; i < atributosAux.size(); i++) {
		// System.out.println(atributosAux.get(i));
		// }

		noh.atributo = melhor;
		int m = valorDaMaioria(exemplosAux);
		ArrayList<Exemplo> exemplotemp;

		while (!exemplosAux.isEmpty()) {
			exemplotemp = new ArrayList<Exemplo>();
			String vi = exemplosAux.get(0).getAtributeValue(melhor);
			System.out.println(vi);
			int i = 0;
			while (i < exemplosAux.size()) {
//				 System.out.println(exemplosAux.get(i).getAtributeValue(melhor)+" "+vi);
//				 System.out.println(i);
				if (exemplosAux.get(i).getAtributeValue(melhor).contentEquals(vi)) {
//					System.out.println("*******************************************************************************");
//					System.out.println(exemplosAux.get(i).getAtributeValue(melhor) + "|    |" + vi + "|" + i);
//					System.out.println("Entrou");
					exemplotemp.add(exemplosAux.remove(i));
					// i=0;
				} else {
					i++;
				}
			}
//			System.out.println("Saiu " + i + "   " + exemplosAux.size());
			NohArvore subarvore = new NohArvore();
			subarvore = aprendizagemEmArvoreDeDecisao(exemplotemp, atributosAux, m);
			noh.filhos.add(subarvore);
		}
		return noh;
	}

	public String escolherAtributo(ArrayList<String> _atributos, ArrayList<Exemplo> _exemplos) {
		String melhor = "";
		List<String> respGender = new ArrayList<String>();
		List<Integer> somaRespGender = new ArrayList<Integer>();

		List<String> respAge = new ArrayList<String>();
		List<Integer> somaRespAge = new ArrayList<Integer>();

		List<String> respOcupation = new ArrayList<String>();
		List<Integer> somaRespOcupation = new ArrayList<Integer>();

		List<String> respZip = new ArrayList<String>();
		List<Integer> somaRespZip = new ArrayList<Integer>();

		List<String> respMovieId = new ArrayList<String>();
		List<Integer> somaRespMovieId = new ArrayList<Integer>();

		List<String> respGenres = new ArrayList<String>();
		List<Integer> somaRespGenres = new ArrayList<Integer>();

		boolean gender = _atributos.contains("gender");
		boolean age = _atributos.contains("age");
		boolean ocupation = _atributos.contains("ocupation");
		boolean zip = _atributos.contains("zip");
		boolean movieid = _atributos.contains("movieid");
		boolean genres = _atributos.contains("genres");

		for (int j = 0; j < _exemplos.size(); j++) {
			// System.out.println(j);
			if (gender)
				if (respGender.contains(_exemplos.get(j).getAtributeValue("gender"))) {
					int i = respGender.indexOf(_exemplos.get(j).getAtributeValue("gender"));
					somaRespGender.add(i, somaRespGender.get(i) + 1);
				} else {
					respGender.add(_exemplos.get(j).getAtributeValue("gender"));
					somaRespGender.add(1);
				}
			if (age)
				if (respAge.contains(_exemplos.get(j).getAtributeValue("age"))) {
					int i = respAge.indexOf(_exemplos.get(j).getAtributeValue("age"));
					somaRespAge.add(i, somaRespAge.get(i) + 1);
				} else {
					respAge.add(_exemplos.get(j).getAtributeValue("age"));
					somaRespAge.add(1);
				}
			if (ocupation)
				if (respOcupation.contains(_exemplos.get(j).getAtributeValue("ocupation"))) {
					int i = respOcupation.indexOf(_exemplos.get(j).getAtributeValue("ocupation"));
					somaRespOcupation.add(i, somaRespOcupation.get(i) + 1);
				} else {
					respOcupation.add(_exemplos.get(j).getAtributeValue("ocupation"));
					somaRespOcupation.add(1);
				}
			if (zip)
				if (respZip.contains(_exemplos.get(j).getAtributeValue("zip"))) {
					int i = respZip.indexOf(_exemplos.get(j).getAtributeValue("zip"));
					somaRespZip.add(i, somaRespZip.get(i) + 1);
				} else {
					respZip.add(_exemplos.get(j).getAtributeValue("zip"));
					somaRespZip.add(1);
				}
			if (movieid)
				if (respMovieId.contains(_exemplos.get(j).getAtributeValue("movieid"))) {
					int i = respMovieId.indexOf(_exemplos.get(j).getAtributeValue("movieid"));
					somaRespMovieId.add(i, somaRespMovieId.get(i) + 1);
				} else {
					respMovieId.add(_exemplos.get(j).getAtributeValue("movieid"));
					somaRespMovieId.add(1);
				}
			if (genres)
				if (respGenres.contains(_exemplos.get(j).getAtributeValue("genres"))) {
					int i = respGenres.indexOf(_exemplos.get(j).getAtributeValue("genres"));
					somaRespGenres.add(i, somaRespGenres.get(i) + 1);
				} else {
					respGenres.add(_exemplos.get(j).getAtributeValue("genres"));
					somaRespGenres.add(1);
				}
		}

		double entropiaAux = 0;
		double size = _exemplos.size();
		if (gender) {
			double entropiaAuxGender = 0;
			for (int j = 0; j < respGender.size(); j++) {
				double p = somaRespGender.get(j) / size;
				entropiaAuxGender += (-p) * Math.log(p);
			}
			if (entropiaAux <= entropiaAuxGender) {
				entropiaAux = entropiaAuxGender;
				melhor = "gender";
			}
		}
		if (age) {
			double entropiaAuxAge = 0;
			for (int j = 0; j < respAge.size(); j++) {
				double p = somaRespAge.get(j) / size;
				entropiaAuxAge += (-p) * Math.log(p);
			}
			if (entropiaAux <= entropiaAuxAge) {
				entropiaAux = entropiaAuxAge;
				melhor = "age";
			}
		}
		if (ocupation) {
			double entropiaAuxOcupation = 0;
			for (int j = 0; j < respOcupation.size(); j++) {
				double p = somaRespOcupation.get(j) / size;
				entropiaAuxOcupation += (-p) * Math.log(p);
			}
			if (entropiaAux <= entropiaAuxOcupation) {
				entropiaAux = entropiaAuxOcupation;
				melhor = "ocupation";
			}
		}
		if (zip) {
			double entropiaAuxZip = 0;
			for (int j = 0; j < respZip.size(); j++) {
				double p = somaRespZip.get(j) / size;
				entropiaAuxZip += (-p) * Math.log(p);
			}
			if (entropiaAux <= entropiaAuxZip) {
				entropiaAux = entropiaAuxZip;
				melhor = "zip";
			}
		}
		if (movieid) {
			double entropiaAuxMovieId = 0;
			for (int j = 0; j < respMovieId.size(); j++) {
				double p = somaRespMovieId.get(j) / size;
				entropiaAuxMovieId += (-p) * Math.log(p);
			}
			if (entropiaAux <= entropiaAuxMovieId) {
				entropiaAux = entropiaAuxMovieId;
				melhor = "movieid";
			}
		}
		if (genres) {
			double entropiaAuxGenres = 0;
			for (int j = 0; j < respGenres.size(); j++) {
				double p = somaRespGenres.get(j) / size;
				entropiaAuxGenres += (-p) * Math.log(p);
			}
			if (entropiaAux <= entropiaAuxGenres) {
				entropiaAux = entropiaAuxGenres;
				melhor = "genres";
			}
		}
		return melhor;
	}

	public int valorDaMaioria(ArrayList<Exemplo> ex) {
		int[] ocor = new int[6];
		for (int i = 0; i < ex.size(); i++) {
			ocor[ex.get(i).rate]++;
		}
		int max = 0, maxval = 0;
		for (int i = 0; i < 6; i++) {
			if (ocor[i] > maxval) {
				max = i;
				maxval = ocor[i];
			}
		}
		return max;
	}

	public boolean sameRate(ArrayList<Exemplo> ex) {
		int aux = ex.get(0).rate;
		for (int i = 1; i < ex.size(); i++)
			if (ex.get(i).rate != aux)
				return false;
		return true;
	}

	public void lerDoArquivo() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("/home/spider/git/Lab3CTC17/src/Exemplos.dat"));
		String line;
		while ((line = in.readLine()) != null) {
			// System.out.println(line);
			this.exemplos.add(new Exemplo(line.split(";")[2], line.split(";")[3], line.split(";")[4],
					line.split(";")[5], line.split(";")[1], line.split(";")[6], Integer.parseInt(line.split(";")[7])));
			// System.out.println(line.split(";")[0]+
			// line.split(";")[3]+line.split(";")[1]+line.split(";")[2]+Integer.parseInt(line.split(";")[4]));
		}
		in.close();
	}

	public static void main(String[] args) throws IOException {
		// Exemplo e1 = new Exemplo("M", "a��o", "19", "0", 4);
		// Exemplo e2 = new Exemplo("M", "fic��o", "35", "0", 2);
		// Exemplo e3 = new Exemplo("F", "romance", "20", "2", 5);
		// Exemplo e4 = new Exemplo("M", "a��o", "50", "0", 3);
		// Exemplo e5 = new Exemplo("F", "com�dia", "28", "4", 4);
		//
		// List<Exemplo> exemplos = new ArrayList<Exemplo>();
		// exemplos.add(e1);
		// exemplos.add(e2);
		// exemplos.add(e3);
		// exemplos.add(e4);
		// exemplos.add(e5);
		//
		// List<String> atributos = new ArrayList<String>();
		// atributos.add("gender");
		// atributos.add("genre");
		// atributos.add("age");
		// atributos.add("occupation");
		// atributos.add("year");
		// atributos.add("classifier");

		int padrao = 3;

		DT dt = new DT();
		dt.lerDoArquivo();
		NohArvore n = dt.aprendizagemEmArvoreDeDecisao(dt.exemplos, dt.atributos, padrao);
		System.out.println("Terminou");

	}

}
