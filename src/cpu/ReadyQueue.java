package cpu;

public class ReadyQueue extends PriorityQueue{

	//constant value empty value
//	private static int EMPTY_VALUE = -1;
	//Process array to hold processes
	private Process[] buffer;
	//pointer to the head of the queue
	private int headPointer;
	
	//priority queue size
	int size;
	
	public ReadyQueue(int size){
		//buffer = new Process[size];
		//headPointer = EMPTY_VALUE;
		this.size = size;
	}
	
	/*
	 * blocking queue: processes will only be added to the queue
	 * if the queue has space
	 * */
	public synchronized void enqueue(Process process){
	
		if(isFull()){
			System.out.println("producer: waiting on queue to empty");
			waitForNotify();
		}
		
		//increment head pointer
		headPointer++;
		//add process to priority queue
		//buffer[headPointer] = process;
		offer(process);
		
		invokeNotify();
		
	}
	
	/*
	 * blocking dequeue: will not dequeue if ready queue is empty
	 * */
	public synchronized Process dequeue(){
		
		//check if queue is empty
		if(isEmpty()){
			System.out.println("scheduler: waiting on queue to fill");
			waitForNotify();
		}
		
//		Process head = buffer[headPointer];
		
		headPointer--;
		
		invokeNotify();
		
		//return process
		return head();
		
	}
	
	public boolean isFull(){
		return headPointer >= size - 1;
	}
	
	//check if queue empty
	public boolean isEmpty(){
		return headPointer <= 0;
	}
	
	//thread will wait if queue empty
	private void waitForNotify(){
		try{
			wait();
		}catch(Exception e){
			System.out.println("ERROR:");
			System.out.println("producer not waiting!!!");
		}
	}
	
	private void invokeNotify(){
		try{
			notify();
		}catch(Exception e){
			System.out.println("ERROR:");
			System.out.println("notify did not work");
		}
	}
	
}
