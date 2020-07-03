package ru.gressor.concatenator.hw1.standard.presenter;

import ru.gressor.concatenator.hw1.standard.model.Model;
import ru.gressor.concatenator.hw1.standard.view.MainView;

public class Presenter {
    MainView mainView;
    Model model;

    public Presenter(MainView mainView) {
        this.mainView = mainView;
        model = new Model();
    }

    public String makeNewText(String oldText, String concatenatedPart) {
        return oldText + concatenatedPart;
    }

    public void setTextViewText(String text) {
        String newText = makeNewText(model.getText(), text);

        model.setText(newText);
        mainView.setTextViewText(newText);
    }
}
