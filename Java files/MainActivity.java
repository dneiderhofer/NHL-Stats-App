/*******************************
 * Class Name: MainActivity class
 * Author: Daniel Neiderhofer
 *******************************/
package com.example.nhlstats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button launch;

    /**/
    /*
    NAME
        onCreate()
    SYNOPSIS
        Creates the launch button and allows the code to be run behind the scenes for the activities for this class.
    DESCRIPTION
        OnCreate creates a button that takes the user to the desired activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button to load menu
        launch = (Button) findViewById(R.id.launchApp);
        launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu();
            }
        });
    }

    /**/
    /*
    NAME
        openMenu()
    SYNOPSIS
        Opens to the menu activity.
    DESCRIPTION
        Allows the button to take the user to the menu activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    public void openMenu()
    {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
}
