package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

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
