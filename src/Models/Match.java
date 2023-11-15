package Models;

import Enums.BetSide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Match {

    public String id;
    public float sideACoef;
    public float sideBCoef;
    public BetSide winSide;

    public Match(List<String> matchFromScanner){
        this.id = matchFromScanner.get(0);
        this.sideACoef = Float.parseFloat(matchFromScanner.get(1));
        this.sideBCoef = Float.parseFloat(matchFromScanner.get(2));
        this.winSide = BetSide.valueOf(matchFromScanner.get(3));
    }

}
