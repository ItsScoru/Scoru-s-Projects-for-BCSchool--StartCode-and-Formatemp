package dao;

import java.util.List;

public interface InterfacciaDao<T> {
	
	public void insertOne(T obj);
	
	public List<T> findAll();
	
	public void delete(Integer id);

}
