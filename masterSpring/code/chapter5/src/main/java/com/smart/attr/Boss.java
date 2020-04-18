package com.smart.attr;

import java.util.*;

public class Boss {
    private String name;
    private int age;
    private Car car = new Car();
    private Map jobs = new HashMap();
    private List favoritesList = new ArrayList();
    private Set favoriteSet = new HashSet();
    private Properties mails = new Properties();
    private Map<String, Integer> jobTime = new HashMap<String, Integer>();

    public Boss() {
    }

    public Boss(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, Integer> getJobTime() {
        return jobTime;
    }

    public void setJobTime(Map<String, Integer> jobTime) {
        this.jobTime = jobTime;
    }

    public Properties getMails() {
        return mails;
    }

    public void setMails(Properties mails) {
        this.mails = mails;
    }

    public Map getJobs() {
        return jobs;
    }

    public void setJobs(Map jobs) {
        this.jobs = jobs;
    }

    public List getFavoritesList() {
        return favoritesList;
    }

    public void setFavoritesList(List favoritesList) {
        this.favoritesList = favoritesList;
    }

    public Set getFavoriteSet() {
        return favoriteSet;
    }

    public void setFavoriteSet(Set favoriteSet) {
        this.favoriteSet = favoriteSet;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String toString() {
        String temp = "car:" + car + "\n";
        temp += "favorites.size:" + favoritesList.size() + "\n";
        temp += "favoriteSet.size:" + favoriteSet.size() + "\n";
        temp += "jobs.size:" + jobs.size();
        return temp;
    }

}
