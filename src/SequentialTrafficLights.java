
public class SequentialTrafficLights extends TrafficLights {
	
	private int i = 1 ;
	
	// Switch Lights in the next Entering Road get the green light
	public void  SwitchLights() {
		if (i >= (super.getJunc().getEnteringRoads().size())-1) 
			i = -1 ;
		i++ ;
		super.setCurrentGreen(super.getJunc().getEnteringRoads().get(i));
	}



	public SequentialTrafficLights (Junction j) {
		super(j) ;
		j = super.getJunc() ;
		System.out.println(this);
	}
	
	public String toString(){
		return "Sequential " + super.toString() ;
	}
}
