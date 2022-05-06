package amuriel.school21;

import amuriel.school21.flyable.AircraftFactory;
import amuriel.school21.flyable.Flyable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ParserFile {
    private int cnt;
    private ArrayList<Flyable> flyables = new ArrayList<>();

    public void parseScenario(String fileName) throws IOException, ErrorException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line = bufferedReader.readLine();
        int lineCount = 1;

        if (line == null) {
            throw new ErrorException("EXCEPTION: Empty file");
        }

        if (line.length() > 0) {
            try {
                cnt = Integer.parseInt(line.trim());
                if (cnt <= 0)
                    throw new ErrorException("");
            } catch (ErrorException e) {
//                throw new ErrorException("ERROR: Wrong simulations count"
//                        + " or line provided");
            }
        }

        System.out.println(cnt);

        String[] arrLine;
        while (line != null) {
            line = bufferedReader.readLine();
            lineCount++;
            if (line == null || line.length() == 0)
                continue;
            arrLine = line.split(" ");
            if (arrLine.length == 0)
                continue;
            if (arrLine.length != 5)
                throw new ErrorException("EXCEPTION: Invalid line --- " + lineCount + " !");

            try {
                int[] cordWords = {
                        Integer.parseInt(arrLine[2]),
                        Integer.parseInt(arrLine[3]),
                        Integer.parseInt(arrLine[4])
                };

                System.out.println(Arrays.toString(arrLine));


                for (int cord : cordWords) {
                    if (cord < 1)
                        throw new ErrorException("EXCEPTION: Invalid line --- " + lineCount
                                + " Coordinates must be positive int number's!");
                }
                flyables.add(AircraftFactory.newAircraft(arrLine[0], arrLine[1],
                        cordWords[0],
                        cordWords[1],
                        cordWords[2]));
            } catch (NumberFormatException e) {
                throw new ErrorException("EXCEPTION: Invalid line --- " + lineCount +
                        " Coordinates must be 3 positive int number's with spaces");
            }
        }
        bufferedReader.close();
    }
}
