package codegnan.com.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int[] images;
    private String[] movies,actors;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        recyclerView = findViewById(R.id.recyclerview);
        RvAdapter rva = new RvAdapter(this);
        recyclerView.setAdapter(rva);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        images = new int[]{R.drawable.athidi, R.drawable.billa,R.drawable.co_kancharapalem,
        R.drawable.darling,R.drawable.eega,R.drawable.fallen,R.drawable.gabbarsingh,
        R.drawable.hackers,R.drawable.ironman,R.drawable.jersey};

        movies = new String[]{"Athidi","Billa","C/o Kancharapalem","Darling","Eega","Fallen",
        "Gabbarsingh","Hackers","Ironman","Jerysey"};

        actors = new String[]{"Mahesh Babu","Prabhas","Karthik","Prabhas",
        "Nani","Addison Timlin","Pawan Kalyan","Jonny Lee Miller","Robert Downey, Jr","Nani"};
    }

    class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvViewHolder>
    {
        Context context;

        public RvAdapter(Context context)
        {
            this.context = context;
        }

        // This method will attach the layout design to all the
        // entries in the recyclerview
        @NonNull
        @Override
        public RvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(context)
                    .inflate(R.layout.one_row_design,parent,false);
            return new RvViewHolder(v);
        }

        // this method will actually populate the data in the right p;
        //place
        @Override
        public void onBindViewHolder(@NonNull RvViewHolder holder, int position) {
            holder.poster.setImageResource(images[position]);
            holder.mn.setText(movies[position]);
            holder.an.setText(actors[position]);
        }

        //returns the total number of recyclerview elements
        @Override
        public int getItemCount() {
            return images.length;
        }

        public class RvViewHolder extends RecyclerView.ViewHolder {
            TextView mn,an;
            ImageView poster;
            public RvViewHolder(@NonNull View itemView) {
                super(itemView);
                mn = itemView.findViewById(R.id.movie_name);
                an = itemView.findViewById(R.id.actor_name);
                poster = itemView.findViewById(R.id.movie_posters);
            }
        }
    }
}