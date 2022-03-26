package project1;

import java.util.*;

public class KNN
{
    private static int k;
    private static Map<Flower,IrisEnum> trainingSet;

    public KNN(int k)
    {
        KNN.k = k;
    }

    public static void setK(int k) {
        KNN.k = k;
    }

    public static void setTrainingSet(Map<Flower, IrisEnum> trainingSet) {
        KNN.trainingSet = trainingSet;
    }

    public static IrisEnum predictResult(Flower testFlower)
    {
        List<Result> results = new ArrayList<>();

        for(Map.Entry<Flower,IrisEnum> entry : trainingSet.entrySet())
        {
            results.add(new Result(calculationDistance(entry.getKey(),testFlower),entry.getValue()));
        }

        results.sort((o1, o2) ->
        {
            if (o1.getDistance() > o2.getDistance())
                return 1;
            else if (o1.getDistance() < o2.getDistance())
                return -1;

            return 0;
        });

        List<IrisEnum> nearestNeighbours = new ArrayList<>();

        for(int i = 0; i < k; i++)
            nearestNeighbours.add(results.get(i).getIrishValue());

        System.out.println("NEAREST NEIGHBOURS" + nearestNeighbours);

        return ListUtils.mostCommonItem(nearestNeighbours);
    }


    //calculation for Euclidean distance
    private static double calculationDistance(Flower flow1, Flower flow2)
    {
        // square_root (( attribute of first flower - attribute of second flower ) ^ 2 )
        double distnace = 0d;

        double[] first_flower_attributes = flow1.getAttributes();
        double[] second_flower_attributes = flow2.getAttributes();

        for(int i = 0; i < first_flower_attributes.length; i++)
        {
            distnace += Math.pow(first_flower_attributes[i] - second_flower_attributes[i],2);
        }



        return Math.sqrt(distnace);
    }


}
