import Loaders.MatchLoader;
import Loaders.PlayerLoader;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Hello and welcome!");
        MatchLoader ml = new MatchLoader();
        ml.load();
        PlayerLoader pl = new PlayerLoader(ml.matches);
        pl.load();
    }
}
