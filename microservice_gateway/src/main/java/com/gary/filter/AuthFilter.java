package com.gary.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
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
        int i = 100/0;

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        HttpServletResponse response = context.getResponse();

        String token = request.getParameter("token");
        if(!"user".equals(token)){
            context.setSendZuulResponse(false);
            response.setStatus(401);

            return null;
        }

        return null;
    }
}
