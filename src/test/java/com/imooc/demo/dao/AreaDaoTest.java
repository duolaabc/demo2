package com.imooc.demo.dao;

import com.imooc.demo.entity.Area;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class AreaDaoTest {

    @Autowired
    AreaDao areadao;

    @Test
    void queryArea() {
        List<Area> areas = areadao.queryArea();
        for (Area w:areas){
            System.out.println(w.getAreaName());
        }
    }

    @Test
    void queryAreaById() {
        System.out.println(areadao.queryAreaById(2).getAreaName() );
    }

    @Test
    void insertArea() {
    }
}