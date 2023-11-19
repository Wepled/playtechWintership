package Services;

import Enums.PlayerOperation;
import Loaders.PlayerLoader;
import Models.BetData;
import Models.Player;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class GameService {

    public PlayerLoader pl;
    public GameService(PlayerLoader pl){
        this.pl = pl;
    }
    private File loadFile(){
        try {
            File myObj = new File("result.txt");
            myObj.createNewFile();
            return myObj;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

    public void writeFile(){
        try {
            FileWriter fileWriter = new FileWriter(loadFile());
            BufferedWriter out = new BufferedWriter(fileWriter);

            for (Map.Entry<String, Player> entry : pl.playerHashMap.entrySet()) {
                Player value = entry.getValue();
                out.write(String.valueOf(value));
                out.newLine();
            }
            out.newLine();
            for (Map.Entry<String, BetData> entry : pl.illegalOperations.entrySet()) {
                BetData value = entry.getValue();
                out.write(String.valueOf(value));
                out.newLine();
            }
            out.newLine();

            out.write(Float.toString(pl.casinoBalance));

            out.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
