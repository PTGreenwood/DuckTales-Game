package uq.deco2800.ducktales.util.exceptions;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for the general exception for all register-related exceptions
 *
 * Created on 18/10/2016.
 * @author khoiphan21
 */
public class ResourceRegisterExceptionTest {
    @Test
    public void testBasicExceptionCreation() {
        String message = "exception message";

        ResourceRegisterException exception = new ResourceRegisterException(message);

        assertEquals(message, exception.getMessage());
    }
}
