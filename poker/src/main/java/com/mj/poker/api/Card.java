package com.mj.poker.api;

/**
 * Card has a value and a type
 * which can be CLUBS DIAMONDS HEARTS SPADES
 *
 */
public class Card {
    private int value;
    private CardType type;

    public Card(int v, CardType c) {
        value = v;
        type = c;
    }

    public int getValue() {
        return value;
    }

    public CardType getType() {
        return type;
    }
}
