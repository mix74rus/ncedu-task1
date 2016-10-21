package org.lavrinocich.classifiers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PrimeClassifierTest {

    private int input;
    private boolean expected;
    private Classifier classifier = new PrimeClassifier();

    @Parameterized.Parameters
    public static Collection<Object[]> data () {
        return Arrays.asList(new Object[][]{
                {12, false},
                {13, true},
                {42, false},
                {14, false},
                {37, true}
        });
    }

    public PrimeClassifierTest(int input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void inClassTest(){
        assertEquals(classifier.isInClass(input),expected);
    }

}