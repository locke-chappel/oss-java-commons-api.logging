package com.github.lc.oss.commons.api.logging;

import com.github.lc.oss.commons.serialization.Jsonable;

public interface LogEntry extends Jsonable {
    long getTimeStamp();

    LogLevels getLevel();

    String getLoggerName();

    String getMessage();

    String getThreadName();

    String getStackTrace();
}
