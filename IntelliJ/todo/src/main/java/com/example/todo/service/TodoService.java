package com.example.todo.service;

import com.example.todo.entity.Todo;
import com.example.todo.interfaces.IDAO;
import com.example.todo.tools.ServiceHibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService implements IDAO<Todo> {

    // @Autowired
    private ServiceHibernate serviceHibernate;

    private Session session;

    public TodoService(ServiceHibernate serviceHibernate){
        this.serviceHibernate = serviceHibernate;
        session = this.serviceHibernate.getSession();
    }

    @Override
    public boolean create(Todo o) {
        session.beginTransaction();
        session.persist(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(Todo o) {
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;

    }

    @Override
    public boolean delete(Todo o) {
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Todo findById(int id) {
        Todo todo = null;
        //todo = session.find(Todo.class, id); // fonctionne
        todo = (Todo) session.get(Todo.class, id);
        return todo;
    }

    @Override
    public List<Todo> findByEtat(boolean etat) {
        if (etat){
            List<Todo> todos = session.createQuery("from Todo where etat=0x01").list();
            return todos;
        }
        List<Todo> todos = session.createQuery("from Todo where etat=0x00").list();
        return todos;
    }

    @Override
    public List<Todo> findAll() {
        List<Todo> todos = session.createQuery("from Todo").list();
        return todos;
    }
}