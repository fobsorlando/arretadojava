package application;

import java.sql.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.ProdutoDao;

import model.entities.Produto;
import model.entities.Secao;
import model.entities.SubGrupo;
import model.entities.Departamento;
import model.entities.Fornecedor;
import model.entities.Grupo;

public class Programa {

	public static void main(String[] args) {
		
	//	System.out.println(obj);
	//	System.out.println(obj1);
	//	System.out.println(obj2);
	//	System.out.println(obj3);
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
		

	}

}
