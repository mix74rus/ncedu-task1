package classifiers;

public class PrimeClassifier implements Classifier {
    public boolean isInClass(int n) {
        for (int i = 2; i < n/2; i++){
            if ((n % i) == 0)
                return false;
        }
        return true;
    }
}
