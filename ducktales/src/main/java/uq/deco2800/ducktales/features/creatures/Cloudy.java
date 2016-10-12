package uq.deco2800.ducktales.features.creatures;
import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Class for cloud creature
 * 
 * @author UniqueLeaf
 * @author MattLeggy
 * 
 */
 
 public class Cloudy extends Creatures {
 
	/**Grabs the images of cloud creature
	*/
 	public void loadImage (String path) throws IOException {
		URL url = this.getResource (path);
		Image img = ImageIO.read(url);
		return img;
 	}
 	
	 /**Frame for sprite animation
	 */
	public void spriteAnimation {
		//create an arraylist to loop over all images
		Arraylist <images> frame;
 	}
 }
