package amuriel.school21;

import java.io.IOException;

public class Simulator {
    public static void main(String[] args) {
        try {
            ParseFile parseFile = new ParseFile();
            parseFile.parseScenario(args[0]);
            for (int i = 0; i < parseFile.getCntTotalSim(); ++i) {
                Logger.getLogger().logMessage("\t\t=== Simulation #" + (i + 1) + " ===");
                parseFile.getWeatherTower().changeWeather();
            }
            System.out.println("\t\tWe have run " + parseFile.getCntTotalSim() + " simulations.");
            System.out.println("Simulation results were logged to a simulation.txt file.");
            Logger.getLogger().logMessagesToFile();
        } catch (ErrorException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
