package pl.project13;

import android.os.Bundle;
import android.widget.Toast;
import roboguice.activity.RoboListActivity;

/**
 * @author Konrad Malawski
 */
public class TasksActivity extends RoboListActivity {

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    String username = savedInstanceState.getString("username");

    Toast.makeText(this, "Hello " + username + ", from " + this.getClass().getSimpleName(), Toast.LENGTH_LONG).show();
  }
}