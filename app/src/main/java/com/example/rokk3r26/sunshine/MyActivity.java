package com.example.rokk3r26.sunshine;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MyActivity extends ActionBarActivity {

  public final String LOG_TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new ForecastFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()){
        case R.id.action_settings:
          startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
          break;
        case R.id.action_map:
          openPreferredLocationInMap();
          break;
      }
      return super.onOptionsItemSelected(item);
    }

  private void openPreferredLocationInMap() {
    SharedPreferences sharedPrefs =
        PreferenceManager.getDefaultSharedPreferences(this);
    String location = sharedPrefs.getString(
        getString(R.string.pref_location_key),
        getString(R.string.pref_location_default));

    // Using the URI scheme for showing a location found on a map.  This super-handy
    // intent can is detailed in the "Common Intents" page of Android's developer site:
    // http://developer.android.com/guide/components/intents-common.html#Maps
    Uri geoLocation = Uri.parse("geo:0,0?").buildUpon()
        .appendQueryParameter("q", location)
        .build();

    Intent intent = new Intent(Intent.ACTION_VIEW);
    intent.setData(geoLocation);

    if (intent.resolveActivity(getPackageManager()) != null) {
      startActivity(intent);
    } else {
      Log.d(LOG_TAG, "Couldn't call " + location + ", no receiving apps installed!");
    }
  }
}
