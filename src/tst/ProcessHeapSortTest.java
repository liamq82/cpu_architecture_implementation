package tst;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cpu.PriorityClass;
import cpu.ProcessHeapSort;
import cpu.Process;

public class ProcessHeapSortTest {
	
	ProcessHeapSort heapSort = new ProcessHeapSort();

	//create processes to sort
	Process p1 = new Process(PriorityClass.NORMAL, (long) 0);
	Process p2 = new Process(PriorityClass.BACKGROUND, (long) 10);
	Process p3 = new Process(PriorityClass.CRITICAL, (long) 20);
	Process p4 = new Process(PriorityClass.CRITICAL, (long) 30);
	Process p5 = new Process(PriorityClass.NORMAL, (long) 40);
	Process p6 = new Process(PriorityClass.BACKGROUND, (long) 50);
	Process p7 = new Process(PriorityClass.BACKGROUND, (long) 60);
	Process p8 = new Process(PriorityClass.NORMAL, (long) 70);
	
	//add processes to an array to sort
	Process[] processArrayToSort = {p1, p2, p3, p4, p5, p6, p7, p8};
	
	//sorted process array for comparison
	Process[] processArraySorted = {p7, p6, p2 , p8, p5, p1, p4, p3};
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//test that heapSort builds a max heap from an array of processes
	@Test
	public void testBuildMaxHeap() {
		//create a random array of processes
		Process[] pArray1 = {p1, p2, p3, p4, p5};
		
		//build a max heap with the array of processes
		heapSort.buildMaxHeap(pArray1);
		
		//check that the most critical process, p3, has bubbled to the top of the array
		assertEquals(p3, heapSort.getMaxHeap()[0]);
		
		//create a random array of processes
		Process[] pArray2 = {p6, p8, p5, p2};

		//build a max heap with the array of processes
		heapSort.buildMaxHeap(pArray2);

		//check that the most critical process, p3, has bubbled to the top of the array
		assertEquals(p5, heapSort.getMaxHeap()[0]);

		
	}

}
