package com.example.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todolist.model.ToDo;
import com.example.todolist.service.ToDoService;

@Controller
@RequestMapping("todos")
public class ToDoController {

	@Autowired
	private ToDoService toDoService;

    @GetMapping
    public String listToDos(Model model) {
        List<ToDo> todos = toDoService.getAllToDos();
        model.addAttribute("todos", todos);
        return "todo-list"; // Thymeleaf のテンプレート
    }
    
    // 新規作成フォーム
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("todo", new ToDo());
        return "todo-form";
    }
    
    // ToDoを保存
    @PostMapping("/save")
    public String saveToDo(@ModelAttribute("todo") ToDo toDo) {
        toDoService.createToDo(toDo);
        return "redirect:/todos";
    }
    
    // 編集フォーム
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        ToDo todo = toDoService.getToDoById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ToDo ID"));
        model.addAttribute("todo", todo);
        return "todo-form";
    }
    
    // ToDoを削除
    @GetMapping("/delete/{id}")
    public String deleteToDo(@PathVariable Long id) {
        toDoService.deleteToDo(id);
        return "redirect:/todos";
    }

//	@GetMapping
//	public List<ToDo> getAllToDos() {
//		return toDoService.getAllToDos();
//	}
//	
//    // IDでToDoを取得
//    @GetMapping("/{id}")
//    public Optional<ToDo> getToDoById(@PathVariable Long id) {
//        return toDoService.getToDoById(id);
//    }
//
//	@PostMapping
//	public ToDo createToDo(@RequestBody ToDo toDo) {
//		return toDoService.createToDo(toDo);
//	}
//
//	@PutMapping("/{id}")
//	public ToDo updateToDo(@PathVariable Long id, @RequestBody ToDo toDo) {
//		return toDoService.updateToDo(id, toDo);
//	}
//
//	@DeleteMapping("/{id}")
//	public void deleteToDo(@PathVariable Long id) {
//		toDoService.deleteToDo(id);
//	}
}
