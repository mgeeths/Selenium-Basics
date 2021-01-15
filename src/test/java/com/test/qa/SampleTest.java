package com.test.qa;

import org.junit.Assert;
import org.junit.Test;

public class SampleTest {

    @Test
    public void addMethod(){
        int a = 2;
        int b = 5;
        int c = a+b;
        System.out.println("Answer is :"+c);
        Assert.assertTrue(c == 7);
    }
}
