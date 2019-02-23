package org.assertj.swing.testng.examples.getting_started;

import org.assertj.swing.aut.getting_started.SimpleCopyApplication;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.testng.testcase.AssertJSwingTestngTestCase;
import org.testng.annotations.Test;

public class SimpleCopyApplication_UseBaseTest extends AssertJSwingTestngTestCase {
  private FrameFixture window;

  @Override
  protected void onSetUp() {
    SimpleCopyApplication frame = GuiActionRunner.execute(() -> new SimpleCopyApplication());
    // IMPORTANT: note the call to 'robot()'
    // we must use the Robot from AssertJSwingTestngTestCase
    window = new FrameFixture(robot(), frame);
    window.show(); // shows the frame to test
  }

  @Test
  public void shouldCopyTextInLabelWhenClickingButton() {
    window.textBox("textToCopy").enterText("Some random text");
    window.button("copyButton").click();
    window.label("copiedText").requireText("Some random text");
  }
}
