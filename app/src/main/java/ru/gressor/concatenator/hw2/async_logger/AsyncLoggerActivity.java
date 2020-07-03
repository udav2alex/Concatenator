package ru.gressor.concatenator.hw2.async_logger;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.gressor.concatenator.R;

public class AsyncLoggerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_logger);

        findViewById(R.id.button).setOnClickListener((view -> startAsyncLogger()));
    }

    private void startAsyncLogger() {
        AsyncLogger asyncLogger = new AsyncLogger();
        asyncLogger.execute();
        Log.d(AsyncLogger.ASYNC_LOGGER, Thread.currentThread().getName() + " : end of startAsyncLogger()");
    }
}
