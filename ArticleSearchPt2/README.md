# Lab 5: ArticleSearch Pt 2

Course Link: [CodePath Android Course](https://courses.codepath.org/courses/and102/unit/5#!labs)

Submitted by: **Andrew Anil George** 

**NYT Article Search Pt 2** is an app designed to maintain functionality while offline by caching the latest data fetched from the NYT API, ensuring a smooth user experience even without network connectivity.

Time spent: **5** hours spent in total 

## Application Features

### Required Features

The following **required** functionality is completed:

- [X] (2 pts) **Most recently fetched data is stored locally in a database**
  - The app should cache the latest articles fetched from the NYT API in a local SQLite database using Room.
  - If the user has fetched data recently, those articles should be available offline.
  - Ensure old cached data is properly replaced with new data upon successful network fetches.
<img src="https://github.com/user-attachments/assets/7d2c104d-39a1-4556-80ed-a99201d85890" width="300" height="640"/>


- [X] (2 pts) **If user turns on airplane mode and closes and reopens app, old data from the database should be loaded**
<img src="https://github.com/user-attachments/assets/7d2c104d-39a1-4556-80ed-a99201d85890" width="300" height="640"/>

### Stretch Features

The following **stretch** functionality is implemented:

- [X] (2 pts) **Add Swipe To Refresh to force a new network call to get new data**
<img src="https://github.com/user-attachments/assets/bfecdb8a-730c-412d-82ef-ce0af575714f" width="300" height="640"/>


- [X] (2 pts) **Add setting toggle for user to create preference for caching data or not (Using Shared Preferences)**
<img src="https://github.com/user-attachments/assets/d06c1439-8265-4270-bf6e-1d1aa31d7a50" width="300" height="640"/>


- [ ] (+3 pts) **Implement a Search UI to filter current RecyclerView entries or fetch data from the search API with query**
  <!-- Replace this link with your actual image/GIF link -->

- [X] (2 pts) **Listen to network connectivity changes and create a UI to let people know they are offline and automatically reload new data if connectivity returns**
<img src="https://github.com/user-attachments/assets/7f794b49-8130-4a1a-99fd-de81a6c7cc7b" width="300" height="640"/>


## Notes
### Challenges
- Integrating Room for offline data storage involved careful handling of schema changes and adding migration strategies to avoid app crashes.
- Parsing and storing nested JSON objects (e.g., multimedia data) required custom type converters to ensure smooth data storage and retrieval in Room.
- Implementing real-time network status monitoring and displaying relevant UI messages when offline or back online involved setting up broadcast receivers and handling state changes.
- Adding a toggle for caching preferences with SharedPreferences required working around deprecated components and adapting the settings UI.
- Ensuring smooth transitions between offline and online states without disrupting the user experience required testing various network scenarios.

## Resources

- [Data storage with Room](https://developer.android.com/training/data-storage/room)
- [Swipe To Refresh](https://developer.android.com/training/swipe/add-swipe-interface)
- [Save key-value data with Shared Preferences](https://developer.android.com/training/data-storage/shared-preferences)
- [Android Search View](https://developer.android.com/reference/android/widget/SearchView)
- [Monitor connectivity status and connection metering](https://developer.android.com/training/monitoring-device-state/connectivity-status-type)
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)

## License

```plaintext
    Copyright [2024] [Andrew Anil George]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
