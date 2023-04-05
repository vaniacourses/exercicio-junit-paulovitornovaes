package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;

@DisplayName("Classe para teste do Carrinho")
public class CarrinhoTest {
	private static Carrinho car;
	private static Produto p1;
	private static Produto p2;
	private static Produto p3;
	
	@BeforeAll
	public static void inicializa() {
		car = new Carrinho();
		p1 = new Produto("maça", 5);
		p2 = new Produto("uva", 10);
		p3 = new Produto("pera", 15);
		car.addItem(p1);
		car.addItem(p2);
		car.addItem(p3);
		
	}
	
	
	
}