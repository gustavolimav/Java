package execao;

public class ChecadaVsNaoChecada {
	
	public static void main(String[] args) {
		
		geraErro1();
		
		try {
			geraErro2();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("FIM");
	}
	
	
	//Not checked or not verified
	static void geraErro1() {
		throw new RuntimeException("Ocorreu um erro aqui #1");
	}
	
	
	// Exception checked or verified
	static void geraErro2() throws Exception {
		throw new Exception("Ocorreu um erro aqui #2");
	}
	
}
