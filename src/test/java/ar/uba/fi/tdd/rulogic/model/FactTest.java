package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FactTest {

    @Test
    public void testFactShouldBeCreatedWithNameAndValue() {
        String[] params = {"javier"};
        Fact fact = new Fact("varon", params);

        Assert.assertTrue(fact.getName().equals("varon") && Arrays.equals(fact.getValues(), params));
    }

    @Test
    public void testFactShouldBeCreatedWithNameAndValues() {
        String[] params = {"javier", "marta"};
        Fact fact = new Fact("hija", params);

        Assert.assertTrue(fact.getName().equals("hija") && Arrays.equals(fact.getValues(), params));
    }

    @Test
    public void testFactShouldGetFactAsString() {
        String[] params = {"juan", "hose"};
        Fact fact = new Fact("varon", params);
        Assert.assertTrue(fact.toString().equals("varon(juan, hose)."));
    }

    @Test
    public void testFactsShouldBeEquals() {
        String[] params = {"juan", "hose"};
        Fact aFact = new Fact("varon", params);
        Fact otherFact = new Fact("varon", params);
        Assert.assertTrue(aFact.isEqualTo(otherFact));
    }

    @Test
    public void testFactsShouldNotBeEquals() {
        String[] params = {"juan", "hose"};
        String[] diffParams = {"marcos", "juan"};

        Fact aFact = new Fact("varon", params);
        Fact diffNameFact = new Fact("hijo", params);
        Fact diffValuesFact = new Fact("varon", diffParams);

        Assert.assertFalse(aFact.isEqualTo(diffNameFact));
        Assert.assertFalse(aFact.isEqualTo(diffValuesFact));
    }
}
