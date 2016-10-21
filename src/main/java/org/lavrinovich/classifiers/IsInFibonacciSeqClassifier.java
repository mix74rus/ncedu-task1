package org.lavrinovich.classifiers;

/**
 * Created by Mix74rus on 22.10.16.
 */
public class IsInFibonacciSeqClassifier implements Classifier {
    private String classProperty = "Is in Fibonacci Sequence?";

    @Override
    public boolean isInClass(int n) {
        int fibPrev = 0;
        int fibCurr = 1;
        int firNext = fibCurr + fibPrev;
        while (firNext < n){
            fibPrev = fibCurr;
            fibCurr = firNext;
            firNext = fibCurr + fibPrev;
        }
        return firNext == n;
    }

    @Override
    public String getClassProperty() {
        return this.classProperty;
    }
}
