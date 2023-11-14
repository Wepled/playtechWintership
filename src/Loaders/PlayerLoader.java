package Loaders;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PlayerLoader implements BaseLoader {

    @Override
    public void load() throws FileNotFoundException {

        File file = new File("Players.txt");
        Scanner scanner = new Scanner(file);


    }


}
