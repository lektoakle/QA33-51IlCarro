package manager;

import models.Car;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderCar {

    @DataProvider
    public Iterator<Object[]> addNewCarDataFile(String filename) throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String line = reader.readLine();
        String[] strs = line.split("/",-1);
        String location = strs[0];
        String manufacture = strs[1];
        String model = strs[2];
        String year = strs[3];
        String fuel = strs[4];
        int seats = Integer.parseInt(strs[5]);
        String carClass = strs[6];
        String carRegNumber = strs[7];
        double price = Double.parseDouble(strs[8]);
        String about = strs[9];

        while (line != null) {
            System.out.println(line);
            list.add(new Object[]{Car.builder()
                    .location(location)
                    .manufacture(manufacture)
                    .model(model)
                    .year(year)
                    .fuel(fuel)
                    .seats(seats)
                    .carClass(carClass)
                    .carRegNumber(carRegNumber)
                    .price(price)
                    .about(about)
                    .build()}
            );
            line = reader.readLine();
        }


        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> addNewCarDataFilePositive() throws IOException {
        return addNewCarDataFile("src/test/resources/addNewCarPositiveData.csv");
    }
}