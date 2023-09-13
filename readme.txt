Demonstrating that a project depending on wicket-util
(which DOES require JUnit in /src/main/java) cannot be started
in Eclipse IDE (up from 2022+):


=========================================================================================================
Case: Leaving <scope>test</scope> for JUnit and not adding requires org.junit.jupiter.api in module-info
=========================================================================================================

- TestFromMain.java > Run As...

    The class compiles, but doesn't start:
	Error occurred during initialization of boot layer
	java.lang.module.FindException: Module org.junit.jupiter.api not found, required by org.apache.wicket.util

- TestFromTest.java > Run As...

    The class is marked red and doesn't compile:
	java.lang.Error: Unresolved compilation problem: "The type org.junit.jupiter.api.Test is not accessible"  

- Project > Run As JUnit Test

    This leads to the following error:
	java.lang.IllegalAccessError: class org.junit.platform.launcher.core.ServiceLoaderRegistry (in unnamed module @0x5f341870) cannot access class org.junit.platform.commons.logging.LoggerFactory (in module org.junit.platform.commons) because module org.junit.platform.commons does not export org.junit.platform.commons.logging to unnamed module @0x5f341870
		at org.junit.platform.launcher.core.ServiceLoaderRegistry.<clinit>(ServiceLoaderRegistry.java:27)
		at org.junit.platform.launcher.core.LauncherFactory.<clinit>(LauncherFactory.java:66)
		at org.eclipse.jdt.internal.junit5.runner.JUnit5TestLoader.<init>(JUnit5TestLoader.java:37)
		at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
		...

- mvn test

	This works, showing that the error is in Eclipse only

	
======================================================================================================
Case: Removing <scope>test</scope> for JUnit and adding requires org.junit.jupiter.api in module-info
(!!! normally, JUnit code should be part of/run in /src/main/java !!!)
======================================================================================================

Then this works for me:
  - TestFromMain.java > Run As...
  - TestFromTest.java > Run As...
  - mvn test
  
But "Run As JUnit Test" leads to the following error:

	java.lang.IllegalAccessError: class org.junit.platform.launcher.core.ServiceLoaderRegistry (in unnamed module @0x5f341870) cannot access class org.junit.platform.commons.logging.LoggerFactory (in module org.junit.platform.commons) because module org.junit.platform.commons does not export org.junit.platform.commons.logging to unnamed module @0x5f341870
		at org.junit.platform.launcher.core.ServiceLoaderRegistry.<clinit>(ServiceLoaderRegistry.java:27)
		at org.junit.platform.launcher.core.LauncherFactory.<clinit>(LauncherFactory.java:66)
		at org.eclipse.jdt.internal.junit5.runner.JUnit5TestLoader.<init>(JUnit5TestLoader.java:37)
		at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
		at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:77)
		at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
		at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:499)
		at java.base/java.lang.reflect.ReflectAccess.newInstance(ReflectAccess.java:128)
		at java.base/jdk.internal.reflect.ReflectionFactory.newInstance(ReflectionFactory.java:347)
		at java.base/java.lang.Class.newInstance(Class.java:645)
		at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.createRawTestLoader(RemoteTestRunner.java:371)
		at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.createLoader(RemoteTestRunner.java:366)
		at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.defaultInit(RemoteTestRunner.java:310)
		at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.init(RemoteTestRunner.java:225)
		at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:209)
