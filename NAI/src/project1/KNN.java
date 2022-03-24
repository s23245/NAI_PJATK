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

        distnace += Math.pow(flow1.getSepalLength() - flow2.getSepalLength(),2);
        distnace += Math.pow(flow1.getSepalWidth() - flow2.getSepalWidth(),2);
        distnace += Math.pow(flow1.getPetalLength() - flow2.getPetalLength(),2);
        distnace += Math.pow(flow1.getPetalWidth() - flow2.getPetalWidth(),2);


        return Math.sqrt(distnace);
    }


}
