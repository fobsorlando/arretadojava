package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.ProdutoDao;

import model.entities.Produto;
import model.entities.Departamento;

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
		
		

		


	}

}
