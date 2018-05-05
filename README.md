# Description

This library meant to pack the core essentiatls resources for building a modern android app. 

Designed in DI style with dagger 2.1.

# Specifications

**wrappers

**activity and fragment modules

**local repository handling

# Install
First, add the library module WeedleLibraryBuilder::class to your app component.

Second, in your Application file select specify which elements you desire to use in the library.

Example:
<code> 
  
  class App : DaggerApplication() {
  
  override fun onCreate() {
  
        WeedleLibInitializer.withFabric = false
        
        WeedleLibInitializer.sharedPrefsName = "itzik"
        
        super.onCreate()
        
    }
</code>


