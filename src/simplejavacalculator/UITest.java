package simplejavacalculator;

import static org.junit.Assert.assertEquals;

import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

import javax.swing.JTextArea;

import org.junit.Test;

public class UITest {

	@Test
	public void testBtnNum() throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		final UI ui = new UI();
		ui.init();

		final Field fieldBtn = ui.getClass().getDeclaredField("but");
		fieldBtn.setAccessible(true);
		final Field fieldText = ui.getClass().getDeclaredField("text");
		fieldText.setAccessible(true);
		final Object btn = fieldBtn.get(ui);
		final JTextArea text = ((JTextArea) fieldText.get(ui));

		text.setText("abcdefg");
		text.select(2, 2); // automatically done by UI in actual execution
		ui.actionPerformed(new ActionEvent(Array.get(btn, 0), 0, null));
		text.select(3, 3); // automatically done by UI in actual execution
		ui.actionPerformed(new ActionEvent(Array.get(btn, 1), 0, null));
		text.select(4, 4); // automatically done by UI in actual execution
		ui.actionPerformed(new ActionEvent(Array.get(btn, 2), 0, null));
		text.select(5, 5); // automatically done by UI in actual execution
		ui.actionPerformed(new ActionEvent(Array.get(btn, 3), 0, null));
		text.select(6, 6); // automatically done by UI in actual execution
		ui.actionPerformed(new ActionEvent(Array.get(btn, 4), 0, null));
		text.select(7, 7); // automatically done by UI in actual execution
		ui.actionPerformed(new ActionEvent(Array.get(btn, 5), 0, null));
		text.select(8, 8); // automatically done by UI in actual execution
		ui.actionPerformed(new ActionEvent(Array.get(btn, 6), 0, null));
		text.select(9, 9); // automatically done by UI in actual execution
		ui.actionPerformed(new ActionEvent(Array.get(btn, 7), 0, null));
		text.select(10, 10); // automatically done by UI in actual execution
		ui.actionPerformed(new ActionEvent(Array.get(btn, 8), 0, null));
		text.select(11, 11); // automatically done by UI in actual execution
		ui.actionPerformed(new ActionEvent(Array.get(btn, 9), 0, null));
		assertEquals("ab0123456789cdefg", text.getText());
	}

	@Test
	public void testBtnNumReplace() throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		final UI ui = new UI();
		ui.init();

		final Field fieldBtn = ui.getClass().getDeclaredField("but");
		fieldBtn.setAccessible(true);
		final Field fieldText = ui.getClass().getDeclaredField("text");
		fieldText.setAccessible(true);
		final Object btn = fieldBtn.get(ui);
		final JTextArea text = ((JTextArea) fieldText.get(ui));

		text.setText("abcdefg");
		text.select(4, 6);
		ui.actionPerformed(new ActionEvent(Array.get(btn, 0), 0, null));
		text.select(4, 4);
		ui.actionPerformed(new ActionEvent(Array.get(btn, 1), 0, null));
		text.select(2, 2);
		assertEquals("abcd10g", text.getText());
		text.selectAll();
		ui.actionPerformed(new ActionEvent(Array.get(btn, 2), 0, null));
		text.select(0, 0);
		ui.actionPerformed(new ActionEvent(Array.get(btn, 3), 0, null));
		assertEquals("32", text.getText());
	}

	@Test
	public void testBtnBiOp() throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		final UI ui = new UI();
		ui.init();

		final Field fieldBtn1 = ui.getClass().getDeclaredField("butAdd");
		fieldBtn1.setAccessible(true);
		final Field fieldBtn2 = ui.getClass().getDeclaredField("butMinus");
		fieldBtn2.setAccessible(true);
		final Field fieldBtn3 = ui.getClass().getDeclaredField("butMultiply");
		fieldBtn3.setAccessible(true);
		final Field fieldBtn4 = ui.getClass().getDeclaredField("butDivide");
		fieldBtn4.setAccessible(true);
		final Field fieldBtnEq = ui.getClass().getDeclaredField("butEqual");
		fieldBtnEq.setAccessible(true);
		final Field fieldText = ui.getClass().getDeclaredField("text");
		fieldText.setAccessible(true);
		final JTextArea text = ((JTextArea) fieldText.get(ui));

		text.setText("2333");
		ui.actionPerformed(new ActionEvent(fieldBtn1.get(ui), 0, null));
		assertEquals("", text.getText());
		text.setText("100");
		ui.actionPerformed(new ActionEvent(fieldBtn2.get(ui), 0, null));
		assertEquals("2433.0", text.getText());
		text.setText("10");
		ui.actionPerformed(new ActionEvent(fieldBtn3.get(ui), 0, null));
		assertEquals("2423.0", text.getText());
		text.setText("42");
		ui.actionPerformed(new ActionEvent(fieldBtn4.get(ui), 0, null));
		assertEquals("101766.0", text.getText());
		text.setText("6.4");
		ui.actionPerformed(new ActionEvent(fieldBtnEq.get(ui), 0, null));
		assertEquals("15900.9375", text.getText());
		text.setText("123.4");
		ui.actionPerformed(new ActionEvent(fieldBtn1.get(ui), 0, null));
		assertEquals("", text.getText());
	}

	@Test
	public void testBtnMonoOp() throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		final UI ui = new UI();
		ui.init();

		final Field fieldBtn1 = ui.getClass().getDeclaredField("butSquareRoot");
		fieldBtn1.setAccessible(true);
		final Field fieldBtn2 = ui.getClass().getDeclaredField("butSquare");
		fieldBtn2.setAccessible(true);
		final Field fieldBtn3 = ui.getClass().getDeclaredField(
				"butOneDevidedBy");
		fieldBtn3.setAccessible(true);
		final Field fieldBtn4 = ui.getClass().getDeclaredField("butCos");
		fieldBtn4.setAccessible(true);
		final Field fieldBtn5 = ui.getClass().getDeclaredField("butSin");
		fieldBtn5.setAccessible(true);
		final Field fieldBtn6 = ui.getClass().getDeclaredField("butTan");
		fieldBtn6.setAccessible(true);
		final Field fieldText = ui.getClass().getDeclaredField("text");
		fieldText.setAccessible(true);
		final JTextArea text = ((JTextArea) fieldText.get(ui));

		text.setText("1024");
		ui.actionPerformed(new ActionEvent(fieldBtn1.get(ui), 0, null));
		assertEquals("32.0", text.getText());
		text.setText("-25");
		ui.actionPerformed(new ActionEvent(fieldBtn2.get(ui), 0, null));
		assertEquals("625.0", text.getText());
		text.setText("2.5");
		ui.actionPerformed(new ActionEvent(fieldBtn3.get(ui), 0, null));
		assertEquals("0.4", text.getText());
		text.setText("Infinity");
		ui.actionPerformed(new ActionEvent(fieldBtn3.get(ui), 0, null));
		assertEquals("0.0", text.getText());
		ui.actionPerformed(new ActionEvent(fieldBtn3.get(ui), 0, null));
		assertEquals("Infinity", text.getText());
		text.setText(Double.toString(Math.PI / 3));
		ui.actionPerformed(new ActionEvent(fieldBtn4.get(ui), 0, null));
		// assertEquals("0.5", text.getText());
		text.setText(Double.toString(-Math.PI / 6));
		ui.actionPerformed(new ActionEvent(fieldBtn5.get(ui), 0, null));
		// assertEquals("-0.5", text.getText());
		text.setText(Double.toString(-Math.PI / 4));
		ui.actionPerformed(new ActionEvent(fieldBtn6.get(ui), 0, null));
		// assertEquals("-1", text.getText());
	}

	@Test
	public void testBtnC() throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		final UI ui = new UI();
		ui.init();

		final Field fieldBtn1 = ui.getClass().getDeclaredField("butAdd");
		fieldBtn1.setAccessible(true);
		final Field fieldBtnEq = ui.getClass().getDeclaredField("butEqual");
		fieldBtnEq.setAccessible(true);
		final Field fieldBtnC = ui.getClass().getDeclaredField("butCancel");
		fieldBtnC.setAccessible(true);
		final Field fieldText = ui.getClass().getDeclaredField("text");
		fieldText.setAccessible(true);
		final JTextArea text = ((JTextArea) fieldText.get(ui));

		text.setText("0");
		ui.actionPerformed(new ActionEvent(fieldBtnC.get(ui), 0, null));
		assertEquals("", text.getText());

		text.setText("1");
		ui.actionPerformed(new ActionEvent(fieldBtn1.get(ui), 0, null));
		text.setText("1");
		ui.actionPerformed(new ActionEvent(fieldBtnC.get(ui), 0, null));
		assertEquals("", text.getText());

		text.setText("2");
		ui.actionPerformed(new ActionEvent(fieldBtn1.get(ui), 0, null));
		text.setText("2");
		ui.actionPerformed(new ActionEvent(fieldBtnEq.get(ui), 0, null));
		assertEquals("4.0", text.getText());
		ui.actionPerformed(new ActionEvent(fieldBtnC.get(ui), 0, null));
		assertEquals("", text.getText());
	}

	@Test
	public void testReader() throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		final UI ui = new UI();
		ui.init();

		final Field fieldText = ui.getClass().getDeclaredField("text");
		fieldText.setAccessible(true);
		final JTextArea text = ((JTextArea) fieldText.get(ui));

		text.setText("0");
		assertEquals(new Double(0.0), ui.reader());
		text.setText("123");
		assertEquals(new Double(123.0), ui.reader());
		text.setText("-123.45e67");
		assertEquals(new Double(-123.45e67), ui.reader());
		text.setText("111111111111111111111111111111111111111111111111111111111");
		assertEquals(new Double(
				111111111111111111111111111111111111111111111111111111111.0),
				ui.reader());
		text.setText("Infinity");
		assertEquals(new Double(Double.POSITIVE_INFINITY), ui.reader());
		text.setText("-Infinity");
		assertEquals(new Double(Double.NEGATIVE_INFINITY), ui.reader());
		text.setText("NaN");
		assertEquals(new Double(Double.NaN), ui.reader());
		// text.setText("temp");
		// assertEquals(new Double(Double.NaN), ui.reader());
	}

	@Test
	public void testWriter() throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		final UI ui = new UI();
		ui.init();

		final Field fieldText = ui.getClass().getDeclaredField("text");
		fieldText.setAccessible(true);
		final JTextArea text = ((JTextArea) fieldText.get(ui));

		ui.writer(0.0);
		assertEquals("0.0", text.getText());
		ui.writer(123.0);
		assertEquals("123.0", text.getText());
		ui.writer(-123.45e67);
		assertEquals("-1.2345E69", text.getText());
		ui.writer(Double.POSITIVE_INFINITY);
		assertEquals("Infinity", text.getText());
		ui.writer(Double.NEGATIVE_INFINITY);
		assertEquals("-Infinity", text.getText());
		ui.writer(Double.NaN);
		assertEquals("", text.getText());
	}
}
