package junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComplexNumberTest {

	private ComplexNumber primer = new ComplexNumber(1,2);
	private ComplexNumber segon = new ComplexNumber(-2,3);
	
	@Test
	public void testAdd() {
		ComplexNumber expected = new ComplexNumber(-1, 5);
		ComplexNumber suma = primer.add(segon);
		System.out.println(expected + "\n" + suma);
		assertEquals(suma, expected);
	}
	
	@Test
	public void testAcumulate() {
		ComplexNumber expected = new ComplexNumber(-1, 5);
		primer.accumulate(segon);
		assertEquals(primer, expected);
	}

	@Test
	public void testGetModulus() {
		double expected = 2.2360679;
		assertEquals(primer.getModulus(), expected, 0.00001);
	}
	
	@Test
	public void testGetArc() {
		double expected = 63.4349488229;
		assertEquals(primer.getArc(), expected, 0.00001);
	}
	
	@Test
	public void testGetComplexConjugate() {
		System.out.println(primer);
		System.out.println(primer.getComplexConjugate());
		ComplexNumber expected = new ComplexNumber(1,-2);
		assertEquals(primer.getComplexConjugate(), expected);
	}
	
	@Test
	public void testProduct(){
		System.out.println("El producto de " + primer + " i " + segon + ":");
		System.out.println(primer.product(segon));
		ComplexNumber expected = new ComplexNumber(-8,-1);
		assertEquals(primer.product(segon), expected);
		assertEquals(segon.product(primer), expected);
	}

	@Test
	public void testDivision(){
		ComplexNumber expected = new ComplexNumber(0.3076923, -0.5384615);
		System.out.println("La division de " + primer + " i " + segon + ":");
		ComplexNumber division = primer.division(segon);
		System.out.println(division);
		assertEquals(expected.getReal().doubleValue(), division.getReal().doubleValue(), 0.00001);
		assertEquals(expected.getImaginary().doubleValue(), division.getImaginary().doubleValue(), 0.00001);
	}
	
}
