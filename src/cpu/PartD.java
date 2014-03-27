package cpu;

public class PartD {
	
	Cpu cpu;
	ReadyQueue readyQueue;
	Producer producer;
	Scheduler scheduler;
	
	
	public PartD(){
		
		this.cpu = new Cpu();
		this.readyQueue = new ReadyQueue(10);
		this.producer = new Producer(readyQueue);
		this.scheduler = new Scheduler(readyQueue, cpu);
	
	}
	
	public static void main(String[] args) {
		
		DemonstrateStarvation d = new DemonstrateStarvation();
		//create test processes
//		Process p1 = new Process(PriorityClass.NORMAL, 60000);
//		Process p2 = new Process(PriorityClass.BACKGROUND, 60000);
//		Process p3 = new Process(PriorityClass.CRITICAL, 60000);
//		Process p4 = new Process(PriorityClass.CRITICAL, 60000);
//		Process p5 = new Process(PriorityClass.NORMAL, 60000);
//		Process p6 = new Process(PriorityClass.BACKGROUND, 60000);
//		d.readyQueue.enqueue(p1);
//		d.readyQueue.enqueue(p2);
//		d.readyQueue.enqueue(p3);
//		d.readyQueue.enqueue(p4);
//		d.readyQueue.enqueue(p5);
//		d.readyQueue.enqueue(p6);
		
		Thread p = new Thread(d.producer);
		Thread s = new Thread(d.scheduler);
		
		p.start();
		s.start();
		
		try{

			p.join();
			s.join();
		}catch(Exception e){
			//do nothing
		}
	}

}
