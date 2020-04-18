package com.lovin.girl.controller;

import com.lovin.girl.domain.Girl;
import com.lovin.girl.domain.Result;
import com.lovin.girl.repository.GirlRepository;
import com.lovin.girl.service.GirlService;
import com.lovin.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;


    /**
     * 查询所有女生
     * @return
     * http://localhost:8081/girl/girls
     */
    @GetMapping(value="/girls")
    public List<Girl> girlList(){
        logger.info("girlList");

        return girlRepository.findAll();
    }


    /**
     * 添加一个女生
     * @param girl
     * @param bindingResult
     * @return
     * http://localhost:8081/girl/girls
     * Headers  [{"key":"Content-Type","value":"application/json","description":"","enabled":true}]
     * Body 选择 raw  JSON(application/json)
     *
     * @Valid对传入的Girl进行验证，验证的结果存入BindingResult里面
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid @RequestBody Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 查询一个女生
     * @param id
     * @return
     * http://localhost:8081/girl/girls/3
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findById(id).get();
    }

    /**
     * 更新女生信息
     * @param id
     * @param cupSize
     * @param age
     * @return
     * http://localhost:8081/girl/girls/1?cupSize=H&age=25
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = girlRepository.findById(id).get();
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    /**
     * 根据id删除女生信息
     * @param id
     * http://localhost:8081/girl/girls/3
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    /**
     * 通过年龄查询女生列表
     * @param age
     * @return
     * http://localhost:8081/girl/girls/age/19
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * http://localhost:8081/girl/girls/two
     */
    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }


    /**
     * 获取女生年龄
     * @param id
     * @throws Exception
     * http://localhost:8081/girl/girls/getAge/8
     */
    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }
}
