package simplejavacalculator;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Field;

import java.lang.reflect.InvocationTargetException;

import java.lang.reflect.Method;
import simplejavacalculator.Calculator.BiOperatorModes;
import simplejavacalculator.Calculator.MonoOperatorModes;

public class CalculatorTest {
	Calculator cal = new Calculator();
	@Test
	public void testEqual() {
		cal.calculateBi(BiOperatorModes.add,2.0);
		assertEquals(8.0, cal.calculateBi(BiOperatorModes.add,6.0),0.0);
		assertEquals(8.0, cal.calculateBi(BiOperatorModes.add,0.0),0.0);
		assertEquals(9.1, cal.calculateBi(BiOperatorModes.add,1.1),0.0);
		assertEquals(Double.POSITIVE_INFINITY, cal.calculateBi(BiOperatorModes.add,Double.POSITIVE_INFINITY),0.0);
	}
	@Test
	public void testReset() throws IllegalArgumentException, IllegalAccessException,
										NoSuchFieldException,SecurityException,
										NoSuchMethodException, InvocationTargetException {
		  
		//≤‚ ‘∑µªÿ÷µ
		cal.calculateBi(BiOperatorModes.add,2.0);
		assertEquals(5.0, cal.calculateBi(BiOperatorModes.add,3.0),0.0);
		assertEquals(Double.NaN, cal.reset(),0.0);
		//≤‚ ‘ num1£¨num2£¨∫Õmode
		Field field1= cal.getClass().getDeclaredField("num1");
		field1.setAccessible(true);
		Field field2= cal.getClass().getDeclaredField("num2");
		field2.setAccessible(true);
		Field field3= cal.getClass().getDeclaredField("mode");
		field3.setAccessible(true);
		Double num_1=(Double) field1.get(cal); 
		Double num_2=(Double) field2.get(cal);
		BiOperatorModes MODE=(BiOperatorModes) field3.get(cal);
		assertEquals(0.0, num_1,0.0);
		assertEquals(0.0, num_2,0.0);
		assertEquals(BiOperatorModes.normal, MODE);
	}
	@Test
	public void testSquare() {
		assertEquals(4.0, cal.calculateMono(MonoOperatorModes.square,2.0),0.0);
		assertEquals(0.0, cal.calculateMono(MonoOperatorModes.square,0.0),0.0);
		assertEquals(1.21, cal.calculateMono(MonoOperatorModes.square,1.1),0.01);
		assertEquals(Double.POSITIVE_INFINITY, cal.calculateMono(MonoOperatorModes.square,Double.POSITIVE_INFINITY),0.0);
	}
	
	@Test
	public void testSquareRoot() {
		assertEquals(8, cal.calculateMono(MonoOperatorModes.squareRoot,(double) 64),0.0);
		assertEquals(0, cal.calculateMono(MonoOperatorModes.squareRoot,(double) 0),0.0);
		assertEquals(Double.NaN, cal.calculateMono(MonoOperatorModes.squareRoot,(double) -64),0.0);
		assertEquals(Double.POSITIVE_INFINITY, cal.calculateMono(MonoOperatorModes.squareRoot,(double) Double.POSITIVE_INFINITY),0.0);
	}
	@Test
	public void testOneDevidedBy() {
		assertEquals(Double.POSITIVE_INFINITY, cal.calculateMono(MonoOperatorModes.oneDevidedBy,0.0),0.0);
		assertEquals(0.2, cal.calculateMono(MonoOperatorModes.oneDevidedBy,5.0),0.0);
		assertEquals(5.0, cal.calculateMono(MonoOperatorModes.oneDevidedBy,0.2),0.0);
		assertEquals(0.0, cal.calculateMono(MonoOperatorModes.oneDevidedBy,Double.POSITIVE_INFINITY),0.0);
	}
	@Test
	public void testCos() {
		assertEquals(1.0, cal.calculateMono(MonoOperatorModes.cos,0.0),0.0);
		assertEquals(0.540, cal.calculateMono(MonoOperatorModes.cos,1.0),0.001);
		assertEquals(0.0, cal.calculateMono(MonoOperatorModes.cos,Math.PI/2),0.001);
		assertEquals(Double.NaN, cal.calculateMono(MonoOperatorModes.cos,Double.POSITIVE_INFINITY),0.001);
	}
	@Test
	public void testSin() {
		assertEquals(0.0, cal.calculateMono(MonoOperatorModes.sin,0.0),0.0);
		assertEquals(0.841, cal.calculateMono(MonoOperatorModes.sin,1.0),0.001);
		assertEquals(1.0, cal.calculateMono(MonoOperatorModes.sin,Math.PI/2),0.001);
		assertEquals(Double.NaN, cal.calculateMono(MonoOperatorModes.sin,Double.POSITIVE_INFINITY),0.001);
	}
	@Test
	public void testTan() {
		assertEquals(0.0, cal.calculateMono(MonoOperatorModes.tan,0.0),0.0);
		assertEquals(1.557, cal.calculateMono(MonoOperatorModes.tan,1.0),0.001);
		assertEquals(Double.POSITIVE_INFINITY, cal.calculateMono(MonoOperatorModes.tan,Math.PI/2),0.001);
		assertEquals(Double.NaN, cal.calculateMono(MonoOperatorModes.tan,Double.POSITIVE_INFINITY),0.001);
	}
	
}
