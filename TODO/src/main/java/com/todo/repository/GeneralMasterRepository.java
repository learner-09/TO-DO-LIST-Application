package com.todo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.todo.model.GeneralMaster;

public interface GeneralMasterRepository extends CrudRepository<GeneralMaster, Integer> {

	List<GeneralMaster> findAllByGeneralTypeId(String generalTypeId);

}
