package com.theforest.apachecommonsexample.chain.stuff;

import static com.theforest.apachecommonsexample.chain.stuff.AtmConstants.NO_OF_TENS_DISPENSED;

public class TenDenominationDispenser  extends AbstractDenominationDispenser {
    @Override
    protected String getDenominationString() {
        return NO_OF_TENS_DISPENSED;
    }

    @Override
    protected int getDenominationValue() {
        return 10;
    }
}