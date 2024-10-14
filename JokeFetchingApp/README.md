# Extra Credit Challenge: Joke Fetching App

Course Link: [CodePath Android Course](https://courses.codepath.org/courses/and102/unit/3#!labs)

Submitted by: **Andrew Anil George** <!-- Replace 'Your Name Here' with your actual name -->

**Joke Fetching App** is an app designed to fetch a list of jokes from an external Joke API and allows users to share jokes on social media.

Time spent: **5** hours spent in total <!-- Replace 'X' with the number of hours you spent on this project -->

## Application Features

### Required Features

The following **required** functionality is completed:

- [X] (2 pts) **Use rapidapi.com to find a Joke API (use BuildConfig).**
<img src="https://github.com/user-attachments/assets/412b5c86-7418-42f8-90de-3a5afb4f5684"/>
      
- [X] (2 pts) **Fetch a list of jokes and display them in a RecyclerView.**
<img src="https://github.com/user-attachments/assets/0922ba78-fca3-40c8-85b0-ed18b31cf92e" width="300" height="640"/>

- [X] (2 pts) **Click a joke to display it in centered format.**
<img src="https://github.com/user-attachments/assets/15d46d9a-bf69-4179-9c3c-556fe0d3c661" width="300" height="640"/>

- [X] (2 pts) **Provide social sharing options for at least 2 platforms (e.g., X, Facebook).**
<img src="https://github.com/user-attachments/assets/dd47c8ba-64c7-4ca4-8a3e-7c2984c43ed9" width="300" height="640"/>
      
- [X] (2 pts) **Customize the theme of the app.**
<img src="https://github.com/user-attachments/assets/0922ba78-fca3-40c8-85b0-ed18b31cf92e" width="300" height="640"/>

## Notes

### Challenges
- Faced difficulties in securely integrating the Joke API using `BuildConfig`, ensuring sensitive information like API keys was handled properly.
- Customizing the app's theme to move away from default Android themes required multiple iterations to achieve a consistent and polished design.
- Encountered issues with testing the share functionality on X and Facebook within the emulator environment due to limited app support, requiring the installation of specific system images.
- Had to overcome layout challenges to display jokes in floating boxes while ensuring a user-friendly interface.
- Implementing the back button functionality for seamless navigation between the main and detail screens required additional logic in `JokeDetailActivity`.


## Resources

- [CodePath's AsyncHTTPClient library](https://guides.codepath.org/android/Using-CodePath-Async-Http-Client)
- [Displaying Images with Glide library](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library)
- [Parsing JSON responses to Models](https://guides.codepath.org/android/converting-json-to-models)
- [Parsing JSON with gson library](https://guides.codepath.org/android/Leveraging-the-Gson-Library#parsing-the-response)
- [Kotlin's Guide on Serialization](https://kotlinlang.org/docs/serialization.html)

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
