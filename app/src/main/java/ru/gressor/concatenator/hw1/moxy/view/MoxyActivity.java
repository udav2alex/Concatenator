package ru.gressor.concatenator.hw1.moxy.view;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.gressor.concatenator.R;
import ru.gressor.concatenator.hw1.moxy.presenter.MoxyPresenter;

public class MoxyActivity extends MvpAppCompatActivity implements MoxyView {
    EditText editText;
    TextView textView;

    @InjectPresenter
    MoxyPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);

        findViewById(R.id.button).setOnClickListener((v)->processEditText());
    }

    private void processEditText() {
        presenter.setTextViewText(editText.getText().toString());
        editText.setText("");
    }

    @Override
    public void setTextViewText(String text) {
        textView.setText(text);
    }
}
