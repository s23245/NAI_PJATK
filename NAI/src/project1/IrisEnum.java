package project1;

public enum IrisEnum
{
    virginica("Iris-virginica"),
    setosa("Iris-setosa"),
    versicolor("Iris-versicolor");

    private String value;

    IrisEnum(String value)
    {
        this.value = value;
    }

    public static IrisEnum forValue(String value)
    {
        for(IrisEnum type : IrisEnum.values())
        {
            if(type.value.equals(value))
                return type;
        }
       throw new IllegalArgumentException("THERE ARE NO SUCH TYPE OF FLOWER");
    }
}
