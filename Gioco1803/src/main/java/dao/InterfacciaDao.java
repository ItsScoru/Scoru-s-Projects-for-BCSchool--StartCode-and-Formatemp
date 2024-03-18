package dao;

import java.util.List;

public interface InterfacciaDao<T> {

    public List<T> findAll();

    public void insertMany(List<T> lista);

    public void delete(int id);

}