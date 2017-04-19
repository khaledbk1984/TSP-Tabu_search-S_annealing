import java.io.IOException;
import java.util.Scanner;

public class Main_c {
	 public static void main(String[] args) {
	        // Create and add our cities
	        City city = new City("istanbul",60, 200);
	        TourManager.addCity(city);
	        City city2 = new City("Bursa",180, 200);
	        TourManager.addCity(city2);
	        City city3 = new City("Ordu",80, 180);
	        TourManager.addCity(city3);
	        City city4 = new City("Trabzon",140, 180);
	        TourManager.addCity(city4);
	        City city5 = new City("Ankara",20, 160);
	        TourManager.addCity(city5);
	        City city6 = new City("kaysari",100, 160);
	        TourManager.addCity(city6);
	        City city7 = new City("konya",200, 160);
	        TourManager.addCity(city7);
	        City city8 = new City("Mersin",140, 140);
	        TourManager.addCity(city8);
	        City city9 = new City("Antep",40, 120);
	        TourManager.addCity(city9);
	        City city10 = new City("Hatay",100, 120);
	        TourManager.addCity(city10);        
	        City city11 = new City("Nevshehir",180, 100);
	        TourManager.addCity(city11);
	        City city12 = new City("kirikkale",60, 80);
	        TourManager.addCity(city12);
	        
	       Scanner s=new Scanner(System.in);
		System.out.print("enter '1' for tabu search and '2' for simulated annealing:    ");
		int i=s.nextInt();
		s.close();
		
		if(i==1){
			tabu_search t_s=new tabu_search();
			t_s.tabu();
			
		}
		else if(i==2){
			 SimulatedAnnealing s_a=new SimulatedAnnealing();
			 s_a.simulatedAnnealing();
			
		}
		else
			System.out.println("incorrectvalue");
	 }
	 

}
