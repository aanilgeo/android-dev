# Lab 4: Article Search

Course Link: [CodePath Android Course](https://courses.codepath.org/courses/and102/unit/4#!labs)

Submitted by: **Andrew Anil George** 

**Article Search** is an app designed to display the most recent articles from the NY Times.

Time spent: **5** hours spent in total 

## Application Features

### Required Features

The following **required** functionality is completed:

- [X] (3 pts) **Articles are displayed using the RecyclerView.**
    - ![Image showing RecyclerView implementation](http://i.imgur.com/link/to/your/gif/file.gif) 

- [X] (4 pts) **Can navigate to the Article Details screen.**
    - ![GIF showing Article Details screen](http://i.imgur.com/link/to/your/gif/file.gif) 

- [X] (3 pts) **Article images are downloaded and displayed using Glide.**
    - ![Image showing Glide usage](http://i.imgur.com/link/to/your/gif/file.gif) 

### Stretch Features

The following **stretch** functionality is implemented:

- [X] (+2 pts bonus) **Enhanced the UI for the application with customized fonts and ConstraintLayout for each of the screens.**
    - ![GIF showing custom UI styling](http://i.imgur.com/link/to/your/gif/file.gif) <!-- Replace this link with your actual image/GIF link -->

## Notes

### Challenges
- Parsing the NY Times API response into usable data models required careful handling.
- Implementing a custom Toolbar with proper back navigation was tricky to manage across screens.
- Ensuring smooth API failure handling and avoiding app crashes posed a challenge.
- Designing a clean RecyclerView layout with images and dividers took multiple iterations.

## Resources

- [Using Intents to Create Flows](https://guides.codepath.org/android/Using-Intents-to-Create-Flows)
- [AsyncHTTPClient](https://guides.codepath.org/android/Using-CodePath-Async-Http-Client)
- [GridLayoutManager](https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/GridLayoutManager)
- [GridView in Android](https://www.geeksforgeeks.org/gridview-in-android-with-example/)

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