package ru.gressor.concatenator.hw3.lambda;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.gressor.concatenator.R;

public class LambdaActivity extends MvpAppCompatActivity implements LambdaView {
    @InjectPresenter
    LambdaPresenter presenter;

    @BindView(R.id.lambda_text_view)
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lambda);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.lambda_button_subscribe)
    public void subscribe(View view) {
        presenter.subscribe();
    }

    @OnClick(R.id.lambda_button_unsubscribe)
    public void unsubscribe(View view) {
        presenter.unsubscribe();
    }

    @Override
    public void setTextViewText(String text) {
        textView.setText(text);
    }
}
