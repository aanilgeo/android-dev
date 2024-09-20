# Lab 2: CodepathMail

Course Link: [CodePath Android Course](https://courses.codepath.org/courses/and102/unit/2#!labs)

Submitted by: **Andrew Anil George** <!-- Replace 'Your Name Here' with your actual name -->

**CodepathMail** is a simple email app clone inspired by Gmail, allowing users to scroll through a list of emails.

Time spent: **3** hours spent in total <!-- Replace 'X' with the number of hours you spent on this project -->

## Application Features

### Required Features

The following **required** functionality is completed:

- [X] (4 pts) **User can scroll through a list of 10 emails.**
    - Each email contains the following information:
        - Sender
        - Email title
        - Email summary
<img src="https://github.com/user-attachments/assets/ff383fd2-12b5-453e-9338-1d2864df284e" width="300" height="640"/>

### Stretch Features

The following **stretch** functionality is implemented:

- [X] (3 pts) **User can press a 'Load More' button to see the next 5 emails displayed.**
  ![GIF showing the 'Load More' button in action](https://github.com/user-attachments/assets/6de6e0ac-77b5-4b62-ab76-612ef35d1e79)

- [X] (3 pts) **Each email displays additional information:**
    - Picture of the sender
    - Email sent date
    - Bolded information if the email is unread
  ![GIF showing additional email information](https://github.com/user-attachments/assets/89ec0dec-087b-4c2a-80b6-29c75a43d085)


## Notes

### Challenges
1. Adjusting UI layout constraints and margins to prevent overlapping and ensure proper spacing between elements.
2. Efficiently managing dynamic content loading without degrading app performance during updates.
3. Maintaining consistent styling across different devices, including fonts and spacing adjustments.
4. Implementing and managing the visual distinction between read and unread emails within the app.
5. Handling RecyclerView updates effectively to reflect newly loaded data while preserving view state.

## Resources

- [Create dynamic lists with RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview)
- [Using the RecyclerView](https://guides.codepath.com/android/using-the-recyclerview)

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
