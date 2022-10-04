package com.example.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserClass, Long> {
	UserClass findByUsername(String username);
}
