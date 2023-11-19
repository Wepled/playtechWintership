package Models;

import Enums.BetSide;
import Enums.PlayerOperation;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Player {

    public String id;
    public float coins = 0f;
    public int matches = 0;
    public int wonMatches = 0;

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.CEILING);
        double a = (double) wonMatches / matches;
        String[] arr = new String[]{
                id,
                Float.toString(coins),
                df.format(a * 100)
        };

        return String.join(" ", arr);
    }
}
