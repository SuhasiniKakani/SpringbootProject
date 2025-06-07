package com.example.demo.Repository;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.Identity.UserTable;

public interface UserRepo extends CrudRepository<UserTable,Integer> {

}
