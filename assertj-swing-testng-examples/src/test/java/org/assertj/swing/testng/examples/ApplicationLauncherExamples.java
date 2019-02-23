package org.assertj.swing.testng.examples;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.swing.testng.util.Assumptions.assumeThat;

import org.assertj.swing.aut.main.SystemPropertiesStore;
import org.assertj.swing.aut.util.SystemPropertiesUtil;
import org.assertj.swing.testng.SwingTestNGExamples;
import org.assertj.swing.launcher.ApplicationLauncher;
import org.testng.annotations.Test;

/** Tests that you can run an application with AssertJ - without UI. */
public class ApplicationLauncherExamples extends SwingTestNGExamples {

  @Override
  protected void onSetUp() {
    // precondition - when not executed, the system properties are null
    SystemPropertiesStore.setProperties(null);
  }

  @Test
  public void application_launching_without_arguments_example() {
    assumeThat(SystemPropertiesStore.getProperties()).isNull();

    // start application
    ApplicationLauncher.application(SystemPropertiesStore.class).start();
    // check result of running application
    assertThat(SystemPropertiesStore.getProperties()).isEmpty();
  }

  @Test
  public void application_launching_with_arguments_example() {
    assumeThat(SystemPropertiesStore.getProperties()).isNull();

    String[] arguments = new String[] { "java.version", "line.separator", "os.arch", "os.name", "os.version" };

    // start application
    ApplicationLauncher.application(SystemPropertiesStore.class).withArgs(arguments).start();
    // check result of running application
    assertThat(SystemPropertiesStore.getProperties()).isEqualTo(SystemPropertiesUtil.fetchProperties(arguments));
  }
}
