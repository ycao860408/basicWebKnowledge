package com.atguigu.dom4j;

import com.atguigu.pojo.Book;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class Dom4jTest {
    @Test
    public void test1() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document dom = saxReader.read("src/books.xml");
        System.out.println(dom);
    }

    @Test
    public void test2() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document dom = reader.read("src/books.xml");
        Element root = dom.getRootElement();
        //System.out.println(root.asXML());
        List<Element> books = root.elements("book");
        for (Element book : books) {
            String name = book.elementText("name");
            String price = book.elementText("price");
            String author = book.elementText("author");
            String sn = book.attributeValue("sn");
            System.out.println(new Book(sn, name, price, author));
        }
    }
}
