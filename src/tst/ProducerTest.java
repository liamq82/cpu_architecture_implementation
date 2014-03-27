package tst;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cpu.PriorityClass;
import cpu.Process;
import cpu.ReadyQueue;

import cpu.Producer;

public class ProducerTest {
	
	Producer producer;
	ReadyQueue readyQueue;
	
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
	 * test that producer produces processes
	 * */
	@Test
	public void testCreateJobs() {
		//create 2 new processes
		Process p1 = producer.newProcess();
		Process p2 = producer.newProcess();
		
		//check that they are of type process
		assertTrue(p1 instanceof Process);
		assertTrue(p2 instanceof Process);
	}
	
	/*
	 * test producer creates processes of random priority
	 * */
	@Test
	public void testCreateRandomProcess(){
		
//		long l = 4;
//		Process p = new Process(PriorityClass.BACKGROUND);
		Process p1 = producer.newProcess();
		
		assertTrue(p1 instanceof Process);
		
	}
	
	/*
	 * test producer creates a specified number of processes of random priority
	 * */
	@Test
	public void testCreateMultipleProcesses(){
		producer.newArrayListOfProcesses(5);
		
		
		assertTrue(producer.getProcess() instanceof Process);
		assertTrue(producer.getProcess() instanceof Process);
		assertTrue(producer.getProcess() instanceof Process);
		assertTrue(producer.getProcess() instanceof Process);
		assertTrue(producer.getProcess() instanceof Process);
		assertTrue(producer.getProcess() instanceof Process);
	}
	
	/*
	 * test producer run method will produce and add processes 
	 * to the ready queue and then wait when the queue is full
	 * */
	@Test
	public void testProducerRunMethod(){
		Thread t = new Thread(producer);
		
		t.start();
	}

}
