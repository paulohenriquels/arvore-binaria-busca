package testes;

import modelo.ABB;
import modelo.No;

public class TestaABB {

	public static void main(String[] args) {
		
		ABB abb = new ABB();
		
		abb.inserir(11, "Lápis");
		abb.inserir(6, "Borracha");
		abb.inserir(13, "Caderno");
		abb.inserir(4, "Apontador");
		abb.inserir(9, "Corretivo");
		abb.inserir(17, "Caneta");
		abb.inserir(7, "Copo");
		abb.inserir(10, "Chilito");
		abb.inserir(16, "Cocada");
		
		abb.preOrdem();
		
		System.out.println("\n== Busca pela chave 10 ===");
		No x = abb.buscar(10);
		
		if(x != null) {
			System.out.println("Chave encontrada: " + 
					x.getChave() + 
					" - " + 
					x.getValor());
		}
		else{
			System.out.println("Chave não encontrada");
		}
		
		System.out.println("\n== Busca pela chave 99 ===");
		x = abb.buscar(99);
		
		if(x != null) {
			System.out.println("Chave encontrada: " + 
					x.getChave() + 
					" - " + 
					x.getValor());
		}
		else{
			System.out.println("Chave não encontrada");
		}
		
		System.out.println("\n== Remover chave 11 ==");
		
		abb.remover(11);
		
		System.out.println("\nNova árvore:");
		abb.preOrdem();
		
	}

}
