package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UnitTest {

    @Test
    public void welcome() {
        Controller controller = new Controller();
        assertEquals("Welcome to Jooby!", controller.sayHi());
    }
}
