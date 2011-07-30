package pl.project13;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.maps.MapView;

public class GPSActivity extends Activity {

  private MapView map;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    map = (MapView) findViewById(R.id.map_view);

    // find location
    LocationManager mLocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    LocationListener mLocListener = new MyLocationListener();

    mLocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mLocListener);
  }

  private class MyLocationListener implements LocationListener {
    @Override
    public void onLocationChanged(Location location) {
      location.getLatitude();

      location.getLongitude();

      String text = "I'm currently at: " +
          "Latitude = " + location.getLatitude() +
          "Longitude = " + location.getLongitude();


      Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();


    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
    }

    @Override
    public void onProviderEnabled(String s) {
      Toast.makeText(getApplicationContext(),
                     "Gps Enabled",
                     Toast.LENGTH_SHORT)
           .show();
    }

    @Override
    public void onProviderDisabled(String s) {
      Toast.makeText(getApplicationContext(),
                     "Gps Disabled",
                     Toast.LENGTH_SHORT)
           .show();
    }
  }
}
