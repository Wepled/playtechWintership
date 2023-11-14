import Loaders.MatchLoader;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Hello and welcome!");
        MatchLoader ml = new MatchLoader();
        ml.load();

    }
}
