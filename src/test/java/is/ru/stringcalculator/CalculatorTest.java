package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(4, Calculator.add("4"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testNewLine() {
        assertEquals(7, Calculator.add("1,3\n3"));
    }
    
    @Test
    public void testNegatives(){
        try {
           Calculator.add("-3,5,-8,2"); 
        }
        catch (RuntimeException ex){
           assertEquals("Negatives not allowed: -3,-8",ex.getMessage());
        }
    }
}
