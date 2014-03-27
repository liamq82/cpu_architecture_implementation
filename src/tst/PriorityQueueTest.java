package tst;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cpu.PriorityClass;
import cpu.PriorityQueue;
import cpu.Process;

public class PriorityQueueTest {

	PriorityQueue priorityQueue;
	
	//create test processes
	Process p1 = new Process(PriorityClass.NORMAL, (long) 0);
	Process p2 = new Process(PriorityClass.BACKGROUND, (long) 10);
	Process p3 = new Process(PriorityClass.CRITICAL, (long) 20);
	Process p4 = new Process(PriorityClass.CRITICAL, (long) 30);
	Process p5 = new Process(PriorityClass.NORMAL, (long) 40);
	Process p6 = new Process(PriorityClass.BACKGROUND, (long) 50);
	Process p7 = new Process(PriorityClass.BACKGROUND, (long) 60);
	Process p8 = new Process(PriorityClass.NORMAL, (long) 70);

	//add processes to an array to add to the priority queue
	Process[] processArrayToSort = {p1, p2, p3, p4, p5, p6, p7, p8};
		
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		priorityQueue = new PriorityQueue();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	 * test priority queue acts as a max priority queue
	 * */
	@Test
	public void testPriorityQueue(){
		
		//add processes to the queue
		priorityQueue.add(p1);
		priorityQueue.add(p2);
		priorityQueue.add(p3);
		priorityQueue.add(p4);
		priorityQueue.add(p5);
		priorityQueue.add(p6);
		priorityQueue.add(p7);
		priorityQueue.add(p8);

		/*
		 * remove processes from queue ensuring that highest priority process is 
		 * removed each time.
		 * */
		assertEquals(p3, priorityQueue.head());
		assertEquals(p4, priorityQueue.head());
		assertEquals(p1, priorityQueue.head());
		assertEquals(p5, priorityQueue.head());
		assertEquals(p8, priorityQueue.head());
		assertEquals(p2, priorityQueue.head());
		assertEquals(p6, priorityQueue.head());
		assertEquals(p7, priorityQueue.head());
		assertEquals(null, priorityQueue.head());
		
	}
	
	/*
	 * test adding to queue
	 * */
	@Test
	public void testAddToQueue() {
		assertTrue(priorityQueue.add(p1));
		assertTrue(priorityQueue.add(p2));
		assertTrue(priorityQueue.add(p3));
		assertTrue(priorityQueue.add(p2));
		assertTrue(priorityQueue.add(p6));
		
		
	}
	
	/*
	 * test offer to queue
	 * */
	@Test
	public void testOfferToQueue(){
		
		assertTrue(priorityQueue.add(p6));
		assertTrue(priorityQueue.add(p3));
		assertTrue(priorityQueue.add(p8));
		assertTrue(priorityQueue.add(p2));
		
		
		
	}
	
	/*
	 * test that highest priority Process is always removed from the head of the queue
	 * */
	@Test
	public void testHead(){
		
		//add three processes to the queue
		priorityQueue.add(p1);
		priorityQueue.add(p2);
		priorityQueue.add(p3);
		
		/*
		 * remove  head of queue one at a time and test that the highest 
		 * priority process is always removed first
		 * */
		assertEquals(p3, priorityQueue.head());
		assertEquals(p1, priorityQueue.head());
		assertEquals(p2, priorityQueue.head());
		assertEquals(null, priorityQueue.head());
		
	}
	
	/*
	 * test clearing the process queue
	 * */
	@Test
	public void testClear(){
		
		//add three processes to the queue
		priorityQueue.add(p8);
		priorityQueue.add(p7);
		priorityQueue.add(p6);
		
		//clear the queue
		priorityQueue.clear();
		
		/*
		 * check queue is empty
		 * */
		priorityQueue.isEmpty();
	}
	
	/*
	 * check size of queue
	 * */
	@Test
	public void testSize(){
		
		//add two processes to the queue
		priorityQueue.add(p8);
		priorityQueue.add(p7);
		
		assertEquals(2, priorityQueue.size());
	}
	
	/*
	 * test peek: return head without removing it
	 * */
	@Test
	public void testPeek(){
		
		assertEquals(null, priorityQueue.peek());
		
		//add three processes to the queue
		priorityQueue.add(p1);
		priorityQueue.add(p4);
		priorityQueue.add(p6);
		
		assertEquals(p4, priorityQueue.peek());
		
	}
	
	
}
