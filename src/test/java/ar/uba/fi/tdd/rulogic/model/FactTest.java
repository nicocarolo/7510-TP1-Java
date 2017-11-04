package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FactTest {

    @Test
    public void testFactShouldBeCreatedWithNameAndValue() {
        String[] params = {"javier"};
        Fact fact = new Fact("varon", params);

        Assert.assertTrue(fact.getName() == "varon" && Arrays.equals(fact.getValues(), params));
    }

    @Test
    public void testFactShouldBeCreatedWithNameAndValues() {
        String[] params = {"javier", "marta"};
        Fact fact = new Fact("hija", params);

        Assert.assertTrue(fact.getName() == "hija" && Arrays.equals(fact.getValues(), params));
    }

    @Test
    public void testFactShouldGetFactAsString() {
        String[] params = {"juan", "hose"};
        Fact fact = new Fact("varon", params);
        System.out.println(fact.toString());
        Assert.assertTrue(fact.toString().equals("varon(juan, hose)."));
    }
}
