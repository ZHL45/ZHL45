package cn.neusoft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("cn.neusoft.mapper")    //扫描mapper层所在的包，为接口创建代理
public class FinanceServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(FinanceServiceApp.class);
    }
}
