package cn.neusoft.config;

import cn.neusoft.filter.RequestTimeFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    //配置Filter作用于那个访问规则上
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {

        return builder.routes().route(r -> r.path("/kehufuwu/**")
                //去掉1个前缀
                        .filters(f -> f.stripPrefix(1)
                        .filter(new RequestTimeFilter()))
                        .uri("lb://customer-service-center")
                        .order(0)
                        .id("test-RequestTimeFilter")
                ).build();
    }
}
