package com.homura.myspringboot.ee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet(urlPatterns = "/simple")
public class MySimpleServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(MySimpleServlet.class);

    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("MySimpleServlet.service()");
        resp.getWriter().write("Hello,World!");
    }
}
