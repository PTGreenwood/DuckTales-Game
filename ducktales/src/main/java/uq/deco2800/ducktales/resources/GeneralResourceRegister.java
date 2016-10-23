package uq.deco2800.ducktales.resources;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uq.deco2800.ducktales.util.exceptions.ResourceRegisterException;

/**
 * This register will hold all sorts of general information
 *
 * Created on 15/10/2016.
 * @author khoiphan21, fractal
 */
public class GeneralResourceRegister {
    /** The logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralResourceRegister.class);

    /**
     * The lists of many first and last names to be used when generating peons
     */
    private List<String> firstNames;
    private List<String> lastNames;

    private static GeneralResourceRegister ourInstance = new GeneralResourceRegister();

    /**
     * Instantiate a general resource register and carry out the following tasks
     *      1. Load the 2 lists of random first and last names
     */
    private GeneralResourceRegister() {
        firstNames = new ArrayList<>();
        lastNames = new ArrayList<>();

        loadNameLists();
    }

    public static GeneralResourceRegister getInstance() {
        return ourInstance;
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


        return firstNames.get(first) + " " + lastNames.get(last);
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
            LOGGER.info("Unable to load file", e);
            throw new ResourceRegisterException(
                    "Cannot find files while trying to" + " load names in GeneralResourceRegister: " + e.getMessage());
        } catch (IOException e) {
            LOGGER.info("Unable to read file", e);
            throw new ResourceRegisterException("Error when trying to read the names"
                    + "in the firstname.txt or lastname.txt files" + " in GeneralResourceRegister");
        }
    }
}