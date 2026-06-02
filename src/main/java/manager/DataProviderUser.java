package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]> loginDataFile(String filename) throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String line = reader.readLine();
        String[] strs = line.split(",");

        while (line != null) {
            list.add(new Object[]{new User().setName("Ann").setLastName("Smith").setEmail(strs[0]).setPassword(strs[1])});
            line = reader.readLine();

        }
        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> positiveLoginDataFile() throws IOException {
        return loginDataFile("src/test/resources/positiveLoginData.csv");

    }

    @DataProvider
    public Iterator<Object[]> negativeLoginData_wrongEmail() throws IOException {
        return loginDataFile("src/test/resources/negativeLoginData_wrongEmail.csv");

    }

    @DataProvider
    public Iterator<Object[]> negativeLoginData_wrongPassword() throws IOException {
        return loginDataFile("src/test/resources/negativeLoginData_wrongPassword.csv");

    }

    @DataProvider
    public Iterator<Object[]> positiveLoginData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setName("A").setLastName("B").setEmail("testemail@test.com").setPassword("aA1@fdfdf")});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> negativeLoginWrongEmailData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setName("A").setLastName("B").setEmail("testemailtest.com").setPassword("aA1@fdfdf")});

//        "testemailtest.com", password)

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> negativeLoginWrongPasswordData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setName("A").setLastName("B").setEmail("testemail@test.com").setPassword("aA@fdfdf")});

        return list.iterator();
    }
}
