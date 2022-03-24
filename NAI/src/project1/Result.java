package project1;

public class Result
{
    private IrisEnum irishValue;
    private double distance;

    public Result(double distance,IrisEnum irishValue)
    {
        this.distance = distance;
        this.irishValue = irishValue;
    }

    public double getDistance() {
        return distance;
    }

    public IrisEnum getIrishValue() {
        return irishValue;
    }

}
