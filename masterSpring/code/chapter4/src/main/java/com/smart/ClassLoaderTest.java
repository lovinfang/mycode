package com.smart;

public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("current loader:"+loader);
        System.out.println("parene loader:"+loader.getParent());
        System.out.println("grandParent loader:"+loader.getParent().getParent());
    }
}
