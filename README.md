# Description

Designed by [WeedleApps](https://weedleapps.co.il/en/), this library meant to pack the core essentiatls resources for building a modern android app. 

Designed in DI style with dagger 2.1.

# Specifications

- wrappers

- activity and fragment modules

- local repository handling

# Install

1) add the gradle dependency:

```compile 'com.github.osfunapps:weedle-android-core-library:v1.0.2' ```



2) add the library module **WeedleLibraryBuilder::class** to your app component.

Example:
```
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBuilder::class,
    WeedleLibraryBuilder::class])
```



3) in your Application file specify which elements you desire to use in the library.

Example:
```
 class App : DaggerApplication() {
  override fun onCreate() {
        WeedleLibInitializer.withFabric = false
        WeedleLibInitializer.sharedPrefsName = "itzik"   
        super.onCreate()     
    }
```

