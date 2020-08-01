package codegnan.com.optionsmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // We will Attach the menu file to this activity using this method
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // This method will be invoked when an item is selected from the menu
        int id = item.getItemId();
        switch (id){
            case R.id.first:
                //Do some action
                Toast.makeText(this, "First", Toast.LENGTH_SHORT).show();
                break;
            case R.id.second:
                //do some Action
                Toast.makeText(this, "Second", Toast.LENGTH_SHORT).show();
                break;
            case R.id.third:
                // Do Some Action
                showAlertDialog();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAlertDialog() {
        //showing an alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("SAMPLE ALERT");
        builder.setIcon(R.drawable.smiley);
        builder.setMessage("This is a Sample Message");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("No",null);
        builder.setNeutralButton("Cancel",null);
        builder.show();
    }

    @Override
    public void onBackPressed() {
        /*super.onBackPressed();*/
        showAlertDialog();
    }
}