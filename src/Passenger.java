import java.util.ArrayList;

public class Passenger {
	
	static private int numOfPassenger ;
	final private int counter ;
	private int time ;
	private Junction start ;
	private Junction end ;
	private boolean isInVehicle ; 
	
	private ArrayList<Road> roads ;
	private ArrayList<Passenger> passengers = new ArrayList<Passenger>() ;

	public Passenger(ArrayList<Road> roads) { 
		counter = ++ numOfPassenger ;
		this.roads = roads ;
		this.time = 0 ;
		this.start = this.roads.get(0).getStart() ;
		this.end = this.roads.get(3).getEnd() ;
		isInVehicle = false ;
		System.out.println(this + " is wating for vehicle at " + this.start + " ,path: " + this.roads );
	}
	
	public void updateTime() {
		for (Passenger p : this.roads.get(0).getStart().getPassengers()){
			p.setTime(time++);
		}
	}




	public Junction getEnd() {
		return end;
	}

	public void setEnd(Junction end) {
		this.end = end;
	}

	public boolean isInVehicle() {
		return isInVehicle;
	}

	public void setInVehicle(boolean isInVehicle) {
		this.isInVehicle = isInVehicle;
	}

	public Junction getStart() {
		return start;
	}

	public void setStart(Junction junction) {
		this.start = junction;
	}

	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(ArrayList<Passenger> passengers) {
		this.passengers = passengers;
	}

	public int getTime() {
		return this.time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public ArrayList<Road> getRoads() {
		return roads;
	}

	public void setRoads(ArrayList<Road> roads) {
		this.roads = roads;
	}

	@Override
	public String toString() {
		return "Passenger " + counter ;
	}
	
}
