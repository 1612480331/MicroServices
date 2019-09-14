package com.example.hellospringbootzuul.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建 WebAdminFeign网关访问故障的回调函数
 */
@Component
public class WebAdminFeignFallBackProvider implements FallbackProvider {
    /**
     * @return 所回到服务的应用id
     */
    @Override
    public String getRoute() {
        return "hello-spring-cloud-web-admin-feign";
    }

    /**
     * 网关向api服务请求失败了，但是消费者客户端向网关发起的
     * 请求还是成功的
     * @param route
     * @param cause
     * @return
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return  HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            /**
             * 响应内容主体
             * @return
             * @throws IOException
             */
            @Override
            public InputStream getBody() throws IOException {
                ObjectMapper objectMapper=new ObjectMapper();
                Map<String,Object> map=new HashMap<>();
                map.put("status",200);
                map.put("message","无法连接，请检查您的网络");
                return new ByteArrayInputStream(objectMapper.writeValueAsString(map).getBytes("utf-8"));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers=new HttpHeaders();
                //和getBody中的编码一致，代表响应的是json数据
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }
        };
    }
}
