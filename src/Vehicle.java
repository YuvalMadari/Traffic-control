
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class Vehicle implements Dynamic{
	
	Random rand = new Random () ;
		
	private boolean b ; 
	static private int numOfVehicle ;
	final private int counter ;
	private Road road ;
	private int speed ;
	private double distance ;
	private int indR ;
	private Passenger passenger ;
	private boolean havePassenger ;
	private boolean printOnce ;

	private ArrayList<Road> roads ;
	

	//Constructor Who get a map and create a Vehicle  
	public Vehicle (Map map){
		speed  = rand.nextInt(30 , 120) ;
		counter = ++ numOfVehicle ;
		this.roads = map.Randomtrack() ;
		indR = 0 ;
		distance = 0 ;
		printOnce = false ;
		b = false ;
		this.road = this.roads.get(indR) ;
		havePassenger = false ;
		System.out.println("Creating " + this + ",speed: " + speed + ", path: " + this.roads);
	}
	
	
	//Method that override a Passenger drive on report.txt
	public void write(Vehicle v , Passenger p , Junction start , Junction end){
        try {
            FileWriter writer = new FileWriter("report.txt" , true );
            BufferedWriter bufferedWriter = new BufferedWriter(writer);           
            bufferedWriter.write(v.toString() +"   |"+ p.toString() +"    |"+  start.toString() +" |"+  end.toString()); ;
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	
	//Method that move a Vehicle on the road 
	public void move() {

		distance += speed ;

		// if the Road is over
		if (distance >= road.getLength()) {
			// if the track is over
			if (indR == roads.size()-1) {
				System.out.println(this + " arrived to it's destination: " + road.getEnd() );
				b = true ;
				// if the Vehicle have a Passenger 
				if (havePassenger && !printOnce) {
					write(this , passenger , passenger.getStart() , passenger.getEnd()) ;
					printOnce = true  ; // guarantee that he print once  
					System.out.println(passenger + " arrived to the destination with " + this);
				}
				return ; 
			}
			// if there have a TrafficLights in the Junction
			if (road.getEnd().getTrafficLights() != null && road.getEnd().getTrafficLights().getCurrentGreen() != road ) {
				System.out.println(this + " is waiting for green light on " + road.getEnd());
				distance -= speed ; 
				return ;

			}
			
			indR ++ ;
			distance -= road.getLength() ; 
			road = roads.get(indR) ; 
			
			// if there have a Passenger o=in the Junction
			if (road.getStart().CheckPassenger(road) != null && havePassenger == false ) { 
				roads = road.getStart().CheckPassenger(road).getRoads() ;
				road = roads.get(0) ; 
				passenger = road.getStart().CheckPassenger(road) ;
				havePassenger = true ;
				indR = 0 ;
				distance = 0 ; 
				System.out.println(this + " is collecting " + road.getStart().CheckPassenger(road) + " at " + road.getStart().CheckPassenger(road).getStart());
				road.getStart().getPassengers().remove(road.getStart().CheckPassenger(road)) ;
				return ;
			}
		}

			System.out.println(this + " is moving on the " + road);

	}
	
	
	public void workUnit() {
		move() ;
	}

	@Override
	public String toString() {
		return "Vehicle " + counter ;
	}

	public boolean getB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}
	
}
