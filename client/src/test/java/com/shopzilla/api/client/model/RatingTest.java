package com.shopzilla.api.client.model;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Rachel Baldovino <rbaldovino@shopzilla.com>
 * @created 4/30/14
 */
public class RatingTest {

    Rating rating;

    @Before
    public void setUp() {
        rating = new Rating();
    }

    @Test
    public void testGettersAndSetters() {
        rating.setDimension(null);
        rating.setValue(null);
        rating.setMax(10);
        rating.setMin(0);

        assertNull(rating.getDimension());
        assertNull(rating.getValue());

        rating.setDimension("average");
        rating.setValue(new BigDecimal(4.21));
        rating.setMax(10);
        rating.setMin(0);

        assertEquals("average", rating.getDimension());
        assertEquals(new BigDecimal(4.21), rating.getValue());
        assertEquals(10, rating.getMax());
        assertEquals(0, rating.getMin());
    }

    @Test
    public void testEquals() {
        assertFalse(rating.equals(null));
        assertFalse(rating.equals(new Object()));

        Rating rating2 = new Rating();
        assertTrue(rating.equals(rating2));

        rating.setDimension("dimension");
        assertFalse(rating.equals(rating2));
        rating2.setDimension("dimension");
        assertTrue(rating.equals(rating2));
        assertEquals(rating.hashCode(), rating2.hashCode());

        rating.setValue(new BigDecimal(421L));
        assertFalse(rating.equals(rating2));
        assertFalse(rating.toString().equals(rating2.toString()));
    }

}
