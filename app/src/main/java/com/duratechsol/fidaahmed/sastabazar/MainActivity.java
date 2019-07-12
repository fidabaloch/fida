package com.duratechsol.fidaahmed.sastabazar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    ViewFlipper vfSlider;
    // variables for expandable list view
    private ExpandableAdapter expandableAdapter;
    private ExpandableListView expList;
    private String[] parents = new String[]{"Action Movies", "Romantic Movies","Comedy Movies",};
    private ArrayList<String> Action_Movies, Romantic_Movies, Comedy_Movies;
    public static ArrayList<ArrayList<String>> childList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int image[]= {R.drawable.img1, R.drawable.img3, R.drawable.img2};
        vfSlider = findViewById(R.id.vfSlider);
        getImages();
        for (int img:image){
            Slider(img);
        }

        // code for expandable list view
        expList = (ExpandableListView) findViewById(R.id.exp_list);

        setChildMovies();

        expandableAdapter = new ExpandableAdapter(this, childList, parents);
        expList.setAdapter(expandableAdapter);

    }
    public void Slider (int image){
        ImageView iv = new ImageView( this);
        iv.setBackgroundResource(image);
        vfSlider.addView(iv);
        vfSlider.setFlipInterval(3000); // interveal is Img3 seconds
        vfSlider.setAutoStart(true);
        // animation
        vfSlider.setInAnimation(this,android.R.anim.slide_in_left);
        vfSlider.setOutAnimation(this,android.R.anim.slide_out_right);
    }
    private void getImages (){
        Log.d(TAG,"getImages: preparing bitmaps ");
        mImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mNames.add("Havasu Falls");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Trondheim");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Portugal");

        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("Rocky Mountain National Park");


        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("Mahahual");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add("Frozen Lake");


        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("White Sands Desert");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames.add("Washington");
        initRecyclerView();
    }
    private void initRecyclerView(){
        Log.d(TAG,"initRecyclerView: init recyclerview");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,mNames,mImageUrls);
        recyclerView.setAdapter(adapter);
    }

    // code for expandable list view

    private void setChildMovies(){

        Action_Movies = new ArrayList<>();
        Romantic_Movies = new ArrayList<>();
        Comedy_Movies = new ArrayList<>();

        Action_Movies.add("Dark Knight");
        Action_Movies.add("Transporter");
        Action_Movies.add("Iron Man");

        Romantic_Movies.add("Twilight");
        Romantic_Movies.add("Titanic");
        Romantic_Movies.add("The House Bunny");

        Comedy_Movies.add("We are the millers");
        Comedy_Movies.add("Hang over");
        Comedy_Movies.add("Last Night");

        childList = new ArrayList<>();

        childList.add(Action_Movies);
        childList.add(Romantic_Movies);
        childList.add(Comedy_Movies);


    }
}