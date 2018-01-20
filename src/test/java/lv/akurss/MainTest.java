package lv.akurss;

import org.junit.Assert;
import org.junit.Test;



public class MainTest {

    @Test

    public void testFormat (){

        String input = "Test &nbsp; &lt; &gt;";
        String formatted = Main.format(input);
        Assert.assertEquals("\n\n=======================\nTest   < >\n====================\n", formatted);

    }

}