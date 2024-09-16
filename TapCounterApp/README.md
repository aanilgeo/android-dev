# Lab 1: Tap Counter App

Course Link: [CodePath Android Course](https://courses.codepath.org/courses/and102/unit/1#!labs)

Submitted by: **Andrew Anil George** <!-- Replace 'Your Name Here' with your actual name -->

**Tap Counter App** is an Android app inspired by idle tap games, allowing users to accumulate points through taps, which can be exchanged for upgrades.

Time spent: **6** hours spent in total <!-- Replace 'X' with the number of hours you spent on this project -->

## Application Features

### Required Features

The following **required** functionality is completed:

- [ ] (2 pts) **User can see a number displayed on the screen. The number starts at 0.**
<img src="https://github.com/aanilgeo/aa3348-CS388-001/blob/Lab1/TapCounterApp/app/src/main/res/drawable/required_1.png?raw=true" alt="Image showing the initial display of the number" width="400"/>



- [ ] (2 pts) **User can tap on a button to see the number displayed increase by 1.**
<img src="https://raw.githubusercontent.com/aanilgeo/aa3348-CS388-001/Lab1/TapCounterApp/app/src/main/res/drawable/required_2.gif?token=GHSAT0AAAAAACXOCMWFU6ETDEGRRFNLGRXQZXIXKJA" alt="Image showing the initial display of the number" width="400"/>




### Stretch Features

The following **stretch** functionality is implemented:

- [ ] (2 pts) **User can exchange the number of taps accumulated for upgrades:**
  - X taps for an upgrade that makes each tap count as 2 taps. (Default: 100 taps)
    - Use a Toast for positive (purchase) or negative (can't afford) notifications.
<img src="https://raw.githubusercontent.com/aanilgeo/aa3348-CS388-001/Lab1/TapCounterApp/app/src/main/res/drawable/stretch_1.gif?token=GHSAT0AAAAAACXOCMWF3ZTOCHXLWJ7P2CSIZXIXHHA" alt="Image showing the initial display of the number" width="400"/>




- [ ] (2 pts) **User can exchange taps for a custom icon button.**  
  - X taps for a custom icon button. (Default: 100 taps)
    - Use a Toast for positive (purchase) or negative (can't afford) notifications.
<img src="https://raw.githubusercontent.com/aanilgeo/aa3348-CS388-001/Lab1/TapCounterApp/app/src/main/res/drawable/stretch_2.gif?token=GHSAT0AAAAAACXOCMWFS6FZPUDOKDHCSTQ4ZXIXHPA" alt="Image showing the initial display of the number" width="400"/>


- [ ] (2 pts) **User can customize the app's theme (e.g., a dog-themed background with a paw print button).**  
<img src="https://github.com/aanilgeo/aa3348-CS388-001/blob/Lab1/TapCounterApp/app/src/main/res/drawable/stretch_3.gif?raw=true" alt="Image showing the initial display of the number" width="400"/>


- [ ] (+2 bonus pts) **User has progressively difficult goals to reach in terms of the number of taps accumulated.**  
  - Display each goal on the screen, and track the total number of goals reached.
  - Use a Toast to notify of a reached goal.
<img src="https://raw.githubusercontent.com/aanilgeo/aa3348-CS388-001/Lab1/TapCounterApp/app/src/main/res/drawable/stretch_4.gif?token=GHSAT0AAAAAACXOCMWEGSVLHX4Z5NZKK472ZXIXI5Q" alt="Image showing the initial display of the number" width="400"/>


## Notes

## Challenges Encountered:
- Managing dynamic UI changes during theme switching and ensuring smooth transitions.
- Ensuring proper visibility of Toast messages without overlapping UI elements.
- Debugging tap increment logic and correctly handling the appearance of the upgrade button.
- Managing multiple upgrades (Add 2, custom icon) while maintaining a smooth user experience.
- Ensuring layout responsiveness and visual consistency across different screen sizes during theme changes.

## Resources

- [ConstraintLayout documentation](https://developer.android.com/training/constraint-layout)
- [Displaying Toasts](https://guides.codepath.com/android/Displaying-Toasts)

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
