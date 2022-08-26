package com.atguigu.json.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {
    @Test
    public void test1() {
        Person person = new Person(1, "Guoge");
        Gson gson = new Gson();
        String s = gson.toJson(person);
        System.out.println(s);
        person = gson.fromJson(s, Person.class);
        System.out.println(person);
        System.out.println(person.getId());
        System.out.println(person.getName());
    }

    @Test
    public void test2() {
        List<Person> ps = new ArrayList<>();
        ps.add(new Person(1, "1"));
        ps.add(new Person(2, "2"));
        ps.add(new Person(3, "3"));

        Gson gson = new Gson();
        String s = gson.toJson(ps);

        System.out.println(s);
        ps = gson.fromJson(s, new TypeToken<List<Person>>(){}.getType());
        System.out.println(ps);
    }
    @Test
    public void test3() {
        Map<String, Person> personMap = new HashMap<>();
        personMap.put("1", new Person(1, "1"));
        personMap.put("2", new Person(2, "2"));
        personMap.put("3",  new Person(3, "3"));

        Gson gson = new Gson();
        String s = gson.toJson(personMap);
        System.out.println(s);

        personMap = gson.fromJson(s, new TypeToken<HashMap<String, Person>>(){}.getType());
        System.out.println(personMap);
    }
}
