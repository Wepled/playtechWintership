package Loaders;

import Models.Match;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MatchLoader implements BaseLoader {

    public ArrayList<Match> matches = new ArrayList<Match>();
    @Override
    public void load() throws FileNotFoundException {

        File file = new File("match_data.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            matches.add(new Match(scanner.nextLine()));
        }
        scanner.close();

    }
}
