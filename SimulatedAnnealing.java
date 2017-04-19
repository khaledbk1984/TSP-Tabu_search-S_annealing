
public class SimulatedAnnealing {
    public SimulatedAnnealing(){
    }
    
    public void simulatedAnnealing(){
   
        
        double temp = 100000;

        double coolingRate = 0.005;

        //create random intial solution
        Tour currentSolution = new Tour();
        currentSolution.generateIndividual();
        
        System.out.println("Total distance of initial solution: " + currentSolution.getTotalDistance());
        System.out.println("Tour: " + currentSolution);

        Tour best = new Tour(currentSolution.getTour());
        
       
        while (temp > 1) {
        	for(int m=0;m<12;m++){
            Tour newSolution = new Tour(currentSolution.getTour());

            int tourPos1 = Utility.randomInt(1 , (newSolution.tourSize()-1));
            int tourPos2 = Utility.randomInt(1 , (newSolution.tourSize()-1));
            
    		while(tourPos1 == tourPos2) {tourPos2 = Utility.randomInt(1 , (newSolution.tourSize()-1));}

            City citySwap1 = newSolution.getCity(tourPos1);
            City citySwap2 = newSolution.getCity(tourPos2);

            newSolution.setCity(tourPos2, citySwap1);
            newSolution.setCity(tourPos1, citySwap2);
            
            int currentDistance   = currentSolution.getTotalDistance();
            int neighbourDistance = newSolution.getTotalDistance();

            double rand = Utility.randomDouble();
          
            if ( Utility.acceptanceProbability(currentDistance, neighbourDistance, temp) > rand) {
             // System.out.println(Utility.acceptanceProbability(currentDistance, neighbourDistance, temp));
            	currentSolution = new Tour(newSolution.getTour());
            }

            if (currentSolution.getTotalDistance() < best.getTotalDistance()) {
            	
                best = new Tour(currentSolution.getTour());
            }
        	}
            temp *= 1 - coolingRate;
        }

        System.out.println("Final solution distance: " + best.getTotalDistance());
        System.out.println("Tour: " + best);
    }
}
