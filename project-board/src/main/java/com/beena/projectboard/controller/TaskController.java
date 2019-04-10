package com.beena.projectboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beena.projectboard.model.Task;
import com.beena.projectboard.service.TaskService;

import lombok.experimental.Delegate;



@RestController
@CrossOrigin
@RequestMapping("/api/dashboard")
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@PostMapping("")
	public ResponseEntity<?> addTaskToBoard(@Valid @RequestBody Task task, BindingResult result) {
		if(result.hasErrors()) {
			Map<String, String> errorMap =  new HashMap<>();
			for(FieldError e : result.getFieldErrors()){
				errorMap.put(e.getField(), e.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}
		Task newTask = taskService.saveOrUpdate(task);
		return new ResponseEntity<Task>(newTask, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public Iterable<Task> getAllTasks(){
		return taskService.findAll();
	}
	
	@GetMapping("/{task_id}")
	public ResponseEntity<?> findById(@PathVariable Long task_id){
		Task task = taskService.findById(task_id);
		return new ResponseEntity<Task>(task, HttpStatus.OK);
	}
	
	@DeleteMapping("/{task_id}")
	public ResponseEntity<?> deleteTask (@PathVariable Long task_id){
		taskService.deleteTask(task_id);
		return new ResponseEntity<String> ("Task Deleted ", HttpStatus.OK);
	}
}
