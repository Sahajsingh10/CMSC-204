

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface dataManage = new CourseDBManager();

	
	@Before
	public void setUp() throws Exception {
		dataManage = new CourseDBManager();
	}

	
	@After
	public void tearDown() throws Exception {
		dataManage = null;
	}

	
	@Test
	public void testAddToDB() {
		try {
			dataManage.add("CMSC204",80976,2,"SC100","No professor");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		dataManage.add("CMSC202",30783,2,"SC467","Yess");
		dataManage.add("CMSC201",30564,6,"SC499","Yupp prof");
		dataManage.add("CMSC206",30098,9,"SC400","Some name");
		ArrayList<String> listing = dataManage.showAll();
		assertEquals(listing.get(0),"\nCourse:CMSC202 CRN:30783 Credits:2 Instructor:Yess");
	 	assertEquals(listing.get(1),"\nCourse:CMSC201 CRN:30564 Credits:6 Instructor:Yupp prof");
		assertEquals(listing.get(2),"\nCourse:CMSC206 CRN:30098 Credits:9 Instructor:Some name");
	}
	
	
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC203 30504 4 SC450 Joey Bag-O-Donuts");
			inFile.print("CMSC204 30503 4 SC450 Jill B. Who-Dunit");
			
			inFile.close();
			dataManage.readFile(inputFile);
			assertEquals("CMSC203",dataManage.get(30504).getID());
			assertEquals("CMSC204",dataManage.get(30503).getID());
			assertEquals("SC450",dataManage.get(30503).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
