package com.oracle.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//クラスのインスタンスが1つしか存在しないことを保証しつつ、メソッドを非静的に保つために、シングルトンパターンを使用
public class AppLogger {
    private static final AppLogger instance = new AppLogger();
    private Logger logger;

    private AppLogger() {
        logger = LoggerFactory.getLogger(AppLogger.class);
    }

    public static AppLogger getInstance() {
        return instance;
    }

    // ログレベルは、以下の順に重要度が高い
    // TRACE < DEBUG < INFO < WARN < ERROR
    // ログレベルを変更するには、demo/src/main/resources/application.propertiesの以下の行を変更する
    public void logInfo(String message) {
        logger.info(message);
    }

    public void logwarn(String message) {
        logger.warn(message);
    }
    public void logerror(String message) {
        logger.error(message);
    }

    public void logdebug(String message) {
        logger.debug(message);
    }

    // このメソッドはテスト用です
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}