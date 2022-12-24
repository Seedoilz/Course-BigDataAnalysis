import java.io.FileReader;

import weka.filters.Filter;
import weka.attributeSelection.PrincipalComponents;

import weka.core.Instances;
public class MainDemo {
    public static void main(String[] args) throws Exception {
        FileReader reader =  new FileReader("src/main/resources/titanic.arff");
        Instances data = new Instances(reader);
        PrincipalComponents pca = new PrincipalComponents();
        pca.setMaximumAttributeNames(3);
        pca.buildEvaluator(data);
        System.out.println(pca);
    }
}
