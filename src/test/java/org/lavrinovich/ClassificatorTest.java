package org.lavrinovich;

import org.junit.Test;
import org.lavrinovich.classifiers.Classifier;
import java.util.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class ClassificatorTest {

    Classificator classificator = new Classificator();

    @Test
    public void classifiersMethodCallingTest(){
        int n = new Random().nextInt();
        Classifier classifier = mock(Classifier.class);
        classificator.setClassifiers(Arrays.asList(classifier));
        classificator.classifyNumber(n);
        verify(classifier).isInClass(n);
    }

    @Test
    public void classificationRuleTest1() {
        int n = new Random().nextInt();
        Classifier classifier = mock(Classifier.class);
        when(classifier.isInClass(n)).thenReturn(true);
        when(classifier.getClassProperty()).thenReturn("Rule");
        classificator.setClassifiers(Arrays.asList(classifier));
        assertEquals(true, classificator.classifyNumber(n).get("Rule"));
    }

    @Test
    public void classificationRuleTest2() {
        int n = new Random().nextInt();
        Classifier classifier = mock(Classifier.class);
        when(classifier.isInClass(n)).thenReturn(false);
        when(classifier.getClassProperty()).thenReturn("Rule");
        classificator.setClassifiers(Arrays.asList(classifier));
        assertEquals(false, classificator.classifyNumber(n).get("Rule"));
    }

    @Test
    public void classificatorResultTest() {
        Random random = new Random();
        int k = random.nextInt(10) + 3;
        int n = random.nextInt(1000);
        Map<String,Classifier> classifierMap = new HashMap<>();
        List<Classifier> classifierList = new ArrayList<>();
        for(int i = 0; i < k; i++){
            Classifier classifier = mock(Classifier.class);
            if(random.nextBoolean()) {
                when(classifier.isInClass(n)).thenReturn(true);
            } else {
                when(classifier.isInClass(n)).thenReturn(false);
            }
            when(classifier.getClassProperty()).thenReturn("Rule" + i);
            classifierMap.put("Rule" + i, classifier);
            classifierList.add(classifier);
        }
        classificator.setClassifiers(classifierList);
        Map<String, Boolean> result = classificator.classifyNumber(n);
        for (String key : classifierMap.keySet()){
            assertEquals(
                    classifierMap.get(key).isInClass(n),
                    result.get(key)
            );
        }

    }
}