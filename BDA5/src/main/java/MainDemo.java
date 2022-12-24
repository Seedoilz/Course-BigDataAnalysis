import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import java.io.FileReader;

public class MainDemo {
    public static void main(String[] args) throws Exception {
        FileReader reader =  new FileReader("src/main/resources/iris.arff");
        Instances data = new Instances(reader);
        SimpleKMeans simpleKMeans = new SimpleKMeans();
        simpleKMeans.setNumClusters(3);
        simpleKMeans.setMaxIterations(5);
        simpleKMeans.buildClusterer(data);
        System.out.println(simpleKMeans);
    }
}
