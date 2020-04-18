package com.geektime.spring.springbucks.jpademo.repository;

import com.geektime.spring.springbucks.jpademo.model.CoffeeOrder;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeOrderRepository extends CrudRepository<CoffeeOrder,Long> {
}
