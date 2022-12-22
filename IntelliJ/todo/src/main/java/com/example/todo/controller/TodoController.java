package com.example.todo.controller;

import com.example.todo.entity.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todo")
@ResponseBody
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping("")
    public Todo postTodo(@RequestBody Todo todo){
        if(todoService.create(todo)) {
            System.out.println("created: ID:"+todo.getId());
            return todo;
        }
        return null;
    }

    @PostMapping("/update/{id}")
    public Todo updateTodo(@PathVariable("id") int id, @RequestBody Todo todo){
        Todo todoFound = todoService.findById(id);
        if(todoFound != null) {
            System.out.println("updated: beforeMarque"+todoFound.getMarque()+" to afterMarque:"+todo.getMarque());
            todoFound.setMarque(todo.getMarque());
            todoFound.setReference(todo.getReference());
            todoFound.setPrix(todo.getPrix());
            todoFound.setStock(todo.getStock());
            todoService.update(todoFound);
            return todoFound;
        }
        return null;
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable("id") int id){
        Todo todoFound = todoService.findById(id);
        if(todoFound != null && todoService.delete(todoFound)) {
            return "deleted: ID:"+todoFound.getId();
        }
        return "Todo with id:"+id+" not found !";
    }

    @GetMapping("/find/{id}")
    public Todo findByIdTodoPath(@PathVariable("id") int id){
        Todo todo = todoService.findById(id);
        System.out.println("found with PathVariable: ID:"+todo.getId());
        return todo;
    }
    @GetMapping("/find")
    public Todo findByIdTodo(@RequestParam("id") int id){
        Todo todo = todoService.findById(id);
        System.out.println("found with RequestParam: ID:"+todo.getId());
        return todo;
    }

    @GetMapping("/findall")
    public List<Todo> findAllTodo(){
        return todoService.findAll();
    }

}