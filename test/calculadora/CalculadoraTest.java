package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois numeros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Excecao nao lancada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@Test
	public void testSubtracaoDoisNumeros() {
		int subtracao = calc.subtracao(10, 5);
		assertTrue(subtracao == 5);
	}
	
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int multiplicacao = calc.multiplicacao(10, 5);
		assertTrue(multiplicacao == 50);
	}
	
	@Test
	public void testSomatoria() {
		int somatoria = calc.somatoria(10);
		assertTrue(somatoria == 55);
	}
	
	@DisplayName("Testa se um número positivo é positivo")
	@Test
	public void testPositivoTrue() {
		boolean positivo = calc.ehPositivo(10);
		assertTrue(positivo);
	}
	@DisplayName("Testa se um número negativo é positivo.")
	@Test
	public void testPositivoFalse() {
		boolean positivo = calc.ehPositivo(-10);
		assertFalse(positivo);
	}
	@DisplayName("Testa se os números são iguais.")
	@Test
	public void testComparaNumerosIguais() {
		int comparativo = calc.compara(10, 10);
		assertEquals(0, comparativo);
	}
	@DisplayName("Testa se o primeiro número é maior que o segundo número.")
	@Test
	public void testComparaNumeroMaior() {
		int comparativo = calc.compara(10,5);
		assertEquals(1, comparativo);
	}
	@DisplayName("Testa se o primeiro número é menor que o segundo número.")
	@Test
	public void testComparaNumeroMenor() {
		int comparativo = calc.compara(5,10);
		assertEquals(-1, comparativo);
	}

}
