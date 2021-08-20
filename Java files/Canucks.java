/*******************************
 * Class Name: Canucks class
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

public class Canucks extends AppCompatActivity {

    //Canucks TextViews
    TextView players, positions, ages, games, points, goals, assists, evGoals, ppGoals, shGoals;
    TextView shots, shotPercents, tois, averageTois;

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
        setContentView(R.layout.activity_blue_jackets);

        //Canucks TextViews to link with XML
        players = (TextView) findViewById(R.id.playersList);
        positions = (TextView) findViewById(R.id.positionsList);
        ages = (TextView) findViewById(R.id.agesList);
        games = (TextView) findViewById(R.id.gpList);
        points = (TextView) findViewById(R.id.pointsList);
        goals = (TextView) findViewById(R.id.goalsList);
        assists = (TextView) findViewById(R.id.assistsList);
        evGoals = (TextView) findViewById(R.id.evGoalsList);
        ppGoals = (TextView) findViewById(R.id.ppGoalsList);
        shGoals = (TextView) findViewById(R.id.shGoalsList);
        shots = (TextView) findViewById(R.id.shotsList);
        shotPercents = (TextView) findViewById(R.id.shotPercentList);
        tois = (TextView) findViewById(R.id.toiList);
        averageTois = (TextView) findViewById(R.id.averageToiList);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Creates an instance of the getCanucksStats class and executes it
        new getCanucksStats().execute();
    }

    /**/
    /*
    NAME
        getCanucksStats
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
    public class getCanucksStats extends AsyncTask<Void, Void, Void> {
        String player, playerLst = "";
        ArrayList<String> playerArr = new ArrayList<String>();
        String position, positionLst = "";
        ArrayList<String> positionArr = new ArrayList<String>();
        String age, ageLst = "";
        ArrayList<String> ageArr = new ArrayList<String>();
        String game, gameLst = "";
        ArrayList<String> gameArr = new ArrayList<String>();
        String point, pointLst = "";
        ArrayList<String> pointArr = new ArrayList<String>();
        String goal, goalLst = "";
        ArrayList<String> goalArr = new ArrayList<String>();
        String assist, assistLst = "";
        ArrayList<String> assistArr = new ArrayList<String>();
        String ev, evLst = "";
        ArrayList<String> evArr = new ArrayList<String>();
        String pp, ppLst = "";
        ArrayList<String> ppArr = new ArrayList<String>();
        String sh, shLst = "";
        ArrayList<String> shArr = new ArrayList<String>();
        String shot, shotLst = "";
        ArrayList<String> shotArr = new ArrayList<String>();
        String percent, percentLst = "";
        ArrayList<String> percentArr = new ArrayList<String>();
        String toi, toiLst = "";
        ArrayList<String> toiArr = new ArrayList<String>();
        String averageToi, averageToiLst = "";
        ArrayList<String> averageToiArr = new ArrayList<String>();

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
            final String url = "https://www.hockey-reference.com/teams/VAN/";

            //Players
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table#skaters.sortable.stats_table tr"))
                {
                    //Skip empty rows
                    if(row.select(".left").text().equals(""))
                    {
                        continue;
                    }
                    //Skip unwanted data
                    else if(row.select(".left").text().equals("Player"))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        player = row.select(".left").text();
                        playerArr.add(player);
                    }
                }
                //Remove garbage values
                int playerIndex = playerArr.size() - 1;
                playerArr.remove(playerIndex);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            //Ages
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table#skaters.sortable.stats_table tr"))
                {
                    //Skip unwanted data
                    if(row.select(".center:nth-of-type(2)").text().equals("Scoring"))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        age = row.select(".center:nth-of-type(2)").text();
                        ageArr.add(age);
                    }
                }
                //Remove garbage values
                int ageIndex = ageArr.size() - ageArr.size();
                ageArr.remove(ageIndex);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            //Positions
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table#skaters.sortable.stats_table tr"))
                {
                    //Skip unwanted data
                    if(row.select(".center:nth-of-type(3)").text().equals("Goals"))
                    {
                        continue;
                    }
                    //Skip unwanted data
                    else if(row.select(".center:nth-of-type(3)").text().equals("Age"))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        position = row.select(".center:nth-of-type(3)").text();
                        positionArr.add(position);
                    }
                }
                //Remove garbage values
                int positionIndex = positionArr.size() - 1;
                positionArr.remove(positionIndex);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            //Games
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table#skaters.sortable.stats_table tr"))
                {
                    //Skip empty rows
                    if(row.select(".right:nth-of-type(4)").text().equals(""))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        game = row.select(".right:nth-of-type(4)").text();
                        gameArr.add(game);
                    }
                }
                //Remove garbage values
                int gameIndex = ageArr.size() - 1;
                gameArr.remove(gameIndex);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            //Points
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table#skaters.sortable.stats_table tr"))
                {
                    //Skip empty rows
                    if(row.select(".right:nth-of-type(7)").text().equals(""))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        point = row.select(".right:nth-of-type(7)").text();
                        pointArr.add(point);
                    }
                }
                //Remove garbage values
                int pointIndex = pointArr.size() - 1;
                pointArr.remove(pointIndex);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            //Goals
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table#skaters.sortable.stats_table tr"))
                {
                    //Skip empty rows
                    if(row.select(".right:nth-of-type(5)").text().equals(""))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        goal = row.select(".right:nth-of-type(5)").text();
                        goalArr.add(goal);
                    }
                }
                //Remove garbage values
                int goalIndex = goalArr.size() - 1;
                goalArr.remove(goalIndex);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            //Assists
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table#skaters.sortable.stats_table tr"))
                {
                    //Skip empty rows
                    if(row.select(".right:nth-of-type(6)").text().equals(""))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        assist = row.select(".right:nth-of-type(6)").text();
                        assistArr.add(assist);
                    }
                }
                //Remove garbage values
                int assistIndex = assistArr.size() - 1;
                assistArr.remove(assistIndex);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            //EVs
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table#skaters.sortable.stats_table tr"))
                {
                    //Skip empty rows
                    if(row.select(".right:nth-of-type(10)").text().equals(""))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        ev = row.select(".right:nth-of-type(10)").text();
                        evArr.add(ev);
                    }
                }
                //Remove garbage values
                int evIndex = evArr.size() - 1;
                evArr.remove(evIndex);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            //PPs
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table#skaters.sortable.stats_table tr"))
                {
                    //Skip empty rows
                    if(row.select(".right:nth-of-type(11)").text().equals(""))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        pp = row.select(".right:nth-of-type(11)").text();
                        ppArr.add(pp);
                    }
                }
                //Remove garbage values
                int ppIndex = ppArr.size() - 1;
                ppArr.remove(ppIndex);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            //SHs
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table#skaters.sortable.stats_table tr"))
                {
                    //Skip empty rows
                    if(row.select(".right:nth-of-type(12)").text().equals(""))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        sh = row.select(".right:nth-of-type(12)").text();
                        shArr.add(sh);
                    }
                }
                //Remove garbage values
                int shIndex = shArr.size() - 1;
                shArr.remove(shIndex);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            //Shots
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table#skaters.sortable.stats_table tr"))
                {
                    //Skip empty rows
                    if(row.select(".right:nth-of-type(17)").text().equals(""))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        shot = row.select(".right:nth-of-type(17)").text();
                        shotArr.add(shot);
                    }
                }
                //Remove garbage values
                int shotIndex = shotArr.size() - 1;
                shotArr.remove(shotIndex);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            //Percents
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table#skaters.sortable.stats_table tr"))
                {
                    //Skip empty rows
                    if(row.select(".right:nth-of-type(18)").text().equals(""))
                    {
                        percentArr.add("N/A");
                    }
                    //Add desired data
                    else
                    {
                        percent = row.select(".right:nth-of-type(18)").text();
                        percentArr.add(percent);
                    }
                }
                //Remove garbage values
                int percentIndex = percentArr.size() - 1;
                int firstIndex = percentArr.size() - percentArr.size();
                percentArr.remove(percentIndex);
                percentArr.remove(firstIndex);
                percentArr.remove(firstIndex);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            //TOIs
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table#skaters.sortable.stats_table tr"))
                {
                    //Skip empty rows
                    if(row.select(".right:nth-of-type(19)").text().equals(""))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        toi = row.select(".right:nth-of-type(19)").text();
                        toiArr.add(toi);
                    }
                }
                //Remove garbage values
                int firstIndex = percentArr.size() - percentArr.size();
                averageToiArr.remove(firstIndex);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            //Average TOIs
            try {
                //Gets the HTML from the url
                final Document doc = Jsoup.connect(url).get();
                //Checks every row in the desired table
                for (Element row : doc.select("table#skaters.sortable.stats_table tr"))
                {
                    //Skip empty rows
                    if(row.select(".right:nth-of-type(20)").text().equals(""))
                    {
                        continue;
                    }
                    //Add desired data
                    else
                    {
                        averageToi = row.select(".right:nth-of-type(20)").text();
                        averageToiArr.add(averageToi);
                    }
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            //Arrays of objects that get converted from ArrayLists to Arrays
            Object[] playerList = playerArr.toArray();
            Object[] posList = positionArr.toArray();
            Object[] ageList = ageArr.toArray();
            Object[] gameList = gameArr.toArray();
            Object[] pointList = pointArr.toArray();
            Object[] goalList = goalArr.toArray();
            Object[] assistList = assistArr.toArray();
            Object[] evList = evArr.toArray();
            Object[] ppList = ppArr.toArray();
            Object[] shList = shArr.toArray();
            Object[] shotList = shotArr.toArray();
            Object[] percentList = percentArr.toArray();
            Object[] toiList = toiArr.toArray();
            Object[] averageToiList = averageToiArr.toArray();

            //Each for loop concatenates each item from the tables from the website
            //And ends the line twice for formatting neatness
            for(Object name : playerList)
                playerLst += name + "\r\n\n";
            for(Object name : posList)
                positionLst += name + "\r\n\n";
            for(Object age : ageList)
                ageLst += age + "\r\n\n";
            for(Object game : gameList)
                gameLst += game + "\r\n\n";
            for(Object point : pointList)
                pointLst += point + "\r\n\n";
            for(Object goal: goalList)
                goalLst += goal + "\r\n\n";
            for(Object assist: assistList)
                assistLst += assist + "\r\n\n";
            for(Object ev: evList)
                evLst += ev + "\r\n\n";
            for(Object pp: ppList)
                ppLst += pp + "\r\n\n";
            for(Object sh: shList)
                shLst += sh + "\r\n\n";
            for(Object shot: shotList)
                shotLst += shot + "\r\n\n";
            for(Object percent: percentList)
                percentLst += percent + "\r\n\n";
            for(Object toi: toiList)
                toiLst += toi + "\r\n\n";
            for(Object averageToi: averageToiList)
                averageToiLst += averageToi + "\r\n\n";

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
            players.setText(playerLst);
            positions.setText(positionLst);
            ages.setText(ageLst);
            games.setText(gameLst);
            points.setText(pointLst);
            goals.setText(goalLst);
            assists.setText(assistLst);
            evGoals.setText(evLst);
            ppGoals.setText(ppLst);
            shGoals.setText(shLst);
            shots.setText(shotLst);
            shotPercents.setText(percentLst);
            tois.setText(toiLst);
            averageTois.setText(averageToiLst);
        }
    }
}
