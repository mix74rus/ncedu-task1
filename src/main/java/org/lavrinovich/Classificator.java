package org.lavrinovich;

import org.lavrinovich.classifiers.Classifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Classificator {

    private List<Classifier> classifiers;

    public void setClassifiers(List<Classifier> classifiers) {
        this.classifiers = classifiers;
    }

    Map<String, Boolean> classifyNumber(int n) {
        Map<String, Boolean> map = new HashMap<>();
        for (Classifier classifier : classifiers){
            map.put(classifier.getClassProperty(), classifier.isInClass(n));
        }
        return map;
    }
}
