package pl.project13;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import roboguice.activity.RoboPreferenceActivity;

/**
 * @author Konrad Malawski
 */
public class SettingsActivity extends RoboPreferenceActivity {

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    addPreferencesFromResource(R.xml.preference);
  }
}