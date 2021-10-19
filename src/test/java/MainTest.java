import org.junit.*;
import java.io.*;
import java.util.logging.*;

public class MainTest {

    @Test
    public void Log() {
        Logger log;
        try (FileInputStream ins = new FileInputStream("log/logging.properties")) {
            LogManager.getLogManager().readConfiguration(ins);
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
                "src/test/resources/notFound.txt"
        };
        Main.main(args2);

    }

    @Test
    public void testCircle() {

        // valide file
        String[] args = new String[]{
                "src/test/resources/testCircleValid.txt",
                "src/test/resources/testCircleOut.txt"
        };
        Main.main(args);

        // not valide file
        String[] args1 = new String[]{
                "src/test/resources/testCircleNotValid.txt",
                "src/test/resources/testCircleOut.txt"
        };
        Main.main(args1);

        // not valide console
        String[] args2 = new String[]{
                "src/test/resources/testCircleNotValid.txt"
        };
        Main.main(args2);

        // valide console
        String[] args3 = new String[]{
                "src/test/resources/testCircleValid.txt"
        };
        Main.main(args3);

    }

    @Test
    public void testRectangle() {

        // valide file
        String[] args = new String[]{
                "src/test/resources/testRectangleValid.txt",
                "src/test/resources/testRectangleOut.txt"
        };
        Main.main(args);

        // not valide file
        String[] args1 = new String[]{
                "src/test/resources/testRectangleNotValid.txt",
                "src/test/resources/testRectangleOut.txt"
        };
        Main.main(args1);

        // not valide console
        String[] args2 = new String[]{
                "src/test/resources/testRectangleNotValid.txt"
        };
        Main.main(args2);

        // valide console
        String[] args3 = new String[]{
                "src/test/resources/testRectangleValid.txt"
        };
        Main.main(args3);

    }

    @Test
    public void testTriangle() {

        // valide file
        String[] args = new String[]{
                "src/test/resources/testTriangleValid.txt",
                "src/test/resources/testTriangleOut.txt"
        };
        Main.main(args);

        // not valide file
        String[] args1 = new String[]{
                "src/test/resources/testTriangleNotValid.txt",
                "src/test/resources/testTriangleOut.txt"
        };
        Main.main(args1);

        // not valide console
        String[] args2 = new String[]{
                "src/test/resources/testTriangleNotValid.txt"
        };
        Main.main(args2);

        // valide console
        String[] args3 = new String[]{
                "src/test/resources/testTriangleValid.txt"
        };
        Main.main(args3);

    }

}