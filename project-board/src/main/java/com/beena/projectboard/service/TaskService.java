package com.beena.projectboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beena.projectboard.model.Task;
import com.beena.projectboard.repository.TaskRepo;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepo taskRepo;
	
	public Task saveOrUpdate(Task task) {
		if (task.getStatus() == null || task.getStatus().isEmpty()) 
			task.setStatus("TO_DO")	;
		return taskRepo.save(task);	
	}

	public Iterable<Task> findAll() {
		return taskRepo.findAll();
	}

	public Task findById(Long id){
		return taskRepo.getById(id);
	}

	public void deleteTask(Long task_id) {
		 taskRepo.deleteById(task_id);	
		 return;
	}
}
