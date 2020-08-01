package codegnan.com.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Connecting the textview on activity_main.xml to the tv object (TextView) on
        // the MainActivity.java
        tv = findViewById(R.id.result);
        if(savedInstanceState!=null){
            count = savedInstanceState.getInt("KEY");
            tv.setText(String.valueOf(count));
        }
    }

    public void decrementScore(View view)
    {
        count--;
        tv.setText(String.valueOf(count));
    }

    public void incrementScore(View view)
    {
        count++;
        tv.setText(""+count);
    }

    // To save the values when the activity is getting destroyed

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("KEY",count);
    }
}