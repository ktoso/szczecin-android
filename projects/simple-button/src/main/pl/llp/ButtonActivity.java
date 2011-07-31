package pl.llp;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.animation.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ButtonActivity extends Activity {

  private Button button;
  private TextView text;
  private EditText greet;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    text = (TextView) findViewById(R.id.hello_text);
    greet = (EditText) findViewById(R.id.whom_to_hello_edit_text);

    button = (Button) findViewById(R.id.main_button);
    button.setOnClickListener(new View.OnClickListener() {
      public void onClick(View view) {
        Editable greetMe = greet.getText();
        String helloText = "Hello" + (greetMe.length() > 0 ? " " + greet : "") + "!";
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
}
