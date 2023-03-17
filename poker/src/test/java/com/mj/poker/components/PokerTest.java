package com.mj.poker.components;

import com.mj.poker.api.Card;
import com.mj.poker.api.CardType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokerTest {

    Poker poker = new Poker();

    @Test
    public void testValidStart() {
        List<Card> hand = Arrays.asList(new Card(2, CardType.CLUBS),
                                        new Card(3, CardType.DIAMONDS),
                                        new Card(4, CardType.HEARTS),
                                        new Card(8, CardType.DIAMONDS),
                                        new Card(5, CardType.SPADES),
                                        new Card(6, CardType.CLUBS),
                                        new Card(11, CardType.CLUBS));

        assertTrue(poker.isStraight(hand));
    }

    @Test
    public void testValidStartDesc() {
        List<Card> hand = Arrays.asList(new Card(2, CardType.CLUBS),
                new Card(8, CardType.DIAMONDS),
                new Card(7, CardType.HEARTS),
                new Card(6, CardType.SPADES),
                new Card(5, CardType.CLUBS),
                new Card(4, CardType.DIAMONDS),
                new Card(11, CardType.CLUBS));

        assertTrue(poker.isStraight(hand));
    }

    @Test
    public void testOnly4InSeq() {
        List<Card> hand = Arrays.asList(
                new Card(2, CardType.CLUBS),
                new Card(3, CardType.DIAMONDS),
                new Card(4, CardType.HEARTS),
                new Card(8, CardType.DIAMONDS),
                new Card(5, CardType.SPADES),
                new Card(9, CardType.CLUBS),
                new Card(11, CardType.CLUBS));

        assertFalse(poker.isStraight(hand));
    }

    @Test
    public void testAceAsOne() {
        List<Card> hand = Arrays.asList(
                new Card(2, CardType.CLUBS),
                new Card(3, CardType.DIAMONDS),
                new Card(4, CardType.HEARTS),
                new Card(8, CardType.DIAMONDS),
                new Card(5, CardType.SPADES),
                new Card(9, CardType.CLUBS),
                new Card(1, CardType.CLUBS));

        assertTrue(poker.isStraight(hand));
    }

    @Test
    public void testAceAs14() {
        List<Card> hand = Arrays.asList(
                new Card(12, CardType.CLUBS),
                new Card(1, CardType.DIAMONDS),
                new Card(13, CardType.HEARTS),
                new Card(10, CardType.DIAMONDS),
                new Card(11, CardType.SPADES),
                new Card(6, CardType.CLUBS),
                new Card(4, CardType.CLUBS));

        assertTrue(poker.isStraight(hand));
    }

    @Test
    public void testWrap13and2() {
        List<Card> hand = Arrays.asList(
                new Card(12, CardType.CLUBS),
                new Card(2, CardType.DIAMONDS),
                new Card(13, CardType.HEARTS),
                new Card(10, CardType.DIAMONDS),
                new Card(11, CardType.SPADES),
                new Card(6, CardType.CLUBS),
                new Card(4, CardType.CLUBS));

        assertFalse(poker.isStraight(hand));
    }

    @Test
    public void EmptyHand() {
        assertFalse(poker.isStraight(null));
        assertFalse(poker.isStraight(new ArrayList<>()));
    }

    @Test
    public void testLessthan7cards() {
        List<Card> hand = Arrays.asList(
                new Card(2, CardType.CLUBS),
                new Card(1, CardType.DIAMONDS),
                new Card(3, CardType.SPADES),
                new Card(5, CardType.CLUBS),
                new Card(4, CardType.CLUBS));

        assertFalse(poker.isStraight(hand));
    }
}