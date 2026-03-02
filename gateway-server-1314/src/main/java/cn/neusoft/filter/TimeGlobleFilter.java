package cn.neusoft.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class TimeGlobleFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("-------进入全局登录验证过滤器------------------");

       /* List<String> token = exchange.getRequest().getHeaders().get("token");

        log.info("检查 TOKEN = {}" ,token);
        if(token == null || token.isEmpty()){
            //响应对象
            ServerHttpResponse response = exchange.getResponse();
            //构建错误结果
            ResultBean data = ResultBean.error(401,"未登录");

            DataBuffer buffer = null;
            try {
                byte[] bytes = JSON.toJSONString(data).getBytes("utf-8");
                buffer = response.bufferFactory().wrap(bytes);

                //设置完成相应，不会继续执行后面的filter
                //response.setComplete();
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                response.getHeaders().add("Content-Type","application/json;charset=UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            //把结果写给客户端   没有放行
            return response.writeWith(Mono.just(buffer));
        }

        log.info("Token不为空 ，放行");*/
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
