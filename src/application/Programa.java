package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartamentoDao;
import model.entities.Departamento;

public class Programa {

	public static void main(String[] args) {
		
	//	System.out.println(obj);
	//	System.out.println(obj1);
	//	System.out.println(obj2);
	//	System.out.println(obj3);
		
/*
		System.out.println("=== TESTE 1 - Find por ID");
		
		ProdutoDao produtoDao = DaoFactory.createProdutoDao();
		
		Produto produto = produtoDao.findByid(1);
		System.out.println(produto);
		
		
		System.out.println("=== TESTE 2 - Find por departamento");
		
		Departamento dep = new Departamento(1,null);
		List<Produto> list = produtoDao.findByDepartamento(dep);
		
		for (Produto obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TESTE 3 - Find All");
		
		
		list  = produtoDao.findAll();
		
		for (Produto obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TESTE 4 - Insert");

		Departamento departamento = new Departamento(1,null);
		Secao secao = new Secao(1,null);
		Grupo grupo = new Grupo(1,null);
		SubGrupo subGrupo = new SubGrupo (1,null);
		Fornecedor fornecedor = new Fornecedor (1,null);
		
		long ean13 = 1111111111;
		
		Produto produto1 = new Produto(
				"OVO DE CHOCOLATE", 
				"OVO DE CHOCOLATE DO FORNECEDOR", 
				ean13, 
				50.00, 
				30.00,
				departamento,
				secao, 
				grupo,
				subGrupo, 
				fornecedor);
		
		produtoDao.insert(produto1);
		System.out.println("Inserido Produto :" + produto1.getId());
		
		System.out.println("=== TESTE 5 - Update");

		produto  = produtoDao.findByid(1);
		
		produto.setNo_produto("COXINHA DE FRANGO");
		produto.setNo_produto_forn("COXINHA DE FRANGO DO EDY");
		produto.setVl_venda(20.00);
		produto.setVl_custo(5.00);
		
		produtoDao.udpdate(produto);
		System.out.println("Alerado Produto :" + produto.getId());
		
		System.out.println("=== TESTE 6 - Delete");

     	produto  = produtoDao.findByid(5);
		
		if (produto.getId() == null) {
			System.out.println("Produto Não Encontrato para Exclusão!");
		}
		else {
			int delid = produto.getId();
			produtoDao.deleteById(delid);
			System.out.println("Produto (" + delid + ") Excluído!");
		}

		produtoDao.deleteById(6);
		System.out.println("Excluido");

*/
		
		System.out.println("=== TESTE 1 - Find por ID");
		
		DepartamentoDao  depDao = DaoFactory.createDepartamentoDao();
		
		Departamento dep = depDao.findByid(1);
		System.out.println(dep);
		
		System.out.println("=== TESTE 2 - Find ALL");
		
		

		List<Departamento> list   = depDao.findAll();
		
		for (Departamento obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TESTE 4 - Insert");

		Departamento departamento = new Departamento(null,"BOLOS EM GERAL");
		//depDao.insert(departamento);
		//System.out.println("Inserido Departamento :" + departamento.getId());
		
		
		System.out.println("=== TESTE 4 - Alteração");

		departamento = new Departamento(3,"COXINHAS EM GERAL"); 
		depDao.udpdate(departamento);
		System.out.println("Alterado Departamento :" + departamento.getId());
		
		System.out.println("=== TESTE 5 - Delete");
		departamento = new Departamento(4,null);
		depDao.deleteById(4);


	}
}
