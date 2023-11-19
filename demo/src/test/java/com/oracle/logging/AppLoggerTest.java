package com.oracle.logging;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

public class AppLoggerTest {
    private Logger loggerMock;
    private AppLogger appLogger;

    @BeforeEach
    public void setup() {
        loggerMock = Mockito.mock(Logger.class);
        appLogger = AppLogger.getInstance();
        appLogger.setLogger(loggerMock);
    }

    @Test
    public void testLogInfo() {
        String message = "Test info message";
        appLogger.logInfo(message);

        Mockito.verify(loggerMock).info(message);
    }

    @Test
    public void testLogWarn() {
        String message = "Test warn message";
        appLogger.logwarn(message);

        Mockito.verify(loggerMock).warn(message);
    }

    @Test
    public void testLogError() {
        String message = "Test error message";
        appLogger.logerror(message);

        Mockito.verify(loggerMock).error(message);
    }

    @Test
    public void testLogDebug() {
        String message = "Test debug message";
        appLogger.logdebug(message);

        Mockito.verify(loggerMock).debug(message);
    }
}