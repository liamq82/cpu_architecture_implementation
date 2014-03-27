package tst;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cpu.PriorityClass;
import cpu.Process;

public class ProcessTest {

//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
//
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}

	@Test
	public void testCreateDefaultProcess() {
		Process p = new Process();
		Long l = Long.MIN_VALUE;
		
		assertEquals(PriorityClass.NORMAL, p.getPriorityClass());
		assertEquals(l, p.getLastRan());
	}
	
	@Test
	public void testProcessWithPriority(){
		Process p = new Process(PriorityClass.CRITICAL);
		
		assertEquals(PriorityClass.CRITICAL, p.getPriorityClass());
	}
	
	@Test
	public void testProcessWithPriorityAndTimeStamp(){
		long tStamp = 5;
		Process p = new Process(PriorityClass.CRITICAL, tStamp);
		
		assertEquals(PriorityClass.CRITICAL, p.getPriorityClass());
		assertEquals(tStamp, (long) p.getLastRan());
	}
	
	@Test
	public void testComparingTwoProcesses(){
		Process p1 = new Process(PriorityClass.BACKGROUND);
		Process p2 = new Process(PriorityClass.NORMAL);
		Process p3 = new Process(PriorityClass.CRITICAL);
		
		assertEquals(-1, p1.compareTo(p2));
		assertEquals(-1, p2.compareTo(p3));
		assertEquals(1, p3.compareTo(p2));
		assertEquals(0, p2.compareTo(p2));
	}
	
	@Test
	public void testTwoEqualPriorityProcesses(){
		Process p1 = new Process(PriorityClass.CRITICAL, (long) 500);
		Process p2 = new Process(PriorityClass.CRITICAL, (long) 1000);
		
		assertEquals(1, p1.compareTo(p2));
		
	}
	
	/*
	 * test creating processes of different priority classes
	 * */
	@Test
	public void testCreateProcessesOfDifferentPriorityClasses(){
		
		Process p1 = new Process(PriorityClass.BACKGROUND);
	
	}
	
	/*
	 * test printing process to screen
	 * */
	@Test
	public void testPrintingProcess(){
		Process p = new Process(PriorityClass.CRITICAL, 10);
		
		System.out.println(p);
	}

}
