package zerobase.weather;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherApplicationTests {




	@Test
	void contextLoads1() {
		assertEquals(1, 1) ;
	}

	@Test
	void contextLoads2() {
		assertNull(null);
	}

	@Test
	void contextLoads3() {
		assertTrue(1 == 1) ;
	}

}
