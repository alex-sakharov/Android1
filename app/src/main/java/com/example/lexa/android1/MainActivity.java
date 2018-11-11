package com.example.lexa.android1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.*;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView urlNameView = findViewById(R.id.url_name);
        urlNameView.setText(R.string.waiting_for_url);

        HandleIntent(getIntent());
    }

    @Override
    protected void onNewIntent (Intent intent) {
        super.onNewIntent(intent);
        HandleIntent(getIntent());
    }

    private void HandleIntent (Intent intent) {
        if (intent != null) {
            if (intent.getAction().equals(Intent.ACTION_VIEW)) {
                Uri uri = intent.getData();
                if (uri != null) {
                    ((TextView)findViewById(R.id.url_name)).setText(uri.toString());
                    ((WebView)findViewById(R.id.content_view)).loadUrl (uri.toString());
                }
            }
        }
    }
}
