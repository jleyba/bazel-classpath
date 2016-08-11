java_library(
  name = "Dep",
  srcs = ["Dep.java"],
  deps = [
    "@guava//jar",  # This is a snapshot of guava 20.0
  ],
)

java_test(
  name = "ExampleTest",
  srcs = ["ExampleTest.java"],
  deps = [
    # There is a hidden dependency on
    # bazel_tools/tools/jdk/TestRunner_deploy.jar, which includes guava 19.0
    #
    # Since TestRunner_deploy.jar is loaded before :Dep, which has a dependency
    # on guava 20.0-SNAPSHOT, any references to 20.0 APIs in :Dep will fail at
    # runtime.
    ":Dep",
    "@hamcrest_core//jar",
    "@junit//jar",
  ],
)