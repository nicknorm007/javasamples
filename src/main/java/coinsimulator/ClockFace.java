package coinsimulator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;

public class ClockFace {

    private static int NUMBER_OF_SLOTS = 12;
    private static Map<Integer, Coin> clockMap = new HashMap<Integer, Coin>();
    private static Map<Integer, Coin> coinMap = new HashMap<Integer, Coin>();

    static {
        Map<Integer, Coin> aMap = new HashMap<Integer, Coin>();
        aMap.put(1, Coin.PENNY);
        aMap.put(2, Coin.NICKEL);
        aMap.put(3, Coin.DIME);
        coinMap = Collections.unmodifiableMap(aMap);
    }

    private static Predicate<Integer> isEmptySlot = i -> (clockMap.get(i) == null);

    public static boolean isClockFull()
    {
        for(int i=1; i<=NUMBER_OF_SLOTS; i++)
        {
            if(isEmptySlot.test(i))
            {
                return false;
            }
        }

        return true;

    }

    public static void placeCoinOnClock(int current, Coin coin)
    {
        if(isEmptySlot.test(current))
        {
            clockMap.put(current, coin);
        }
        printClockMap();
    }

    public static void printClockMap()
    {

        for (Map.Entry<Integer, Coin> entry : clockMap.entrySet())
        {
            System.out.println("Slot = " + entry.getKey() +
                    ", Coin = " + entry.getValue());
        }

    }

    public static Coin getRandomCoin()
    {
        Random rn = new Random();
        int coin = rn.nextInt(3) + 1;

        return coinMap.get(coin);
    }



}
