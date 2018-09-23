package com.zycus.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.zycus.entity.Share;

public interface ShareSurveyRepository extends CrudRepository<Share, Integer> {

	/*@Query("select s from Share s where s.user_id = :id")
	public Iterable<Share> getAllSurvey(@Param("id") int id);*/
}
