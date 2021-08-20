/*******************************
 * Class Name: ConferenceStandings class
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

public class ConferenceStandings extends AppCompatActivity {

    //Eastern Conference TextViews
    TextView eastRanks, eastTeams, eastGames, eastWins, eastLosses, eastOvertimeLosses, eastPoints;
    TextView eastGoals, eastGoalsAgainst, eastL10s, eastStreaks;
    //Western Conference TextViews
    TextView westRanks, westTeams, westGames, westWins, westLosses, westOvertimeLosses, westPoints;
    TextView westGoals, westGoalsAgainst, westL10s, westStreaks;

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
        setContentView(R.layout.activity_conference_standings);

        //Eastern Conference TextViews to link with XML
        eastRanks = (TextView) findViewById(R.id.eastRanksList);
        eastTeams = (TextView) findViewById(R.id.eastTeamsList);
        eastGames = (TextView) findViewById(R.id.eastGamesList);
        eastWins = (TextView) findViewById(R.id.eastWinsList);
        eastLosses = (TextView) findViewById(R.id.eastLossesList);
        eastOvertimeLosses = (TextView) findViewById(R.id.eastOvertimeList);
        eastPoints = (TextView) findViewById(R.id.eastPointsList);
        eastGoals = (TextView) findViewById(R.id.eastGoalsList);
        eastGoalsAgainst = (TextView) findViewById(R.id.eastGoalsAllowedList);
        eastL10s = (TextView) findViewById(R.id.eastL10List);
        eastStreaks = (TextView) findViewById(R.id.eastStreakList);

        //Western Conference TextViews to link with XML
        westRanks = (TextView) findViewById(R.id.westRanksList);
        westTeams = (TextView) findViewById(R.id.westTeamsList);
        westGames = (TextView) findViewById(R.id.westGamesList);
        westWins = (TextView) findViewById(R.id.westWinsList);
        westLosses = (TextView) findViewById(R.id.westLossesList);
        westOvertimeLosses = (TextView) findViewById(R.id.westOvertimeList);
        westPoints = (TextView) findViewById(R.id.westPointsList);
        westGoals = (TextView) findViewById(R.id.westGoalsList);
        westGoalsAgainst = (TextView) findViewById(R.id.westGoalsAllowedList);
        westL10s = (TextView) findViewById(R.id.westL10List);
        westStreaks = (TextView) findViewById(R.id.westStreakList);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Creates an instance of the getConferenceStandings class and executes it
        new getConferenceStandings().execute();
    }

    /**/
    /*
    NAME
        getConferenceStandings
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
    public class getConferenceStandings extends AsyncTask<Void, Void, Void> {
        //Team Rank
        int[] eastRankArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        String eastRankLst = "";
        int[] westRankArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        String westRankLst = "";
        //Team Name
        String eastTeam, eastTeamLst = "";
        ArrayList<String> eastTeamArr = new ArrayList<String>();
        String westTeam, westTeamLst = "";
        ArrayList<String> westTeamArr = new ArrayList<String>();
        //Games Played
        String eastGP, eastGPLst = "";
        ArrayList<String> eastGPArr = new ArrayList<String>();
        String westGP, westGPLst = "";
        ArrayList<String> westGPArr = new ArrayList<String>();
        //Wins
        String eastW, eastWLst = "";
        ArrayList<String> eastWArr = new ArrayList<String>();
        String westW, westWLst = "";
        ArrayList<String> westWArr = new ArrayList<String>();
        //Losses
        String eastL, eastLLst = "";
        ArrayList<String> eastLArr = new ArrayList<String>();
        String westL, westLLst = "";
        ArrayList<String> westLArr = new ArrayList<String>();
        //OT Losses
        String eastOT, eastOTLst = "";
        ArrayList<String> eastOTArr = new ArrayList<String>();
        String westOT, westOTLst = "";
        ArrayList<String> westOTArr = new ArrayList<String>();
        //Points
        String eastPTS, eastPTSLst = "";
        ArrayList<String> eastPTSArr = new ArrayList<String>();
        String westPTS, westPTSLst = "";
        ArrayList<String> westPTSArr = new ArrayList<String>();
        //Goals For
        String eastGF, eastGFLst = "";
        ArrayList<String> eastGFArr = new ArrayList<String>();
        String westGF, westGFLst = "";
        ArrayList<String> westGFArr = new ArrayList<String>();
        //Goals Against
        String eastGA, eastGALst = "";
        ArrayList<String> eastGAArr = new ArrayList<String>();
        String westGA, westGALst = "";
        ArrayList<String> westGAArr = new ArrayList<String>();
        //Last 10 Games
        String eastLast10, eastLast10Lst = "";
        ArrayList<String> eastLast10Arr = new ArrayList<String>();
        String westLast10, westLast10Lst = "";
        ArrayList<String> westLast10Arr = new ArrayList<String>();
        //Streak
        String eastStreak, eastStreakLst = "";
        ArrayList<String> eastStreakArr = new ArrayList<String>();
        String westStreak, westStreakLst = "";
        ArrayList<String> westStreakArr = new ArrayList<String>();

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
            final String url = "https://www.msn.com/en-us/sports/nhl/standings/sp-vw-con";

            //East Teams
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("div.tablegroupbytitle.tablegroup1.first tr"))
                {
                    //Skip empty rows
                    if (row.select(".teamname").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        eastTeam = row.select(".teamname").text();
                        eastTeamArr.add(eastTeam);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //East Games Played
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("div.tablegroupbytitle.tablegroup1.first tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide1:nth-of-type(4)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        eastGP = row.select(".hide1:nth-of-type(4)").text();
                        eastGPArr.add(eastGP);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //East Wins
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("div.tablegroupbytitle.tablegroup1.first tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(5)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        eastW = row.select("td:nth-of-type(5)").text();
                        eastWArr.add(eastW);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //East Losses
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("div.tablegroupbytitle.tablegroup1.first tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(6)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        eastL = row.select("td:nth-of-type(6)").text();
                        eastLArr.add(eastL);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //East Overtime Losses
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("div.tablegroupbytitle.tablegroup1.first tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(7)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        eastOT = row.select("td:nth-of-type(7)").text();
                        eastOTArr.add(eastOT);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //East Points
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("div.tablegroupbytitle.tablegroup1.first tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(8)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        eastPTS = row.select("td:nth-of-type(8)").text();
                        eastPTSArr.add(eastPTS);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //East Goals
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("div.tablegroupbytitle.tablegroup1.first tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide12:nth-of-type(9)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        eastGF = row.select(".hide12:nth-of-type(9)").text();
                        eastGFArr.add(eastGF);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //East Goals Against
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("div.tablegroupbytitle.tablegroup1.first tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide12:nth-of-type(10)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        eastGA = row.select(".hide12:nth-of-type(10)").text();
                        eastGAArr.add(eastGA);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //East Last 10 Games
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("div.tablegroupbytitle.tablegroup1.first tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide1.fullrecords:nth-of-type(13)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        eastLast10 = row.select(".hide1.fullrecords:nth-of-type(13)").text();
                        eastLast10Arr.add(eastLast10);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //East Streak
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("div.tablegroupbytitle.tablegroup1.first tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide12:nth-of-type(14)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        eastStreak = row.select(".hide12:nth-of-type(14)").text();
                        eastStreakArr.add(eastStreak);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //West Teams
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("div.tablegroupbytitle.tablegroup2 tr"))
                {
                    //Skip empty rows
                    if (row.select(".teamname").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        westTeam = row.select(".teamname").text();
                        westTeamArr.add(westTeam);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //West Games Played
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("div.tablegroupbytitle.tablegroup2 tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide1:nth-of-type(4)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        westGP = row.select(".hide1:nth-of-type(4)").text();
                        westGPArr.add(westGP);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //West Wins
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("div.tablegroupbytitle.tablegroup2 tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(5)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        westW = row.select("td:nth-of-type(5)").text();
                        westWArr.add(westW);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //West Losses
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("div.tablegroupbytitle.tablegroup2 tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(6)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        westL = row.select("td:nth-of-type(6)").text();
                        westLArr.add(westL);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //West Overtime Losses
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("div.tablegroupbytitle.tablegroup2 tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(7)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        westOT = row.select("td:nth-of-type(7)").text();
                        westOTArr.add(westOT);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //West Points
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("div.tablegroupbytitle.tablegroup2 tr"))
                {
                    //Skip empty rows
                    if (row.select("td:nth-of-type(8)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        westPTS = row.select("td:nth-of-type(8)").text();
                        westPTSArr.add(westPTS);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //West Goals
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("div.tablegroupbytitle.tablegroup2 tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide12:nth-of-type(9)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        westGF = row.select(".hide12:nth-of-type(9)").text();
                        westGFArr.add(westGF);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //West Goals Against
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("div.tablegroupbytitle.tablegroup2 tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide12:nth-of-type(10)").text().equals("")) {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        westGA = row.select(".hide12:nth-of-type(10)").text();
                        westGAArr.add(westGA);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //West Last 10 Games
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("div.tablegroupbytitle.tablegroup2 tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide1.fullrecords:nth-of-type(13)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        westLast10 = row.select(".hide1.fullrecords:nth-of-type(13)").text();
                        westLast10Arr.add(westLast10);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //West Streak
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("div.tablegroupbytitle.tablegroup2 tr"))
                {
                    //Skip empty rows
                    if (row.select(".hide12:nth-of-type(14)").text().equals(""))
                    {
                        continue;
                    }
                    //Add the desired data
                    else
                    {
                        westStreak = row.select(".hide12:nth-of-type(14)").text();
                        westStreakArr.add(westStreak);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Arrays of objects that get converted from ArrayLists to Arrays
            Object[] eastTeamList = eastTeamArr.toArray();
            Object[] eastGPList = eastGPArr.toArray();
            Object[] eastWinsList = eastWArr.toArray();
            Object[] eastLossesList = eastLArr.toArray();
            Object[] eastOTList = eastOTArr.toArray();
            Object[] eastPointsList = eastPTSArr.toArray();
            Object[] eastGoalsList = eastGFArr.toArray();
            Object[] eastGAList = eastGAArr.toArray();
            Object[] eastL10List = eastLast10Arr.toArray();
            Object[] eastStreakList = eastStreakArr.toArray();
            Object[] westTeamList = westTeamArr.toArray();
            Object[] westGPList = westGPArr.toArray();
            Object[] westWinsList = westWArr.toArray();
            Object[] westLossesList = westLArr.toArray();
            Object[] westOTList = westOTArr.toArray();
            Object[] westPointsList = westPTSArr.toArray();
            Object[] westGoalsList = westGFArr.toArray();
            Object[] westGAList = westGAArr.toArray();
            Object[] westL10List = westLast10Arr.toArray();
            Object[] westStreakList = westStreakArr.toArray();

            //Each for loop concatenates each item from the tables from the website
            //And ends the line twice for formatting neatness
            for(Object rank : eastRankArr)
                eastRankLst += rank + "\r\n\n";

            for(Object team : eastTeamList)
                eastTeamLst += team + "\r\n\n";

            for(Object gp : eastGPList)
                eastGPLst += gp + "\r\n\n";

            for(Object win : eastWinsList)
                eastWLst += win + "\r\n\n";

            for(Object loss : eastLossesList)
                eastLLst += loss + "\r\n\n";

            for(Object ot : eastOTList)
                eastOTLst += ot + "\r\n\n";

            for(Object point : eastPointsList)
                eastPTSLst += point + "\r\n\n";

            for(Object goal : eastGoalsList)
                eastGFLst += goal + "\r\n\n";

            for(Object goalA : eastGAList)
                eastGALst += goalA + "\r\n\n";

            for(Object L10 : eastL10List)
                eastLast10Lst += L10 + "\r\n\n";

            for(Object streak : eastStreakList)
                eastStreakLst += streak + "\r\n\n";

            for(Object rank : westRankArr)
                westRankLst += rank + "\r\n\n";

            for(Object team : westTeamList)
                westTeamLst += team + "\r\n\n";

            for(Object gp : westGPList)
                westGPLst += gp + "\r\n\n";

            for(Object win : westWinsList)
                westWLst += win + "\r\n\n";

            for(Object loss : westLossesList)
                westLLst += loss + "\r\n\n";

            for(Object ot : westOTList)
                westOTLst += ot + "\r\n\n";

            for(Object point : westPointsList)
                westPTSLst += point + "\r\n\n";

            for(Object goal : westGoalsList)
                westGFLst += goal + "\r\n\n";

            for(Object goalA : westGAList)
                westGALst += goalA + "\r\n\n";

            for(Object L10 : westL10List)
                westLast10Lst += L10 + "\r\n\n";

            for(Object streak : westStreakList)
                westStreakLst += streak + "\r\n\n";

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
            eastRanks.setText(eastRankLst);
            eastTeams.setText(eastTeamLst);
            eastGames.setText(eastGPLst);
            eastWins.setText(eastWLst);
            eastLosses.setText(eastLLst);
            eastOvertimeLosses.setText(eastOTLst);
            eastPoints.setText(eastPTSLst);
            eastGoals.setText(eastGFLst);
            eastGoalsAgainst.setText(eastGALst);
            eastL10s.setText(eastLast10Lst);
            eastStreaks.setText(eastStreakLst);

            westRanks.setText(westRankLst);
            westTeams.setText(westTeamLst);
            westGames.setText(westGPLst);
            westWins.setText(westWLst);
            westLosses.setText(westLLst);
            westOvertimeLosses.setText(westOTLst);
            westPoints.setText(westPTSLst);
            westGoals.setText(westGFLst);
            westGoalsAgainst.setText(westGALst);
            westL10s.setText(westLast10Lst);
            westStreaks.setText(westStreakLst);
        }
    }
}
