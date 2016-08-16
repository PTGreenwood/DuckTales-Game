package uq.deco2800.ducktales.entities;

public class Threats {
	String name;
	String type;
	
	/**Enemy takes a string name and a type of enemy which is or Creature
	 * or Effect
	 * @param name - String name
	 * @param type - String that is Creature
	 * or Effect
	 * @return
	 */
	public Threats(String name, String  type){
		
		if (name.isEmpty() || name.equals(' ')){
			// Throw exception
		}else{
			this.name = name;	
		}
		
		if ( !(type.equals("Creature") || type.equals("Effect") || type.equals("creature") || type.equals("effect"))   ){
			// Throw exception
		}else{
		
		this.type = type;
				
		}
	}
}
