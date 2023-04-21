import java.util.Random ; 

public class RandomTrafficLights extends TrafficLights{
	
	Random rand = new Random () ;

	// Switch Lights in Random choice which Entering Road get the green light
	public void SwitchLights() {
		super.setCurrentGreen(super.getJunc().getEnteringRoads().get(rand.nextInt(super.getJunc().getEnteringRoads().size()))) ;
	}


	public RandomTrafficLights (Junction j) {
		super(j) ;
		System.out.println(this);
	}
	
	public String toString(){
		return "Random " + super.toString() ;
	}
}


