package com.udacity.gradle.builditbigger;

import static br.bosseur.jokelibrary.JokeFragment.ARG_JOKE;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import br.bosseur.jokelibrary.JokeActivity;


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

    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  public void tellJoke(View view) {

    new EndpointsAsyncTask(this).execute(this);

  }


  @Override
  public void tellJoke(String joke) {
    if (!TextUtils.isEmpty(joke)) {
      Intent intent = new Intent(this, JokeActivity.class);
      intent.putExtra(ARG_JOKE, joke);
      startActivity(intent);
    }

  }
}
