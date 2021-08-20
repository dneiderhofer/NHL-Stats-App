/*******************************
 * Class Name: StandingsMenu class
 * Author: Daniel Neiderhofer
 *******************************/
package com.example.nhlstats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StandingsMenu extends AppCompatActivity {

    /**/
    /*
    NAME
        onCreate()
    SYNOPSIS
        Creates the buttons and allows the code to be run behind the scenes for the activities for this class.
    DESCRIPTION
        OnCreate creates each button that takes the user to the desired activity.
        Creates the toolbar that displays the title of the activity.
        Creates an instance of the class.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings_menu);

        //Creates buttons for this activity
        defineButtons();
    }

    /**/
    /*
    NAME
        openDivisionStandings()
    SYNOPSIS
        Opens to the Division Standings activity.
    DESCRIPTION
        Allows the button to take the user to the Division Standings activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openDivisionStandings()
    {
        Intent divisionStandingsIntent = new Intent(this, DivisionStandings.class);
        startActivity(divisionStandingsIntent);
    }

    /**/
    /*
    NAME
        openConferenceStandings()
    SYNOPSIS
        Opens to the Conference Standings activity.
    DESCRIPTION
        Allows the button to take the user to the Conference Standings activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openConferenceStandings()
    {
        Intent conferenceStandingsIntent = new Intent(this, ConferenceStandings.class);
        startActivity(conferenceStandingsIntent);
    }

    /**/
    /*
    NAME
        openLeagueStandings()
    SYNOPSIS
        Opens to the League Standings activity.
    DESCRIPTION
        Allows the button to take the user to the League Standings activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openLeagueStandings()
    {
        Intent leagueStandingsIntent = new Intent(this, LeagueStandings.class);
        startActivity(leagueStandingsIntent);
    }

    /**/
    /*
    NAME
        defineButtons()
    SYNOPSIS
        Creates buttons
    DESCRIPTION
        Creates the buttons that will take the user to the different Standings activities
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    public void defineButtons()
    {
        findViewById(R.id.toDivisionStandings).setOnClickListener(buttonClickListener);
        findViewById(R.id.toConferenceStandings).setOnClickListener(buttonClickListener);
        findViewById(R.id.toLeagueStandings).setOnClickListener(buttonClickListener);
    }

    //Activity waits for a button to be pressed to continue
    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        /**/
        /*
        NAME
            onClick()
        SYNOPSIS
            Wait for a button to be clicked on
        DESCRIPTION
            This function waits for one of the buttons to be clicked on the menu. When a button is
            pressed, it will open the activity associated with that button.
        RETURNS
            None.
        AUTHOR
            Daniel Neiderhofer
        */
        /**/
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.toDivisionStandings:
                    openDivisionStandings();
                    break;
                case R.id.toConferenceStandings:
                    openConferenceStandings();
                    break;
                case R.id.toLeagueStandings:
                    openLeagueStandings();
                    break;
            }
        }
    };
}