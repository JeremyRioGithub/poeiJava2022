package com.example.todo.interfaces;

import com.example.todo.entity.Todo;

import java.util.List;

public interface IDAO<T> {
    boolean create(T o);
    boolean update(T o);
    boolean delete(T o);
    T findById(int id);

    List<Todo> findByEtat(boolean etat);

    List<T> findAll();

}
