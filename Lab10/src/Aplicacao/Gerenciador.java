package Aplicacao;

public class Gerenciador {

	public void met(int[] v) {
		for (int el : v) {
			System.out.print(el + "\n");
		}
	}
	
	public static void main(String args[]) {
		int a[] = new int[5];
		a[0] = 3;
		a[1] = 2;
		//System.out.println(a.length);
		
		Gerenciador ger = new Gerenciador();
//		ger.met(a);
		
		double b = 100 / 3;
		Posicao pos = new Posicao(3, 4);
		System.out.println(String.format("posicao: %s", pos));
		
	}
	
}
