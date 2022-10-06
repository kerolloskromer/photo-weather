## Installation
  - You should use your own API key from [Open Weather API](https://openweathermap.org/) and put it in `local.properties` file in project root folder along with 
  `BASE_URL="https://api.openweathermap.org/"`
  `API_KEY="beccc54953c5377f2321f8152b75ff0d"`

## Tech stack & Open-source libraries
  - FusedLocationAPI - for getting current location
  - Navigation component - navigation graph for navigating and replacing screens/fragments
  - ViewBinding - allows to more easily write code that interacts with views and replaces ```findViewById```.
  - ViewModel - UI related data holder, lifecycle aware.
  - LiveData - Build data objects that notify views when the underlying database changes.
  - Dagger-Hilt for dependency injection. Object creation and scoping is handled by Hilt.
  - Kotlin Coroutines + Flow - for managing background threads with simplified code and reducing needs for callbacks
  - Retrofit2 & OkHttp3 - to make REST requests to the web service integrated.
  - Room for database
  - Timber - for logs.
  - Mockito and JUnit - for Unit tests
  - Gradle Kotlin DSL
 
## Architecture:
  - Clean Architecture (Data - Domain - Presentation)
  - MVVM Architecture 
  - Repository Pattern
  - SOLID Principles

## Features
+ Capture photo with camera
+ Fetch weather info by your current location.
+ Add weather and location data as a banner overlay on top of the catured photo and save it as a new image
+ Share generated image to other apps like facebook and twitter

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details
