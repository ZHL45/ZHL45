package cn.neusoft.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
public class RequestTimeFilter implements GatewayFilter, Ordered {

    private static final String COUNT_Start_TIME = "countStartTime";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("--------进入------RequestTimeFilter--------------");
        //开始时间
        exchange.getAttributes().put(COUNT_Start_TIME, System.currentTimeMillis());
        //执行完成之后
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    //开始时间
                    Long startTime = exchange.getAttribute(COUNT_Start_TIME);
                    //结束时间
                    Long endTime=(System.currentTimeMillis() - startTime);
                    if (startTime != null) {
                        log.info(exchange.getRequest().getURI().getRawPath() + ": " + endTime + "ms");
                    }
                })
        );
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
