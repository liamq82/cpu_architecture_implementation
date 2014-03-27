package cpu;

import java.lang.Math;
import java.util.List;

//this class creates a heap sort
public class MaxHeap {

	private List sortedMaxHeap;
	protected List processQueue;
	private int heapSize;
	private int halfHeapSize;
	private int leftNode;
	private int rightNode;
	private int largest;
	private int i;
	
	public void heapSort(List processArray){
		
		//build a max heap array
		buildMaxHeap(processArray);
		
		
		//loop trough heap
		for(int i = processArray.size(); i > 0; i--){

			//exchange intArray[1] with intArray[i]
			Process tmpI = (Process) processArray.remove(i-1);
			Process tmpZero = (Process) processArray.remove(0);
			
			//add i-1 to the head
			processArray.add(0, tmpI);
			processArray.add(i-1, tmpZero);
			
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
	private void maxHeapify(List processArray, int i){
		//left child
		leftNode = getLeftChildLocation(i);
		rightNode = getRightChildLocation(i);
		
		//largest root
		try{

			if(leftNode < heapSize){
				
				//compare priority of parent and left child process
				int priority = ((Process) processArray.get(leftNode)).compareTo((Process) processArray.get(i));
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
				int priority = ((Process) processArray.get(rightNode)).compareTo((Process) processArray.get(largest));
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
				Process tmpLargest = (Process) processArray.remove(largest);
				Process tmpI = (Process) processArray.remove(i);
				
				processArray.add(i, tmpLargest);
				processArray.add(largest, tmpI);
				
				//recurse down the tree
				maxHeapify(processArray, largest);
			}
			
		}catch(ArrayIndexOutOfBoundsException e){
			//do nothing
		}
		
	}
	
	public void buildMaxHeap(List processArray){
		
		//get size of heap
		heapSize = processArray.size();
		//get half of length for start point
		halfHeapSize = (int)Math.floor((float) (heapSize/2));
		
		//call to maxHeapify
		for(i = halfHeapSize - 1; i >= 0; i--){
			maxHeapify(processArray, i);
		}
		
		//assign max heap processArray to our local array for retrieval
		this.processQueue = processArray;
		
	}
	
	public List getMaxHeap(){
		
		return processQueue;
		
	}
	
	public List getSortedMaxHeap() {
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
