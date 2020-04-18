package com.geektime.spring.data.declarativetransactiondemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FooServiceImpl implements FooService{

    private Logger log = LoggerFactory.getLogger(FooServiceImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private FooService fooService;

    @Override
    @Transactional
    public void insertRecord() {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('AAA')");
    }

    @Override
    @Transactional(rollbackFor = RollbackException.class)
    public void insertThenRollback() throws RollbackException {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('BBB')");
        throw new RollbackException();
    }

    @Override
    public void invokeInsertThenRollback() throws RollbackException {
        //事务没起作用
//        insertThenRollback();

        /**
         * Spring的声明式事物本质上是通过AOP来增强了类的功能
         * Spring的AOP本质上就是为类做了一个代理
         *   看似在调用自己写的类，实际用的是增强后的代理类
         * 问题的解法:访问增强后的代理类的方法，而非直接访问自身的方法  这样事务就会起作用
         */
        fooService.insertThenRollback();
    }

    @Override
    @Transactional(rollbackFor = RollbackException.class, propagation = Propagation.REQUIRES_NEW)
    public void insertWithTransaction() throws RollbackException {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('BBB')");
    }

    @Override
    @Transactional(rollbackFor = RollbackException.class)
    public void invokeInsertWithTransaction() throws RollbackException {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('AAA')");
        try{
            fooService.insertWithTransaction();
        }catch (RollbackException e){
            log.error("RollbackException",e);
        }
        throw new RuntimeException();
    }
}
