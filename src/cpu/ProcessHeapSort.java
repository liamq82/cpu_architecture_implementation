package cpu;

import java.lang.Math;

//this class creates a heap sort
public class ProcessHeapSort {

	private Process[] sortedMaxHeap;
	protected Process[] processQueue;
	private int heapSize;
	private int halfHeapSize;
	private int leftNode;
	private int rightNode;
	private int largest;
	private int i;
	
	public void heapSort(Process[] processArray){
		
		//build a max heap array
		buildMaxHeap(processArray);
		
		
		//loop trough heap
		for(int i = processArray.length; i > 0; i--){

			//exchange intArray[1] with intArray[i]
			Process tmp = processArray[0];
			processArray[0] = processArray[i-1];
			processArray[i-1] = tmp;

			//reduce heap length by 1
			--heapSize;
			maxHeapify(processArray, 0);

		}
		
		sortedMaxHeap = processArray;
					
	}
	
	//return left node
	private int getLeftChildLocation(int i){
		
		return (2 * i) + 1;
		
	}
	
	//return right node
	private int getRightChildLocation(int i){
		
		return (2 * i) + 2;
		
	}
		
	//max heapify method
	private void maxHeapify(Process[] processArray, int i){
		//left child
		leftNode = getLeftChildLocation(i);
		rightNode = getRightChildLocation(i);
		
		//largest root
		try{

			if(leftNode < heapSize){
				
				//compare priority of parent and left child process
				int priority = processArray[leftNode].compareTo(processArray[i]);
				//if left child of higher priority, set largest to point to the left child process
				if(priority == 1){

					largest = leftNode;
					
				}else{

					largest = i;//largest is new element
					
				}
			}
			
		}catch(ArrayIndexOutOfBoundsException e){
			//do nothing
		}
		
		
		try{

			if(rightNode < heapSize){
				
				//compare priority of most important process and right child process
				int priority = processArray[rightNode].compareTo(processArray[largest]);
				//if left child of higher priority, set largest to point to the left child process
				if(priority == 1){

					largest = rightNode;//greater than largest so far
					
				}
				
			}
			
		}catch(ArrayIndexOutOfBoundsException e){
			//do nothing
		}
		
		try{

			if(largest != i){
				//swap intArray[i] with intArray[largest]
				Process tmp = processArray[i];
				processArray[i] = processArray[largest];
				processArray[largest] = tmp;
				
				//recurse down the tree
				maxHeapify(processArray, largest);
			}
			
		}catch(ArrayIndexOutOfBoundsException e){
			//do nothing
		}
		
	}
	
	public void buildMaxHeap(Process[] processArray){
		
		//get size of heap
		heapSize = processArray.length;
		//get half of length for start point
		halfHeapSize = (int)Math.floor((float) (heapSize/2));
		
		//call to maxHeapify
		for(i = halfHeapSize - 1; i >= 0; i--){
			maxHeapify(processArray, i);
		}
		
		//assign max heap processArray to our local array for retrieval
		this.processQueue = processArray;
		
	}
	
	public Process[] getMaxHeap(){
		
		return processQueue;
		
	}
	
	public Process[] getSortedMaxHeap() {
		return sortedMaxHeap;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return heapSize;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.heapSize = length;
	}

	/**
	 * @return the halfLength
	 */
	public int getHalfLength() {
		return halfHeapSize;
	}

	/**
	 * @param halfLength the halfLength to set
	 */
	public void setHalfLength(int halfLength) {
		this.halfHeapSize = halfLength;
	}

	/**
	 * @return the leftNode
	 */
	public int getLeftNode() {
		return leftNode;
	}

	/**
	 * @param leftNode the leftNode to set
	 */
	public void setLeftNode(int leftNode) {
		this.leftNode = leftNode;
	}

	/**
	 * @return the rightNode
	 */
	public int getRightNode() {
		return rightNode;
	}

	/**
	 * @param rightNode the rightNode to set
	 */
	public void setRightNode(int rightNode) {
		this.rightNode = rightNode;
	}
	
}
