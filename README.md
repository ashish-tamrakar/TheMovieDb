# The Movie DB application

In this project I am demonstrating the usage of The Movie DB free API to get the list of Movies and its details.

Here I have used Clean Architecture patten written in Kotlin. It uses [Jetpack's Paging component](https://developer.android.com/topic/libraries/architecture/paging/) to demonstrate endless scrolling using database + network.

## Libraries Used

1. **Clean Architecture**: Design an app using layered architecture based on [Clean Architecture by Uncle Bob](http://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html). 
2. **Paging library**: Learn how to use PagedList callbacks to coordinate between local database and fetching more data from network.
3. **Navigation component**: At last it's settled, single activity is what's Google recommend now. Navigation editor make things easy for us to design navigation path of our app. 
4. **Architecture components**: The good old tristar LiveData, ViewModel and Room.
5. **Kotlin**: We all love it. Learn how to use it to develop an Android app.
6. **Dagger 2**: Dependency injection help us to abstract the creation of a dependency. Dagger 2 further helps to manage the dependencies in an optimal way.
7. **Kept TMDB_API_KEY in gradle.properties**: For security of API Key, I kept API Key in gradle.properties so that it will be impossible to get it from APK file.
## Pre-requisites
Android Studio 3.2 or higher

## Screenshots of app -

![screenshot1_scaled](https://user-images.githubusercontent.com/6271062/62344305-1601df80-b50b-11e9-8fe5-f20f5b7a50a1.png)
![screenshot2_scaled](https://user-images.githubusercontent.com/6271062/62344304-1601df80-b50b-11e9-8f9e-80c8a9a102cb.png)




