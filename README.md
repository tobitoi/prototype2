# prototype2
boilerplate mvp android


### Requirement for Smartphone
    Min SDK Version 16
    Target SDK Version 25
    Check the compileSdkVersion, and buildToolsVersion to be the latest
    Build Tools Version 25.0.2
    Java 1.7

### Technology Stack (Both Smartphone)
- [Android Support Design](https://developer.android.com/topic/libraries/support-library/features.html)
- [Realm Database](https://realm.io/)
- [Fabric SDK](https://fabric.io)
- [Dagger 2](https://google.github.io/dagger/)
- [RxAndroid](https://github.com/ReactiveX/RxAndroid)
- [Retrofit 2](https://square.github.io/retrofit/)
- [Jackson Converter](http://wiki.fasterxml.com/JacksonHome)
- [Retrofit 2 RxJava Adapter](https://github.com/square/retrofit/tree/master/retrofit-adapters/rxjava)
- [OkHttp 3](http://square.github.io/okhttp/)
- [OkHttp 3 - Logging Interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor)
- [Parceler](https://github.com/johncarl81/parceler)
- [Glide](https://github.com/bumptech/glide)

### Technology Stack (Smartphone) :
- [ButterKnife](http://jakewharton.github.io/butterknife/)
- [RxJava](https://github.com/ReactiveX/RxJava)

### Support Libraries
- [Joda Time](http://www.joda.org/joda-time/)
- [CircleImageView](https://github.com/hdodenhof/CircleImageView)
- [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart)
- [SectionedRecyclerViewAdapter](https://github.com/luizgrp/SectionedRecyclerViewAdapter)

### Unit Test
- [jUnit](http://junit.org/junit4/)
- [Mockito](http://site.mockito.org/)

### Instrumentation Test
- [Android Support Test Runner](https://google.github.io/android-testing-support-library/downloads/)
- [Espresso](https://google.github.io/android-testing-support-library/docs/espresso/)

### Step to Build Smartphone Module
* Run the following command to build the **Development** Environment with **DEBUG** mode
```./gradlew assembleDevelopmentDebug```

* Run the following command to build the **Development** Environment with **RELEASE** mode
```./gradlew assembleDevelopmentRelease```

* Run the following command to build the **Production** Environment with **DEBUG** mode
```./gradlew assembleProductionDebug```

* Run the following command to build the **Production** Environment with **RELEASE** mode
```./gradlew assembleProductionRelease```

### Step to Build Tablet Module
* Run the following command to build the **Development** Environment with **DEBUG** mode
```./gradlew assembleDevelopmenttabletDebug```

* Run the following command to build the **Development** Environment with **RELEASE** mode
```./gradlew assembleDevelopmenttabletRelease```

* Run the following command to build the **Production** Environment with **DEBUG** mode
```./gradlew assembleProductiontabletDebug```

* Run the following command to build the **Production** Environment with **RELEASE** mode
```./gradlew assembleProductiontabletRelease```

## Naming Convention
* Icon - ```ic_<your_icon>```
* Drawable - ```bg_<your_drawable>```
* Activity Layout - ```activity_<your_activity>```
* Fragment Layout - ```fragment_<your_activity>```
* Dialog Fragment Layout - ```dialog_<your_activity>```
* Adapter/List Layout - ```item_<your_item>
