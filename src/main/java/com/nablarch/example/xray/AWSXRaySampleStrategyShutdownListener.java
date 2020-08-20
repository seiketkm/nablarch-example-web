package com.nablarch.example.xray;

import com.amazonaws.xray.AWSXRay;
import nablarch.core.log.Logger;
import nablarch.core.log.LoggerManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AWSXRaySampleStrategyShutdownListener implements ServletContextListener {
    private static final Logger LOGGER = LoggerManager.get(AWSXRaySampleStrategyShutdownListener.class);
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.logInfo("Sampling strategy shutdown start.");
        AWSXRay.getGlobalRecorder().getSamplingStrategy().shutdown();
        LOGGER.logInfo("Sampling strategy shutdown complete.");
    }
}
