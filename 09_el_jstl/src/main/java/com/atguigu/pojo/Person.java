package com.atguigu.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Person {
    private String[] phones;
    private Integer id;
    private List<String> cities;
    private Map<String, Object> map;

    public Person() {
    }

    public Person(String[] phones, Integer id, List<String> cities, Map<String, Object> map) {
        this.phones = phones;
        this.id = id;
        this.cities = cities;
        this.map = map;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Person {" +
                "phones=" + Arrays.toString(phones) +
                ", id=" + id +
                ", cities=" + cities +
                ", map=" + map +
                '}';
    }
}
