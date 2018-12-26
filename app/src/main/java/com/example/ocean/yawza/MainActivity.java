package com.example.ocean.yawza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    String[] data = {"Finger Play", "Entertainment news",
                     "Sports news", "Tap game",
                      "Stock market", "Converter"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = findViewById(R.id.listViewID);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                                 android.R.layout.simple_list_item_1, data);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    Intent tainment = new Intent(view.getContext(), Entertainment.class);
                    startActivity(tainment);
                }

                if (position == 3) {
                    Intent tap = new Intent(view.getContext(), Tapper.class);
                    startActivity(tap);
                }
                Toast.makeText(MainActivity.this, data[position],
                        Toast.LENGTH_SHORT).show();
            }
        });
    } // end of on create

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Toast.makeText(getApplicationContext(), "About Yawza", Toast.LENGTH_SHORT).show();
                break;

            case R.id.help:
                Toast.makeText(getApplicationContext(), "Get help", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
} // end of main class
