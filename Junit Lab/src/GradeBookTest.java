import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	private GradeBook book;
	private GradeBook book2;

	@BeforeEach
	void setUp() throws Exception {
		
		 book = new GradeBook(5);
		 book2 = new GradeBook(5);
		
		book.addScore(2.0);
		book.addScore(6.0);
		book2.addScore(9.0);
		book2.addScore(7.0);
	}
	
	

	@AfterEach
	void tearDown() throws Exception {
		
		   book = null;
		 book2 = null;
		
		
	}

	@Test
	void sumtest() {
		assertEquals(book.sum(), 8);
		assertEquals(book2.sum(), 16);
	
		
	} 
	@Test
	void minimumTest() {
		
		assertEquals(book.minimum(), 2);
		assertEquals(book2.minimum(), 7);
		
}
	@Test
	void addTest() {
		assertEquals(book.ScoreSize(), 2);
		assertEquals(book2.ScoreSize(), 2); 
		assertTrue(book2.toString().equals("9.0 7.0 "));
		assertTrue(book.toString().equals("2.0 6.0 "));
		
	}
	@Test
	void FinalScoreTest() {
		assertEquals(book.finalScore(), 6.0);
		assertEquals(book2.finalScore(), 9.0);
	}
}
