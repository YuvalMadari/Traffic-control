import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DrivingGame  {
	
	boolean b ;
	private Map map ;
	
	private ArrayList<Junction> juncs ;
	private ArrayList<Vehicle> cars ;
	private ArrayList<Passenger> passengers  = new ArrayList<Passenger>() ;
	private ArrayList<Dynamic> dynamics = new ArrayList<Dynamic>() ;



	
	public DrivingGame (int NumOfJunction ,int NumOfVehicle ) { 
		
		cars = new ArrayList<Vehicle>(NumOfVehicle) ;
		map = new Map (NumOfJunction) ;
		juncs = map.getJunctions();
		for (int i=0 ; i<NumOfVehicle ; i++) 
			cars.add(new Vehicle(map)) ;
		
        try {
            FileWriter writer = new FileWriter("report.txt" , false );
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("  Vehicle   |   Passenger   |     From   |     To    ");
            bufferedWriter.newLine();
            bufferedWriter.write("------------|---------------|------------|------------");
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

		
	}
	
	public void checkIfFinish () {
		int isFinish = 0 ;
		for (int i = 0 ; i < cars.size() ; i++) {
			if (cars.get(i).getB() == true)
				isFinish ++ ;
		}
		if (isFinish == cars.size())
			b = true ;
	}
	
	public void play () { 
		int i = 1 ;

		for (Vehicle v:cars) {
			dynamics.add(v) ;
		}
		for (Junction j:juncs) {
			if (j.getTrafficLights()!= null) {
				dynamics.add(j.getTrafficLights());
			}	
		}
		do {
			System.out.println("turn " + i );

			for (Passenger p : passengers)
				p.setTime(p.getTime()+1);

			for (Dynamic d : dynamics  ) {
				d.workUnit();
			}
			if (i%3 == 0) {
				Passenger tempPassenger = new Passenger(map.Randomtrack()) ;
				passengers.add(tempPassenger) ;
				tempPassenger.getStart().getPassengers().add(tempPassenger) ;
			}
			i ++ ;
			checkIfFinish ();
		}
		while (!b) ;
	}
	
}
