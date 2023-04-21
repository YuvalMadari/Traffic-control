import java.util.ArrayList;

public class Junction extends Point {
	
	static private int numOfJunction  ;
	final private int counter ;
	private TrafficLights trafficLights ;
	private Road greenRoad ;
	
	private ArrayList<Road> EnteringRoads = new ArrayList<Road>() ;
	private ArrayList<Road> ExitingRoads = new ArrayList<Road>() ;
	private ArrayList<Passenger> passengers = new ArrayList<Passenger>() ;

	
	
	// constructor that create a random Junction
	public Junction () {
		super() ;
		counter = ++ numOfJunction  ; 
		System.out.printf("Creating %s at Point (%.2f, %.2f) %n" , this , getX() , getY() );
	}
	
	// constructor who get (x,y) and create a Point
	public Junction (double x , double y) {
		super(x , y) ;
		counter = ++ numOfJunction  ; 
		System.out.printf("Creating %s at Point (%.2f, %.2f) %n" , this , getX() , getY() );
	}
	
	///method that Check id there have a Passenger in the Junction
	public Passenger CheckPassenger(Road road) {
		Passenger passenger = null ;
		if ( road.getStart().getPassengers() != null && road.getStart().getPassengers().size() > 1 ) {
			int maxTime = 0 ;
			for (Passenger p : road.getStart().getPassengers()){
				if (p.getTime() > maxTime ) {
					maxTime = p.getTime() ;
					passenger = p ;
				}
			}
		}
		if (road.getStart().getPassengers().size() == 1)
			passenger = road.getStart().getPassengers().get(0) ;
		return passenger; 		
	}
	
	
	@Override
	public String toString() {
		return "Junction " + counter ;
	}
	
	
	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(ArrayList<Passenger> passengers) {
		this.passengers = passengers;
	}

	public ArrayList<Road> getEnteringRoads() {
		return EnteringRoads;
	}

	public void setEnteringRoads(ArrayList<Road> enteringRoads) {
		EnteringRoads = enteringRoads;
	}

	public ArrayList<Road> getExitingRoads() {
		return ExitingRoads;
	}

	public void setExitingRoads(ArrayList<Road> exitingRoads) {
		ExitingRoads = exitingRoads;
	}

	public TrafficLights getTrafficLights() {
		return trafficLights;
	}

	public void setTrafficLights(TrafficLights t) {
		this.trafficLights = t;
	}

	public Road getGreenRoad() {
		return greenRoad;
	}

	public void setGreenRoad(Road greenRoad) {
		this.greenRoad = greenRoad;
	}
	
}
