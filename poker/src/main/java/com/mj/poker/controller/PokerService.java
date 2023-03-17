package com.mj.poker.controller;

import com.mj.poker.api.Card;
import com.mj.poker.components.Poker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poker")
public class PokerService {

    @Autowired
    Poker pokerComponent;

    @GetMapping("/about")
    public String about() {
        return "Poker for Quicken";
    }

    @PostMapping("/isstraight")
    public boolean isStraight(@RequestBody List<Card> hand) {
        return pokerComponent.isStraight(hand);
    }
}
