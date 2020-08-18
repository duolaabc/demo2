package com.imooc.demo.service.Impl;

import com.imooc.demo.dao.AreaDao;

import com.imooc.demo.entity.Area;

import com.imooc.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl  implements AreaService {

    @Autowired
    private AreaDao aredao;

    @Autowired
    private RedisTemplate redisTemplate;


    public List<Area> queryArea(){
        redisTemplate.opsForList();
        return aredao.queryArea();
    }

    public Area queryAreaById(int areaId){
        return aredao.queryAreaById(areaId);
    }

    @Transactional
    public boolean addArea(Area area){
        if(area.getAreaName()!=null&&!"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                if(aredao.insertArea(area)>0) return true;
                else throw new RuntimeException("添加区域信息失败!");
            }catch (Exception e){
                throw new RuntimeException("添加区域信息失败:" + e.toString());
            }
        }else{
            throw new RuntimeException("区域信息不能为空！");
        }

    }

}
