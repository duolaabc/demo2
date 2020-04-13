package com.imooc.demo.web;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.imooc.demo.entity.ListArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;


@RestController
@RequestMapping("/superadmin")
public class AreaController {

    @Autowired
    AreaService areaService;

    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    public Map<String,List> listArea(){
        List<Area> areas = areaService.queryArea();
        Map<String,List> map = new HashMap<String,List>();
        map.put("区域的列表",areas);

        return map;
    }

    @RequestMapping(value = "/getareabyid", method = RequestMethod.GET)
    public Map<String,Area> queryAreaById(@RequestParam int areaId){
        Area area = areaService.queryAreaById(areaId);

        Map<String,Area> map = new HashMap<String,Area>();
        map.put("对应id的区域",area);

        return map;

    }

    @RequestMapping(value = "/modifyarea", method = RequestMethod.POST)
    public Map<String,Object> addArea(@RequestBody Area area){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("sucess",areaService.addArea(area));
        return map;
    }

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public Area[] testArray(Area[] areas){

        return areas;
    }

    //http://localhost:8080/superadmin/test2?Areas%5B0%5D.areaId=1&Areas%5B0%5D.areaName=c&Areas%5B1%5D.areaId=2&Areas%5B1%5D.areaName=b&Areas%5B2%5D.areaId=3&Areas%5B2%5D.areaName=l
    @RequestMapping(value = "/test2")
    public List<Area> testList(ListArea areas){

        return areas.getAreas();
    }
}
