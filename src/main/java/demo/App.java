/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;

import coinsimulator.ClockFace;
import coinsimulator.Coin;
import static coinsimulator.ClockFace.getRandomCoin;
import static coinsimulator.ClockFace.isClockFull;
import static coinsimulator.ClockFace.placeCoinOnClock;

public class App {

    public static void main(String[] args)
    {
        //starts at 1pm
        int current = 1;
        int times = 0;
        boolean isFull = false;

        while(!isFull && times++ < 100 )
        {
            Coin coin = getRandomCoin();
            placeCoinOnClock(current, coin);
            isFull = isClockFull();
            System.out.println("isFull? " + isFull);
            current = (current + coin.getValue()) > 12 ?
                    (current + coin.getValue()) % 12 : (current + coin.getValue());
            System.out.println("Times: " + times);

        }





    }
}