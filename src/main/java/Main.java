import exception.FileNotValidException;
import figures.*;

import java.io.*;
import java.util.logging.*;

public class Main {

    private static Logger log;

    static {
        try (FileInputStream ins = new FileInputStream("log/logging.properties")) {
            LogManager.getLogManager().readConfiguration(ins);
            log = Logger.getLogger(Main.class.getName());
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            log.info("start program");
            runCommand(args);
        } catch (IOException e) {
            log.log(Level.INFO, e.getMessage(), e);
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        } finally {
            log.info("end program");
        }
    }

    private static void runCommand(String[] args) throws IOException, FileNotValidException {
        int countArgs = args.length;
        switch (countArgs) {
            case 0:
                help();
                break;
            case 1:
                if (args[0].equals("--help")) {
                    help();
                } else {
                    outputFigure(args, false);
                }
                break;
            case 2:
                outputFigure(args, true);
                break;
        }
    }

    private static Figure createFigure(String[] content) throws FileNotValidException {
        String[] params;
        String errText = "Ошибка при чтении параметров файла";
        try {
            String type = content[0];
            switch (type) {
                case "CIRCLE":
                    double radius = Double.parseDouble(content[1]);
                    return new Circle(radius);
                case "RECTANGLE":
                    params = content[1].split(" ");
                    double sides1 = Double.parseDouble(params[0]);
                    double sides2 = Double.parseDouble(params[1]);
                    return new Rectangle(sides1, sides2);
                case "TRIANGLE":
                    params = content[1].split(" ");
                    double a = Double.parseDouble(params[0]);
                    double b = Double.parseDouble(params[1]);
                    double c = Double.parseDouble(params[2]);
                    return new Triangle(a, b, c);
                default:
                    throw new FileNotValidException("Не найден введенный код(тип) фигуры");
            }
        } catch (FileNotValidException e) {
            throw new FileNotValidException(e.getMessage());
        } catch (Exception e) {
            throw new FileNotValidException(errText);
        }
    }

    private static void outputFigure(String[] args, boolean printFile) throws FileNotValidException, IOException {

        String[] content = parseFile(args[0]);
        Figure figure = createFigure(content);

        if (printFile) {
            printFile(figure.toString(), args[1]);
        } else {
            printConsole(figure.toString());
        }

    }

    private static String[] parseFile(String path) throws IOException {
        int ch;
        StringBuilder sb = new StringBuilder("");
        try (FileReader reader = new FileReader(path)) {
            while ((ch = reader.read()) != -1) {
                sb.append(((char) ch));
            }
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
        return sb.toString().split("\n");
    }

    private static void printFile(String text, String path) {
        try (FileWriter writer = new FileWriter(path, false)) {
            writer.write(text);
            writer.flush();
        } catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    private static void printConsole(String text) {
        System.out.println(text);
    }

    private static void help() {
        System.out.println("Для вывода в консоль введите: <путь файла для чтения>\n" +
                "Для вывода в файл введите: <путь файла для чтения> <путь файла для записи>\n" +
                "Для для повторного вывода справки введите: <--help>\n");
    }

}
