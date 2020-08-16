package com.techpassel.springbootjpamysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.techpassel.springbootjpamysql.model.User;

public interface UserRepo extends CrudRepository<User, Integer> {
	//You don't need to define explicitly "findById()" method.It is already defined in CrudRepository.
	User findByName(String name);
	
	List<User> findByIdGreaterThan(int id);
	//To fetch all users whose Id is greater than given Id(as argument).
	
	
	@Query("from User order by name")
	List<User> findAllByNameSorted();
	//Above custom query is made using jpql which is based on hql and which itself is based on sql.
	
	@Query("from User where name=?1 order by name")
	List<User> findByNameSorted(String name);
	//Here "?1" represents 1st argument, similarly if it had second argument you could have used it like "id=?2"
	
	
}
