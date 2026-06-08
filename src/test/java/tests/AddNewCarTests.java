package tests;

import manager.DataProviderCar;
import models.Car;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends TestBase {

    @Test(groups = {"functest", "cars"})
    public void addNewCarSuccess() {
        int i = new Random().nextInt(1000) + 1000;
        Car car = Car.builder()
                .location("Haifa")
                .manufacture("BMW")
                .model("1004")
                .year("2012")
                .fuel("Petrol")
                .seats(4)
                .carClass("3")
                .carRegNumber("FR532" + i)
                .price(100)
                .about("")
                .build();
        System.out.println(car);

        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("/home/no-u/QA_Automation/QA33-51IlCarro/src/main/resources/4-Website-Page-1500x664-241224.jpg.ximg.l_full_m.smart.jpg");
    }

    @Test(groups={"smoke", "functest","cars.data"},dataProvider = "addNewCarDataFilePositive", dataProviderClass = DataProviderCar.class)
    public void addNewCarSuccessFile(Car car) {
        System.out.println(car);
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("/home/no-u/QA_Automation/QA33-51IlCarro/src/main/resources/4-Website-Page-1500x664-241224.jpg.ximg.l_full_m.smart.jpg");
    }

}
