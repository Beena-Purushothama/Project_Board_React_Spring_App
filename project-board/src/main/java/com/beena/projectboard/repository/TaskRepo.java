package com.beena.projectboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.beena.projectboard.model.Task;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long>{
	Task getById(Long id);
}
