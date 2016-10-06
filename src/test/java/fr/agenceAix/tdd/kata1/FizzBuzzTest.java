package fr.agenceAix.tdd.kata1;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import fr.gfi.agenceAix.tdd.kata1.model.BasicNumber;
import fr.gfi.agenceAix.tdd.kata1.model.Countable;
import fr.gfi.agenceAix.tdd.kata1.service.CountableService;
import fr.gfi.agenceAix.tdd.kata1.service.CountableServiceImpl;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FizzBuzzTest {
	
	CountableService countableService;
	
	@Before
	public void initTest() {
		countableService = new CountableServiceImpl();
	}
	
	@Test
	public void exercice_01() {
		Countable c = countableService.createCountable(1);
		assertNotNull(c);
		assertThat(c, instanceOf(BasicNumber.class));
		assertEquals("1", c.count());
	}
	
	@Test
	public void exercice_02() {
		Countable c = countableService.createCountable(2);
		assertThat(c, instanceOf(BasicNumber.class));
		assertEquals("2", c.count());
		c = countableService.createCountable(4);
		assertThat(c, instanceOf(BasicNumber.class));
		assertEquals("4", c.count());
		c = countableService.createCountable(7);
		assertThat(c, instanceOf(BasicNumber.class));
		assertEquals("7", c.count());
	}
	
	
	@Test
	public void exercice_03() {
		Countable c = countableService.createCountable(3);
		assertNotNull(c);
		assertEquals("Fizz", c.count());
		assertThat(c, not(instanceOf(BasicNumber.class)));
	}
	
	@Test
	public void exercice_04() {
		Countable c = countableService.createCountable(6);
		assertEquals("Fizz", c.count());
		c = countableService.createCountable(9);
		assertEquals("Fizz", c.count());
		c = countableService.createCountable(5);
		assertEquals("Buzz", c.count());
		c = countableService.createCountable(10);
		assertEquals("Buzz", c.count());
	}
	
	@Test(expected = ArithmeticException.class)
	public void exercice_05() {
		countableService.createCountable(0);
	}
	
	@Test(expected = ArithmeticException.class)
	public void exercice_06() {
		countableService.createCountable(-1);
	}
	
	@Test
	public void exercice_07() {
		Countable[] range = countableService.createCountableRange(1, 10);
		assertNotNull(range);
		assertEquals(10, range.length);
		for (int i = 2; i < range.length; i+=3) {
			assertThat(String.format("There's a problem with range[%s]", i), range[i].count(), containsString("Fizz"));
		}
		for (int i = 4; i < range.length; i+=5) {
			assertThat(String.format("There's a problem with range[%s]", i), range[i].count(), containsString("Buzz"));
		}
	}
	
	@Test(expected = ArithmeticException.class)
	public void exercice_08() {
		countableService.createCountableRange(0, 10);
	}

	@Test(expected = ArithmeticException.class)
	public void exercice_09() {
		countableService.createCountableRange(10, 1);
	}
	
	@Test
	public void exercice_10() {
		Countable[] range = countableService.createCountableRange(1, 100);
		assertNotNull(range);
		assertEquals(100, range.length);
		for (int i = 2; i < range.length; i+=3) {
			assertThat(String.format("There's a problem with range[%s]", i), range[i].count(), containsString("Fizz"));
		}
		for (int i = 4; i < range.length; i+=5) {
			assertThat(String.format("There's a problem with range[%s]", i), range[i].count(), containsString("Buzz"));
		}
		for (int i = 0; i < range.length; i++) {
			if((i+1) %3 > 0 && (i+1) % 5 > 0) {
				assertThat(String.format("There's a problem with range[%s]", i), range[i].count(), equalTo(String.valueOf(i +1)));
			}
		}
	}
	
}
