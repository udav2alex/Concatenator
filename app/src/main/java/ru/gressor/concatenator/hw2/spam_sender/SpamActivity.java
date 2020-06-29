package ru.gressor.concatenator.hw2.spam_sender;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.gressor.concatenator.R;

public class SpamActivity extends AppCompatActivity implements Observer {
    public static final String TAG = "SpamActivity";
    private Spammer spammer = new Spammer();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spam);

        findViewById(R.id.button_subscribe).setOnClickListener(view -> subscribeMe());
        findViewById(R.id.button_unsubscribe).setOnClickListener(view -> unsubscribeMe());
        findViewById(R.id.button_spam).setOnClickListener(view -> sendSpam());
    }

    @Override
    public void update(String message) {
        Log.d(TAG, message);
    }

    private void sendSpam() {
        spammer.sendSpam();
    }

    private void unsubscribeMe() {
        spammer.unregister(this);
    }

    private void subscribeMe() {
        spammer.register(this);
    }
}
