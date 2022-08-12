package modelo;

public class ABB {

	
	private No raiz;

	public ABB() {
		this.setRaiz(null);
	}

	public ABB(No r) {
		this.setRaiz(r);
	}
	
	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

	/**
	 * Percursos
	 */
	
	public void preOrdem() {
		this.preOrdem(getRaiz());
	}
	
	private void preOrdem(No arv) {

		if (arv != null) {

			System.out.println(arv.getChave() + " - " + arv.getValor());
			this.preOrdem(arv.getEsq());
			this.preOrdem(arv.getDir());

		}

	}
	
	public void ordem() {
		this.ordem(getRaiz());
	}

	private void ordem(No arv) {

		if (arv != null) {

			this.ordem(arv.getEsq());
			System.out.println(arv.getChave() + " - " + arv.getValor());
			this.ordem(arv.getDir());

		}

	}
	
	public void posOrdem() {
		this.posOrdem(getRaiz());
	}

	public void posOrdem(No arv) {

		if (arv != null) {

			this.posOrdem(arv.getEsq());
			this.posOrdem(arv.getDir());
			System.out.println(arv.getChave() + " - " + arv.getValor());

		}

	}
	
	/**
	 * Operações na ABB
	 * @param chave
	 * @return No
	 */
	
	public No buscar(int chave) {
		return this.buscar(getRaiz(), chave);
	}

	private No buscar(No arv, int chave) {

		if (arv == null)
			return null;

		else if (arv.getChave() > chave)

			return this.buscar(arv.getEsq(), chave);

		else if (arv.getChave() < chave)

			return this.buscar(arv.getDir(), chave);

		else
			return arv;

	}
	
	public void inserir(int chave, String valor) {
		
		raiz = inserir(this.getRaiz(), chave, valor);
		
		//this.setRaiz(this.inserir(this.getRaiz(), chave, valor));
	}

	private No inserir(No arv, int chave, String valor) {

		if (arv == null) {

			arv = new No(chave, valor);

		} else if (chave < arv.getChave()) // inserir no lado esquerdo

			arv.esq = inserir(arv.getEsq(), chave, valor);
			//arv.setEsq(this.inserir(arv.getEsq(), chave, valor));

		else if (chave > arv.getChave()) // inserir no lado direito

			arv.dir = inserir(arv.getDir(), chave, valor);
			//arv.setDir(this.inserir(arv.getDir(), chave, valor));

		return arv;

	}

	public void remover(int chave) {
		
		this.remover(getRaiz(), chave);
		
	}
	
	// testar todos os casos
	private No remover(No arv, int chave) {

		No temp = null;
		
		if (arv == null)

			return null;

		else if (arv.getChave() > chave)

			arv.esq = remover(arv.getEsq(), chave);
			//arv.setEsq(this.remover(arv.getEsq(), chave));

		else if (arv.getChave() < chave)

			arv.dir = remover(arv.getDir(), chave);
			//arv.setDir(this.remover(arv.getDir(), chave));

		else {
			/* achou o nó a remover */

			/* caso 1: nó sem filhos */
			if (arv.getEsq() == null && arv.getDir() == null) {
				arv = null;
			}
			/* caso 2: nó só tem filho à direita */
			else if (arv.getEsq() == null) {
				temp = arv;
				arv = arv.getDir();
				temp = null;
			}
			/* caso 2: só tem filho à esquerda */
			else if (arv.getDir() == null) {
				temp = arv;
				arv = arv.getEsq();
				temp = null;
			}
			/* caso 3: nó tem os dois filhos */
			else {
				
				temp = arv.getEsq();
				while (temp.getDir() != null) {
					temp = temp.getDir();
				}

				/* 
				 * troca as informações 
				 * */
				arv.setChave(temp.getChave());
				arv.setValor(temp.getValor());
				temp.setChave(chave);
				
				arv.esq = remover(arv.getEsq(), chave);
				//arv.setEsq(this.remover(arv.getEsq(), chave));
			}
		}
		return arv;
	}
}
