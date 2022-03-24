package project1;


import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class File
{
    public static Map<Flower,IrisEnum> importData(String file_train)
    {
        Map<Flower,IrisEnum> data = new HashMap<>();
        try
        {
            BufferedReader file = new BufferedReader(new FileReader(file_train));
            String line = file.readLine();

            while(line != null)
            {
                String[] attributes = line.split(",");
                Flower flower = new Flower();

                flower.setSepalLength(Double.parseDouble(attributes[0]));
                flower.setSepalWidth(Double.parseDouble(attributes[1]));
                flower.setPetalLength(Double.parseDouble(attributes[2]));
                flower.setPetalWidth(Double.parseDouble(attributes[3]));

                data.put(flower,IrisEnum.forValue(attributes[4]));
                line = file.readLine();
            }
            file.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return data;
    }
}
