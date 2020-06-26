package ru.gressor.concatenator.standard.presenter;

import ru.gressor.concatenator.standard.model.Model;
import ru.gressor.concatenator.standard.view.MainView;

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
