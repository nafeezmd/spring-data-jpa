package com.labs.springboot.repository;

import com.labs.springboot.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

  // when you don't give any methods here, you just get basic CRUD methods for Customer entity
  List<Customer> findAllByLastName(String lastName);

}
