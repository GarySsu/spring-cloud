package com.gary.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gary.response.BaseResponse;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class ErrorFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.ERROR_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletResponse response = context.getResponse();

        ZuulException exception = (ZuulException)context.get("throwable");

        BaseResponse message = new BaseResponse("401",exception.getMessage());

        ObjectMapper mapper = new ObjectMapper();
        try {
            String result  = mapper.writeValueAsString(message);
            response.setContentType("text/json;charset=utf8");
            response.getWriter().write(result);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }
}
