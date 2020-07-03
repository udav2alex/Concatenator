package ru.gressor.concatenator.hw1.moxy.view;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface MoxyView  extends MvpView {
    @StateStrategyType(value = AddToEndSingleStrategy.class)
    void setTextViewText(String text);
}
