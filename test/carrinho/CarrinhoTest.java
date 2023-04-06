package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste do Carrinho")
public class CarrinhoTest {
	private static Carrinho car;
	private static Produto p1;
	private static Produto p2;
	private static Produto p3;
	private static Produto p4;
	@BeforeEach
	public void inicializa() {
		car = new Carrinho();
		p1 = new Produto("maça", 5);
		p2 = new Produto("uva", 10);
		p3 = new Produto("pera", 15);
		p4 = new Produto("fora do carrinho", 0);
		car.addItem(p1);
		car.addItem(p2);
		car.addItem(p3);
		
	}
	@Test
	public void testQuantidadeProdutos() {
		int qteItems = car.getQtdeItems();
		assertEquals(3, qteItems);
	}
	
	@Test
	public void testValidaValorTotal() {
		double valorTotal = car.getValorTotal();
		
		assertEquals(30, valorTotal);
	}
	
	@Test
	public void testRemoveProduto() {
		try {
			car.removeItem(p1);
			int novaQuantidade = car.getQtdeItems();
			assertEquals(2, novaQuantidade);
		} catch (ProdutoNaoEncontradoException e) {
			fail("não foi possivel remover o Item");
		}
	}
	
	@Test
	public void testRemoveProdutoThrows() {
		assertThrows(ProdutoNaoEncontradoException.class,
				() -> car.removeItem(p4));
	}
	@Test
	public void testEsvazia() {
		car.esvazia();
		var qtd = car.getQtdeItems();
		assertEquals(qtd, 0);
	}
	
	
	
}