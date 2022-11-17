package com.github.lc.oss.commons.api.logging;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.github.lc.oss.commons.serialization.Message.Category;
import com.github.lc.oss.commons.util.TypedEnumCache;

public enum LogLevels implements Category {
    Error(40000),
    Warn(30000),
    Info(20000),
    Debug(10000),
    Trace(5000);

    private static final TypedEnumCache<LogLevels, LogLevels> CACHE = new TypedEnumCache<>(LogLevels.class);
    private static final Map<Integer, LogLevels> INT_CACHE;
    static {
        Map<Integer, LogLevels> map = new HashMap<>();
        for (LogLevels logLevel : LogLevels.all()) {
            map.put(logLevel.level(), logLevel);
        }
        INT_CACHE = Collections.unmodifiableMap(map);
    }

    public static Set<LogLevels> all() {
        return LogLevels.CACHE.values();
    }

    public static LogLevels byLevel(int level) {
        LogLevels value = LogLevels.INT_CACHE.get(level);
        if (value == null) {
            throw new IllegalArgumentException("No LogLevels for level " + level);
        }
        return value;
    }

    public static LogLevels byName(String name) {
        return LogLevels.CACHE.byName(name);
    }

    public static boolean hasName(String name) {
        return LogLevels.CACHE.hasName(name);
    }

    public static boolean hasLevel(int level) {
        return LogLevels.INT_CACHE.containsKey(level);
    }

    public static LogLevels tryParse(String name) {
        return LogLevels.CACHE.tryParse(name);
    }

    private final int level;

    private LogLevels(int level) {
        this.level = level;
    }

    public int level() {
        return this.level;
    }
}
