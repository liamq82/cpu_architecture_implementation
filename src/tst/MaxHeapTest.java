package tst;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import cpu.MaxHeap;
import cpu.PriorityClass;
import cpu.Process;

public class MaxHeapTest {

	MaxHeap maxHeap;
	ArrayList<Process> arrayList;
	
	//create processes to sort
	Process p1 = new Process(PriorityClass.NORMAL, (long) 0);
	Process p2 = new Process(PriorityClass.BACKGROUND, (long) 10);
	Process p3 = new Process(PriorityClass.CRITICAL, (long) 20);
	Process p4 = new Process(PriorityClass.CRITICAL, (long) 30);
	Process p5 = new Process(PriorityClass.NORMAL, (long) 40);
	Process p6 = new Process(PriorityClass.BACKGROUND, (long) 50);
	Process p7 = new Process(PriorityClass.BACKGROUND, (long) 60);
	Process p8 = new Process(PriorityClass.NORMAL, (long) 70);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		//create maxHeap and arrayList
		maxHeap = new MaxHeap();
		arrayList = new ArrayList<Process>();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHeapSort() {
		//add processes to arrayList
//		arrayList.add(p1);
//		arrayList.add(p2);
//		arrayList.add(p3);
//		arrayList.add(p4);
//		arrayList.add(p5);
//		arrayList.add(p6);
//		arrayList.add(p7);
//		arrayList.add(p8);
		
		arrayList.add(p2);
		arrayList.add(p1);
		arrayList.add(p3);
		
		maxHeap.heapSort(arrayList);
		
		assertEquals(p1, maxHeap.getSortedMaxHeap().get(0));
		assertEquals(p2, maxHeap.getSortedMaxHeap().get(1));
		assertEquals(p3, maxHeap.getSortedMaxHeap().get(2));
		
	}
	
	//test build max heap. Highest priority process should bubble to first index
	@Test
	public void testBuildMaxHeapWithThreeProcesses(){
		
		arrayList.add(p2);
		arrayList.add(p1);
		arrayList.add(p3);
		
		maxHeap.buildMaxHeap(arrayList);
		
		assertEquals(p3, maxHeap.getMaxHeap().get(0));
		
	}
	
	//test build max heap. Highest priority process should bubble to first index
	@Test
	public void testBuildMaxHeapWithEightProcesses(){
		
		//add processes to arrayList
		arrayList.add(p1);
		arrayList.add(p4);
		arrayList.add(p5);
		arrayList.add(p6);
		arrayList.add(p7);
		arrayList.add(p8);
		
		maxHeap.buildMaxHeap(arrayList);
		
		assertEquals(p4, maxHeap.getMaxHeap().get(0));
		
		
	}
	
	

}
