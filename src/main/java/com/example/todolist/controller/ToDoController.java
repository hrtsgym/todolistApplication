package com.example.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.model.ToDo;
import com.example.todolist.service.ToDoService;

@RestController
@RequestMapping("/todos")
public class ToDoController {

	private final ToDoService toDoService;

	@Autowired
	public ToDoController(ToDoService toDoService) {
		this.toDoService = toDoService;
	}

	@GetMapping("/view")
	public String viewToDoList(Model model) {
		model.addAttribute("todos", toDoService.getAllToDos());
		return "index";
	}

	@GetMapping
	public List<ToDo> getAllToDos() {
		return toDoService.getAllToDos();
	}

	@PostMapping
	public ToDo createToDo(@RequestBody ToDo toDo) {
		return toDoService.createToDo(toDo);
	}

	@PutMapping("/{id}")
	public ToDo updateToDo(@PathVariable Long id, @RequestBody ToDo toDo) {
		return toDoService.updateToDo(id, toDo);
	}

	@DeleteMapping("/{id}")
	public void deleteToDo(@PathVariable Long id) {
		toDoService.deleteToDo(id);
	}
}
