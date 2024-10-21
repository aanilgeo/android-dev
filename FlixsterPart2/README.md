# Android Project 4 - *FlixsterPart2*

Submitted by: **Andrew Anil George**

**Flixster II** is a movie browsing app that allows users to browse the latest popular movies and TV shows and view detailed information about each movie or actor, including plot summaries, and movies known for, and seamlessly transition between lists and detailed views using smooth shared element transitions.

Time spent: **5** hours spent in total

## Required Features

The following **required** functionality is completed:

- [X] **Choose any endpoint on The MovieDB API except `now_playing`**
    - Chosen Endpoint: `[person/popular]`
- [X] **Make a request to your chosen endpoint and implement a RecyclerView to display all entries**
- [X] **Use Glide to load and display at least one image per entry**
- [X] **Click on an entry to view specific details about that entry using Intents**

The following **optional** features are implemented:

- [X] **Add another API call and RecyclerView that lets the user interact with different data.**
- [X] **Add rounded corners to the images using the Glide transformations**
- [X] **Implement a shared element transition when user clicks into the details of a movie**

## Video Walkthrough

<img src='https://github.com/user-attachments/assets/78bdb36e-20a4-4ea4-bdb5-43527e7f8b38' title='Video Walkthrough' width='' alt='Video Walkthrough' />

<!-- Replace this with whatever GIF tool you used! -->
GIF created with Kap
<!-- Recommended tools:
[Kap](https://getkap.co/) for macOS
[ScreenToGif](https://www.screentogif.com/) for Windows
[peek](https://github.com/phw/peek) for Linux. -->

## Notes
### Challenges
- Handling asynchronous API calls and parsing JSON data from The Movie Database API efficiently.
- Implementing smooth shared transitions between list and detail views for both movies and actors.
- Managing layout configurations to ensure consistent image sizes across horizontal lists for movies and actors.
- Aligning the app's UI to create a clean, user-friendly interface with proper spacing, dark themes, and rounded image corners.
- Ensuring proper error handling for failed API calls and displaying fallback UI in case of network issues.

## License

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
