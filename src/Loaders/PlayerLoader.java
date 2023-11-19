package Loaders;

import Enums.BetSide;
import Enums.PlayerOperation;
import Models.Match;
import Models.Player;
import Models.BetData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PlayerLoader implements BaseLoader {

    final HashMap<String, Match> matchList;
    public HashMap<String, Player> playerHashMap = new HashMap<String, Player>();
    public HashMap<String, BetData> illegalOperations = new HashMap<String, BetData>();
    public float casinoBalance;
    public PlayerLoader(HashMap<String, Match> matchList){
        this.matchList = matchList;
    }
    @Override
    public void load() throws FileNotFoundException {

        File file = new File("player_data.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()){
            BetData betData = new BetData(Arrays.asList(scanner.nextLine().split(",")));
            Player player;
            if( !playerHashMap.containsKey(betData.playerId) &&
                    betData.operation == PlayerOperation.DEPOSIT ){
                player = new Player();
                player.id = betData.playerId;
                playerHashMap.put(betData.playerId, player);
            } else if(playerHashMap.containsKey(betData.playerId)) {
                player = playerHashMap.get(betData.playerId);
            } else {
                illegalOperations.put(betData.playerId, betData);
                continue;
            }

            if(betData.operation == PlayerOperation.DEPOSIT){
                player.coins += betData.coins;
            } else{
                if(betData.coins > player.coins){
                    illegalOperations.put(betData.playerId, betData);
                    continue;
                }
                if(betData.operation == PlayerOperation.WITHDRAW){
                    player.coins -= betData.coins;
                }
                else if(betData.operation == PlayerOperation.BET){
                    Match playedMatch = matchList.get(betData.matchId);
                    if(playedMatch.winSide == BetSide.DRAW) continue;

                    boolean isWinningSide = playedMatch.winSide == betData.side;
                    player.matches++;
                    if(isWinningSide){
                        float coef = betData.side == BetSide.A ? playedMatch.sideACoef : playedMatch.sideBCoef;
                        float winSum = betData.coins * coef;
                        casinoBalance -= winSum;

                        player.coins += winSum;
                        player.wonMatches++;
                    } else {
                        player.coins -= betData.coins;
                        casinoBalance += betData.coins;
                    }


                }
            }
        }
        System.out.println(playerHashMap);
        System.out.println(illegalOperations);
        System.out.println(casinoBalance);


    }


}
