package org.lavrinocich.classifiers;

public class PrimeClassifier implements Classifier {
    private  String classProperty = "Odd";

    public boolean isInClass(int n) {
        for (int i = 2; i < n/2; i++){
            if ((n % i) == 0)
                return false;
        }
        return true;
    }

    public String getClassProperty(){
        return this.classProperty;
    }
}
