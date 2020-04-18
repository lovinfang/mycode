package com.lovin.girl.service;

import com.lovin.girl.domain.Girl;
import com.lovin.girl.enums.ResultEnum;
import com.lovin.girl.exception.GirlException;
import com.lovin.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transient
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlA.setMoney(300d);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BBBB");
        girlB.setAge(19);
        girlB.setMoney(250d);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findById(id).get();
        Integer age = girl.getAge();
        if(age < 10){
            //返回"你还在上小学吧" code=100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age < 16){
            //返回"你可能在上初中" code=101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    public Girl findOne(Integer id){
        return girlRepository.findById(id).get();
    }
}
