package ejemplos_TP03.JUnit.src.figura;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// https://www.youtube.com/watch?v=wkXL3emg-NU


class TestRectangulo {

	private Rectangulo r1;
	private Rectangulo r2;
	
	@BeforeEach
	void setUp() throws Exception {
		r1 = new Rectangulo (2, 4);	
		r2 = new Rectangulo (4, 2);		
	}
	
	@Test
	void test1() {
		assertEquals(r1.area(), 8);
		r1.setAncho(4);
		assertEquals(r1.area(), 16);
	}
	
	@Test
	void test2() {
		assertEquals(r1.perimetro(), 12);
		r1.setAncho(4);
		assertEquals(r1.perimetro(), 16);
	}

	
	@Test
	void test3() {
		assertEquals(r1, r2);		
	}

	@Test
	void test4() {
		assertTrue(r1.equals(r2));		
	}
}
