package dao;

import java.util.List;

public interface InterfacciaDao<T> {

    public List<T> findAll();

    public T findOne(int id);

    public void insertMany(List<T> lista);

}
