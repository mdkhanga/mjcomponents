package com.mj.poker.components;

import com.mj.poker.api.Card;

import java.util.Comparator;

/**
 * For this service we need to compare only card values
 * which are numbers
 *
 */
public class CardComparator implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        return o1.getValue() - o2.getValue();
    }
}
