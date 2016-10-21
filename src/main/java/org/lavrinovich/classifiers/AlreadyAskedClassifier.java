package org.lavrinovich.classifiers;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class AlreadyAskedClassifier implements Classifier {
    private String classProperty = "Already asked";
    private Set<Integer> alreadyAsked = new HashSet<>();
    @Override
    public boolean isInClass(int n) {
        if (alreadyAsked.contains(n)){
            return true;
        } else {
            alreadyAsked.add(n);
            return false;
        }
    }

    @Override
    public String getClassProperty() {
        return this.classProperty;
    }
}
