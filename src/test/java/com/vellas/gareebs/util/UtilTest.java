package com.vellas.gareebs.util;

import com.vellas.gareebs.util.Util;
import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class UtilTest {
    @Test
    public void testGetDate() throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(Util.getDate("2/7/2010"));

        assertEquals(2, cal.get(Calendar.DATE));
        assertEquals(Calendar.JULY, cal.get(Calendar.MONTH));
        assertEquals(2010, cal.get(Calendar.YEAR));
    }

    @Test
    public void testGetDoubleNumberedDate() throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(Util.getDate("12/12/2010"));

        assertEquals(12, cal.get(Calendar.DATE));
        assertEquals(Calendar.DECEMBER, cal.get(Calendar.MONTH));
        assertEquals(2010, cal.get(Calendar.YEAR));
    }

}
