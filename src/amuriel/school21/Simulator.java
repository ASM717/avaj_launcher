package amuriel.school21;


import java.io.IOException;

public class Simulator {
    private final WeatherTower weatherTower = new WeatherTower();
    private final Logger logger = new Logger();

    public static void main(String[] args) throws ErrorException {

        try {
            if (args.length != 1) {
                System.err.println("ERROR: Enter single argument - scenario.txt");
                System.exit(-1);
            }

            ParserFile parserFile = new ParserFile();
            parserFile.parseScenario(args[0]);

        } catch (ErrorException | IOException | NumberFormatException e) {
//            throw new ErrorException("EXCEPTION: " + e.getMessage());
            System.out.println("EXCEPTION: " + e.getMessage());
        } //finally {
//            Logger.closeFile();
//        }

    }
}
