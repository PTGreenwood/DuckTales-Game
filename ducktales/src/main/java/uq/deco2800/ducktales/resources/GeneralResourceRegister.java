package uq.deco2800.ducktales.resources;

import uq.deco2800.ducktales.util.exceptions.GameSetupException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This register will hold all sorts of general information
 *
 * Created on 15/10/2016.
 */
public class GeneralResourceRegister {
    /**
     * The lists of many first and last names to be used when generating peons
     */
    private List<String> firstNames;
    private List<String> lastNames;

    private static GeneralResourceRegister ourInstance = new GeneralResourceRegister();

    public static GeneralResourceRegister getInstance() {
        return ourInstance;
    }

    private GeneralResourceRegister() {
        firstNames = new ArrayList<>();
        lastNames = new ArrayList<>();

        loadNameLists();
    }

    /**
     * Get a randomized name
     *
     * @return a name with randomized first and last names
     */
    public String getRandomName() {
        Random random = new Random();

        int first = random.nextInt(200);
        int last = random.nextInt(200);


        return firstNames.get(first) + "" + lastNames.get(last);
    }

    /**
     * Load the lists of random names into the names variables
     */
    private void loadNameLists() {
        try {
            //Changes loading files to use a class loading instead - mattyleggy.
        	InputStream firstNamesInputStream 
        		= getClass().getClassLoader().getResourceAsStream("peon/firstnames.txt");
        	
        	InputStream lastNamesInputStream 
    			= getClass().getClassLoader().getResourceAsStream("peon/lastnames.txt");

            BufferedReader firstNamesReader = new BufferedReader(
            		new InputStreamReader(firstNamesInputStream)
            );
            
            BufferedReader lastNamesReader = new BufferedReader(
            		new InputStreamReader(lastNamesInputStream)
            );

            // Now start loading the first names and last names
            String firstName = firstNamesReader.readLine();
            while (firstName != null) {
                firstNames.add(firstName);
                firstName = firstNamesReader.readLine();
            }
            String lastName = lastNamesReader.readLine();
            while (lastName != null) {
                lastNames.add(lastName);
                lastName = lastNamesReader.readLine();
            }

            // Close the file streams
            firstNamesReader.close();
            lastNamesReader.close();

        } catch (FileNotFoundException e) {
            throw new GameSetupException(
                    "Cannot find files while trying to" + " load names in GeneralResourceRegister: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("Error when trying to read the names"
                    + "in the firstname.txt or lastname.txt files" + " in GeneralResourceRegister");
        }
    }
}