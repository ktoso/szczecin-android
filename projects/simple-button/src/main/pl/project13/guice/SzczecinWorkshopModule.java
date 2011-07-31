package pl.project13.guice;

import roboguice.config.AbstractAndroidModule;
import roboguice.inject.SharedPreferencesName;

/**
 * @author Konrad Malawski
 */
public class SzczecinWorkshopModule extends AbstractAndroidModule {

  @Override
  protected void configure() {

    // BUG need a better way to set default preferences context
    bindConstant().annotatedWith(SharedPreferencesName.class).to("pl.project13");
  }
}
