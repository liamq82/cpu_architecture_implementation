package tst;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import cpu.IntegerHeapSort;

public class IntegerHeapSortTest {

	IntegerHeapSort heapSort;
	//test array 1
	int[] testArray1 = {1,2,3,4,5};
	
	int[] testArray2 = {2,5,3,6,9,1,2};
	//sorted test array 2
	int[] testArray2Sorted = {1,2,2,3,5,6,9};
	int[] testArray3 = {};
	//two arrays to test extracting half of length and rounding up
	int[] intArray1 = new int[10];
	int[] intArray2 = new int[11];
	int[] intArray3 = new int[13];
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		heapSort = new IntegerHeapSort();
	}

	@After
	public void tearDown() throws Exception {
	}

	//test get half of length of heap and make sure it is rounded to whole number
	@Test
	public void test() {
		
		heapSort.heapSort(intArray1);
		assertEquals(5, heapSort.getHalfLength());
		
		heapSort.heapSort(intArray2);
		assertEquals(5, heapSort.getHalfLength());
		
		heapSort.heapSort(intArray3);
		assertEquals(6, heapSort.getHalfLength());
		
	}
	
	//test getting left/right nodes
	@Test
	public void getLeftRightNode(){
		//heapSort testArray1
		heapSort.heapSort(testArray1);
		
		
	}
	
	//test max heap sort
	@Test
	public void testMaxHeapSort(){
		heapSort.heapSort(testArray2);
	}
	
	//test max heap sort
	@Test
	public void testMaxHeapSortArray3(){
		
		heapSort.heapSort(testArray3);
		
		
	}
	

}
