package ru.gressor.concatenator.hw2.rx_example;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import ru.gressor.concatenator.R;

public class RxActivity extends AppCompatActivity {
    private static final String TAG = "rx_example_activity";
    Observable<String> messenger;
    RxPresenter rxPresenter;
    Disposable disposable;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);

        textView = findViewById(R.id.text_view_rx);

        rxPresenter = new RxPresenter();
        messenger = rxPresenter.getMessenger();

        findViewById(R.id.button_rx_subscribe).setOnClickListener(view -> subscribe());
        findViewById(R.id.button_rx_unsubscribe).setOnClickListener(view -> unsubscribe());
    }

    private void subscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            return;
        }

        messenger.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(String s) {
                String string = s + "\n" + textView.getText().toString();
                textView.setText(string);
                Log.d(TAG, Thread.currentThread().getName() + " : onNext : " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, Thread.currentThread().getName() + " : onError : " + e);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, Thread.currentThread().getName() + " : onComplete");
            }
        });
        Log.d(TAG, Thread.currentThread().getName() + " : <<subscribe end>>");
    }

    private void unsubscribe() {
        disposable.dispose();
        Log.d(TAG, Thread.currentThread().getName() + " : <<unsubscribe end>>");
    }
}
