# 📱 Android Posts App

A simple yet scalable Android app built using **MVVM architecture** and **Clean Architecture principles**. The app fetches post data from a demo REST API using Retrofit and displays it in a RecyclerView. It also supports offline access using Room Database.

---

## 🚀 Features
- Fetch posts from [JSONPlaceholder API](https://jsonplaceholder.typicode.com/posts)
- Display posts in a RecyclerView
- Offline caching using Room Database
- MVVM + Clean Architecture
- Dependency injection with Dagger Hilt
- Unit testing with JUnit

---

## 🧱 Tech Stack
- **Kotlin**
- **MVVM** (Model-View-ViewModel)
- **Clean Architecture**
- **Retrofit** for network requests
- **Room** for local data persistence
- **Dagger Hilt** for Dependency Injection
- **Coroutines** for async operations
- **LiveData / StateFlow** for UI state
- **JUnit** for unit testing

---

## 📁 Package Structure
```
com.example.postsapp
│
├── data/                # Retrofit, Room, DTOs
├── domain/              # UseCases, Models, Repository Interfaces
├── presentation/        # UI (Activity/ViewModel/Adapter)
├── di/                  # Dagger Hilt modules
└── utils/               # Helpers, Mappers, etc.
```

---

## 🧪 Testing
- Unit tests for UseCases and ViewModels using **JUnit**

---

## 📦 API Used
- [https://jsonplaceholder.typicode.com/posts](https://jsonplaceholder.typicode.com/posts)

---

## 💡 How It Works
1. App fetches posts from API via Repository & UseCase
2. Data is shown in UI via ViewModel
3. Posts are cached in local Room DB
4. If offline, data is loaded from local DB

---

## 📌 Requirements
- Android Studio Giraffe or later
- Gradle 8+
- Min SDK: 21
- Kotlin 1.8+

---

## 🛠 Setup
```bash
# Clone the repo
git clone https://github.com/yourusername/PostsApp.git

# Open in Android Studio and run on emulator/device
```

---

## 📄 License
MIT License. Feel free to use and modify.
