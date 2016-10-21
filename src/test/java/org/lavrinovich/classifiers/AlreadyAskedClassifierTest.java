package org.lavrinovich.classifiers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;



@RunWith(Parameterized.class)
public class AlreadyAskedClassifierTest {

    private int input;
    private boolean expected;
    private static Classifier classifier = new AlreadyAskedClassifier();


    @Parameterized.Parameters
    public static Collection<Object[]> data () {
        return Arrays.asList(new Object[][]{
                {12, false},
                {12, true},
                {42, false},
                {14, false},
                {42, true},
                {42, true},
                {14, true},
                {7, false}
        });
    }

    public AlreadyAskedClassifierTest(int input, boolean expected){
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void isInClassTest(){
        assertEquals(classifier.isInClass(input),expected);
    }

}