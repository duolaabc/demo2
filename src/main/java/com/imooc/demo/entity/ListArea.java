package com.imooc.demo.entity;

import java.util.List;

public class ListArea {          //此类用于接收数据绑定时      前端返回多个Area,后端不能直接用list接收，需要一个包装类     当然可以直接使用数组来映射

    List<Area> Areas ;


    public List<Area> getAreas() {
        return Areas;
    }

    public void setAreas(List<Area> areas) {
        Areas = areas;
    }

    @Override
    public String toString() {
        return "ListArea{" +
                "Areas=" + Areas +
                '}';
    }
}
