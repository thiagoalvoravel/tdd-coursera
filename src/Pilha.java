public class Pilha {
	
	private Object[] elementos;
	private int quantidade = 0;

	public Pilha(int maximo) {
		this.elementos = new Object[maximo];
	}

	public boolean estaVazia() {
		return (this.quantidade == 0);
	}
	
	public boolean estaCheia() {
		return (this.quantidade == this.elementos.length);
	}

	public int tamanho() {
		return this.quantidade;
	}

	public void empilha(Object elemento) {
		if(this.estaCheia()) {
			throw new PilhaCheiaException("Não é possível empilhar");
		}
		
		this.elementos[quantidade] = elemento;
		this.quantidade++;
	}

	public Object topo() {
		return this.elementos[this.quantidade - 1];
	}

	public Object desempilha() {
		if(this.estaVazia()) {
			throw new PilhaVaziaException("Não é possível desempilhar");
		}
		
		Object topo = this.topo();
		this.quantidade--;
		return topo;		
	}

}
