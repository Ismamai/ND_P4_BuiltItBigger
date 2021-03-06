package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.iblesa.androidjoke.Constants;
import com.iblesa.androidjoke.MainJokeActivity;
import com.iblesa.javajokes.Joker;


public class MainActivity extends AppCompatActivity implements JokeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        new EndpointsAsyncTask(this).execute();

    }


    public void tellAndroidJoke(View view) {
        Joker joker = new Joker();
        String joke = joker.getJoke();
        startAndroidJokeActivity(joke);
    }

    private void startAndroidJokeActivity(String joke) {
        Intent intent = new Intent(this, MainJokeActivity.class);
        intent.putExtra(Constants.JOKE, joke);
        startActivity(intent);
    }

    @Override
    public void onJokeReceived(String joke) {
       startAndroidJokeActivity(joke);
    }
}
