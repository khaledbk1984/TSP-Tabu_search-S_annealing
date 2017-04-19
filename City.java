
public class City {
    private int x;
    private int y;
    private String cityName;            

    public City(){
    	
    }
	public City(String cityName, int x, int y){
    	this.cityName = cityName;
        this.x = x;
        this.y = y;
    }            
        
    
	public int getX() {
		return x;
	}

	
	public void setX(int x) {
		this.x = x;
	}

	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public void print_city(){
		System.out.print(this.getCityName());
	}
	
}
