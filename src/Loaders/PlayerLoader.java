package Loaders;

import Models.Match;
import Models.Player;
import Models.BetData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PlayerLoader implements BaseLoader {

    final HashMap<String, Match> matchList;
    final HashMap<String, Player> playerHashMap = new HashMap<String, Player>();
    public PlayerLoader(HashMap<String, Match> matchList){
        this.matchList = matchList;
    }
    @Override
    public void load() throws FileNotFoundException {

        File file = new File("player_data.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()){
            BetData playerActionFromScanner = new BetData(Arrays.asList(scanner.nextLine().split(",")));
        }

    }


}
