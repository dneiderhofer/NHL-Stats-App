/*******************************
 * Class Name: DivisionStandings class
 * Author: Daniel Neiderhofer
 *******************************/
package com.example.nhlstats;

import java.util.ArrayList;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class DivisionStandings extends AppCompatActivity {

    //Atlantic Division TextViews
    TextView atlanticRanks, atlanticTeams, atlanticGames, atlanticWins, atlanticLosses, atlanticOvertimeLosses, atlanticPoints;
    TextView atlanticGoals, atlanticGoalsAgainst, atlanticL10s, atlanticStreaks;
    //Metropolitan Division TextViews
    TextView metroRanks, metroTeams, metroGames, metroWins, metroLosses, metroOvertimeLosses, metroPoints;
    TextView metroGoals, metroGoalsAgainst, metroL10s, metroStreaks;
    //Central Division TextViews
    TextView centralRanks, centralTeams, centralGames, centralWins, centralLosses, centralOvertimeLosses, centralPoints;
    TextView centralGoals, centralGoalsAgainst, centralL10s, centralStreaks;
    //Pacific Division TextViews
    TextView pacificRanks, pacificTeams, pacificGames, pacificWins, pacificLosses, pacificOvertimeLosses, pacificPoints;
    TextView pacificGoals, pacificGoalsAgainst, pacificL10s, pacificStreaks;

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
        setContentView(R.layout.activity_division_standings);

        //Atlantic Division TextViews to link with XML
        atlanticRanks = (TextView) findViewById(R.id.atlanticRanksList);
        atlanticTeams = (TextView) findViewById(R.id.atlanticTeamsList);
        atlanticGames = (TextView) findViewById(R.id.atlanticGamesList);
        atlanticWins = (TextView) findViewById(R.id.atlanticWinsList);
        atlanticLosses = (TextView) findViewById(R.id.atlanticLossesList);
        atlanticOvertimeLosses = (TextView) findViewById(R.id.atlanticOvertimeList);
        atlanticPoints = (TextView) findViewById(R.id.atlanticPointsList);
        atlanticGoals = (TextView) findViewById(R.id.atlanticGoalsList);
        atlanticGoalsAgainst = (TextView) findViewById(R.id.atlanticGoalsAllowedList);
        atlanticL10s = (TextView) findViewById(R.id.atlanticL10List);
        atlanticStreaks = (TextView) findViewById(R.id.atlanticStreakList);

        //Metropolitan Division TextViews to link with XML
        metroRanks = (TextView) findViewById(R.id.metroRanksList);
        metroTeams = (TextView) findViewById(R.id.metroTeamsList);
        metroGames = (TextView) findViewById(R.id.metroGamesList);
        metroWins = (TextView) findViewById(R.id.metroWinsList);
        metroLosses = (TextView) findViewById(R.id.metroLossesList);
        metroOvertimeLosses = (TextView) findViewById(R.id.metroOvertimeList);
        metroPoints = (TextView) findViewById(R.id.metroPointsList);
        metroGoals = (TextView) findViewById(R.id.metroGoalsList);
        metroGoalsAgainst = (TextView) findViewById(R.id.metroGoalsAllowedList);
        metroL10s = (TextView) findViewById(R.id.metroL10List);
        metroStreaks = (TextView) findViewById(R.id.metroStreakList);

        //Central Division TextViews to link with XML
        centralRanks = (TextView) findViewById(R.id.centralRanksList);
        centralTeams = (TextView) findViewById(R.id.centralTeamsList);
        centralGames = (TextView) findViewById(R.id.centralGamesList);
        centralWins = (TextView) findViewById(R.id.centralWinsList);
        centralLosses = (TextView) findViewById(R.id.centralLossesList);
        centralOvertimeLosses = (TextView) findViewById(R.id.centralOvertimeList);
        centralPoints = (TextView) findViewById(R.id.centralPointsList);
        centralGoals = (TextView) findViewById(R.id.centralGoalsList);
        centralGoalsAgainst = (TextView) findViewById(R.id.centralGoalsAllowedList);
        centralL10s = (TextView) findViewById(R.id.centralL10List);
        centralStreaks = (TextView) findViewById(R.id.centralStreakList);

        //Pacific Division TextViews to link with XML
        pacificRanks = (TextView) findViewById(R.id.pacificRanksList);
        pacificTeams = (TextView) findViewById(R.id.pacificTeamsList);
        pacificGames = (TextView) findViewById(R.id.pacificGamesList);
        pacificWins = (TextView) findViewById(R.id.pacificWinsList);
        pacificLosses = (TextView) findViewById(R.id.pacificLossesList);
        pacificOvertimeLosses = (TextView) findViewById(R.id.pacificOvertimeList);
        pacificPoints = (TextView) findViewById(R.id.pacificPointsList);
        pacificGoals = (TextView) findViewById(R.id.pacificGoalsList);
        pacificGoalsAgainst = (TextView) findViewById(R.id.pacificGoalsAllowedList);
        pacificL10s = (TextView) findViewById(R.id.pacificL10List);
        pacificStreaks = (TextView) findViewById(R.id.pacificStreakList);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Creates an instance of the getDivisionStandings class and executes it
        new getDivisionStandings().execute();
    }

    /**/
    /*
    NAME
        getDivisionStandings
    SYNOPSIS
        Nested class that contains specific functions to get all the data from a website.
    DESCRIPTION
        This class contains many string variables and ArrayLists and extends AsyncTask which is an Android
        class that lets us perform long lasting background operations. This class also contains
        specific functions that MUST be used along with the AsyncTask class which includes
        getting the data and giving us a way to display the data after execution.
    AUTHOR
        Daniel Neiderhofer
    */
    /**/
    public class getDivisionStandings extends AsyncTask<Void, Void, Void>
    {
        //Team Rank
        int[] atlanticRankArr = {1, 2, 3, 4, 5, 6, 7, 8};
        String atlanticRankLst = "";
        int[] metroRankArr = {1, 2, 3, 4, 5, 6, 7, 8};
        String metroRankLst = "";
        int[] centralRankArr = {1, 2, 3, 4, 5, 6, 7};
        String centralRankLst = "";
        int[] pacificRankArr = {1, 2, 3, 4, 5, 6, 7, 8};
        String pacificRankLst = "";
        //Team Name
        String atlanticTeam, atlanticTeamLst = "";
        ArrayList<String> atlanticTeamArr = new ArrayList<String>();
        String metroTeam, metroTeamLst = "";
        ArrayList<String> metroTeamArr = new ArrayList<String>();
        String centralTeam, centralTeamLst = "";
        ArrayList<String> centralTeamArr = new ArrayList<String>();
        String pacificTeam, pacificTeamLst = "";
        ArrayList<String> pacificTeamArr = new ArrayList<String>();
        //Games Played
        String atlanticGP, atlanticGPLst = "";
        ArrayList<String> atlanticGPArr = new ArrayList<String>();
        String metroGP, metroGPLst = "";
        ArrayList<String> metroGPArr = new ArrayList<String>();
        String centralGP, centralGPLst = "";
        ArrayList<String> centralGPArr = new ArrayList<String>();
        String pacificGP, pacificGPLst = "";
        ArrayList<String> pacificGPArr = new ArrayList<String>();
        //Wins
        String atlanticW, atlanticWLst = "";
        ArrayList<String> atlanticWArr = new ArrayList<String>();
        String metroW, metroWLst = "";
        ArrayList<String> metroWArr = new ArrayList<String>();
        String centralW, centralWLst = "";
        ArrayList<String> centralWArr = new ArrayList<String>();
        String pacificW, pacificWLst = "";
        ArrayList<String> pacificWArr = new ArrayList<String>();
        //Losses
        String atlanticL, atlanticLLst = "";
        ArrayList<String> atlanticLArr = new ArrayList<String>();
        String metroL, metroLLst = "";
        ArrayList<String> metroLArr = new ArrayList<String>();
        String centralL, centralLLst = "";
        ArrayList<String> centralLArr = new ArrayList<String>();
        String pacificL, pacificLLst = "";
        ArrayList<String> pacificLArr = new ArrayList<String>();
        //OT Losses
        String atlanticOT, atlanticOTLst = "";
        ArrayList<String> atlanticOTArr = new ArrayList<String>();
        String metroOT, metroOTLst = "";
        ArrayList<String> metroOTArr = new ArrayList<String>();
        String centralOT, centralOTLst = "";
        ArrayList<String> centralOTArr = new ArrayList<String>();
        String pacificOT, pacificOTLst = "";
        ArrayList<String> pacificOTArr = new ArrayList<String>();
        //Points
        String atlanticPTS, atlanticPTSLst = "";
        ArrayList<String> atlanticPTSArr = new ArrayList<String>();
        String metroPTS, metroPTSLst = "";
        ArrayList<String> metroPTSArr = new ArrayList<String>();
        String centralPTS, centralPTSLst = "";
        ArrayList<String> centralPTSArr = new ArrayList<String>();
        String pacificPTS, pacificPTSLst = "";
        ArrayList<String> pacificPTSArr = new ArrayList<String>();
        //Goals For
        String atlanticGF, atlanticGFLst = "";
        ArrayList<String> atlanticGFArr = new ArrayList<String>();
        String metroGF, metroGFLst = "";
        ArrayList<String> metroGFArr = new ArrayList<String>();
        String centralGF, centralGFLst = "";
        ArrayList<String> centralGFArr = new ArrayList<String>();
        String pacificGF, pacificGFLst = "";
        ArrayList<String> pacificGFArr = new ArrayList<String>();
        //Goals Against
        String atlanticGA, atlanticGALst = "";
        ArrayList<String> atlanticGAArr = new ArrayList<String>();
        String metroGA, metroGALst = "";
        ArrayList<String> metroGAArr = new ArrayList<String>();
        String centralGA, centralGALst = "";
        ArrayList<String> centralGAArr = new ArrayList<String>();
        String pacificGA, pacificGALst = "";
        ArrayList<String> pacificGAArr = new ArrayList<String>();
        //Last 10 Games
        String atlanticLast10, atlanticLast10Lst = "";
        ArrayList<String> atlanticLast10Arr = new ArrayList<String>();
        String metroLast10, metroLast10Lst = "";
        ArrayList<String> metroLast10Arr = new ArrayList<String>();
        String centralLast10, centralLast10Lst = "";
        ArrayList<String> centralLast10Arr = new ArrayList<String>();
        String pacificLast10, pacificLast10Lst = "";
        ArrayList<String> pacificLast10Arr = new ArrayList<String>();
        //Streak
        String atlanticStreak, atlanticStreakLst = "";
        ArrayList<String> atlanticStreakArr = new ArrayList<String>();
        String metroStreak, metroStreakLst = "";
        ArrayList<String> metroStreakArr = new ArrayList<String>();
        String centralStreak, centralStreakLst = "";
        ArrayList<String> centralStreakArr = new ArrayList<String>();
        String pacificStreak, pacificStreakLst = "";
        ArrayList<String> pacificStreakArr = new ArrayList<String>();

        /**/
        /*
        NAME
            doInBackground()
        SYNOPSIS
            Gets data from the tables on a specific website
        DESCRIPTION
            The doInBackground function is the first of functions that must be used when extending
            the AsyncTask Android class. This class is responsible for getting the data from a specific
            url, table and column with the help of the Jsoup library. With the use of try-catch
            statements, it becomes possible to get multiple columns from a specific table or div
            from the desired url. After getting the data and pushing it onto a specific ArrayList,
            the ArrayList gets converted to an array, and then each object in the array gets
            concatenated to a string that is used for output later.
        RETURNS
            None.
        AUTHOR
            Daniel Neiderhofer
        */
        /**/
        @Override
        protected Void doInBackground(Void... voids) {
            final String url = "https://www.msn.com/en-us/sports/nhl/standings/sp-vw-div";

            //Atlantic Teams
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"52\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".teamname").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        atlanticTeam = row.select(".teamname").text();
                        atlanticTeamArr.add(atlanticTeam);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Atlantic Games
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"52\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide1:nth-of-type(4)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        atlanticGP = row.select(".hide1:nth-of-type(4)").text();
                        atlanticGPArr.add(atlanticGP);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Atlantic Wins
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"52\"] tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(5)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        atlanticW = row.select("td:nth-of-type(5)").text();
                        atlanticWArr.add(atlanticW);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Atlantic Losses
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"52\"] tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(6)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        atlanticL = row.select("td:nth-of-type(6)").text();
                        atlanticLArr.add(atlanticL);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Atlantic Overtime Losses
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"52\"] tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(7)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        atlanticOT = row.select("td:nth-of-type(7)").text();
                        atlanticOTArr.add(atlanticOT);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Atlantic Points
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"52\"] tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(8)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        atlanticPTS = row.select("td:nth-of-type(8)").text();
                        atlanticPTSArr.add(atlanticPTS);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Atlantic Goals
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"52\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide12:nth-of-type(9)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        atlanticGF = row.select(".hide12:nth-of-type(9)").text();
                        atlanticGFArr.add(atlanticGF);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Atlantic Goals Against
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"52\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide12:nth-of-type(10)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        atlanticGA = row.select(".hide12:nth-of-type(10)").text();
                        atlanticGAArr.add(atlanticGA);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Atlantic Last 10 Games
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"52\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide1.fullrecords:nth-of-type(13)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        atlanticLast10 = row.select(".hide1.fullrecords:nth-of-type(13)").text();
                        atlanticLast10Arr.add(atlanticLast10);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Atlantic Streak
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"52\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide12:nth-of-type(14)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        atlanticStreak = row.select(".hide12:nth-of-type(14)").text();
                        atlanticStreakArr.add(atlanticStreak);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Metropolitan Teams
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"61\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".teamname").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        metroTeam = row.select(".teamname").text();
                        metroTeamArr.add(metroTeam);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Metropolitan Games
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"61\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide1:nth-of-type(4)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        metroGP = row.select(".hide1:nth-of-type(4)").text();
                        metroGPArr.add(metroGP);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Metropolitan Wins
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"61\"] tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(5)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        metroW = row.select("td:nth-of-type(5)").text();
                        metroWArr.add(metroW);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Metropolitan Losses
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"61\"] tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(6)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        metroL = row.select("td:nth-of-type(6)").text();
                        metroLArr.add(metroL);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Metropolitan Overtime Losses
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"61\"] tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(7)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        metroOT = row.select("td:nth-of-type(7)").text();
                        metroOTArr.add(metroOT);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Metropolitan Points
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"61\"] tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(8)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        metroPTS = row.select("td:nth-of-type(8)").text();
                        metroPTSArr.add(metroPTS);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Metropolitan Goals
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"61\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide12:nth-of-type(9)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        metroGF = row.select(".hide12:nth-of-type(9)").text();
                        metroGFArr.add(metroGF);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Metropolitan Goals Against
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"61\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide12:nth-of-type(10)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        metroGA = row.select(".hide12:nth-of-type(10)").text();
                        metroGAArr.add(metroGA);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Metropolitan Last 10 Games
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"61\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide1.fullrecords:nth-of-type(13)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        metroLast10 = row.select(".hide1.fullrecords:nth-of-type(13)").text();
                        metroLast10Arr.add(metroLast10);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Metropolitan Streak
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"61\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide12:nth-of-type(14)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        metroStreak = row.select(".hide12:nth-of-type(14)").text();
                        metroStreakArr.add(metroStreak);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Central Teams
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"70\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".teamname").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        centralTeam = row.select(".teamname").text();
                        centralTeamArr.add(centralTeam);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Central Games
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"70\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide1:nth-of-type(4)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        centralGP = row.select(".hide1:nth-of-type(4)").text();
                        centralGPArr.add(centralGP);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Central Wins
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"70\"] tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(5)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        centralW = row.select("td:nth-of-type(5)").text();
                        centralWArr.add(centralW);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Central Losses
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"70\"] tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(6)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        centralL = row.select("td:nth-of-type(6)").text();
                        centralLArr.add(centralL);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Central Overtime Losses
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"70\"] tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(7)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        centralOT = row.select("td:nth-of-type(7)").text();
                        centralOTArr.add(centralOT);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Central Points
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"70\"] tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(8)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        centralPTS = row.select("td:nth-of-type(8)").text();
                        centralPTSArr.add(centralPTS);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Central Goals
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"70\"] tr"))
                {
                    if (row.select(".hide12:nth-of-type(9)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        centralGF = row.select(".hide12:nth-of-type(9)").text();
                        centralGFArr.add(centralGF);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Central Goals Against
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"70\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide12:nth-of-type(10)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        centralGA = row.select(".hide12:nth-of-type(10)").text();
                        centralGAArr.add(centralGA);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Central Last 10 Games
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"70\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide1.fullrecords:nth-of-type(13)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        centralLast10 = row.select(".hide1.fullrecords:nth-of-type(13)").text();
                        centralLast10Arr.add(centralLast10);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Central Streak
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"70\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide12:nth-of-type(14)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        centralStreak = row.select(".hide12:nth-of-type(14)").text();
                        centralStreakArr.add(centralStreak);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Pacific Teams
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"78\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".teamname").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        pacificTeam = row.select(".teamname").text();
                        pacificTeamArr.add(pacificTeam);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Pacific Games
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"78\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide1:nth-of-type(4)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        pacificGP = row.select(".hide1:nth-of-type(4)").text();
                        pacificGPArr.add(pacificGP);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Pacific Wins
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"78\"] tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(5)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        pacificW = row.select("td:nth-of-type(5)").text();
                        pacificWArr.add(pacificW);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Pacific Losses
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"78\"] tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(6)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        pacificL = row.select("td:nth-of-type(6)").text();
                        pacificLArr.add(pacificL);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Pacific Overtime Losses
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"78\"] tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(7)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        pacificOT = row.select("td:nth-of-type(7)").text();
                        pacificOTArr.add(pacificOT);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Pacific Points
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"78\"] tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(8)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        pacificPTS = row.select("td:nth-of-type(8)").text();
                        pacificPTSArr.add(pacificPTS);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Pacific Goals
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"78\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide12:nth-of-type(9)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        pacificGF = row.select(".hide12:nth-of-type(9)").text();
                        pacificGFArr.add(pacificGF);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Pacific Goals Against
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"78\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide12:nth-of-type(10)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        pacificGA = row.select(".hide12:nth-of-type(10)").text();
                        pacificGAArr.add(pacificGA);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Pacific Last 10 Games
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"78\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide1.fullrecords:nth-of-type(13)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        pacificLast10 = row.select(".hide1.fullrecords:nth-of-type(13)").text();
                        pacificLast10Arr.add(pacificLast10);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Pacific Streak
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table.tableview.standing[data-id=\"78\"] tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide12:nth-of-type(14)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        pacificStreak = row.select(".hide12:nth-of-type(14)").text();
                        pacificStreakArr.add(pacificStreak);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Arrays of objects that get converted from ArrayLists to Arrays
            //Atlantic
            Object[] atlanticTeamList = atlanticTeamArr.toArray();
            Object[] atlanticGPList = atlanticGPArr.toArray();
            Object[] atlanticWList = atlanticWArr.toArray();
            Object[] atlanticLList = atlanticLArr.toArray();
            Object[] atlanticOTList = atlanticOTArr.toArray();
            Object[] atlanticPTSList = atlanticPTSArr.toArray();
            Object[] atlanticGFList = atlanticGFArr.toArray();
            Object[] atlanticGAList = atlanticGAArr.toArray();
            Object[] atlanticL10List = atlanticLast10Arr.toArray();
            Object[] atlanticStreakList = atlanticStreakArr.toArray();
            //Metropolitan
            Object[] metroTeamList = metroTeamArr.toArray();
            Object[] metroGPList = metroGPArr.toArray();
            Object[] metroWList = metroWArr.toArray();
            Object[] metroLList = metroLArr.toArray();
            Object[] metroOTList = metroOTArr.toArray();
            Object[] metroPTSList = metroPTSArr.toArray();
            Object[] metroGFList = metroGFArr.toArray();
            Object[] metroGAList = metroGAArr.toArray();
            Object[] metroL10List = metroLast10Arr.toArray();
            Object[] metroStreakList = metroStreakArr.toArray();
            //Central
            Object[] centralTeamList = centralTeamArr.toArray();
            Object[] centralGPList = centralGPArr.toArray();
            Object[] centralWList = centralWArr.toArray();
            Object[] centralLList = centralLArr.toArray();
            Object[] centralOTList = centralOTArr.toArray();
            Object[] centralPTSList = centralPTSArr.toArray();
            Object[] centralGFList = centralGFArr.toArray();
            Object[] centralGAList = centralGAArr.toArray();
            Object[] centralL10List = centralLast10Arr.toArray();
            Object[] centralStreakList = centralStreakArr.toArray();
            //Pacific
            Object[] pacificTeamList = pacificTeamArr.toArray();
            Object[] pacificGPList = pacificGPArr.toArray();
            Object[] pacificWList = pacificWArr.toArray();
            Object[] pacificLList = pacificLArr.toArray();
            Object[] pacificOTList = pacificOTArr.toArray();
            Object[] pacificPTSList = pacificPTSArr.toArray();
            Object[] pacificGFList = pacificGFArr.toArray();
            Object[] pacificGAList = pacificGAArr.toArray();
            Object[] pacificL10List = pacificLast10Arr.toArray();
            Object[] pacificStreakList = pacificStreakArr.toArray();

            //Each for loop concatenates each item from the tables from the website
            //And ends the line twice for formatting neatness
            //Atlantic
            for(Object rank : atlanticRankArr)
                atlanticRankLst += rank + "\r\n\n";
            for (Object team : atlanticTeamList)
                atlanticTeamLst += team + "\r\n\n";
            for (Object gp : atlanticGPList)
                atlanticGPLst += gp + "\r\n\n";
            for (Object win : atlanticWList)
                atlanticWLst += win + "\r\n\n";
            for (Object loss : atlanticLList)
                atlanticLLst += loss + "\r\n\n";
            for (Object ot : atlanticOTList)
                atlanticOTLst += ot + "\r\n\n";
            for (Object point : atlanticPTSList)
                atlanticPTSLst += point + "\r\n\n";
            for (Object goal : atlanticGFList)
                atlanticGFLst += goal + "\r\n\n";
            for (Object goalA : atlanticGAList)
                atlanticGALst += goalA + "\r\n\n";
            for (Object L10 : atlanticL10List)
                atlanticLast10Lst += L10 + "\r\n\n";
            for (Object streak : atlanticStreakList)
                atlanticStreakLst += streak + "\r\n\n";
            //Metropolitan
            for(Object rank : metroRankArr)
                metroRankLst += rank + "\r\n\n";
            for (Object team : metroTeamList)
                metroTeamLst += team + "\r\n\n";
            for (Object gp : metroGPList)
                metroGPLst += gp + "\r\n\n";
            for (Object win : metroWList)
                metroWLst += win + "\r\n\n";
            for (Object loss : metroLList)
                metroLLst += loss + "\r\n\n";
            for (Object ot : metroOTList)
                metroOTLst += ot + "\r\n\n";
            for (Object point : metroPTSList)
                metroPTSLst += point + "\r\n\n";
            for (Object goal : metroGFList)
                metroGFLst += goal + "\r\n\n";
            for (Object goalA : metroGAList)
                metroGALst += goalA + "\r\n\n";
            for (Object L10 : metroL10List)
                metroLast10Lst += L10 + "\r\n\n";
            for (Object streak : metroStreakList)
                metroStreakLst += streak + "\r\n\n";
            //Central
            for(Object rank : centralRankArr)
                centralRankLst += rank + "\r\n\n";
            for (Object team : centralTeamList)
                centralTeamLst += team + "\r\n\n";
            for (Object gp : centralGPList)
                centralGPLst += gp + "\r\n\n";
            for (Object win : centralWList)
                centralWLst += win + "\r\n\n";
            for (Object loss : centralLList)
                centralLLst += loss + "\r\n\n";
            for (Object ot : centralOTList)
                centralOTLst += ot + "\r\n\n";
            for (Object point : centralPTSList)
                centralPTSLst += point + "\r\n\n";
            for (Object goal : centralGFList)
                centralGFLst += goal + "\r\n\n";
            for (Object goalA : centralGAList)
                centralGALst += goalA + "\r\n\n";
            for (Object L10 : centralL10List)
                centralLast10Lst += L10 + "\r\n\n";
            for (Object streak : centralStreakList)
                centralStreakLst += streak + "\r\n\n";
            //Pacific
            for(Object rank : pacificRankArr)
                pacificRankLst += rank + "\r\n\n";
            for (Object team : pacificTeamList)
                pacificTeamLst += team + "\r\n\n";
            for (Object gp : pacificGPList)
                pacificGPLst += gp + "\r\n\n";
            for (Object win : pacificWList)
                pacificWLst += win + "\r\n\n";
            for (Object loss : pacificLList)
                pacificLLst += loss + "\r\n\n";
            for (Object ot : pacificOTList)
                pacificOTLst += ot + "\r\n\n";
            for (Object point : pacificPTSList)
                pacificPTSLst += point + "\r\n\n";
            for (Object goal : pacificGFList)
                pacificGFLst += goal + "\r\n\n";
            for (Object goalA : pacificGAList)
                pacificGALst += goalA + "\r\n\n";
            for (Object L10 : pacificL10List)
                pacificLast10Lst += L10 + "\r\n\n";
            for (Object streak : pacificStreakList)
                pacificStreakLst += streak + "\r\n\n";

            return null;
        }

        /**/
        /*
        NAME
            onPostExecute()
        SYNOPSIS
            Sets the text in the content XML file
        DESCRIPTION
            This function simply sets the content of a string variable to be the text
            of a TextView in the content XML file
        RETURNS
            None.
        AUTHOR
            Daniel Neiderhofer
        */
        /**/
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //Atlantic
            atlanticRanks.setText(atlanticRankLst);
            atlanticTeams.setText(atlanticTeamLst);
            atlanticGames.setText(atlanticGPLst);
            atlanticWins.setText(atlanticWLst);
            atlanticLosses.setText(atlanticLLst);
            atlanticOvertimeLosses.setText(atlanticOTLst);
            atlanticPoints.setText(atlanticPTSLst);
            atlanticGoals.setText(atlanticGFLst);
            atlanticGoalsAgainst.setText(atlanticGALst);
            atlanticL10s.setText(atlanticLast10Lst);
            atlanticStreaks.setText(atlanticStreakLst);
            //Metropolitan
            metroRanks.setText(metroRankLst);
            metroTeams.setText(metroTeamLst);
            metroGames.setText(metroGPLst);
            metroWins.setText(metroWLst);
            metroLosses.setText(metroLLst);
            metroOvertimeLosses.setText(metroOTLst);
            metroPoints.setText(metroPTSLst);
            metroGoals.setText(metroGFLst);
            metroGoalsAgainst.setText(metroGALst);
            metroL10s.setText(metroLast10Lst);
            metroStreaks.setText(metroStreakLst);
            //Central
            centralRanks.setText(centralRankLst);
            centralTeams.setText(centralTeamLst);
            centralGames.setText(centralGPLst);
            centralWins.setText(centralWLst);
            centralLosses.setText(centralLLst);
            centralOvertimeLosses.setText(centralOTLst);
            centralPoints.setText(centralPTSLst);
            centralGoals.setText(centralGFLst);
            centralGoalsAgainst.setText(centralGALst);
            centralL10s.setText(centralLast10Lst);
            centralStreaks.setText(centralStreakLst);
            //Pacific
            pacificRanks.setText(pacificRankLst);
            pacificTeams.setText(pacificTeamLst);
            pacificGames.setText(pacificGPLst);
            pacificWins.setText(pacificWLst);
            pacificLosses.setText(pacificLLst);
            pacificOvertimeLosses.setText(pacificOTLst);
            pacificPoints.setText(pacificPTSLst);
            pacificGoals.setText(pacificGFLst);
            pacificGoalsAgainst.setText(pacificGALst);
            pacificL10s.setText(pacificLast10Lst);
            pacificStreaks.setText(pacificStreakLst);
        }
    }
}
