package ru.gressor.concatenator.hw3.single;

import moxy.MvpView;
import moxy.viewstate.strategy.SingleStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface SingleView extends MvpView {
    @StateStrategyType(SingleStateStrategy.class)
    void setTextViewText(String string);
}