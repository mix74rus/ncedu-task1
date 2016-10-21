package org.lavrinocich.classifiers;

/**
 * Created by Mix74rus on 20.10.16.
 */
public class OddClassifier implements Classifier {
    private  String classProperty = "Odd";

    public boolean isInClass(int n) {
        return (n % 2) == 1;
    }

    public String getClassProperty(){
        return this.classProperty;
    }
}
