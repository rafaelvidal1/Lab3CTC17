import java.util.ArrayList;

public class NohArvore {
	String atributo;
	ArrayList<String> resp;
	ArrayList<NohArvore> filhos;
	public NohArvore() {
		this.atributo = null;
		this.resp = new ArrayList<String>();
		this.filhos = new ArrayList<NohArvore>();
	}
	
}
