package pl.llp;

import android.widget.Button;
import android.widget.TextView;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.*;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author Konrad Malawski
 */
@RunWith(RobolectricTestRunner.class)
public class ButtonActivityTest {

  private ButtonActivity activity;

  private Button button = (Button) activity.findViewById(R.id.main_button);
  private TextView helloText = (TextView) activity.findViewById(R.id.hello_text);
  private TextView whomToHelloEditText = (TextView) activity.findViewById(R.id.whom_to_hello_edit_text);


  @Before
  public void setUp() throws Exception {
    activity = new ButtonActivity();
    activity.onCreate(null);
  }

  @Test
  public void shouldHaveApplicationName() throws Exception {
    String appName = activity.getResources().getString(R.string.app_name);
    assertThat(appName, equalTo("simple-button"));
  }

  @Test
  public void shouldSayHelloForEmptyName() throws Exception {
    // when
    button.performClick();
    whomToHelloEditText.setText("");

    // then
    String textValue = String.valueOf(helloText.getText());
    assertThat(textValue, containsString("Hello!"));
  }

  @Test
  public void shouldSayHelloSzczecin() throws Exception {
    // when
    button.performClick();
    whomToHelloEditText.setText("Szczecin");

    // then
    String textValue = String.valueOf(helloText.getText());
    assertThat(textValue, containsString("Hello Szczecin!"));
  }

  @Test
  public void shouldHideButton() throws Exception {
    // when
    button.performClick();
    Thread.sleep(100);

    // then
    assertThat(button.isEnabled(), is(false));
  }
}