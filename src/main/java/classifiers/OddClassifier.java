package classifiers;

/**
 * Created by Mix74rus on 20.10.16.
 */
public class OddClassifier implements Classifier {
    public boolean isInClass(int n) {
        return (n % 2) == 1;
    }
}
