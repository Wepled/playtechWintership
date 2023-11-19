import Loaders.MatchLoader;
import Loaders.PlayerLoader;
import Services.GameService;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Hello and welcome!");
        System.out.print("Run program)");
        MatchLoader ml = new MatchLoader();
        ml.load();
        PlayerLoader pl = new PlayerLoader(ml.matches);
        pl.load();
        GameService gs = new GameService(pl);
        gs.writeFile();
    }
}
