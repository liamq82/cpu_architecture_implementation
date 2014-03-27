package cpu;

import java.util.ArrayList;

public class PriorityQueue extends MaxHeap implements Queue{
	
	
	public PriorityQueue(){
		
		/*the queue is an array of size nine*/
		this.processQueue = new ArrayList<Process>();
		
	}
	/*
	 * empty the queue
	 */
	@Override
	public void clear() {
		
		//empty the queue
		processQueue.clear();
		
	}

	/*
	 * check if queue is empty
	 * */
	@Override
	public boolean isEmpty() {
		
		//if queue is empty return true
		return processQueue.isEmpty();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return processQueue.size();
	}

	/*attempt to add an object to next available spot in the queue. return true if addition successful.
	 * Return false if unsuccessful and throw an IllegalStateException. */
	@Override
	public boolean add(Object element) throws IllegalStateException {

		try{
			
			//cast object to a Process and add to queue
			processQueue.add((Process) element);

			//bubble highest priority process to head of queue
			buildMaxHeap(processQueue);
			//return true if process added successfully
			return true;
			
		}catch(ArrayIndexOutOfBoundsException e){
			
			
			return false;
			
		}

	}

	/*offer an element for addition to the queue.
	 * */
	@Override
	public boolean offer(Object element) {
		
		try{

			//cast object to a Process and add to queue
			processQueue.add((Process) element);
						
			return true;

		}catch(ArrayIndexOutOfBoundsException e){

			return false;

		}
	}

	@Override
	public Object peek() {
		
		//check if queue is not empty
		if(!processQueue.isEmpty()){
			
			//return head without removing it
			return processQueue.get(0);
						
		}else{
			
			return null;
			
		}
		
		
	}

	@Override
	public Process head() {
		
		/*
		 * if queue IS NOT empty, remove the first process and return.
		 * */
		if(!processQueue.isEmpty()){
			
			Process tmp = (Process) processQueue.remove(0);
			buildMaxHeap(processQueue);
			return tmp;			
			
		}else{
			
			return null;
			
		}

		
	}

}
