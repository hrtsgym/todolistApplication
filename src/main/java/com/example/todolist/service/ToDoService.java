package com.example.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todolist.model.ToDo;
import com.example.todolist.repository.ToDoRepository;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> getAllToDos() {
        return toDoRepository.findAll();
    }

    public ToDo createToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public ToDo updateToDo(Long id, ToDo toDo) {
        toDo.setId(id);
        return toDoRepository.save(toDo);
    }

    public void deleteToDo(Long id) {
        toDoRepository.deleteById(id);
    }
}
