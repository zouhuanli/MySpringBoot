package com.homura.myspringboot.ee;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class MyFilter  extends HttpFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyFilter.class);

    /**
     * @param req   a {@link ServletRequest} object that contains the request the client has made of the filter
     * @param res   a {@link ServletResponse} object that contains the response the filter sends to the client
     * @param chain the <code>FilterChain</code> for invoking the next filter or the resource
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        if (!(req instanceof HttpServletRequest && res instanceof HttpServletResponse)) {
            throw new ServletException("non-HTTP request or response");
        }
        beforeDo(req);
        chain.doFilter(req, res);
        afterDo(req, res);
    }

    /**
     * 前置处理
     * @param req
     * @param res
     */
    private void afterDo(ServletRequest req, ServletResponse res) {
        LOGGER.info(")MyFilter.afterDo(");
    }

    /**
     * 后置处理
     * @param req
     */
    private void beforeDo(ServletRequest req) {
        LOGGER.info("MyFilter.beforeDo()");
    }

}
