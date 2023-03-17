package com.mj.poker.components;

import com.mj.poker.api.Card;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Business logic for Poker
 */
@Component
public class Poker {

    CardComparator cardComparator = new CardComparator();

    public Poker() {}

    /**
     * Given a hand of cards determine if the hand is straight or not
     *
     * @param hand A List of cards
     * @return true if the hand is straight and false if it is not
     */
    public boolean isStraight(List<Card> hand) {

        if (hand == null) {
            return false;
        }

        if (hand.size() < 7) {
            return false ;
        }

        Collections.sort(hand, cardComparator);

        boolean hasAce = false ;
        int seqCount = 1;
        Card prev = hand.get(0);
        hasAce = prev.getValue() == 1 ? true : false;
        for (int i = 1 ; i < 7 ; i++) {
            Card curr = hand.get(i);
            if (curr.getValue() == prev.getValue() + 1) {
                seqCount++;
                if (seqCount == 5) {
                    return true;
                }
                if (curr.getValue() == 1) {
                    // remember if there is an ACE. Needed for edge case below
                    hasAce = false;
                }
            } else {
                seqCount = 1;
            }
            // if we have a 4 count seq ending in King and we have an
            // Ace it can substitute as 14
            if (seqCount == 4 && curr.getValue() == 13 && hasAce) {
                return true;
            }
            prev = curr;
        }

        return false ;
    }
}
