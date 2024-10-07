# Android Project 3 - *FlixsterPart1*

Submitted by: **Andrew Anil George**

**Flixster** is a movie browsing app that allows users to browse movies currently playing in theaters.

Time spent: **5** hours spent in total

## Required Features

The following **required** functionality is completed:

- [X] **Make a request to [The Movie Database API's `now_playing`](https://developers.themoviedb.org/3/movies/get-now-playing) endpoint to get a list of current movies**
- [X] **Parse through JSON data and implement a RecyclerView to display all movies**
- [X] **Use Glide to load and display movie poster images**

The following **optional** features are implemented:

- [X] Improve and customize the user interface through styling and coloring
- [X] Implement orientation responsivity
    - App should neatly arrange data in both landscape and portrait mode
- [X] Implement Glide to display placeholder graphics during loading
    - Note: this feature is difficult to capture in a GIF without throttling internet speeds.  Instead, include an additional screencap of your Glide code implementing the feature.  (<10 lines of code)
<img width="572" alt="glide" src="https://github.com/user-attachments/assets/44a55371-61bc-40ff-a9f0-f319b2a218f9">


## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://github.com/user-attachments/assets/476f8e1f-cfbd-4ce8-a5d4-4e5d753f3d29' title='Video Walkthrough' width='' alt='Video Walkthrough' />

<!-- Replace this with whatever GIF tool you used! -->
GIF created with Kap
<!-- Recommended tools:
[Kap](https://getkap.co/) for macOS
[ScreenToGif](https://www.screentogif.com/) for Windows
[peek](https://github.com/phw/peek) for Linux. -->

## Notes

### Challenges
- Ensuring that the layout adapts well to both portrait and landscape modes, using `RecyclerView`, `GridLayoutManager`, and constraint-based layouts for responsiveness.
- Implementing Glide for efficient loading of movie posters, including handling placeholders and errors when images fail to load.
- Ensuring consistent styling across different devices, particularly customizing the theme, colors, and text appearances to improve the overall user experience.
- Adapting the layout to work seamlessly on devices with varying screen sizes and resolutions by using flexible constraint layouts and avoiding hardcoded dimensions.

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
