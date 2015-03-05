package com.example.rokk3r26.sunshine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DetailActivity extends Activity {
  private final String KEY_DATA = "keyData";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);
    String data = getIntent().getStringExtra(KEY_DATA);
    if (savedInstanceState == null) {
      Bundle bundle = new Bundle();
      bundle.putString(KEY_DATA, data);
      getFragmentManager().beginTransaction()
          .add(R.id.container, DetailFragment.newInstance(bundle)).commit();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_detail, menu);
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
      startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
