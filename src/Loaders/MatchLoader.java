package Loaders;

import Models.Match;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MatchLoader implements BaseLoader {

    public HashMap<String, Match> matches = new HashMap<String, Match>();
    @Override
    public void load() throws FileNotFoundException {

        File file = new File("match_data.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            List<String> matchFromScanner = Arrays.asList(scanner.nextLine().split(","));
            matches.put(matchFromScanner.get(0), new Match(matchFromScanner));
        }
        scanner.close();

    }
}
