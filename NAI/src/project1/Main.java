package project1;


import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Map<Flower,IrisEnum> trainData = File.importData("/Users/bohdanmacbook/IdeaProjects/PJWSTK/NAI/src/project1/train.txt");
        KNN.setK(3);
        KNN.setTrainingSet(trainData);

        Scanner scanner = new Scanner(System.in);
        System.out.println("WRITE ENTER TO USE TEST FILE OTHERWISE WRITE YOUR VECTOR");
        String str = scanner.nextLine();

        Map<Flower,IrisEnum> testData;
        if(Objects.equals(str, ""))
        {
            testData = File.importData("/Users/bohdanmacbook/IdeaProjects/PJWSTK/NAI/src/project1/test.txt");
            int goodPredictedValues = 0;
            int badPredictedValues = 0;
            int allPredictions = 0;
            int indexFlower = 1;

            for (Map.Entry<Flower,IrisEnum> entry : testData.entrySet())
            {
                System.out.print(indexFlower + "-");
                IrisEnum prediction = KNN.predictResult(entry.getKey());

                if(prediction == entry.getValue())
                    goodPredictedValues++;

                allPredictions = testData.size();
                indexFlower++;
            }

            badPredictedValues = testData.size() - goodPredictedValues;

            System.out.println("GOOD PREDICTED VALUES: " + goodPredictedValues + " BAD PREDICTED VALUES: " + badPredictedValues);
            double percentage = (double) goodPredictedValues / allPredictions;
            System.out.println("RIGHT PREDICTIONS %: " +  percentage * 100);
        }
        else
        {
            String[] attributes = str.split(",");
            Flower your_flower = new Flower();
            double[] attributes_double = new double[attributes.length - 1];

            for(int i = 0; i < attributes.length - 1; i++)
                attributes_double[i] = Double.parseDouble(attributes[i]);

            your_flower.setAttributes(attributes_double);

            Map<Flower,IrisEnum> data = new HashMap<>();

            data.put(your_flower,IrisEnum.forValue(attributes[attributes.length-1]));

            for(Map.Entry<Flower,IrisEnum> entry : data.entrySet())
            {
                IrisEnum prediction = KNN.predictResult(entry.getKey());

                System.out.println("THE PREDICTION FOR THE VECTOR IS: " + prediction);
            }
        }





    }
}
