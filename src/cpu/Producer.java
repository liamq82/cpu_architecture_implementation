package cpu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Producer implements Runnable{
	
	private Random generate;
	//list to store processes
	private List<Process> processList;
	//producer HAS A ready queue to add processes to
	private ReadyQueue readyQueue;
	
	public Producer(ReadyQueue readyQueue){
		this.readyQueue = readyQueue;
		generate = new Random();
		//create arrayList to store processes
		processList = new ArrayList<Process>();
	}

	@Override
	public void run() {
		for(int i = 0; i < 100; i++){
			System.out.println("producer: adding process to queue");
			readyQueue.enqueue(newProcess());
		}
		
	}
	
	/*
	 * create a specified number of processes of random priority and store in an arrayList
	 *  and random runTime
	 * */
	public void newArrayListOfProcesses(int quantity){
		for(int i = 0; i < quantity; i++){
			//generate random number
			int priority = generate.nextInt(3);
			//generate process of random priority and add to the processList
			switch(priority){
			case 0: processList.add(new Process(PriorityClass.BACKGROUND, generateRandomRuntime()));
			case 1: processList.add(new Process(PriorityClass.NORMAL, generateRandomRuntime()));
			case 2: processList.add(new Process(PriorityClass.CRITICAL, generateRandomRuntime()));
			default: processList.add(new Process());
			}
		}
	}
	
	
	/*
	 * create a new process of random priority and random runTime
	 * */
	public Process newProcess(){
		
		int priority = generate.nextInt(3);
		
		switch(priority){
		case 0: return new Process(PriorityClass.BACKGROUND, generateRandomRuntime());
		case 1: return new Process(PriorityClass.NORMAL, generateRandomRuntime());
		case 2: return new Process(PriorityClass.CRITICAL, generateRandomRuntime());
		default: return new Process();
		}
		
	}
	
	/**
	 * @return process of random priority
	 */
	public Process getProcess() {
		if(!processList.isEmpty()){

			return processList.remove(0);
			
		}return null;
	}
	/*
	 * generate a random process run time
	 * */
	private int generateRandomRuntime(){
		int runTime = generate.nextInt(60001);
		return runTime;
	}

	
}
