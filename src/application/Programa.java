package application;

import model.entities.Departamento;
import model.entities.Grupo;
import model.entities.Secao;
import model.entities.SubGrupo;

public class Programa {

	public static void main(String[] args) {
		
		Departamento obj = new Departamento(1,"BOLOS");
		
		Grupo obj1 = new Grupo(1,"BOLOS de cuba");

		SubGrupo obj2 = new SubGrupo(1,"BOLOS de nao sei ");

		Secao obj3 = new Secao(1,"mais BOLOS");

		System.out.println(obj);
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);


	}

}
