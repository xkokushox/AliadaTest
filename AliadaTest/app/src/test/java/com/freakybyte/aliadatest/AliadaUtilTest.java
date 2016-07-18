package com.freakybyte.aliadatest;

import com.freakybyte.aliadatest.util.AliadaUtil;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jose Torres in FreakyByte on 28/06/16.
 */
public class AliadaUtilTest {

    @Test
    public void testUserValid() {

        boolean isInValidEmpty = AliadaUtil.isInValiedField("");
        boolean isInValidNull = AliadaUtil.isInValiedField(null);
        boolean isInValidText = AliadaUtil.isInValiedField("Username");

        assertEquals("Is Valid Empty", false, !isInValidEmpty);
        assertEquals("Is Valid Null", false, !isInValidNull);
        assertEquals("Is Valid Text", true, !isInValidText);
    }
}
