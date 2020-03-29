package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySefRule {
    @Bean
    public IRule myRule(){
        //return new RandomRule();//达到的目的，用我们重新选择的随机算法替代默认的轮询
        return new RandomRule_LHD();//自定义的，每台机器五次
    }
}
