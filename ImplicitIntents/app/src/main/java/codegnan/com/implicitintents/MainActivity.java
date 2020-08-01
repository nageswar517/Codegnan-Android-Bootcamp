package codegnan.com.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText url,address;
    private Button btn,maps_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = findViewById(R.id.editTextTextPersonName);
        btn = findViewById(R.id.button);

        address = findViewById(R.id.editTextTextPersonName2);
        maps_btn = findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openURL();
            }
        });

        maps_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMaps();
            }
        });
    }

    private void openMaps() {
        Intent i = new Intent();
        // action type
        i.setAction(Intent.ACTION_VIEW);
        // data
        String add = address.getText().toString();
        i.setData(Uri.parse("geo:0,0?q="+add));
        startActivity(i);
    }

    private void openURL() {
        Intent i = new Intent();
        // Action type
        i.setAction(Intent.ACTION_VIEW);
        // Data
            // step 1: get DAta
        String link = url.getText().toString();
        i.setData(Uri.parse("https://"+link));
        //start the activity
        startActivity(i);
    }
}