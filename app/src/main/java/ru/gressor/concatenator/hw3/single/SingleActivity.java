package ru.gressor.concatenator.hw3.single;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.gressor.concatenator.R;

public class SingleActivity extends MvpAppCompatActivity implements SingleView {
    @BindView(R.id.single_text_view)
    TextView textView;

    @InjectPresenter
    SinglePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.single_button_subscribe)
    public void subscribe() {
        presenter.subscribe();
    }

    @Override
    public void setTextViewText(String string) {
        textView.setText(string);
    }
}
