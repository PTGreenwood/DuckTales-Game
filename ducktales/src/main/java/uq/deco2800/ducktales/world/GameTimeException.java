package uq.deco2800.ducktales.world;

import org.junit.rules.ExpectedException;

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