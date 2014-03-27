package tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cpu.Cpu;
import cpu.PriorityClass;
import cpu.Producer;
import cpu.ReadyQueue;
import cpu.Scheduler;
import cpu.Process;

public class CpuTest {

	Cpu cpu;
	Producer producer;
	Scheduler scheduler;
	ReadyQueue readyQueue;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		cpu = new Cpu();
		readyQueue = new ReadyQueue(10);
		producer = new Producer(readyQueue);
		scheduler = new Scheduler(readyQueue, cpu);
		
	}

	/*
	 * test cpu decrements process run time by 0.1s
	 * */
	@Test
	public void test() {
		/*
		 * create a new process of priority class critical and run time 10
		 * */
		Process p = new Process(PriorityClass.CRITICAL, 10);
		
		//add process to queue
		readyQueue.enqueue(p);
		
		
	
	}

}
