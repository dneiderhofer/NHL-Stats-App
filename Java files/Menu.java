/*******************************
 * Class Name: Menu class
 * Author: Daniel Neiderhofer
 *******************************/
package com.example.nhlstats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    /**/
    /*
    NAME
        onCreate()
    SYNOPSIS
        Creates the buttons and allows the code to be run behind the scenes for the activities for this class.
    DESCRIPTION
        OnCreate calls a function that creates the buttons for the activity
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //Creates the buttons for the activity
        defineButtons();
    }

    /**/
    /*
    NAME
        openStandingsMenu()
    SYNOPSIS
        Opens to the Standings activity.
    DESCRIPTION
        Allows the button to take the user to the Standings activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openStandingsMenu()
    {
        Intent standingsMenuIntent = new Intent(this, StandingsMenu.class);
        startActivity(standingsMenuIntent);
    }

    /**/
    /*
    NAME
        openHurricanes()
    SYNOPSIS
        Opens to the Hurricanes activity.
    DESCRIPTION
        Allows the button to take the user to the Hurricanes activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openHurricanes()
    {
        Intent hurricanesIntent = new Intent(this, Hurricanes.class);
        startActivity(hurricanesIntent);
    }

    /**/
    /*
    NAME
        openBlueJackets()
    SYNOPSIS
        Opens to the Blue Jackets activity.
    DESCRIPTION
        Allows the button to take the user to the Blue Jackets activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openBlueJackets()
    {
        Intent intent = new Intent(this, BlueJackets.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openDevils()
    SYNOPSIS
        Opens to the Devils activity.
    DESCRIPTION
        Allows the button to take the user to the Devils activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openDevils()
    {
        Intent intent = new Intent(this, Devils.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openIslanders()
    SYNOPSIS
        Opens to the Islanders activity.
    DESCRIPTION
        Allows the button to take the user to the Islanders activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openIslanders()
    {
        Intent intent = new Intent(this, Islanders.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openRangers()
    SYNOPSIS
        Opens to the Rangers activity.
    DESCRIPTION
        Allows the button to take the user to the Rangers activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openRangers()
    {
        Intent intent = new Intent(this, Rangers.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openFlyers()
    SYNOPSIS
        Opens to the Flyers activity.
    DESCRIPTION
        Allows the button to take the user to the Flyers activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openFlyers()
    {
        Intent intent = new Intent(this, Flyers.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openPenguins()
    SYNOPSIS
        Opens to the Penguins activity.
    DESCRIPTION
        Allows the button to take the user to the Penguins activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openPenguins()
    {
        Intent intent = new Intent(this, Penguins.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openCapitals()
    SYNOPSIS
        Opens to the Capitals activity.
    DESCRIPTION
        Allows the button to take the user to the Capitals activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openCapitals()
    {
        Intent intent = new Intent(this, Capitals.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openBruins()
    SYNOPSIS
        Opens to the Bruins activity.
    DESCRIPTION
        Allows the button to take the user to the Bruins activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openBruins()
    {
        Intent intent = new Intent(this, Bruins.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openSabres()
    SYNOPSIS
        Opens to the Sabres activity.
    DESCRIPTION
        Allows the button to take the user to the Sabres activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openSabres()
    {
        Intent intent = new Intent(this, Sabres.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openRedWings()
    SYNOPSIS
        Opens to the Red Wings activity.
    DESCRIPTION
        Allows the button to take the user to the Red Wings activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openRedWings()
    {
        Intent intent = new Intent(this, RedWings.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openPanthers()
    SYNOPSIS
        Opens to the Panthers activity.
    DESCRIPTION
        Allows the button to take the user to the Panthers activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openPanthers()
    {
        Intent intent = new Intent(this, Panthers.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openCanadiens()
    SYNOPSIS
        Opens to the Canadiens activity.
    DESCRIPTION
        Allows the button to take the user to the Canadiens activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openCanadiens()
    {
        Intent intent = new Intent(this, Canadiens.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openSenators()
    SYNOPSIS
        Opens to the Senators activity.
    DESCRIPTION
        Allows the button to take the user to the Senators activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openSenators()
    {
        Intent intent = new Intent(this, Senators.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openLightning()
    SYNOPSIS
        Opens to the Lightning activity.
    DESCRIPTION
        Allows the button to take the user to the Lightning activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openLightning()
    {
        Intent intent = new Intent(this, Lightning.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openMapleLeafs()
    SYNOPSIS
        Opens to the Maple Leafs activity.
    DESCRIPTION
        Allows the button to take the user to the Maple Leafs activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openMapleLeafs()
    {
        Intent intent = new Intent(this, MapleLeafs.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openBlackhawks()
    SYNOPSIS
        Opens to the Blackhawks activity.
    DESCRIPTION
        Allows the button to take the user to the Blackhawks activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openBlackhawks()
    {
        Intent intent = new Intent(this, Blackhawks.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openAvalanche()
    SYNOPSIS
        Opens to the Avalanche activity.
    DESCRIPTION
        Allows the button to take the user to the Avalanche activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openAvalanche()
    {
        Intent intent = new Intent(this, Avalanche.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openStars()
    SYNOPSIS
        Opens to the Stars activity.
    DESCRIPTION
        Allows the button to take the user to the Stars activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openStars()
    {
        Intent intent = new Intent(this, Stars.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openWild()
    SYNOPSIS
        Opens to the Wild activity.
    DESCRIPTION
        Allows the button to take the user to the Wild activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openWild()
    {
        Intent intent = new Intent(this, Wild.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openPredators()
    SYNOPSIS
        Opens to the Predators activity.
    DESCRIPTION
        Allows the button to take the user to the Predators activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openPredators()
    {
        Intent intent = new Intent(this, Predators.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openBlues()
    SYNOPSIS
        Opens to the Blues activity.
    DESCRIPTION
        Allows the button to take the user to the Blues activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openBlues()
    {
        Intent intent = new Intent(this, Blues.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openJets()
    SYNOPSIS
        Opens to the Jets activity.
    DESCRIPTION
        Allows the button to take the user to the Jets activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openJets()
    {
        Intent intent = new Intent(this, Jets.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openDucks()
    SYNOPSIS
        Opens to the Ducks activity.
    DESCRIPTION
        Allows the button to take the user to the Ducks activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openDucks()
    {
        Intent intent = new Intent(this, Ducks.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openCoyotes()
    SYNOPSIS
        Opens to the Coyotes activity.
    DESCRIPTION
        Allows the button to take the user to the Coyotes activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openCoyotes()
    {
        Intent intent = new Intent(this, Coyotes.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openFlames()
    SYNOPSIS
        Opens to the Flames activity.
    DESCRIPTION
        Allows the button to take the user to the Flames activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openFlames()
    {
        Intent intent = new Intent(this, Flames.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openOilers()
    SYNOPSIS
        Opens to the Oilers activity.
    DESCRIPTION
        Allows the button to take the user to the Oilers activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openOilers()
    {
        Intent intent = new Intent(this, Oilers.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openKings()
    SYNOPSIS
        Opens to the Kings activity.
    DESCRIPTION
        Allows the button to take the user to the Kings activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openKings()
    {
        Intent intent = new Intent(this, Kings.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openSharks()
    SYNOPSIS
        Opens to the Sharks activity.
    DESCRIPTION
        Allows the button to take the user to the Sharks activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openSharks()
    {
        Intent intent = new Intent(this, Sharks.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openCanucks()
    SYNOPSIS
        Opens to the Canucks activity.
    DESCRIPTION
        Allows the button to take the user to the Canucks activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openCanucks()
    {
        Intent intent = new Intent(this, Canucks.class);
        startActivity(intent);
    }

    /**/
    /*
    NAME
        openGoldenKnights()
    SYNOPSIS
        Opens to the Golden Knights activity.
    DESCRIPTION
        Allows the button to take the user to the Golden Knights activity.
    RETURNS
        None.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    private void openGoldenKnights()
    {
        Intent intent = new Intent(this, GoldenKnights.class);
        startActivity(intent);
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
    public void defineButtons() {
        // To Standings
        findViewById(R.id.toStandingsMenu).setOnClickListener(buttonClickListener);
        // Metropolitan Division
        findViewById(R.id.imageButtonHurricanes).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonBlueJackets).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonDevils).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonIslanders).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonRangers).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonFlyers).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonPenguins).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonCapitals).setOnClickListener(buttonClickListener);
        // Atlantic Division
        findViewById(R.id.imageButtonBruins).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonSabres).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonRedWings).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonPanthers).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonCanadiens).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonSenators).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonLightning).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonMapleLeafs).setOnClickListener(buttonClickListener);
        // Central Division
        findViewById(R.id.imageButtonBlackhawks).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonAvalanche).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonStars).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonWild).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonPredators).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonBlues).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonJets).setOnClickListener(buttonClickListener);
        // Pacific Division
        findViewById(R.id.imageButtonDucks).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonCoyotes).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonFlames).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonOilers).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonKings).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonSharks).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonCanucks).setOnClickListener(buttonClickListener);
        findViewById(R.id.imageButtonGoldenKnights).setOnClickListener(buttonClickListener);
    }

    //Activity waits for a button to be pressed to continue
    private View.OnClickListener buttonClickListener = new View.OnClickListener()
    {
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
        public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.toStandingsMenu:
                    openStandingsMenu();
                    break;
                case R.id.imageButtonHurricanes:
                    openHurricanes();
                    break;
                case R.id.imageButtonBlueJackets:
                    openBlueJackets();
                    break;
                case R.id.imageButtonDevils:
                    openDevils();
                    break;
                case R.id.imageButtonIslanders:
                    openIslanders();
                    break;
                case R.id.imageButtonRangers:
                    openRangers();
                    break;
                case R.id.imageButtonFlyers:
                    openFlyers();
                    break;
                case R.id.imageButtonPenguins:
                    openPenguins();
                    break;
                case R.id.imageButtonCapitals:
                    openCapitals();
                    break;
                case R.id.imageButtonBruins:
                    openBruins();
                    break;
                case R.id.imageButtonSabres:
                    openSabres();
                    break;
                case R.id.imageButtonRedWings:
                    openRedWings();
                    break;
                case R.id.imageButtonPanthers:
                    openPanthers();
                    break;
                case R.id.imageButtonCanadiens:
                    openCanadiens();
                    break;
                case R.id.imageButtonSenators:
                    openSenators();
                    break;
                case R.id.imageButtonLightning:
                    openLightning();
                    break;
                case R.id.imageButtonMapleLeafs:
                    openMapleLeafs();
                    break;
                case R.id.imageButtonBlackhawks:
                    openBlackhawks();
                    break;
                case R.id.imageButtonAvalanche:
                    openAvalanche();
                    break;
                case R.id.imageButtonStars:
                    openStars();
                    break;
                case R.id.imageButtonWild:
                    openWild();
                    break;
                case R.id.imageButtonPredators:
                    openPredators();
                    break;
                case R.id.imageButtonBlues:
                    openBlues();
                    break;
                case R.id.imageButtonJets:
                    openJets();
                    break;
                case R.id.imageButtonDucks:
                    openDucks();
                    break;
                case R.id.imageButtonCoyotes:
                    openCoyotes();
                    break;
                case R.id.imageButtonFlames:
                    openFlames();
                    break;
                case R.id.imageButtonOilers:
                    openOilers();
                    break;
                case R.id.imageButtonKings:
                    openKings();
                    break;
                case R.id.imageButtonSharks:
                    openSharks();
                    break;
                case R.id.imageButtonCanucks:
                    openCanucks();
                    break;
                case R.id.imageButtonGoldenKnights:
                    openGoldenKnights();
                    break;
            }
        }
    };
}