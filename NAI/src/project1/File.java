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
                double[] attributes_double = new double[attributes.length - 1];

                for(int i = 0; i < attributes.length - 1; i++)
                    attributes_double[i] = Double.parseDouble(attributes[i]);

                flower.setAttributes(attributes_double);

                data.put(flower,IrisEnum.forValue(attributes[attributes.length-1]));
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
