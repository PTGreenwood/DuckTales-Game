package uq.deco2800.ducktales.features.time;

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