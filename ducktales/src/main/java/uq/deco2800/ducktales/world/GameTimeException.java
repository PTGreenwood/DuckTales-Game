package uq.deco2800.ducktales.world;

public class GameTimeException extends RuntimeException {
      //Parameterless Constructor
      public GameTimeException() {

      }

      //Constructor that accepts a message
      public GameTimeException(String message)
      {
         super(message);
      }
      
 }