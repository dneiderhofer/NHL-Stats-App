/*******************************
 * Class Name: LeagueStandings class
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

public class LeagueStandings extends AppCompatActivity {

    //League TextViews
    TextView overallRanks, overallTeams, overallGames, overallWins, overallLosses, overallOvertimeLosses;
    TextView overallPoints, overallGoals, overallGoalsAgainst, overallL10s, overallStreaks;

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
        setContentView(R.layout.activity_league_standings);

        //League TextViews to link with XML
        overallRanks = (TextView) findViewById(R.id.overallRanksList);
        overallTeams = (TextView) findViewById(R.id.overallTeamsList);
        overallGames = (TextView) findViewById(R.id.overallGamesList);
        overallWins = (TextView) findViewById(R.id.overallWinsList);
        overallLosses = (TextView) findViewById(R.id.overallLossesList);
        overallOvertimeLosses = (TextView) findViewById(R.id.overallOvertimeList);
        overallPoints = (TextView) findViewById(R.id.overallPointsList);
        overallGoals = (TextView) findViewById(R.id.overallGoalsList);
        overallGoalsAgainst = (TextView) findViewById(R.id.overallGoalsAllowedList);
        overallL10s = (TextView) findViewById(R.id.overallL10List);
        overallStreaks = (TextView) findViewById(R.id.overallStreakList);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Creates an instance of the getLeagueStandings class and executes it
        new getLeagueStandings().execute();
    }

    /**/
    /*
    NAME
        getLeague
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
    public class getLeagueStandings extends AsyncTask<Void, Void, Void> {
        //Rank
        int[] overallRankArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
        17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        String overallRankLst = "";
        //Team Name
        String overallTeam, overallTeamLst = "";
        ArrayList<String> overallTeamArr = new ArrayList<String>();
        //Games Played
        String overallGP, overallGPLst = "";
        ArrayList<String> overallGPArr = new ArrayList<String>();
        //Wins
        String overallW, overallWLst = "";
        ArrayList<String> overallWArr = new ArrayList<String>();
        //Losses
        String overallL, overallLLst = "";
        ArrayList<String> overallLArr = new ArrayList<String>();
        //OT Losses
        String overallOT, overallOTLst = "";
        ArrayList<String> overallOTArr = new ArrayList<String>();
        //Points
        String overallPTS, overallPTSLst = "";
        ArrayList<String> overallPTSArr = new ArrayList<String>();
        //Goals For
        String overallGF, overallGFLst = "";
        ArrayList<String> overallGFArr = new ArrayList<String>();
        String westGF, westGFLst = "";
        //Goals Against
        String overallGA, overallGALst = "";
        ArrayList<String> overallGAArr = new ArrayList<String>();
        //Last 10 Games
        String overallLast10, overallLast10Lst = "";
        ArrayList<String> overallLast10Arr = new ArrayList<String>();
        //Streak
        String overallStreak, overallStreakLst = "";
        ArrayList<String> overallStreakArr = new ArrayList<String>();

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
        protected Void doInBackground(Void... voids) {
            final String url = "https://www.msn.com/en-us/sports/nhl/standings/sp-vw-lge";

            //Teams
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                for (Element row : doc.select("div#standings tr"))
                {
                    //Skip empty rows
                    if (row.select(".teamname").text().equals(""))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        overallTeam = row.select(".teamname").text();
                        overallTeamArr.add(overallTeam);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Games Played
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                for (Element row : doc.select("div#standings tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide1:nth-of-type(4)").text().equals(""))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        overallGP = row.select(".hide1:nth-of-type(4)").text();
                        overallGPArr.add(overallGP);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //overall Wins
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                for (Element row : doc.select("div#standings tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(5)").text().equals(""))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        overallW = row.select("td:nth-of-type(5)").text();
                        overallWArr.add(overallW);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Losses
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                for (Element row : doc.select("div#standings tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(6)").text().equals(""))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        overallL = row.select("td:nth-of-type(6)").text();
                        overallLArr.add(overallL);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Overtime Losses
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                for (Element row : doc.select("div#standings tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(7)").text().equals(""))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        overallOT = row.select("td:nth-of-type(7)").text();
                        overallOTArr.add(overallOT);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Points
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                for (Element row : doc.select("div#standings tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(8)").text().equals(""))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        overallPTS = row.select("td:nth-of-type(8)").text();
                        overallPTSArr.add(overallPTS);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Goals
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                for (Element row : doc.select("div#standings tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide12:nth-of-type(9)").text().equals(""))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        overallGF = row.select(".hide12:nth-of-type(9)").text();
                        overallGFArr.add(overallGF);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Goals Against
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                for (Element row : doc.select("div#standings tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide12:nth-of-type(10)").text().equals(""))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        overallGA = row.select(".hide12:nth-of-type(10)").text();
                        overallGAArr.add(overallGA);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Last 10 Games
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                for (Element row : doc.select("div#standings tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide1.fullrecords:nth-of-type(13)").text().equals(""))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        overallLast10 = row.select(".hide1.fullrecords:nth-of-type(13)").text();
                        overallLast10Arr.add(overallLast10);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Streak
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                for (Element row : doc.select("div#standings tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide12:nth-of-type(14)").text().equals(""))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        overallStreak = row.select(".hide12:nth-of-type(14)").text();
                        overallStreakArr.add(overallStreak);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Arrays of objects that get converted from ArrayLists to Arrays
            Object[] overallTeamList = overallTeamArr.toArray();
            Object[] overallGPList = overallGPArr.toArray();
            Object[] overallWinsList = overallWArr.toArray();
            Object[] overallLossesList = overallLArr.toArray();
            Object[] overallOTList = overallOTArr.toArray();
            Object[] overallPointsList = overallPTSArr.toArray();
            Object[] overallGoalsList = overallGFArr.toArray();
            Object[] overallGAList = overallGAArr.toArray();
            Object[] overallL10List = overallLast10Arr.toArray();
            Object[] overallStreakList = overallStreakArr.toArray();

            //Each for loop concatenates each item from the tables from the website
            //And ends the line twice for formatting neatness
            for (Object rank : overallRankArr)
                overallRankLst += rank + "\r\n\n";
            for (Object team : overallTeamList)
                overallTeamLst += team + "\r\n\n";
            for (Object gp : overallGPList)
                overallGPLst += gp + "\r\n\n";
            for (Object win : overallWinsList)
                overallWLst += win + "\r\n\n";
            for (Object loss : overallLossesList)
                overallLLst += loss + "\r\n\n";
            for (Object ot : overallOTList)
                overallOTLst += ot + "\r\n\n";
            for (Object point : overallPointsList)
                overallPTSLst += point + "\r\n\n";
            for (Object goal : overallGoalsList)
                overallGFLst += goal + "\r\n\n";
            for (Object goalA : overallGAList)
                overallGALst += goalA + "\r\n\n";
            for (Object L10 : overallL10List)
                overallLast10Lst += L10 + "\r\n\n";
            for (Object streak : overallStreakList)
                overallStreakLst += streak + "\r\n\n";

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
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);
            overallRanks.setText(overallRankLst);
            overallTeams.setText(overallTeamLst);
            overallGames.setText(overallGPLst);
            overallWins.setText(overallWLst);
            overallLosses.setText(overallLLst);
            overallOvertimeLosses.setText(overallOTLst);
            overallPoints.setText(overallPTSLst);
            overallGoals.setText(overallGFLst);
            overallGoalsAgainst.setText(overallGALst);
            overallL10s.setText(overallLast10Lst);
            overallStreaks.setText(overallStreakLst);
        }
    }
}
