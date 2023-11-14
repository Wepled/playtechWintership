package Models;

import Enums.BetSide;

import java.util.Arrays;
import java.util.List;

public class Match {

    public String id;
    public float sideACoef;
    public float sideBCoef;
    public BetSide winSide;

    public Match(String fromFileString){
        List<String> elephantList = Arrays.asList(fromFileString.split(","));
        this.id = elephantList.get(0);
        this.sideACoef = Float.parseFloat(elephantList.get(1));
        this.sideBCoef = Float.parseFloat(elephantList.get(2));
        this.winSide = BetSide.valueOf(elephantList.get(3));
    }

}
