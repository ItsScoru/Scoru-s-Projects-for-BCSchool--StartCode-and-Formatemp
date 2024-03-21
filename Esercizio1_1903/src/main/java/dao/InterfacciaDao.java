package dao;

import java.util.List;

public interface InterfacciaDao<T> {

    public void insertMany(List<T> lista);

    public List<T> findAll();
    
}
