package com.homura.myspringboot.ee;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener(value = "MyListener")
public class MyListener implements ServletContextListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyListener.class);

    /**
     * * Notification that the web application initialization process is starting. All ServletContextListeners are
     * notified of context initialization before any filter or servlet in the web application is initialized. The
     * default implementation is a NO-OP.
     *
     * @param sce Information about the ServletContext that was initialized
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOGGER.info("MyListener.contextInitialized()");
    }

    /**
     * * Notification that the servlet context is about to be shut down. All servlets and filters have been destroyed
     * before any ServletContextListeners are notified of context destruction. The default implementation is a NO-OP.
     *
     * @param sce Information about the ServletContext that was destroyed
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.info("MyListener.contextDestroyed()");
    }


}

