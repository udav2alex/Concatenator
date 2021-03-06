package ru.gressor.concatenator.hw1.moxy.presenter;

import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.gressor.concatenator.hw1.moxy.view.MoxyView;
import ru.gressor.concatenator.hw1.standard.model.Model;

@InjectViewState
public class MoxyPresenter extends MvpPresenter<MoxyView> {
    Model model;

    public MoxyPresenter() {
        model = new Model();
    }

    public String makeNewText(String oldText, String concatenatedPart) {
        return oldText + concatenatedPart;
    }

    public void setTextViewText(String text) {
        String newText = makeNewText(model.getText(), text);

        model.setText(newText);
        getViewState().setTextViewText(newText);
    }
}
