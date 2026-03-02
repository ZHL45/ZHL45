package cn.neusoft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("cn.neusoft.mapper")
public class fenzhanapp {
    public static void main(String[] args) {
        SpringApplication.run(fenzhanapp.class);
    }
}
