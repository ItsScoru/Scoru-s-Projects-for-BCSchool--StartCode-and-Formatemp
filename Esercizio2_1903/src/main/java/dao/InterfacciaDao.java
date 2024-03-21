package dao;

import java.util.List;

public interface InterfacciaDao <T>{
	
	public  void insert( T istanza);
	
	public List<T> findAll();
	
	public void delete(int id);
	
	public void update(int id, String name);

}
