package org.lavrinovich.classifiers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Mix74rus on 22.10.16.
 */
@RunWith(Parameterized.class)
public class IsSquareClassifierTest {
    private int input;
    private boolean expected;
    private Classifier classifier = new IsSquareClassifier();


    @Parameterized.Parameters
    public static Collection<Object[]> data () {
        return Arrays.asList(new Object[][]{
                {12, false},
                {13, false},
                {42, false},
                {14, false},
                {37, false},
                {36, true},
                {1, true},
                {25, true},
                {1024, true}
        });
    }

    public IsSquareClassifierTest (int input, boolean expected){
        this.input = input;
        this.expected = expected;
    }
    @Test
    public void isInClassTest() throws Exception {
        assertEquals(classifier.isInClass(input),expected);
    }

}