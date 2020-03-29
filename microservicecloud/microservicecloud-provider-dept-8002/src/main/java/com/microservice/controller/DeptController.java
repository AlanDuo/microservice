package com.microservice.controller;

import com.microservice.entity.Dept;
import com.microservice.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/dept/add")
    public boolean add(Dept dept){
        return deptService.addDept(dept);
    }
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptService.findById(id);
    }
    @GetMapping("dept/list")
    public List<Dept> list(){
        return deptService.findAll();
    }
    @GetMapping("/dept/discovery")
    public Object discovery(){
        List<String> list=discoveryClient.getServices();
        System.out.println("**********"+list);
        List<ServiceInstance> serviceInstanceList=discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for(ServiceInstance s:serviceInstanceList){
            System.out.println(s.getServiceId()+"\t"+s.getHost()+"\t"+s.getUri());
        }
        return this.discoveryClient;
    }
}
