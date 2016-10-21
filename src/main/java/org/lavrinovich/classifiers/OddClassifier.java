package org.lavrinovich.classifiers;

public class OddClassifier implements Classifier {
    private  String classProperty = "Odd";

    public boolean isInClass(int n) {
        return (n % 2) == 1;
    }

    public String getClassProperty(){
        return this.classProperty;
    }
}
