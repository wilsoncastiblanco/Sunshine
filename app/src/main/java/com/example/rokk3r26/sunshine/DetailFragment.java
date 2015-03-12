package com.example.rokk3r26.sunshine;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ShareActionProvider;
import android.widget.TextView;

/**
 * Created by wilsoncastiblanco on 2/25/15.
 */
public class DetailFragment extends Fragment{

  private String LOG_TAG = DetailFragment.class.getSimpleName();
  private String FORECAST_SHARE_HASHTAG = "#SunshineApp";
  private final String KEY_DATA = "keyData";

  private String mForecastString;

  TextView textViewWeather;

  public DetailFragment(){
    setHasOptionsMenu(true);
  }

  public static DetailFragment newInstance(Bundle bundle) {
    DetailFragment fragment = new DetailFragment();
    fragment.setArguments(bundle);
    return fragment;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
    textViewWeather = (TextView) rootView.findViewById(R.id.textViewWeather);
    mForecastString = this.getArguments().getString(KEY_DATA);
    textViewWeather.setText(mForecastString);
    return rootView;
  }

  @Override
  public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    // Inflate the menu; this adds items to the action bar if it is present.
    inflater.inflate(R.menu.detailfragment, menu);

    // Retrieve the share menu item
    MenuItem menuItem = menu.findItem(R.id.action_share);

    // Get the provider and hold onto it to set/change the share intent.
    ShareActionProvider mShareActionProvider =
        (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

    // Attach an intent to this ShareActionProvider.  You can update this at any time,
    // like when the user selects a new piece of data they might like to share.
    if (mShareActionProvider != null ) {
      mShareActionProvider.setShareIntent(createShareForecastIntent());
    } else {
      Log.d(LOG_TAG, "Share Action Provider is null?");
    }
  }

  private Intent createShareForecastIntent() {
    Intent shareIntent = new Intent(Intent.ACTION_SEND);
    shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
    shareIntent.setType("text/plain");
    shareIntent.putExtra(Intent.EXTRA_TEXT,
        mForecastString + FORECAST_SHARE_HASHTAG);
    return shareIntent;
  }
}
