package com.example.fyp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


import android.app.DatePickerDialog;
import androidx.fragment.app.DialogFragment;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.Calendar;

//imports for time picker
import android.app.TimePickerDialog;
import android.widget.TimePicker;

import com.example.fyp.fragments.DatePickerFragment;
import com.example.fyp.R;
import com.example.fyp.fragments.TimePickerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class StudyBuddy extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

   //declaring variable toolbar typ Toolbar
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_buddy);


        //reference time picker https://codinginflow.com/tutorials/android/timepickerdialog
        //Pick time button
        Button btnPickTime = (Button) findViewById(R.id.btnPickTime);

        btnPickTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });

        //linking variable toolbar to the toolbar
        toolbar=findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);

        //https://www.youtube.com/watch?v=urQp7KsQhW8
        //youtube video code taking for spinner

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);

        //container that holders the values and then integrates them with a spinner
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(StudyBuddy.this,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter((myAdapter));




        //reference https://codinginflow.com/tutorials/android/datepickerdialog?fbclid=IwAR3TWrfEQMTeKOLm1SZrG_ruwF7szrhD4xhVmE2yQBuQVGElLkrBNnEeEfM
        Button button = (Button) findViewById(R.id.btnDatePicker);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

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
                        Intent startMainClassIntent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(startMainClassIntent);
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


        Button btnSave = (Button) findViewById(R.id.btnSave);
       // button.setOnClickListener(new View.OnClickListener() {
           // @Override
            //public void onClick(View v) {
              //  Intent startIntent = new Intent(getApplicationContext(), StudyBuddyActiveGroups.class);
                //startIntent.putExtra("passingsomething", "hello world");
                //startActivity(startIntent);

       //     }
       // });





    }





    //reference https://codinginflow.com/tutorials/android/datepickerdialog?fbclid=IwAR3TWrfEQMTeKOLm1SZrG_ruwF7szrhD4xhVmE2yQBuQVGElLkrBNnEeEfM
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        TextView textView = (TextView) findViewById(R.id.tvShowDate);
        textView.setText("Date Selected " + currentDateString);
    }





    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView textView = (TextView) findViewById(R.id.tvShowTime);
        textView.setText("Time Selected " + "Hour: " + hourOfDay + " Minute: " + minute);
    }






    //using inflater to show the items in the menu (toolbar)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }


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