import org.junit.*;
import java.io.*;
import java.util.logging.*;

public class MainTest {

    @Test
    public void testLog() {
        Logger log;
        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("logging.properties"));
            log = Logger.getLogger(Main.class.getName());
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }

    @Test
    public void testNotValideCommands(){

        String[] args = new String[]{
                "12412343",
                " ",
                "c",
                "ghbbmlkfds"
        };
        Main.main(args);

        String[] args1 = new String[]{
                ""
        };
        Main.main(args1);

        String[] args2 = new String[]{
                "notFound.txt"
        };
        Main.main(args2);

    }

    @Test
    public void testCircle() {

        // valide file
        String[] args = new String[]{
                MainTest.class.getResource("testCircleValid.txt").getPath(),
                MainTest.class.getResource("testCircleOut.txt").getPath()
        };
        Main.main(args);

        // not valide file
        String[] args1 = new String[]{
                MainTest.class.getResource("testCircleNotValid.txt").getPath(),
                MainTest.class.getResource("testCircleOut.txt").getPath()
        };
        Main.main(args1);

        // not valide console
        String[] args2 = new String[]{
                MainTest.class.getResource("testCircleNotValid.txt").getPath()
        };
        Main.main(args2);

        // valide console
        String[] args3 = new String[]{
                MainTest.class.getResource("testCircleValid.txt").getPath()
        };
        Main.main(args3);


    }

    @Test
    public void testRectangle() {

        // valide file
        String[] args = new String[]{
                MainTest.class.getResource("testRectangleValid.txt").getPath(),
                MainTest.class.getResource("testRectangleOut.txt").getPath()
        };
        Main.main(args);

        // not valide file
        String[] args1 = new String[]{
                MainTest.class.getResource("testRectangleNotValid.txt").getPath(),
                MainTest.class.getResource("testRectangleOut.txt").getPath()
        };
        Main.main(args1);

        // not valide console
        String[] args2 = new String[]{
                MainTest.class.getResource("testRectangleNotValid.txt").getPath()
        };
        Main.main(args2);

        // valide console
        String[] args3 = new String[]{
                MainTest.class.getResource("testRectangleValid.txt").getPath()
        };
        Main.main(args3);

    }

    @Test
    public void testTriangle() {

        // valide file
        String[] args = new String[]{
                MainTest.class.getResource("testTriangleValid.txt").getPath(),
                MainTest.class.getResource("testTriangleOut.txt").getPath()
        };
        Main.main(args);

        // not valide file
        String[] args1 = new String[]{
                MainTest.class.getResource("testTriangleNotValid.txt").getPath(),
                MainTest.class.getResource("testTriangleOut.txt").getPath()
        };
        Main.main(args1);

        // not valide console
        String[] args2 = new String[]{
                MainTest.class.getResource("testTriangleNotValid.txt").getPath()
        };
        Main.main(args2);

        // valide console
        String[] args3 = new String[]{
                MainTest.class.getResource("testTriangleValid.txt").getPath()
        };
        Main.main(args3);

    }

}