package cpu;

public class DemonstrateStarvation {

	Cpu cpu;
	ReadyQueue readyQueue;
	Producer producer;
	Scheduler scheduler;
	
	Process p = new Process(PriorityClass.CRITICAL, (long) 100);
	
	public DemonstrateStarvation(){
		this.cpu = new Cpu();
		this.readyQueue = new ReadyQueue(10);
		this.producer = new Producer(readyQueue);
		this.scheduler = new Scheduler(readyQueue, cpu);
	}
	
	public static void main(String[] args) {
		
		DemonstrateStarvation d = new DemonstrateStarvation();
		
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
