package ru.gressor.concatenator.hw2.async_logger;

import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class AsyncLogger extends AsyncTask<Void, Void, Void> {
    public static final String ASYNC_LOGGER = "async_logger";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(ASYNC_LOGGER, Thread.currentThread().getName() + " : end of onPreExecute()");
    }

    @Override
    protected Void doInBackground(Void... voids) {
        for (int i = 1; i <= 5; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
                Log.d(ASYNC_LOGGER, Thread.currentThread().getName() + " : " + i + " sec.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d(ASYNC_LOGGER, Thread.currentThread().getName() + " : end of onPostExecute()");
    }
}
