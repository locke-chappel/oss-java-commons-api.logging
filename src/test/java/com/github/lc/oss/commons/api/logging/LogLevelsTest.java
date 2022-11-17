package com.github.lc.oss.commons.api.logging;

import java.util.Arrays;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogLevelsTest {
    @Test
    public void test_enumFunctions() {
        LogLevels[] values = LogLevels.values();
        Set<LogLevels> all = LogLevels.all();
        Assertions.assertEquals(values.length, all.size());
        Assertions.assertSame(all, LogLevels.all());
        Arrays.stream(values).forEach(v -> Assertions.assertTrue(all.contains(v)));
        all.stream().forEach(a -> {
            Assertions.assertTrue(LogLevels.hasName(a.name()));
            Assertions.assertSame(a, LogLevels.byName(a.name()));
            Assertions.assertSame(a, LogLevels.tryParse(a.name()));

            Assertions.assertTrue(LogLevels.hasLevel(a.level()));
            Assertions.assertSame(a, LogLevels.byLevel(a.level()));
        });

        try {
            LogLevels.byLevel(-1);
            Assertions.fail("Expected exception");
        } catch (IllegalArgumentException ex) {
            Assertions.assertEquals("No LogLevels for level -1", ex.getMessage());
        }
    }
}
