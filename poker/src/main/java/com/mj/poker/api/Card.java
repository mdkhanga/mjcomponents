package com.mj.poker.api;

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
