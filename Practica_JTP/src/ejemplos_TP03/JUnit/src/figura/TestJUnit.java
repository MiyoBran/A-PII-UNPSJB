package ejemplos_TP03.JUnit.src.figura;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestJUnit {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Antes de comenzar el Test");
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Despu�s de finalizar el Test");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Antes de comenzar cada Test individual");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Despu�s de finalizar Test individual");		
	}

	@Test
	void test1() {
		fail("Not yet implemented");
	}
	
	@Test
	void test2() {
		fail("Not yet implemented");
	}

}
