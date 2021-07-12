# viaplay-android-test
Android test for Viaplay

Built using recommended MVVM patterns from Google. Dependencies include:

* LiveData for lifecycle aware bindings between VM and view.
* Room for local persistence
* Retrofit together with Kotlin coroutines for network calls
* Kotlin Flow for observations in the data and api layer
* Jetpack Navigation for handling in-app navigation
* Hilt for dependency injection

The app contains both offline and online support, but data needs to be synced online first in order for it to work offline.
The views listen to database changes and so do not depend on the api calls in future sessions (but the latest data is always fetched and replaced in the DB if possible).
