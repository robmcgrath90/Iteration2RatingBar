package com.example.fyp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.fyp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ViewManagementComments extends AppCompatActivity {

    private Toolbar toolbar;
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_management_comments);



        //start of bottom nav
        // declaring the bottom nav https://stackoverflow.com/questions/40202294/set-selected-item-in-android-bottomnavigationview
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.btm_home);
        //bringing user to selected activity, reference https://suragch.medium.com/how-to-add-a-bottom-navigation-bar-in-android-958ed728ef6c
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.btm_home:
                        //activity already active
                        break;
                    case R.id.btm_dashboard:
                        Intent startCommunityIntent = new Intent(getApplicationContext(), CommunitySection.class);
                        startActivity(startCommunityIntent);
                        break;
                    case R.id.btm_maps:
                        Intent startClassIntent = new Intent(getApplicationContext(), ClassFinder.class);
                        startActivity(startClassIntent);
                        break;
                }
                return true;
            }
        });
        //end of bottom nav


        //toolbar
        toolbar=findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);


        //  reference for the rating bar https://www.youtube.com/watch?v=O5I9cSW31ho
        //creating a ratingbar variable linking it to the rating bar by the id
        // creating a button to submit the rating
        ratingBar = findViewById(R.id.ratingBar);
        final Button btnSubmit = (Button) findViewById(R.id.btnSubmitManStar1);

        //button that gets the rating and uses a toast to display it
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplicationContext(), s+"Star",
                        Toast.LENGTH_SHORT).show();
            }
        });



    }








    //using inflater to show the items in the menu (toolbar)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }



    //toolbar
    // tutorial 2 mobile
    //https://www.youtube.com/watch?v=Pmsd2x-Bksk
    //using intents to to allow items in the menu to complete a task
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())

        {
            case R.id.delete:
                finish();
                Toast.makeText(this, "Delete function pressed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dropdown1:
                Intent startIntent1 = new Intent(getApplicationContext(), Jobs.class);
                startActivity(startIntent1);
                Toast.makeText(this, "dropdown1 function pressed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btm_home:
                Intent startIntent3 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent3);
                Toast.makeText(this, "dropdown2 function pressed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btm_maps:
                Intent startIntent4 = new Intent(getApplicationContext(), ClassFinder.class);
                startActivity(startIntent4);
                Toast.makeText(this, "dropdown2 function pressed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btm_dashboard:
                Intent startIntent5 = new Intent(getApplicationContext(), CommunitySection.class);
                startActivity(startIntent5);
                Toast.makeText(this, "dropdown2 function pressed", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}