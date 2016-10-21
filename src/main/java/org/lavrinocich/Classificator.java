package org.lavrinocich;

import org.lavrinocich.classifiers.Classifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Classificator {

    List<Classifier> classifiers;

    public void setClassifiers(List<Classifier> classifiers) {
        this.classifiers = classifiers;
    }

    Map<String, Boolean> clasifyNumber(int n) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        for (Classifier classifier : classifiers){
            map.put(classifier.getClassProperty(), classifier.isInClass(n));
        }
        return map;
    }
}
