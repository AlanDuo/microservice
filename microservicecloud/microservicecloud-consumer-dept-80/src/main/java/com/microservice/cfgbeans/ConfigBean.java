package com.microservice.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced//开启负载均衡,SpringCloud Ribbon是基于Netflix Ribbon实现的一套客户端  负载均衡工具
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    /*@Bean
    public IRule myRule(){
        //return new RoundRobinRule();//轮询
        //return new RandomRule();//达到的目的，用我们重新选择的随机算法替代默认的轮询
        return new RetryRule();//重试
    }*/
}
