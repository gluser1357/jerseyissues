Demonstrating that a project depending on wicket-util
(which DOES require JUnit in /src/main/java) cannot be started
in Eclipse IDE (up from 2022+):

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
