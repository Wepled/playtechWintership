package Models;

import Enums.BetSide;
import Enums.PlayerOperation;

import java.util.List;

public class BetData {


    public BetData(List<String> fromScanner){
        this.playerId = fromScanner.get(0);
        this.operation = PlayerOperation.valueOf(fromScanner.get(1));
        this.matchId = fromScanner.get(2);
        this.coins = Integer.valueOf(fromScanner.get(3));
        this.side = fromScanner.size() > 4 ? BetSide.valueOf(fromScanner.get(4)) : null;
    }

    @Override
    public String toString() {

        String[] arr = new String[]{
            playerId,
            operation.toString(),
            !matchId.isEmpty() ? matchId : "null",
            Integer.toString(coins),
            side != null ? side.toString() : "null"
        };

        return String.join(" ", arr);
    }

    public String playerId;
    public PlayerOperation operation;
    public String matchId = null;
    public Integer coins;
    public BetSide side;
}
