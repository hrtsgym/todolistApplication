package com.example.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todolist.model.ToDo;
import com.example.todolist.repository.ToDoRepository;

@Service
public class ToDoService {

	@Autowired
    private ToDoRepository toDoRepository;

    //全てのtoDoを取得
    public List<ToDo> getAllToDos() {
        return toDoRepository.findAll();
    }
    
    // IDでToDoを取得
    public Optional<ToDo> getToDoById(Long id) {
        return toDoRepository.findById(id);
    }

     // ToDoを保存（新規・更新）
    public ToDo createToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }
    // TpDoを更新
    public ToDo updateToDo(Long id, ToDo toDo) {
        toDo.setId(id);
        return toDoRepository.save(toDo);
    }

    // ToDoを削除
    public void deleteToDo(Long id) {
        toDoRepository.deleteById(id);
    }
}
