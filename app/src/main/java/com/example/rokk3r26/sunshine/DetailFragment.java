package com.example.rokk3r26.sunshine;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wilsoncastiblanco on 2/25/15.
 */
public class DetailFragment extends Fragment{
  private final String KEY_DATA = "keyData";
  TextView textViewWeather;
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
    textViewWeather.setText(this.getArguments().getString(KEY_DATA));
    return rootView;
  }
}
