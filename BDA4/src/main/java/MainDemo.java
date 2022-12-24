import weka.classifiers.Evaluation;
import weka.core.Instance;
import weka.core.Instances;

import java.io.File;
import java.io.FileReader;
import weka.classifiers.trees.J48;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils;

public class MainDemo {
    public static void main(String[] args) throws Exception {
        //最开始用来转化文件的 没有找到arff文件
//        Instances allData = ConverterUtils.DataSource.read("src/main/resources/adult.csv");
//        ArffSaver saver = new ArffSaver();
//        saver.setInstances(allData);
//        saver.setFile(new File("src/main/resources/adult.arff"));
//        saver.writeBatch();
        FileReader reader =  new FileReader("src/main/resources/adult_income_uk.arff");
        Instances data = new Instances(reader);
        data.setClassIndex(data.numAttributes() - 1);
        J48 j48 = new J48();
        j48.buildClassifier(data);
        Evaluation evaluation = new Evaluation(data);
        Instance testInstance;
        int length=data.numInstances();
        for(int i=0;i<length;i++){
            testInstance=data.instance(i);
            evaluation.evaluateModelOnceAndRecordPrediction(j48,testInstance);
        }
        System.out.println("分类的正确率为 "+(1-evaluation.errorRate()));
        System.out.println(j48);
    }
}
