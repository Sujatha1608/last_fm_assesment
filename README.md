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

This project contains two screens. First screen contains Get Data Button, 
If we click on that button navigate to next Activity. 
In Second Screen calling the public api using retrofit and display the list of
data in recycler view. The data contains title and body.