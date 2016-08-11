# bazel-classpath
Demonstrates a bazel classpath pollution bug

## Passing Test

```
$ bazel info | grep "release: "
release: release head (@a9d4107)

$ bazel test javatests/example:all --test_output=errors
//javatests/example:ExampleTest                                 (cached) PASSED in 0.6s
```

## Failing Test

```
release: release 0.3.1

Test output for //javatests/example:ExampleTest:
JUnit4 Test Runner
.E
Time: 0.068
There was 1 failure:
1) test(example.ExampleTest)
java.lang.NoSuchMethodError: com.google.common.base.Preconditions.checkArgument(ZLjava/lang/String;Ljava/lang/Object;)V
  at example.Dep.go(Dep.java:7)
  at example.ExampleTest.test(ExampleTest.java:16)
  at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
  at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
  at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
  at java.lang.reflect.Method.invoke(Method.java:498)
  at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:47)
  at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
  at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:44)
  at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
  at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:271)
  at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:70)
  at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:50)
  at org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)
  at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)
  at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)
  at org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)
  at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)
  at org.junit.runners.ParentRunner.run(ParentRunner.java:309)
  at com.google.testing.junit.runner.junit4.CancellableRequestFactory$CancellableRunner.run(CancellableRequestFactory.java:89)
  at org.junit.runner.JUnitCore.run(JUnitCore.java:160)
  at org.junit.runner.JUnitCore.run(JUnitCore.java:138)
  at com.google.testing.junit.runner.junit4.JUnit4Runner.run(JUnit4Runner.java:114)
  at com.google.testing.junit.runner.BazelTestRunner.runTestsInSuite(BazelTestRunner.java:152)
  at com.google.testing.junit.runner.BazelTestRunner.main(BazelTestRunner.java:91)

FAILURES!!!
Tests run: 1,  Failures: 1


BazelTestRunner exiting with a return value of 1
JVM shutdown hooks (if any) will run now.
The JVM will exit once they complete.

-- JVM shutdown starting at 2016-08-11 17:43:19 --

================================================================================
INFO: Elapsed time: 6.764s, Critical Path: 1.24s
//javatests/example:ExampleTest                                          FAILED in 0.5s
```