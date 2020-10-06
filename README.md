## Splash-Gram
This project was my submission for MADE class at Dicoding Academy.
You checkout the academy class here https://www.dicoding.com/academies/165

## Before you go
Before you are running the app, you should sign up to get an API ACCESS KEY on https://unsplash.com/developers and then rename file ```build_config.example.gradle``` into ```build_config.gradle```.

Change ```ACCESS_KEY``` with yours
```gradle
android {
    defaultConfig {
        buildConfigField "String", "BASE_URL", "\"https://api.unsplash.com/\""
        buildConfigField "String", "CLIENT_ID", "\"ACCESS_KEY\""
    }
}
```
and then do build

## Unsplash API
For demo tier we only got 50 request per hour and then the metrics will be updated every 20 minutes.

## Disclaimer
Please use this repository for learning purpose, any plagiarism activity will hurt yourself. 
🔥🔥 **STOP PLAGIARISM!** 🔥🔥
