Adson - Control Flow - Android Library
=======

## Installation
1. Open Android project.
2. Open your root **build.gradle** and add JitPack to *repositories* section:
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
3. Open your app **build.gradle** and add lib to the *dependencies* section
```gradle
dependencies {
    ...
    implementation 'com.github.Adson-admin:android_control_flow:1.0.0'
}
```
4. Wait until sync process finished.

Congratulations! Now you can use the library!

## Usage

Firstly you need to create a `ControlProvider` instance:
```java
ControlProvider controlProvider = new ControlProvider.Builder().buildAdsonStub();
```

### Return control to **Adson Stub** application

To open Adson application and notify it with specific action use `OpenContentCommand`:
```java
// Setup Open action
int contentId = 37 // You can get it from XML file.
OpenContentAction action = new OpenContentAction(contentId, OpenContentActionType.TEXT);

// Intantiate Open command
OpenContentCommand command = new OpenContentCommand(action);

// Execute command
controlProvider.open(this.getActivity(), command);
```

Available action types:

```java
public enum OpenContentActionType {
    NONE,
    TEXT,
    PHONE
}
```

### Handle **XML** file path from **Adson Stub** application

1. Open **AndroidManifest.xml** file, find an activity that should handle events and add there an intent-filter:

```xml
<intent-filter>
    <action android:name="android.intent.action.VIEW" />

    <category android:name="android.intent.category.DEFAULT" />
    <category android:name="android.intent.category.BROWSABLE" />

    <data android:scheme="apostera" />
    <data android:host="update-content"/>
</intent-filter>
```

1. Open class of your handle activity and add this to `onCreate` method:

```java
Intent intent = getIntent();
if (intent == null) { return; }

ContentLocation action = controlProvider.handle(intent, ContentLocation.class);
if (action != null) {
    String xmlPath = action.getContentFilePath();
    // Do your processing here
}
```