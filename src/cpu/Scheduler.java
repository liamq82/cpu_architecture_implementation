package cpu;

public class Scheduler implements Runnable{
	
	private ReadyQueue readyQueue;
	private Cpu cpu;
	
	public Scheduler(ReadyQueue queue, Cpu cpu){
		this.readyQueue = queue;
		this.cpu = cpu;
	}

	@Override
	public void run() {
		
		while(true){
			Process p = readyQueue.dequeue();
			System.out.println("scheduler: removing process from queue " + p);
			
			cpu.setCpuProcess(p);
			
			//return process to ready queue if it is not complete i.e. run time > 0
			if(p.getProcessRunTime() > 0){

//				readyQueue.enqueue(p);
				readyQueue.add(p);
				System.out.println("returning process " + p + " to the ready queue");
				
			}else{
				System.out.println("process " + p + "complete");
			}
			
//			try{
//				System.out.println("sleeping");
//				Thread.sleep(1);
//				
//			}catch(Exception e){
//				//do nothing
//			}
		}
		
	}
	
	/*
	 * take the highest priority process from the ready queue
	 * */
	public Process getProcessFromReadyQueue(){
		return readyQueue.dequeue();
	}
	
	/*
	 * take process from cpu and place back on ready queue
	 * */
	public void setProcessOnReadyQueue(){
		readyQueue.enqueue(getProcessFromCpu());
	}
	
	/*
	 * take process from cpu
	 * */
	public Process getProcessFromCpu(){
		return cpu.getCpuProcess();
	}
	
	/*
	 * put a process on the cpu
	 * */
	public void setProcessOnCPU(){
		cpu.setCpuProcess(getProcessFromReadyQueue());
	}

}
