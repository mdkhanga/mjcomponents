package com.mj.poker.components;

import com.mj.poker.api.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Business logic for Poker
 */
@Component
public class Poker {

    static Logger LOGGER = LoggerFactory.getLogger(Poker.class);

    CardComparator cardComparator = new CardComparator();

    public Poker() {}

    /**
     * Given a hand of cards determine if the hand is straight or not
     *
     * @param hand A List of cards
     * @return true if the hand is straight and false if it is not
     */
    public boolean isStraight(List<Card> hand) {

        if (!validateHand(hand)) {
            return false;
        }

        Collections.sort(hand, cardComparator);

        int seqCount = 1;
        Card prev = hand.get(0);
        boolean hasAce = prev.getValue() == 1 ? true : false;
        for (int i = 1 ; i < 7 ; i++) {
            Card curr = hand.get(i);
            if (curr.getValue() == prev.getValue() + 1) {
                seqCount++;
                if (seqCount == 5) {
                    return true;
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
        LOGGER.info("Hand does not have sequence returning false");
        return false ;
    }

    private boolean validateHand(List<Card> hand) {

        if (hand == null) {
            LOGGER.warn("Invalid null hand");
            return false;
        }

        if (hand.size() != 7) {
            LOGGER.warn("Invalid hand does not have 7 cards");
            return false;
        }

        for (Card c : hand) {
            if (c.getValue() < 1 || c.getValue() > 13) {
                LOGGER.warn("Invalid card " + c.getValue() + c.getType().name());
                return false;
            }
        }
        return true;
    }
}
