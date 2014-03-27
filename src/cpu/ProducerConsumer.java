package cpu;

public class ProducerConsumer {

	Cpu cpu;
	ReadyQueue readyQueue;
	Producer producer;
	Scheduler scheduler;
	
	
	public ProducerConsumer(){
		
		this.cpu = new Cpu();
		this.readyQueue = new ReadyQueue(10);
		this.producer = new Producer(readyQueue);
		this.scheduler = new Scheduler(readyQueue, cpu);
	
	}
	
	public static void main(String[] args) {
	
		ProducerConsumer prodCons = new ProducerConsumer();
		Thread t1 = new Thread(prodCons.producer);
		Thread t2 = new Thread(prodCons.scheduler);
		t1.start();
		t2.start();
		
		try{
			t1.join();
			t2.join();
		}catch(Exception e){
			//do nothing
		}
	}

}
