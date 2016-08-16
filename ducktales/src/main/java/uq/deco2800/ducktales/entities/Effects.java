package uq.deco2800.ducktales.entities;

public class Effects extends Threats{
	
	/**Effect that 'effects' the game world be objects or areas
	 * SetS
	 * 
	 */
	
	private boolean HasStartTimer = false;
	private boolean HasEndTimer = false;
	
	private float StartTimer = 0;
	private float EndTimer = 0;
	private float currentTime;
	
	
	
	public Effects(String name){
		super(name,"Effect");
	}
	
	
	
	/**Set time for a timer of start
	 * 
	 * @param time input the system time when the effect needs to start
	 */
	public void SetStartTimer(float time){
		if(time >0){
			this.StartTimer = time;
			this.HasStartTimer = true;
		}else{
			//throw new exception
		}
		
	}
	
	
	
	/**Set time for a timer of expiry
	 * 
	 * @param time in seconds when effect ends from now
	 */
	public void SetEndTimer(float time){
		if(time >0){
			this.currentTime = System.currentTimeMillis();
			this.EndTimer = time + currentTime;
			this.HasEndTimer = true;
		}else{
			//throw new exception
		}
		
	}
	
	
	
	/**
	 * 
	 * @return true if the effect should/end expire
	 */
	public boolean HasEffectEnded(){
		this.currentTime = System.currentTimeMillis();
		if(EndTimer ==currentTime && HasEndTimer){
			//Change HasEndTimer to false (Not sure if if stat will break)
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 
	 * @return true when the effect should start
	 */
	public boolean ShouldEffectStart(){
		this.currentTime = System.currentTimeMillis();
		if(StartTimer ==currentTime && HasStartTimer){
			//Change HasStarTimer to false (Not sure if if stat will break)
			return true;
		}else{
			return false;
		}
	}
	
	
	
	/**
	 * 
	 * @return StartTime if it exists or 0 if the timer has expired or otherwise
	 */
	public float ReturnStartTime(){
		if(HasStartTimer){
			return StartTimer;
		}else{
			return 0;
		}
	}
	
	
	
	/**
	 * 
	 * @return EndTime if it exists or 0 if the timer has expired or otherwise
	 */
	public float ReturnEndTime(){
		if(HasEndTimer){
			return EndTimer;
		}else{
			return 0;
		}
	}
	
	
	
	
	
}
