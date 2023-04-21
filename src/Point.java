import java.util.Random ; 

public class Point {
	
	private double x ; 
	private double y ;

	Random rand = new Random () ; 

	// constructor who get (x,y) and print create a Point
	public Point (double x ,double y) { 
		this.x = x ; 
		this.y = y ;
		checkPoint(this.x , this.y) ; 
		if (!(this instanceof Junction))
			System.out.printf("Creating Point (%.2f, %.2f) %n" , this.x , this.y) ;			
	}

	//constructor that create a random Point
	public Point () { // Default constructor - give random Point
		this.x = rand.nextDouble(0,800) ; // x between 0 to 800
		this.y = rand.nextDouble(0,600) ; // y between 0 to 600
		if (!(this instanceof Junction))
			System.out.printf("Creating Point (%.2f, %.2f) %n" , this.x , this.y) ;
	}

	// Check if the Point have a valid input
	public double checkPoint (double x , double y) { 
		
		try {
			setX (x) ;
		}catch (Exception e) {
			this.x = rand.nextDouble(0,800) ; // random x between 0 to 800
			System.out.printf("%f is illegal value for x and has been replaced with%n%f %n" ,x ,this.x);
		}
		
		try {
			setY(y);
		}catch (Exception e) {
			this.y = rand.nextDouble(0,600) ; // random y between 0 to 600
			System.out.printf("%f is illegal value for y and has been replaced with%n%f %n" ,y ,this.y);
		}
		return this.x + this.y ;   
	}


	//return the Distance between two Point 
	public  double calcDistance(Point other ) { 
		double disX = Math.pow((this.getX() - other.getX()), 2) ; // (x1-x2)^2
		double disY = Math.pow((this.getY() - other.getY()), 2) ; // (y1-y2)^2
		return Math.sqrt(disX + disY ) ; 
	}

	public double getX() {
		return x;
	}
	
	public void setX(double x) throws Exception {
		if (x < 0 || x > 800)  // x  is not in the range
			throw new Exception (x + " is illegal value for x and has been replaced with " ) ;	
		else 
			this.x = x ;

	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) throws Exception {
		if (y < 0 || y > 600)  // y  is not in the range
			throw new Exception (y + " is illegal value for y and has been replaced with " ) ;	
		 else 
			this.y = y ;
		
	}

}