import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;



public class tabu_list {
	private Queue<Move> list=new LinkedList<Move>();
	private int tabu_maxSize=4;
	Move n=new Move();
	
	public tabu_list(){
		
	}
	public void tabu(Move m){
		//list=new Move();
		//if(!this.list.contains(m)){
		//Move new_m=new Move();
			if(this.list.size()>=tabu_maxSize)
			{
				n=this.list.remove();
			n.print(n);}
						
			
		this.list.add(m);
		//}
	}
	
	public void delet_tabu(Move m){
		this.list.remove(m);
	}
	public boolean isTabuElem(Move move){
		if(!this.list.contains(move)){
			return false;
			
		}
		else return true;
		
		//return this.list.contains(move);
	}
	
	public int getMaxSize() {
		return tabu_maxSize;
	}

	
	public void setMaxSize(int maxSize) {
		this.tabu_maxSize = maxSize;
	}
	public void print(){
		Iterator<Move> i=list.iterator();
		while(i.hasNext()){
			Move m=new Move();
			m=i.next();
			City c1=new City();
			City c2=new City();
			c1=m.getCity1();
			c2=m.getCity2();
			System.out.print("("+c1.getCityName()+","+c2.getCityName()+")");
			
		
		}
	}

}
