package ru.gressor.concatenator.hw3.lambda;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class LambdaPresenter extends MvpPresenter<LambdaView> {
    private static final String TAG = "LambdaPresenter";

    private LambdaModel model;
    private Disposable disposable;
    private Observable<String> messenger;

    private int counter = 1;

    public LambdaPresenter() {
        this.model = new LambdaModel();

        messenger = Observable.create((ObservableOnSubscribe<String>) emitter -> {
            try {
                while (!emitter.isDisposed()) {
                    TimeUnit.SECONDS.sleep(1);
                    String message = "Message " + counter++;
                    Log.d(TAG, Thread.currentThread().getName() + " : " + message);
                    emitter.onNext(message);
                }
                emitter.onComplete();
                Log.d(TAG, Thread.currentThread().getName() + "onComplete");

            } catch (InterruptedException e) {
                Log.d(TAG, Thread.currentThread().getName() + "Interrupted : " + e);
            }
        }).subscribeOn(Schedulers.io());
    }

    public void subscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            return;
        }

        disposable = messenger.observeOn(AndroidSchedulers.mainThread()).subscribe(
                this::setTextViewText,
                Throwable::printStackTrace
        );
    }

    public void unsubscribe() {
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public void setTextViewText(String text) {
        String string = text + "\n" + model.getText();

        model.setText(string);
        getViewState().setTextViewText(string);
    }
}
