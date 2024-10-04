# Lab 3: NY Times Bestselling Books aka 'BestSellersApp'

Course Link: [CodePath Android Course](https://courses.codepath.org/courses/and102/unit/3#!labs)

Submitted by: **Andrew Anil George** <!-- Replace 'Your Name Here' with your actual name -->

**BestSellersApp** is an app designed to display the current bestselling books based on NY Times data.

Time spent: **5** hours spent in total <!-- Replace 'X' with the number of hours you spent on this project -->

## Application Features

### Required Features

The following **required** functionality is completed:

- [X] (2 pts) **Live data is loaded from the NY Times API.**
<img src="https://github.com/user-attachments/assets/a8f69022-4297-465e-ab2d-c11642bab224" width="300" height="640"/>
<img src="https://github.com/user-attachments/assets/097203fd-2f6b-4263-8128-2a2f37438e53" width="300" height="640"/>

- [X] (4 pts) **Books are displayed using a RecyclerView.**
    - Displays book ranking, cover, title, author, and description.
    - Book cover images are downloaded using Glide.
<img src="https://github.com/user-attachments/assets/0de82e58-be8d-41ae-b0ec-21e87f9ec013" width="300" height="640"/>

### Stretch Features

The following **stretch** functionality is implemented:

- [X] (4 pts) **Improved layout and styling to match the NY Times website.**
    - Includes a "buy" button that links to Amazon.
  <img src="https://github.com/user-attachments/assets/e4360de8-087d-419d-8b77-b6ffc1d83756" width="300" height="640"/>

## Notes

### Challenges
- Aligning UI components properly to ensure no overlap between titles, images, and rankings, especially with varying text lengths.
- Adjusting margins and constraints to maintain a clear and visually appealing layout without breaking the overall design.
- Handling dynamic content loading from the API without affecting the performance of the RecyclerView, ensuring smooth scrolling.
- Maintaining consistent design elements, such as text size and padding, across different screen sizes to ensure a responsive layout.
- Efficiently setting up click listeners on dynamically generated content (like the Amazon buttons) without causing unexpected behavior.

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
