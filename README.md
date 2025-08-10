# Kotlin News API App

**Kotlin News API** is a simple Android application demonstrating how to fetch and display news articles using the [NewsAPI](https://newsapi.org/).  
The app is written in Kotlin and uses **Retrofit**, **Moshi**, **Glide**, and **ViewPager2** to build a minimal news reader.  
Users enter their name on the launch screen, navigate to a tabbed home screen, and browse a list of top headlines.

## Features

- **Login Screen** – Enter your name to personalise the session.
- **Tabbed Home Screen** – Two tabs: **News** (top headlines) and **Profile**.
- **Top Headlines** – Fetch news via Retrofit from NewsAPI.org.
- **News Details** – Tap an article to view its details, including image and description.
- **Image Loading** – Glide for smooth and efficient image display.
- **RecyclerView** – Display articles in a scrollable list.

## Tech Stack

- **Language**: Kotlin
- **Networking**: Retrofit + Moshi
- **Image Loading**: Glide
- **UI**: RecyclerView, ViewPager2, TabLayout
- **Architecture**: Basic MVVM pattern

## Project Structure

```
app/
 ├── api/       # Retrofit service interface
 ├── model/     # Data models (Article, NewsData)
 ├── ui/        # Activities, Fragments, Adapters
 ├── utils/     # Utility classes
```

## Getting Started

### Prerequisites
- Android Studio Iguana or newer
- JDK 17+
- A valid NewsAPI.org API key

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/bellashrns/kotlin_newsapi.git
   ```
2. Open in Android Studio.
3. Add your **NewsAPI** key to `NewsApiService.kt`:
   ```kotlin
   @GET("top-headlines")
   suspend fun getTopHeadlines(
       @Query("country") country: String = "us",
       @Query("apiKey") apiKey: String = "YOUR_API_KEY"
   ): Response<NewsData>
   ```
4. Sync the project with Gradle.

### Run the App
- Build and run on a device or emulator with internet access.
