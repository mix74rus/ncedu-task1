package org.lavrinovich.classifiers;

/**
 * Created by Mix74rus on 22.10.16.
 */
public class IsSquareClassifier implements Classifier {
    private String classProrerty = "Is Square?";
    @Override
    public boolean isInClass(int n) {
        return Math.floor(Math.sqrt(n)) == Math.sqrt(n);
    }

    @Override
    public String getClassProperty() {
        return this.classProrerty;
    }
}
