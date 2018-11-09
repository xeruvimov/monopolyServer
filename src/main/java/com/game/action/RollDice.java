package com.game.action;

import java.util.Random;

public class RollDice {
    private static final Random rnd = new Random();
    private long userId;
    /**
     * Bound of 0 to 35
     */
    private int place;
    private int diceOne;
    private int diceTwo;
    private boolean isDual;

    public long getUserId() {
        return userId;
    }

    public int getPlace() {
        return place;
    }

    public int getDiceOne() {
        return diceOne;
    }

    public int getDiceTwo() {
        return diceTwo;
    }

    public boolean getIsDual() {
        return isDual;
    }

    public void rollDice() {
        this.diceOne = rnd.nextInt(6) + 1;
        this.diceTwo = rnd.nextInt(6) + 1;
        isDual();
        moveOnNumber(this.diceOne + this.diceTwo);
    }

    private void isDual() {
        this.isDual = this.diceOne == this.diceTwo;
    }

    private void moveOnNumber(Integer number) {
        if (this.place + number > 35) {
            this.place = this.place + number - 36;
        } else {
            this.place += number;
        }
    }
}
