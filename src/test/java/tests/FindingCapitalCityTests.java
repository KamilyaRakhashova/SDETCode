package tests;

import org.junit.Assert;
import org.junit.Test;
import program.FindingCapitalCity;

public class FindingCapitalCityTests {

    @Test
    public void test1(){
        String name="Peru";
        Assert.assertEquals("[Lima]", FindingCapitalCity.getCapitalByName(name));
    }

    @Test
    public void test2(){
        String name="United";
        Assert.assertEquals("[Dodoma]", FindingCapitalCity.getCapitalByName(name));
    }

    @Test
    public void test3(){
        String name="InvalidName";
        Assert.assertEquals("", FindingCapitalCity.getCapitalByName(name));
    }

    @Test
    public void test4(){
        String code="pe";
        Assert.assertEquals("[Lima]", FindingCapitalCity.getCapitalByCode(code));
    }

    @Test
    public void test5(){
        String code="604";
        Assert.assertEquals("[Lima]", FindingCapitalCity.getCapitalByCode(code));
    }

    @Test
    public void test6(){
        String code="InvalidCode";
        Assert.assertEquals("", FindingCapitalCity.getCapitalByCode(code));
    }


}
