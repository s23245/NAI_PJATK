package project1;

import java.util.Iterator;
import java.util.Map;

public class Main
{
    public static void main(String[] args)
    {
        Map<Flower,IrisEnum> trainData = File.importData("/Users/bohdanmacbook/IdeaProjects/PJWSTK/NAI/src/project1/train.txt");
        Map<Flower,IrisEnum> testData = File.importData("/Users/bohdanmacbook/IdeaProjects/PJWSTK/NAI/src/project1/test.txt");

        KNN.setK(2);
        KNN.setTrainingSet(trainData);
        int goodPredictedValues = 0;
        int badPredictedValues = 0;

        for (Map.Entry<Flower,IrisEnum> entry : testData.entrySet())
        {
            System.out.println("ENTRY: " + entry.getKey().getSepalWidth() + " VALUE: " + entry.getValue());
            IrisEnum prediction = KNN.predictResult(entry.getKey());

            if(prediction == entry.getValue())
                goodPredictedValues++;
        }

        badPredictedValues = testData.size() - goodPredictedValues;

        System.out.println("GOOD PREDICTED VALUES: " + goodPredictedValues + " BAD PREDICTED VALUES: " + badPredictedValues);

    }
}
