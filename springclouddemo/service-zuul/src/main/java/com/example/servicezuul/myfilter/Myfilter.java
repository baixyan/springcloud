package com.example.servicezuul.myfilter;

import com.example.servicezuul.util.MD5Util;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

/**
 * created by baixuyan on 2018/6/19
 *
 * @author baixuyan
 **/

/*ilterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
 *pre：路由之前
 *routing：路由之时
 *post： 路由之后
 *error：发送错误调用
 *filterOrder：过滤的顺序
 *shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
 *run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
 */

public class Myfilter extends ZuulFilter
{

    private static org.slf4j.Logger log = LoggerFactory.getLogger(Myfilter.class);

    @Override
    public String filterType() {
        return "pre";
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
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        String method = "post";
        String accessMethod = request.getMethod();
        String tempstr = "";
        String requestbody = "";
        try
        {
            BufferedReader bf = request.getReader();
            while ((tempstr = bf.readLine()) != null)
            {
                requestbody += tempstr;
            }
        } catch (Exception e)
        {
        }
        if (method.equalsIgnoreCase(accessMethod))
        {
            try
            {
                //String bodyStr = ReadUtil.getBody(request);
                log.info("requestbody:" + requestbody);
                String bodyMd5Check = MD5Util.MD5(requestbody);
                Object bodyMd5 = request.getHeader("bodyMd5");
                if (bodyMd5.equals(bodyMd5Check))
                {
                    try
                    {
                        ctx.setSendZuulResponse(true);
                        ctx.setResponseStatusCode(200);
                    } catch (Exception e)
                    {


                    }
                } else
                {
                    try
                    {
                        ctx.setSendZuulResponse(false);
                        ctx.setResponseStatusCode(401);
                        ctx.getResponse().getWriter().write("bodyMd5Check is not the same as bodyMd5");



                    } catch (Exception e)
                    {

                    }

                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            //Object accessToken = request.getParameter("token");
        /*if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }*/
        //log.info("ok");

        }
        return null;
    }
}
