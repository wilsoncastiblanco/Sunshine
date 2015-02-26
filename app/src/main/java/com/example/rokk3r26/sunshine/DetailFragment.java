package com.example.rokk3r26.sunshine;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wilsoncastiblanco on 2/25/15.
 */
public class DetailFragment extends Fragment{

  public DetailFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
    return rootView;
  }
}
