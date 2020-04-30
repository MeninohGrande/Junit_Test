package atividade.programa;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import atividade.conta.Conta;

public class ContaTeste {

	Conta c = new Conta();
	
	/*
	  A conta inicialmente não possui nenhum saldo.
	  
	  <esperado passar no teste>
	 */
	
	@Test
	void testeSaca() {
		assertFalse(c.saca(40));
	}
	
	// agora o teste para sacar será feito com um saldo inicial
	// <esperado passar no teste>
	@Test
	void testSacaComSaldo() {
		c.deposita(50);
		assertTrue(c.saca(40));
	}
	
	/*
	 * Agora a conta possui um saldo de apenas $10 e o teste tentara transferir $50
	 * <esperado passar no teste>
	 */
	@Test
	void testaTransfere() {
		Conta contadestino = new Conta();
		assertFalse(c.transfere(contadestino, 50));
	}
	
	// Testa uma transferencia de $5
	// <esperado passar no teste>
	@Test
	void testaTransfereComSaldo() {
		assertTrue(c.transfere(new Conta(), 5));
	}
	
	/*
	 * Dá um nome ao propietario da conta para testar o retorno do metodo
	 * <esperado passar no teste>
	 */
	@Test
	void testaNome() {
		c.setNome("Daniel");    //Define um nome para o proprietário
		assertEquals("Daniel",c.getNome());
	}
	
	/*
	 * Unico teste que deve falhar por conta da escrita do teste que pede
	 * que o valor retornado pelo metodo 'c.getNome' seja diferente de Daniel
	 * <esperado reprovar no teste>
	 */
	@Test
	@DisplayName("Verificar se o nome do propriterio definido é diferente de Daniel")
	void testaNomeFalse() {
		assertNotEquals("Daniel", c.getNome());
	}
	
}
