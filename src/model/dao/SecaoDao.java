package model.dao;

import java.util.List;

import model.entities.Departamento;

public interface SecaoDao {
	void insert  (Departamento obj);
	void udpdate (Departamento obj);
	void deleteById (Integer id);
	Departamento findByid(Integer id);
	
	List<Secao> findAll();
}
