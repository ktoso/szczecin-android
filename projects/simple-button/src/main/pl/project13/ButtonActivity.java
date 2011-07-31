package pl.project13;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.inject.Inject;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class ButtonActivity extends RoboActivity {

  private final String TAG = getClass().getSimpleName();

  @InjectView(R.id.main_button)
  private Button button;
  @InjectView(R.id.hello_text)
  private TextView text;
  @InjectView(R.id.whom_to_hello_edit_text)
  private EditText greet;

  @Inject
  private SharedPreferences preferences;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

//    text = (TextView) findViewById(R.id.hello_text);
//    greet = (EditText) findViewById(R.id.whom_to_hello_edit_text);
//
//    button = (Button) findViewById(R.id.main_button);
    button.setOnClickListener(new View.OnClickListener() {
      public void onClick(View view) {
        Editable greetMe = greet.getText();
        String helloText = "Hello" + (greetMe.length() > 0 ? " " + greetMe : "") + "!";
        text.setText(helloText);
        button.setEnabled(false);
        hideButton();
      }
    });
  }

  private void hideButton() {
    AnimationSet as = new AnimationSet(true);

    AlphaAnimation fadeOut = new AlphaAnimation(1f, 0f);
    fadeOut.setDuration(500);
    as.addAnimation(fadeOut);


    TranslateAnimation moveLeft = new TranslateAnimation(0f, -500f, 0f, 0f);
    moveLeft.setDuration(500);
    as.addAnimation(moveLeft);

    as.setDuration(500);
    as.setAnimationListener(new Animation.AnimationListener() {
      public void onAnimationStart(Animation animation) {}

      public void onAnimationEnd(Animation animation) {
        button.setVisibility(View.GONE);
      }

      public void onAnimationRepeat(Animation animation) {}
    });

    button.startAnimation(as);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();

    inflater.inflate(R.menu.menu, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int itemId = item.getItemId();

    switch (itemId){
      case R.id.click_me_menu_item:
        break;
      default:
        Log.i(TAG, "Some weird action was requested");
    }

    return true;
  }
}
