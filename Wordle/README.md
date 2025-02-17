# Android Project 1 - *Wordle*

Submitted by: **Andrew Anil George**

**Wordle** is an android app that recreates a simple version of the popular word game [Wordle](https://www.nytimes.com/games/wordle/index.html).

Time spent: **5** hours spent in total

## Required Features

The following **required** functionality is completed:

- [X] **User has 3 chances to guess a random 4 letter word**
- [X] **After 3 guesses, user should no longer be able to submit another guess**
- [X] **After each guess, user sees the "correctness" of the guess**
- [X] **After all guesses are taken, user can see the target word displayed**

The following **optional** features are implemented:

- [ ] User can toggle between different word lists
- [X] User can see the 'correctness' of their guess through colors on the word
- [X] User sees a visual change after guessing the correct word
- [ ] User can tap a 'Reset' button to get a new word and clear previous guesses
- [ ] User will get an error message if they input an invalid guess
- [ ] User can see a 'streak' record of how many words they've guessed correctly.

The following **additional** features are implemented:

* [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<div>
    <a href="https://www.loom.com/share/22b216b654b14513a217bb4630d4305d">
    </a>
    <a href="https://www.loom.com/share/22b216b654b14513a217bb4630d4305d">
      <img style="max-width:300px;" src="https://cdn.loom.com/sessions/thumbnails/22b216b654b14513a217bb4630d4305d-b7790ec680051c77-full-play.gif">
    </a>
  </div>

<!-- Replace this with whatever GIF tool you used! -->
Video created with Loom
<!-- Recommended tools:
[Kap](https://getkap.co/) for macOS
[ScreenToGif](https://www.screentogif.com/) for Windows
[peek](https://github.com/phw/peek) for Linux. -->

## Notes

### Challenges Encountered

- **Managing UI State Changes**: Handling visibility of UI elements (such as TextViews for guesses and buttons) based on user input and game progression was tricky, especially ensuring they updated correctly after each guess.

- **Integrating External Libraries**: Adding the `Konfetti` animation library and resolving dependency issues with Gradle required extra configuration and debugging.

- **Handling Input Validation**: Ensuring that the user inputted valid 4-letter words, while providing appropriate error feedback, posed challenges in balancing user experience and functionality.

- **Displaying Guess Feedback**: Implementing the color-coded feedback using `SpannableStringBuilder` for indicating correct letters and positions required careful handling of string operations and UI updates.

- **Game Logic Flow**: Structuring the core game logic to handle multiple guesses, track attempts, and end the game appropriately without bugs was a critical and challenging aspect.

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