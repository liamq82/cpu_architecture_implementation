package tst;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cpu.PriorityClass;
import cpu.ReadyQueue;
import cpu.Producer;
import cpu.Process;

public class ReadyQueueTest {

	//create new ready queue
	ReadyQueue readyQueue;
	
	//create new producer to produce random processes
	Producer producer;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		readyQueue = new ReadyQueue(10);
		producer = new Producer(readyQueue);
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	 * test adding/removing processes to the queue
	 * */
	@Test
	public void testAddingRemovingProcess() {
		readyQueue.enqueue(producer.newProcess());
		
		assertTrue(readyQueue.dequeue() instanceof Process);
	}
	
	/*
	 * test adding/removing multiple processes from queue
	 * */
	@Test
	public void testAddingRemovingMultipleProcesses(){
		//add multiple processes to queue
		readyQueue.enqueue(producer.newProcess());
		readyQueue.enqueue(producer.newProcess());
		readyQueue.enqueue(producer.newProcess());
		
		assertTrue(readyQueue.dequeue() instanceof Process);
		assertTrue(readyQueue.dequeue() instanceof Process);
		assertTrue(readyQueue.dequeue() instanceof Process);
	}
	
	/*
	 * test trying to deque when queue is empty
	 * */
	@Test
	public void testDequeueWhenEmpty(){
		//add 1 process
		readyQueue.enqueue(producer.newProcess());
		
		//dequeue twice
		assertTrue(readyQueue.dequeue() instanceof Process);
//		assertTrue(readyQueue.dequeue() instanceof Process);
		
	}
	
	/*
	 * test enqueuing when queue is full
	 * */
	@Test
	public void testEnqueueWhenFull(){
		ReadyQueue queue = new ReadyQueue(3);
		
		queue.enqueue(producer.newProcess());
		queue.enqueue(producer.newProcess());
		queue.enqueue(producer.newProcess());
//		queue.enqueue(producer.newProcess());
	}
	
	/*
	 * test ready queue will dequeue sorted processes
	 * we will add our test processes to the ready queue, then dequeue them one by one comparing
	 * them to eachother. 
	 * */
	@Test
	public void testReadyQueueDequeuesSortedProcesses(){
		//create test processes
		Process p1 = new Process(PriorityClass.NORMAL, (long) 0);
		Process p2 = new Process(PriorityClass.BACKGROUND, (long) 10);
		Process p3 = new Process(PriorityClass.CRITICAL, (long) 20);
		Process p4 = new Process(PriorityClass.CRITICAL, (long) 30);
		Process p5 = new Process(PriorityClass.NORMAL, (long) 40);
		Process p6 = new Process(PriorityClass.BACKGROUND, (long) 50);
		
		//add processes p1 to p6
		readyQueue.enqueue(p1);
		readyQueue.enqueue(p2);
		readyQueue.enqueue(p3);
		readyQueue.enqueue(p4);
		readyQueue.enqueue(p5);
		readyQueue.enqueue(p6);
		
		/*
		 * dequeue processes one at a time comparing the priority of the current with the previous. this will always
		 * evaluate to 1 as none of our processes are equal and the will be sorted by priority.
		 * */
		assertEquals(1, readyQueue.dequeue().compareTo(readyQueue.dequeue()));
		assertEquals(1, readyQueue.dequeue().compareTo(readyQueue.dequeue()));
		assertEquals(1, readyQueue.dequeue().compareTo(readyQueue.dequeue()));
		
	}

}
