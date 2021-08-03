package br.com.guslima.cm.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.guslima.cm.exception.ExplosaoException;

public class CampoTest {
	
	private Campo campo;
	
	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3, 3);
	}
	
	@Test
	void testeVizinhoHorizontalVertical() {
		Campo vizinho = new Campo(3, 4);
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoDiagonal() {
		Campo vizinho = new Campo(2, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeNaoVizinhoHorizontalVertical() {
		Campo vizinho = new Campo(5, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertFalse(resultado);
	}
	
	@Test
	void testeNaoVizinhoDiagonal() {
		Campo vizinho = new Campo(5, 5);
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertFalse(resultado);
	}
	
	@Test
	void testeValorPadraoAtributoMarcado() {
		
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacao() {
		
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAbrirCampoNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirCampoNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirCampoMinadoNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
	}
	
	@Test
	void testeAbrirCampoMinadoMarcado() {
		campo.minar();
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirComVizinhos1() {
		Campo campo11 = new Campo(1,1);
		Campo campo22 = new Campo(2,2);
		
		campo22.adicionarVizinho(campo11);
		
		campo.adicionarVizinho(campo22);
		
		campo.abrir();
		
		assertTrue(campo11.isAberto() && campo22.isAberto());
	}
	
	@Test
	void testeAbrirComVizinhos2() {
		Campo campo11 = new Campo(1,1);
		Campo campo12 = new Campo(1,2);
		campo12.minar();
		
		Campo campo22 = new Campo(2,2);

		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo22);
		
		campo.abrir();
		
		assertTrue(campo11.isFechado() && campo22.isAberto());
	}
	
	@Test
	void testeObjetivoAlcancado() {
		Campo campo11 = new Campo(1,1);
		Campo campo12 = new Campo(1,2);
		
		campo12.minar();
		
		Campo campo22 = new Campo(2,2);

		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo22);
		
		campo.abrir();
		
		assertTrue(campo.objetivoAlcancado());
	}
	
	@Test
	void testeMinasNaVizinhaca() {
		Campo campo11 = new Campo(1,1);
		Campo campo12 = new Campo(1,2);
		
		campo12.minar();
		
		Campo campo22 = new Campo(2,2);

		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		assertEquals(campo22.minasNaVizinhaca(), 1);
	}
	
	@Test
	void testeReiniciar() {
		Campo campo11 = new Campo(1,1);
		Campo campo12 = new Campo(1,2);
		
		campo12.minar();
		
		Campo campo22 = new Campo(2,2);

		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo22);
		
		campo.abrir();
		
		campo.reiniciar();
		
		assertFalse(campo.isAberto() && campo.isMarcado() && campo.isMinado());
	}
	
	@Test
	void testeLinhaColuna() {
		
		assertEquals(campo.getColuna(), 3);
		assertEquals(campo.getLinha(), 3);
	}
	
	@Test
	void testeMinado() {
		Campo campo12 = new Campo(1,2);
		
		campo12.minar();
		
		assertTrue(campo12.isMinado());
	}
	
	@Test
	void testeToString() {
		Campo campo11 = new Campo(1,1);
		Campo campo12 = new Campo(1,2);
		
		campo12.minar();
		campo11.alternarMarcacao();
		
		assertEquals(campo11.toString(), "x");
		
		Campo campo22 = new Campo(2,2);

		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		assertEquals(campo22.toString(), "?");
		
		campo.adicionarVizinho(campo22);
		
		campo.abrir();
		
		assertEquals(campo.toString(), " ");
		
		assertEquals(campo22.toString(), "1");
		
		assertThrows(ExplosaoException.class, () -> {
			campo12.abrir();
		});
		
		assertEquals(campo12.toString(), "*");
	}
	
	
}
