package cpu;

public class TestingStarvation {

	Cpu cpu;
	ReadyQueue readyQueue;
	Producer producer;
	Scheduler scheduler;
	
	
	public TestingStarvation(){
		
		this.cpu = new Cpu();
		this.readyQueue = new ReadyQueue(1000);
		this.producer = new Producer(readyQueue);
		this.scheduler = new Scheduler(readyQueue, cpu);
	
	}
	
	public static void main(String[] args) {
		
		TestingStarvation main = new TestingStarvation();
		Thread p = new Thread(main.producer);
		Thread s = new Thread(main.scheduler);
		
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
