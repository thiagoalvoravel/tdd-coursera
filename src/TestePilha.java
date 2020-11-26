import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestePilha {

	private Pilha p;
	
	@BeforeEach
	public void inicializaPilha() {
		this.p = new Pilha(10);
	}
	
	@Test
	void pilhaVazia() {
		assertTrue(p.estaVazia());
		assertEquals(0, p.tamanho());
	}
	
	@Test
	void empilhaUmElemento() {
		p.empilha("primeiro");
		assertFalse(p.estaVazia());
		assertEquals(1, p.tamanho());
		assertEquals("primeiro", p.topo());
	}
	
	@Test
	void empilhaEDesempilha() {
		p.empilha("primeiro");
		p.empilha("segundo");
		assertEquals(2, p.tamanho());
		assertEquals("segundo", p.topo());
		Object desempilhado = p.desempilha();
		assertEquals(1, p.tamanho());
		assertEquals("primeiro", p.topo());
		assertEquals("segundo", desempilhado);
	}
	
	@Test
	void removeDaPilhaVazia() {
		assertThrows(PilhaVaziaException.class,
			()->{
				p.desempilha();
			}
		);		
		
	}
	
	@Test
	void adicionaNaPilhaCheia() {
		for(int i = 0; i < 10; i++) {
			p.empilha(i);
		}
		
		try {
			p.empilha(11);
			fail();
		} catch (PilhaCheiaException e) { }				
		
	}
	
	
	
	
	
	
	
	

}
