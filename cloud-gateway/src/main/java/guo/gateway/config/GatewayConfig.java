package guo.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author GuoJunJiang
 * @version 1.0
 * @date 2020/5/30 18:44
 */
//通过配置类的方式，配置一个路由
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRoute(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("i am id",r ->//指定路由id
            //指定断言，和断言为true后路由的路径
            r.path("/guonei").uri("http://news.baidu.com")).build();
        return routes.build();
    }
}
