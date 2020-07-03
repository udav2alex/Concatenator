package ru.gressor.concatenator.hw2.rx_example;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class RxPresenter {
    private static final String TAG = "rx_example_presenter";
    private int counter;

    public Observable<String> getMessenger() {

        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                try {
                    while (!emitter.isDisposed()) {
                        TimeUnit.SECONDS.sleep(1);
                        String message = "Message " + counter++;
                        Log.d(TAG, Thread.currentThread().getName() + " : " + message);
                        emitter.onNext(message);
                    }

                    emitter.onComplete();
                    Log.d(TAG, Thread.currentThread().getName() + " : emitter.onComplete()");

                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
            }
        }).subscribeOn(Schedulers.io());
    }
}
