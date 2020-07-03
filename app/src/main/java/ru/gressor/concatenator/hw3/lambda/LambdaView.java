package ru.gressor.concatenator.hw3.lambda;

import moxy.MvpView;
import moxy.viewstate.strategy.SingleStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface LambdaView extends MvpView {
    @StateStrategyType(SingleStateStrategy.class)
    void setTextViewText(String text);
}
