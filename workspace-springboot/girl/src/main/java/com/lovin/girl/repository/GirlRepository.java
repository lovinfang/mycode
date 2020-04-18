package com.lovin.girl.repository;

import com.lovin.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer> {

    /**
     * 通过年龄来查询
     * @param age
     * @return
     */
    public List<Girl> findByAge(Integer age);
}
