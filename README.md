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

![screenshot1_scaled](https://user-images.githubusercontent.com/6271062/62344130-6b89bc80-b50a-11e9-8e07-f061b8e2a793.png)
![screenshot2_scaled](https://user-images.githubusercontent.com/6271062/62344129-6af12600-b50a-11e9-9926-ca7eb9e2827f.png)



