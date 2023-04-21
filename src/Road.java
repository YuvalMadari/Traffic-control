
public class Road {
	
	private Junction start ;
	private Junction end ;	

	// constructor who get 2 Junctions and print create a Road
	public Road (Junction start, Junction end) {
		this.start = start ;
		this.end = end ;
		if (start == end) {
			this.end = new Junction () ;
			System.out.printf("Road can not connect a junction to itself, the end junction has been %nreplace with %s %n" , this.end);
		}
		System.out.printf("Creating %s, length: %.2f %n" , this , getLength() );
		//System.out.println("Creating Road from " + this.start + " to " + this.end + ", length: " + this.start.calcDistance(this.end) );
		end.getEnteringRoads().add(this) ;
		start.getExitingRoads().add(this) ;
	}
	
	public double getLength () {
		return  start.calcDistance(end) ;
	}
	
	public Junction getStart () {
		return this.start ;
	}

	public Junction getEnd () { 
		return this.end ;
	}

	public String toString() {
		return "Road from " + this.start + " to " + this.end ;
	}

}
