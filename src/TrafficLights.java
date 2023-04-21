import java.util.Random ; 

public abstract class TrafficLights implements Dynamic  {
	
	Random rand = new Random () ;
	
	int delay ;
	private Junction junc ;
	private int delayCounter ;
	private Road currentGreen ;
	
	
	public TrafficLights (Junction j) { 
		delay = rand.nextInt(2,5) ;
		this.junc = j ;
		currentGreen = this.junc.getEnteringRoads().get(0);
		delayCounter =  delay ;
	}
	
	public void workUnit() {
		check() ;
	}

	
	// check if the delay time in the TrafficLights is over
	public void check() {
		delayCounter -- ;
		if (delayCounter == 0) { 
			SwitchLights() ;
			System.out.println(this);
			delayCounter = delay ;
		}
	}
	
	public abstract void SwitchLights() ; // Switch Light in the TrafficLights

	
	public Junction getJunc() {
		return junc;
	}

	public void setJunc(Junction j) {
		this.junc = j;
	}
	
	public Road getCurrentGreen() {
		return currentGreen;
	}
	
	public void setCurrentGreen(Road currentGreen) {
		this.currentGreen = currentGreen;
	}

	@Override
	public String toString() {
		return  "TrafficLights " + junc + ", delay= " + delay + ": green light on " + this.getCurrentGreen() ;
	}
}
