package tst;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cpu.Cpu;
import cpu.PriorityClass;
import cpu.Producer;
import cpu.ReadyQueue;
import cpu.Scheduler;
import cpu.Process;

public class SchedulerTest {

	/*
	 * to test scheduler we need a readyQueue and a CPU
	 * */
	ReadyQueue readyQueue;
	Cpu cpu;
	Scheduler scheduler;
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
		cpu = new Cpu();
		scheduler = new Scheduler(readyQueue, cpu);
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	 * test taking process from ready queue and placing on cpu
	 * */
	@Test
	public void testGetProcessFromReadyQueueAndPlaceOnCpu() {
		//create a new process
		Process p1 = producer.newProcess();
		
		//place process on ready queue
		readyQueue.enqueue(p1);
		
		//scheduler takes process from ready queue and places it on cpu
		scheduler.setProcessOnCPU();
		
		//test that process was put on cpu
		assertEquals(p1, cpu.getCpuProcess());
	}

	/*
	 * test taking process from cpu and placing it on the ready queue
	 * */
	@Test
	public void testTakeProcessOffCpuAndPlaceOnReadyQueue() {
		//create a new process
		Process p1 = producer.newProcess();
		
		//place process on cpu
		cpu.setCpuProcess(p1);
		
		//take process from cpu and place on ready queue
		scheduler.setProcessOnReadyQueue();
		
		//test that process was placed back on ready queue
		assertEquals(p1, readyQueue.dequeue());
	}
	
	/*
	 * test scheduler takes highest priority process
	 * from ready queue to place on cpu
	 * */
	@Test
	public void testSchedulerTakesHighestPriorityProcessFirst(){
		//create three processes of differing priority
		Process p1 = new Process(PriorityClass.CRITICAL);
		Process p2 = new Process(PriorityClass.NORMAL);
		Process p3 = new Process(PriorityClass.BACKGROUND);
		
		//place processes on ready queue
		readyQueue.enqueue(p1);
		readyQueue.enqueue(p3);
		readyQueue.enqueue(p2);
		
		//test scheduler selects highest priority process first
		assertEquals(p1, scheduler.getProcessFromReadyQueue());
		assertEquals(p2, scheduler.getProcessFromReadyQueue());
		assertEquals(p3, scheduler.getProcessFromReadyQueue());
	}
	
	/*
	 * start scheduler dequeue thread and test that it dequeues processes
	 * and then waits for queue to fill when empty
	 * */
	@Test
	public void testFullCycle(){
		int qty = 10;
		//create ten processes
		producer.newArrayListOfProcesses(qty);
		
		//populate ready queue with processes
		for(int i = 0; i < qty; i++){
			readyQueue.enqueue(producer.getProcess());
		}
		
		Thread t = new Thread(scheduler);
		t.start();
	
	}
	
	/*
	 * test scheduler pre-emptive scheduling.
	 * Scheduler should place a process on the cpu, the cpu will decrement
	 * the run time by 0.1seconds and then the scheduler will remove the process
	 * and place back on ready queue before selecting a new process for the cpu.
	 * */
	@Test
	public void testSchedulerPreEmptive(){
		//populate ready queue with 10 processes
//		producer.newArrayListOfProcesses(10);
		//create test processes
		Process p1 = new Process(PriorityClass.NORMAL, 60000);
//		Process p2 = new Process(PriorityClass.BACKGROUND, 60000);
//		Process p3 = new Process(PriorityClass.CRITICAL, 60000);
//		Process p4 = new Process(PriorityClass.CRITICAL, 60000);
//		Process p5 = new Process(PriorityClass.NORMAL, 60000);
//		Process p6 = new Process(PriorityClass.BACKGROUND, 60000);

		readyQueue.enqueue(p1);
//		readyQueue.enqueue(p2);
//		readyQueue.enqueue(p3);
//		readyQueue.enqueue(p4);
//		readyQueue.enqueue(p5);
//		readyQueue.enqueue(p6);
		
		
//		for(int i = 0; i < 10; i ++){
//			readyQueue.enqueue(producer.getProcess());
//		}
		
		/*
		 * create a new scheduler thread to consumer processes
		 * */
		Thread t = new Thread(scheduler);
		t.start();
		
	}
	
}
