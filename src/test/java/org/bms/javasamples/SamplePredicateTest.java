package org.bms.javasamples;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SamplePredicateTest {

    @Test
    public void testPredicate() throws Exception {
        SamplePredicate<String> p1 = t -> t.contains("bhag");
        assertTrue(p1.test("bhagyashree"));

        SamplePredicate<String> p2 = t -> t.length() < 20;

        SamplePredicate<String> p3 = p1.and(p2);

        assertTrue(p3.test("bhagyashree"));

        SamplePredicate<String> p4 = SamplePredicate.equalTo("bhagyashree");

        assertTrue(p4.test("bhagyashree"));
        assertFalse(p4.test("randomStr"));

        SamplePredicate<Integer> p5 = SamplePredicate.equalTo(100);
        assertTrue(p5.test(100));
    }
}
