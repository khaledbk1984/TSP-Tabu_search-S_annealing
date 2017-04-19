import java.util.ArrayList;
import java.util.Collections;

public class tabu_search {
	public tabu_search(){
		
	}
	public void tabu(){
		int numberOfIterations = 100;
       // int tabuLength = 4;
        tabu_list t_l=new tabu_list();
       // t_l.setMaxSize(tabuLength);
        Tour currentSolution = new Tour();
        //Tour newSolution =new Tour();
        currentSolution.generateIndividual();
       // Move m=new Move();
        City citySwap1 =new City();
        City citySwap2 = new City();
        System.out.println("Total distance of initial solution: " + currentSolution.getTotalDistance());
        System.out.println("Tour: " + currentSolution);

        Tour best = new Tour(currentSolution.getTour());
         		int best_des=currentSolution.getTotalDistance();
         		Tour newSolution=new Tour();
         		while(numberOfIterations>0){
            for(int i=1;i<currentSolution.tourSize()-1;i++){
    		for(int j=2;j<currentSolution.tourSize()-1;j++){
    			//System.out.println(i+"   "+j);
    			
    			if(i==j){
    			//||t_l.isTabuElem(m)==true
    				continue;
    				
    			}
    			
    			else{
    			
    			citySwap1 = new City(currentSolution.getCity(i).getCityName(),currentSolution.getCity(i).getX(),currentSolution.getCity(i).getY());
                citySwap2 = new City(currentSolution.getCity(j).getCityName(),currentSolution.getCity(j).getX(),currentSolution.getCity(j).getY());
                //citySwap1.print_city();
               // citySwap2.print_city();
               // System.out.print("\n");
                newSolution=new Tour(currentSolution.getTour());
                newSolution.setCity(i, citySwap2);
               newSolution.setCity(j, citySwap1);
    			
       			//Collections.swap(newSolution, i, j);
               //if(i==1&&j==3){
       			//System.out.println("Tour: " + currentSolution);}
    			int new_des=newSolution.getTotalDistance();
    			if(new_des<best_des){
    				Move m=new Move();
    				m.setMove(citySwap1,citySwap2);
    				if(!t_l.isTabuElem(m)){
    				best_des=new_des;
    				best=new Tour(newSolution.getTour());
    				currentSolution=new Tour(newSolution.getTour());
    				
    				t_l.tabu(m);
    				t_l.print();
    				System.out.print("\n");
    				}
    				
    				//aspiration criteria
    				else if(t_l.isTabuElem(m)&&new_des<best_des){
    					best_des=new_des;
        				best=new Tour(newSolution.getTour());
        				currentSolution=new Tour(newSolution.getTour());
        				t_l.delet_tabu(m);
        				t_l.tabu(m);
        				t_l.print();
        				System.out.print("\n");
    				}
    				//System.out.println(m.getCity1().getCityName()+"   "+m.getCity2().getCityName());
    				
    				}
    			
    		//}
    			
    		} }
            
	}
         		
                /*City a=newSolution.getCity(3);
    			City b=newSolution.getCity(9);
    			Move n=new Move();
    			n.setMove(a, b);
    			t_l.tabu(n);*/
                numberOfIterations--;
              
              System.out.print("\n");
                
         		}
         		System.out.println("Final solution distance: " + best.getTotalDistance());
         	    System.out.println("Tour: " + best);}

}
