package com.microservice.service.Impl;

import com.microservice.dao.DeptDao;
import com.microservice.entity.Dept;
import com.microservice.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;
    @Override
    public boolean addDept(Dept dept){
        return deptDao.addDept(dept);
    }
    @Override
    public Dept findById(Long id){
        return deptDao.findById(id);
    }
    @Override
    public List<Dept> findAll(){
        return deptDao.findAll();
    }
}
