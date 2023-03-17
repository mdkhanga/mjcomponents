package com.mj.poker.components;

import com.mj.poker.api.Card;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class Poker {

    CardComparator cardComparator = new CardComparator();

    public Poker() {}

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
                    hasAce = false;
                }
            } else {
                seqCount = 1;
            }
            if (seqCount == 4 && curr.getValue() == 13 && hasAce) {
                return true;
            }
            prev = curr;
        }

        return false ;
    }
}
