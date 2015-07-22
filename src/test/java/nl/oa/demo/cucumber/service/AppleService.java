package nl.oa.demo.cucumber.service;

import org.springframework.stereotype.Service;

public interface AppleService {

    boolean hasEnoughApples(int askedAmount);

    void addApples(int amountOfApples);

    int receiveApples(int amountApplesAsked);
}
