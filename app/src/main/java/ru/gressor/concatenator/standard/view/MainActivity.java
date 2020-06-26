package ru.gressor.concatenator.standard.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import ru.gressor.concatenator.R;
import ru.gressor.concatenator.standard.presenter.Presenter;

public class MainActivity extends AppCompatActivity implements MainView {
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
    }


}