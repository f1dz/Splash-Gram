## Splash-Gram

[![f1dz](https://circleci.com/gh/f1dz/Splash-Gram.svg?style=svg)](https://circleci.com/gh/f1dz/Splash-Gram)


This project was my submission for MADE class at Dicoding Academy.
You checkout the academy class here https://www.dicoding.com/academies/165

## Before you go
Before you are running the app, you should sign up to get an API ACCESS KEY on https://unsplash.com/developers and then rename file ```build_config.example.gradle``` into ```build_config.gradle```.

Change ```ACCESS_KEY``` with yours and change ```YOUR_DB_SECRET``` as you wish to encrypt the database.
```gradle
android {
    defaultConfig {
        buildConfigField "String", "BASE_URL", "\"https://api.unsplash.com/\""
        buildConfigField "String", "CLIENT_ID", "\"ACCESS_KEY\""
        buildConfigField "String", "SECRET", "\"YOUR_DB_SECRET\""
    }
}
```
and then do build

## Unsplash API
For demo tier we only got 50 request per hour and then the metrics will be updated every 20 minutes.

## To do
- [ ] Add download feature
- [ ] Add Copyright
- [ ] Ability to view portrait photo
- [ ] Add set as home background
- [ ] Explore user photo
- [ ] Add alt description
- [ ] Pull to refresh


## Disclaimer
Please use this repository for learning purpose, any plagiarism activity will hurt yourself. 

🔥🔥 **STOP PLAGIARISM!** 🔥🔥
