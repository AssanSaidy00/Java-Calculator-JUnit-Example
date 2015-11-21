package simplejavacalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import simplejavacalculator.Calculator.BiOperatorModes;


public class CalculatorTest {
	Calculator cal;
	@Before
	public void setUp()
	{
		cal=new Calculator();
	}
	
	@Test

	public void testNormal() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, InvocationTargetException {
		Field field1= cal.getClass().getDeclaredField("num1");
		field1.setAccessible(true);
		Double num_1=12.0;
		Double num_2=Double.POSITIVE_INFINITY;
		field1.set(cal, num_1);
		Field field2= cal.getClass().getDeclaredField("num2");
		field2.setAccessible(true);
		field2.set(cal, num_2);
		Field field3= cal.getClass().getDeclaredField("mode");
		field3.setAccessible(true);
		field3.set(cal, BiOperatorModes.normal);
		Method method=cal.getClass().getDeclaredMethod("calculateBiImpl", null);
		method.setAccessible(true);
		Double res=(Double) method.invoke(cal, null);
		System.out.println(res);
        assertEquals(num_2,res,0); 
	}

	public void testAdd() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, InvocationTargetException {
		Double num_1=10.1;
		Double num_2=Double.POSITIVE_INFINITY;
		Field field1= cal.getClass().getDeclaredField("num1");
		field1.setAccessible(true);
		field1.set(cal, num_1);
		Field field2= cal.getClass().getDeclaredField("num2");
		field2.setAccessible(true);
		field2.set(cal, num_2);
		Field field3= cal.getClass().getDeclaredField("mode");
		field3.setAccessible(true);
		field3.set(cal, BiOperatorModes.add);
		Method method=cal.getClass().getDeclaredMethod("calculateBiImpl", null);
		method.setAccessible(true);
		Double res=(Double) method.invoke(cal, null);
		System.out.println(res);
        assertEquals(num_1+num_2,res,0); 
	}

	public void test() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, InvocationTargetException {
		Field field1= cal.getClass().getDeclaredField("mode");
		field1.setAccessible(true);
		field1.set(cal, BiOperatorModes.normal);
		Field field2= cal.getClass().getDeclaredField("num1");
		field2.setAccessible(true);
		Double num1=100.0;
		field2.set(cal, num1);
		BiOperatorModes newmode=BiOperatorModes.minus;
		Double num=Double.POSITIVE_INFINITY;
		cal.calculateBi(newmode, num);
		Double num_2=7.0;
		Field field3= cal.getClass().getDeclaredField("num2");
		field3.setAccessible(true);
		field3.set(cal, num_2);
		Method method=cal.getClass().getDeclaredMethod("calculateBiImpl", null);
		method.setAccessible(true);
		Double res=(Double) method.invoke(cal, null);
		System.out.println(res);
        assertEquals(num-num_2,res,0); 
	}
	
	
	public void testBi() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		Field field1= cal.getClass().getDeclaredField("mode");
		field1.setAccessible(true);
		field1.set(cal, BiOperatorModes.add);
		Field field2= cal.getClass().getDeclaredField("num1");
		field2.setAccessible(true);
		Field field3= cal.getClass().getDeclaredField("num2");
		field3.setAccessible(true);
		Double num1=10.0;
		field2.set(cal, num1);
		BiOperatorModes newmode=BiOperatorModes.minus;
		Double num=Double.POSITIVE_INFINITY;
		Double res=cal.calculateBi(newmode, num);
		System.out.println(res);
		assertEquals(num1+num,res,0);				  	//return num1=calculateBi()?
		assertEquals(num,(Double)field3.get(cal),0);  	//num2=num?
		if(newmode!=(BiOperatorModes)field1.get(cal)) 	//mode=newmode?
			fail("mode is not set");

	}
	
	
}
