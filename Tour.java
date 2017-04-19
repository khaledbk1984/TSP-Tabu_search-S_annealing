
import java.util.ArrayList;
import java.util.Collections;



public class Tour{

    private ArrayList<City> tour = new ArrayList<City>();
    
    private int distance = 0;
    
   
    public Tour(){
        for (int i = 0; i < TourManager.numberOfCities(); i++) {
            tour.add(null);
        }
    }
    
   
    @SuppressWarnings("unchecked")
	public Tour(ArrayList<City> tour){
        this.tour = (ArrayList<City>) tour.clone();
    }
    
   
    public ArrayList<City> getTour(){
        return tour;
    }
    
   
	
    
    public void generateIndividual() {
        for (int cityIndex = 0; cityIndex < TourManager.numberOfCities(); cityIndex++) {
          setCity(cityIndex, TourManager.getCity(cityIndex));
        }
        City b = null;
        Collections.shuffle(tour);
        for(int i=0;i<tour.size();i++){
        City a=tour.get(i);
        if(a.getCityName()=="istanbul"){
        	b=a;
        Collections.swap(tour, i, 0);
        }}tour.add(b);
       /* for(int j=0;j<tour.size();j++)
        	System.out.print(tour.get(j).getCityName()+"  ");
        System.out.print("\n");*/
        
    }

    public City getCity(int index) {
        return tour.get(index);
    }

   
    public void setCity(int index, City city) {
        tour.set(index, city);
        distance = 0;
    }
    
   
    public int getTotalDistance(){
    	if (distance == 0) {
            int tourDistance = 0;
            for (int cityIndex=0; cityIndex < tourSize(); cityIndex++) {
                City fromCity = getCity(cityIndex);
                City destinationCity;
                
                if(cityIndex+1 < tourSize()){
                    destinationCity = getCity(cityIndex+1);
                }
                else{
                    destinationCity = getCity(0);
                }                
                tourDistance += Utility.distance(fromCity, destinationCity); 
            }
            distance = tourDistance;
        }
        return distance;
    }

   
    public int tourSize() {
        return tour.size();
    }
    
    @Override
    
    public String toString() {
        String s = getCity(0).getCityName();
        for (int i = 1; i < tourSize(); i++) {
            s += " -> " + getCity(i).getCityName();
        }
        return s;
    }
}
    
