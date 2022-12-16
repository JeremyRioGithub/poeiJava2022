package org.example.interfaces;

public interface IDAO<Type> {
    void begin();
    boolean create(Type object);

    boolean update(Type object);

    boolean delete(Type object);

    Type findById(int id);
    void envoie();
    void close();
}