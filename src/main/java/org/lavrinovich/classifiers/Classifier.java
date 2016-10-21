package org.lavrinovich.classifiers;

public interface Classifier {
    boolean isInClass(int n);

    String getClassProperty();
}
