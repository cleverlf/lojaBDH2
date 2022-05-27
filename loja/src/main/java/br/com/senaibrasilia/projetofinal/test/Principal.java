package br.com.senaibrasilia.projetofinal.test;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.senaibrasilia.projetofinal.dao.ProdutoDAO;
import br.com.senaibrasilia.projetofinal.model.Categoria;
import br.com.senaibrasilia.projetofinal.model.Cliente;
import br.com.senaibrasilia.projetofinal.model.Produto;
import br.com.senaibrasilia.projetofinal.util.JPAUtil;

public class Principal {
	
	private static EntityManager em = JPAUtil.getEntityManager();

	private static ProdutoDAO prodao = new ProdutoDAO(JPAUtil.getEntityManager());
	private static ProdutoDAO catdao = new ProdutoDAO(JPAUtil.getEntityManager());
	private static ProdutoDAO clidao = new ProdutoDAO(JPAUtil.getEntityManager());
	
	public static void main(String[] args) {
		
		Produto p1 = new Produto("Mouse", "Mouse Dell Optico",new BigDecimal("100"),new Categoria("Periferico"));
		Produto p2 = new Produto("Cadeira", "Herman Miller",new BigDecimal("10720"),new Categoria("Cadeira"));		
		Produto p3 = new Produto("Computador", "Workstation Precision 3650",new BigDecimal("9234"),new Categoria("Desktop"));		
		Cliente cl = new Cliente("Clever", "12345678910", "Brasilia,DF", "(61)91234-5678");
		
				
		em.getTransaction().begin();	
		prodao.cadastrar(p1);
		prodao.cadastrar(p2);
		prodao.cadastrar(p3);
		//catdao.cadastrar(p3);
		prodao.pesquisarTodos();
		
		em.getTransaction().commit();
		em.close();	
		
		
		
	}

}
