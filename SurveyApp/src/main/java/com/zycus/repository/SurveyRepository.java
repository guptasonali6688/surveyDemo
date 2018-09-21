package com.zycus.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.zycus.entity.Survey;
import com.zycus.entity.User;

public interface SurveyRepository extends CrudRepository<Survey, Integer>{


	@Query("select s from Survey s where s.status = true")
	public Iterable<Survey> getActiveSurvey();

	@Transactional
	@Modifying
	@Query("update Survey s set s.status = false where s.id = :id")
	public void deactivateSurvey(@Param("id") int id);
}
