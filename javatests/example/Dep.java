package example;

import static com.google.common.base.Preconditions.checkArgument;

final class Dep {
  public static void go() {
    // checkArgument(boolean, String, int) is not in guava 19.0
    checkArgument(true, "an int:  %s", 1234);
  }

  enum Color {red};
}