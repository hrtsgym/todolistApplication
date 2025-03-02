package com.example.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todolist.model.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    // 必要に応じてカスタムメソッドを追加
}
