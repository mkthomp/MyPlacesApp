package edu.asu.bsse.mkthomp.myplacesapp;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.asu.bsse.mkthomp.myplacesapp.PlaceDescription;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    private ListView placesList;
    private PlaceDescription place;
    private PlaceLibrary places;

    private String[] labels;
    private int[] ids;
    //private List<HashMap<String, String>> fillMaps;
    private ArrayList<String> fillMaps;

    private String[] placeNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.util.Log.d(this.getCallingPackage(), "testing");

        placesList = (ListView)findViewById(R.id.placeListView);

        try {
            places = new PlaceLibrary(this);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        this.prepareAdapter();
        ArrayAdapter aa = new ArrayAdapter(this, R.layout.activity_main, fillMaps);
        placesList.setAdapter(aa);
        placesList.setOnItemClickListener(this);
    }


    public void setLocation(View view) {

    }

    private void prepareAdapter(){
//        labels = this.getResources().getStringArray(R.array.col_header);
//        ids = new int[] {R.id.student_firstTV, R.id.student_lastTV, R.id.student_idTV};
        this.placeNames = places.getNames();
        Arrays.sort(this.placeNames);
        fillMaps = new ArrayList<String>();
//        fillMaps = new ArrayList<HashMap<String,String>>();
//        HashMap<String,String> titles = new HashMap<>();
//        // first row contains column headers
//        titles.put("First","First");
//        titles.put("Last","Last");
//        titles.put("Id","Id");
//        fillMaps.add(titles);
        // fill in the remaining rows with first last and student id.
        for (int i = 0; i < placeNames.length; i++) {
//            String[]firstNLast = placeNames[i].split(" ");
//            HashMap<String,String> map = new HashMap<>();
//            Log.d(this.getClass().getSimpleName(),"mapping: "+firstNLast[0]+" "+firstNLast[1]);
//            map.put("First", firstNLast[0]);
//            map.put("Last", firstNLast[1]);
//            map.put("Id", ((Integer)places.get(this.placeNames[i]).studentid).toString());
//            android.util.Log.w(this.getClass().getSimpleName(),placeNames[i]+" has  id "+
//                    ((Integer)places.get(this.placeNames[i]).studentid).toString());
            fillMaps.add(placeNames[i]);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}