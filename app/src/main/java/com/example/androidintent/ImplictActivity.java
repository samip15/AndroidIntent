package com.example.androidintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class ImplictActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implict);
    }

    public void onClickOpenWebPage(View view) {
        String url = "https://google.com";
        openWebPage(url);

    }
    //function to open webpage

    private void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    public void onClickOpenADDRESSButton(View view) {
        String addressString = "Nagarjun";
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("geo").path("0,0").appendQueryParameter("q", addressString);
        Uri addressUri = builder.build();
        openMap(addressUri);

    }

    //function open map
    private void openMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW, geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void onClickShareTextButton(View view) {
        String shretext = "Hello! I am Samip and i am a developer ";
        openShareText(shretext);

    }

    public void openShareText(String shareText) {
        String mimeType = "text/plain";
        String title = "Learning To Share Intents";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(title)
                .setText(shareText)
                .startChooser();
    }
}