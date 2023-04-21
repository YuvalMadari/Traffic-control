import java.util.ArrayList;
import java.util.Random;

public class Map {
	
	Random rand = new Random () ;
	
	private Junction junc ;
	
	ArrayList<Junction> junctions = new ArrayList<Junction>() ;
	ArrayList<Road> roads = new ArrayList<Road>() ;
	
	
	// constructor that get a integer number and ,
	// create a  same number of Junction as the integer number and ,
	// create a map with Roads and Traffic Lights
	public Map (int numOfJunction) {
		for (int i=0 ;i < numOfJunction ; i ++) {
			junc = new Junction() ;
			junctions.add(junc) ;

		}
		
		for (int i=0 ; i < numOfJunction ; i++) {
			for (int j=0 ;j < numOfJunction ; j ++) {
				if (i!=j && rand.nextBoolean()) {
					Road r = new Road (junctions.get(i) , junctions.get(j)) ;
					roads.add(r) ;
				}
			}
		}

		for (Junction j : junctions) {
			if (j.getEnteringRoads().size() >= 1) 
				if (rand.nextBoolean() && rand.nextBoolean())
					if (rand.nextBoolean()) {
						j.setTrafficLights(new SequentialTrafficLights(j)) ;
					}
					else 
						j.setTrafficLights(new RandomTrafficLights(j)) ;
		}
	}

	// constructor who get ArrayList of Junctions and ArrayList of Roads
	// and create a map 
	public Map (ArrayList Junction , ArrayList Road ) {

		for (Junction j : junctions) {
			// if Junction have more then a single road
			if (j.getEnteringRoads().size() >= 1) 
				// the probability to set a Traffic Light on Junction is 0.25
				if (rand.nextBoolean() && rand.nextBoolean()) 
					// the probability to set a Sequential Traffic Light or Random Traffic Lights is 0.5
					if (rand.nextBoolean())
						j.setTrafficLights(new SequentialTrafficLights(j)) ;
					else 
						j.setTrafficLights(new RandomTrafficLights(j)) ;
		}

	}
	int i = 0 ;
	// method that build a Random Route 
	public ArrayList<Road> Randomtrack () {
		ArrayList<Road> randomRoads = new ArrayList<Road>() ;
		Junction start ;
		int i =0 ; 
		do {
			start = this.junctions.get(rand.nextInt(junctions.size()-1)) ;
		}
			while (start.getExitingRoads().size() == 0) ;
		while (randomRoads.size() < 4 && start.getExitingRoads().size() > 0) {
			randomRoads.add(start.getExitingRoads().get(rand.nextInt(start.getExitingRoads().size()))) ;
			start =  randomRoads.get(i++).getEnd() ;
		}
		return randomRoads;
	}

	
	public ArrayList<Road> getRoads() {
		return roads;
	}

	public void setRoads(ArrayList<Road> roads) {
		this.roads = roads;
	}

	public ArrayList<Junction> getJunctions() {
		return junctions;
	}
	
	public void setJunctions(ArrayList<Junction> junctions) {
		this.junctions = junctions;
	}

	public Junction getJunc() {
		return junc;
	}

	public void setJunc(Junction j) {
		this.junc = j;
	}
	
	


}
