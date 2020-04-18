package com.geektime.spring.data.declarativetransactiondemo;

public interface FooService {
    void insertRecord();
    void insertThenRollback() throws RollbackException;
    void invokeInsertThenRollback() throws RollbackException;
    void insertWithTransaction() throws RollbackException;
    void invokeInsertWithTransaction()throws RollbackException;

}
