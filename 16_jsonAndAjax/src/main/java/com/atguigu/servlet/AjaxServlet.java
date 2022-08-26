package com.atguigu.servlet;

import com.atguigu.json.test.Person;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "AjaxServlet", value = "/ajaxServlet")
public class AjaxServlet extends BaseServlet {

    protected void javaScriptAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("javaScriptAjax has been called!");
        Person person = new Person(1, "haha1");
        Gson gson = new Gson();
        String s = gson.toJson(person);
        response.getWriter().write(s);
    }

    protected  void jQueryAjax(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("jQueryAjax has been called!");
        Person person = new Person(2, "haha2");
        Gson gson = new Gson();
        String s = gson.toJson(person);
        response.getWriter().write(s);
    }

    protected  void jQueryGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("jQueryGet has been called!");
        Person person = new Person(3, "haha3");
        Gson gson = new Gson();
        String s = gson.toJson(person);
        response.getWriter().write(s);
    }

    protected  void jQueryPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("jQueryPost has been called!");
        Person person = new Person(4, "haha4");
        Gson gson = new Gson();
        String s = gson.toJson(person);
        response.getWriter().write(s);
    }

    protected  void jQueryJson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("jQueryJson has been called!");
        Person person = new Person(5, "haha5");
        Gson gson = new Gson();
        String s = gson.toJson(person);
        response.getWriter().write(s);
    }

    protected  void jQuerySerialize(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("jQuerySerialize has been called!");
        String single = request.getParameter("single");
        String[] checks = request.getParameterValues("check");
        System.out.println(Arrays.toString(checks));
        System.out.println(single);
        Person person = new Person(6, "haha6");
        Gson gson = new Gson();
        String s = gson.toJson(person);
        response.getWriter().write(s);
    }
}
