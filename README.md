# Sample Application

### Structure of the code ###
Simple Android Application written in Kotlin.
This project follows Clean Architecture with MVVM with Clean Architecture Design


# Main libraries used

* Data Binding
* Dagger2
* RxJava2
* Retrofit2
* Timber
* Glide
* Android Architecture component Jetpack

# Modules
* `data/` : contains the code to access to the data (repository pattern)
* `domain/` : contains the business logic and the usecases
* `app` : Presentation layer, contains the UI 


This App Contains 2 screens
First Screen contains user names search. 
Enter the user name and click the Search button then call the api and 
display the list of users in recyclerview.
When click on list items user data is displayed from the api.
