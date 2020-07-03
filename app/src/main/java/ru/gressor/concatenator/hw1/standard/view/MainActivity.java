package ru.gressor.concatenator.hw1.standard.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import ru.gressor.concatenator.R;
import ru.gressor.concatenator.hw1.standard.presenter.Presenter;

public class MainActivity extends AppCompatActivity implements MainView {
    Presenter presenter;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);

        presenter = new Presenter(this);
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