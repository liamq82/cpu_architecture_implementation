package cpu;

import java.lang.Math;

//this class creates a heap sort
public class IntegerHeapSort {

	private int[] sortedMaxHeap;
	private int heapSize;
	private int halfHeapSize;
	private int leftNode;
	private int rightNode;
	private int largest;
	private int i;
	
	public void heapSort(int[] intArray){
		
		//build a max heap array
		buildMaxHeap(intArray);
		
		
		//loop trough heap
		for(int i = intArray.length; i > 0; i--){

			//exchange intArray[1] with intArray[i]
			int tmp = intArray[0];
			intArray[0] = intArray[i-1];
			intArray[i-1] = tmp;

			//reduce heap length by 1
			--heapSize;
			maxHeapify(intArray, 0);

		}
		
		sortedMaxHeap = intArray;
					
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
	private void maxHeapify(int[] intArray, int i){
		//left child
		leftNode = getLeftChildLocation(i);
		rightNode = getRightChildLocation(i);
		
		//largest root
		try{

			if(leftNode < heapSize && intArray[leftNode] > intArray[i]){
				largest = leftNode;
			}else 
			{
				largest = i;//largest is new element
			}
			
		}catch(ArrayIndexOutOfBoundsException e){
			//do nothing
		}
		
		
		try{

			if(rightNode < heapSize && intArray[rightNode] > intArray[largest]){
				largest = rightNode;//greater than largest so far
			}
			
		}catch(ArrayIndexOutOfBoundsException e){
			//do nothing
		}
		
		try{

			if(largest != i){
				//swap intArray[i] with intArray[largest]
				int tmp = intArray[i];
				intArray[i] = intArray[largest];
				intArray[largest] = tmp;
				
				//recurse down the tree
				maxHeapify(intArray, largest);
			}
			
		}catch(ArrayIndexOutOfBoundsException e){
			//do nothing
		}
		
	}
	
	private void buildMaxHeap(int[] intArray){
		
		//get size of heap
		heapSize = intArray.length;
		//get half of length for start point
		halfHeapSize = (int)Math.floor((float) (heapSize/2));
		
		//call to maxHeapify
		for(i = halfHeapSize - 1; i >= 0; i--){
			maxHeapify(intArray, i);
		}
	}
	
	public int[] getSortedMaxHeap() {
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
