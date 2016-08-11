package example;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * this works with bazel release: release head (@a9d4107)
 */
@RunWith(JUnit4.class)
public final class ExampleTest {
  @Test
  public void test() {
    Dep.go();
  }
}