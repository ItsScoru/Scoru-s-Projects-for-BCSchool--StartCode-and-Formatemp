package dao;

import java.util.List;

// DAO Data Access Object è un paattern architetturale
// serve a formire lo scheletro di alcuni metodi CRUD usati dalle classi
// mantiene una rigida separazione tra le componenti di un'applicazione
public interface InterfacciaDao<T> {

    public List<T> findAll();

    public T findOne(int id);

    public void insertMany(List<T> tipo);

}
