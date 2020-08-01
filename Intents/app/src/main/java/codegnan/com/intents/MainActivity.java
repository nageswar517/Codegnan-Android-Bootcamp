package codegnan.com.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.texts);
    }

    public void nextActivity(View view)
    {
        String text = editText.getText().toString();
        Intent i = new Intent(this,SecondActivity.class);
        i.putExtra("KEY",text);
        startActivity(i);
    }
}