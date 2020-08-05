package codegnan.com.coronaupdates;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.corona);
        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.covid19api.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        CoronaInterface ci = retrofit.create(CoronaInterface.class);
        ci.getData().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                /*tv.setText(response.body());*/
                tv.setText("DATE    CONFIRMED CASES\n");
                try {
                    JSONArray array = new JSONArray(response.body());
                    for(int i=array.length()-1; i>=0 ;i--){
                        JSONObject obj = array.getJSONObject(i);
                        int confirmed = obj.getInt("Confirmed");
                        String date = obj.getString("Date");
                        tv.append(date.substring(0,10)+"  "+confirmed+"\n");
                    }
                    progressBar.setVisibility(View.GONE);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                Log.i("TAG", "onFailure: "+t.getMessage());
            }
        });
    }
}