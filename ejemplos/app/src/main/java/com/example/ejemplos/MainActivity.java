package com.example.ejemplos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView coursesGV;
    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};

    String[] courses = { "C", "Data structures",
            "Interview prep", "Algorithms",
            "DSA with java", "OS" };

    String[] tiempo = {"12:00", "13:00", "14:00", "15:00", "14:00"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initiating the tabhost
        TabHost tabhost = (TabHost) findViewById(R.id.tabhost);

        // setting up the tab host
        tabhost.setup();

        // Code for adding Tab 1 to the tabhost
        TabHost.TabSpec spec = tabhost.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);

        // setting the name of the tab 1 as "Tab One"
        spec.setIndicator("List view ejemplo");

        // adding the tab to tabhost
        tabhost.addTab(spec);

        // Code for adding Tab 2 to the tabhost
        spec = tabhost.newTabSpec("Grid View ejemplo");
        spec.setContent(R.id.tab2);

        // setting the name of the tab 1 as "Tab Two"
        spec.setIndicator("Grid View");
        tabhost.addTab(spec);

        // Code for adding Tab 3 to the tabhost
        spec = tabhost.newTabSpec("Relative view ejemplo");
        spec.setContent(R.id.tab3);

        spec.setIndicator("Relative view ejemplo");
        tabhost.addTab(spec);


        ///se llena el primer tab
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, mobileArray);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

        //se llena el segundo tab
        coursesGV = findViewById(R.id.idGVcourses);

        ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();
        courseModelArrayList.add(new CourseModel("DSA", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new CourseModel("JAVA", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new CourseModel("C++", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new CourseModel("Python", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new CourseModel("Javascript", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new CourseModel("DSA", R.drawable.ic_launcher_background));

        CourseGVAdapter adapter2 = new CourseGVAdapter(this, courseModelArrayList);
        coursesGV.setAdapter(adapter2);
        //tab 3 spinners
        //spiner1
        Spinner spino = findViewById(R.id.dates);

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, courses);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spino.setAdapter(ad);
        //spiner2
        Spinner spino2 = findViewById(R.id.times);

        ArrayAdapter ad2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, tiempo);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spino2.setAdapter(ad2);
    }
}