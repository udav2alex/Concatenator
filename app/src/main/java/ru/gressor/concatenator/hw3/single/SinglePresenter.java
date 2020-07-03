package ru.gressor.concatenator.hw3.single;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class SinglePresenter extends MvpPresenter<SingleView> {
    private static final String TAG = "SinglePresenter";

    private SingleModel model;
    private Single<String> single;
    private Disposable disposable;

    private int counter = 1;

    public SinglePresenter() {
        model = new SingleModel();
        single = Single.create((SingleOnSubscribe<String>) emitter -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                String string = "Message " + counter++;
                emitter.onSuccess(string);
                Log.d(TAG, string);
            } catch (InterruptedException e) {
                Log.d(TAG, "InterruptedException : " + e);
            }
        }).subscribeOn(Schedulers.io());
    }

    public void subscribe() {
        disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(
                this::processMessage,
                Throwable::printStackTrace
        );
    }

    public void processMessage(String string) {
        String viewContent = string + "\n" + model.getText();
        model.setText(viewContent);
        getViewState().setTextViewText(viewContent);
    }
}
