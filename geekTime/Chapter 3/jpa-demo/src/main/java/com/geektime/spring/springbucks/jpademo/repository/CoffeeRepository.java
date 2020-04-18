package com.geektime.spring.springbucks.jpademo.repository;

import com.geektime.spring.springbucks.jpademo.model.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee,Long> {
}
