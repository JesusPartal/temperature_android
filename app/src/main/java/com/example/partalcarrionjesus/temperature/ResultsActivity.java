package com.example.partalcarrionjesus.temperature;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        final Intent receiveIntent = getIntent();
        final String message = receiveIntent.getStringExtra("message");
        Button bt_share = (Button)findViewById(R.id.bt_share);
        TextView tv_message = (TextView) findViewById(R.id.tv_message);
        tv_message.setText(message);

        // if the bt_share button is clicked
        bt_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create new intent to create email with the message
                Intent shareIntent = new Intent(Intent.ACTION_SENDTO);
                shareIntent.setData(Uri.parse("mailto:"));
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My conversion");
                shareIntent.putExtra(Intent.EXTRA_TEXT, message);

                if (shareIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(shareIntent);
                }
            }
        });
    }
}
