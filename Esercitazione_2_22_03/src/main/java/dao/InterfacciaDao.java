package dao;

import java.util.List;

public interface InterfacciaDao <T>{
	
	public void save(T obj);
	
	public List<T> readAll();
	
	public void delete(int id);

}
