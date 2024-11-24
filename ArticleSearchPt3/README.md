# Lab 6: ArticleSearch Pt 3

Course Link: [CodePath Android Course](https://courses.codepath.org/courses/and102/unit/6)

Submitted by: **Andrew Anil George** 

**NYT ArticleSearch Pt 3** is an app that combines the Best Setting Books app and the Article Search app, allowing users to navigate between books and articles seamlessly.

Time spent: **4** hours spent in total 

## Application Features

### Required Features

The following **required** functionality is completed:

- [X] (3 pts) **Add and implement Bottom Navigation to your application**
    - Allows navigation between books and articles using Bottom Navigation.

- [X] (4 pts) **Dynamically use fragments within Activities**
    - Displays books and articles in their respective fragments, dynamically managed within the main activity.

- [X] (3 pts) **Customize the toolbar and icons**
    - Provides a unique toolbar experience for each section with relevant icons.

### Stretch Features

The following **stretch** functionality is implemented:

- [X] (2 pts) **Respond to device orientation changes without resetting the application**
    - Ensures app content maintains its state across orientation changes.


## Notes
### Challenges
- Parsing complex nested JSON objects (e.g., multimedia and headline data) required creating custom data classes and handling missing or null fields to avoid runtime errors. 
- Dynamically managing fragments within the main activity involved handling fragment transactions seamlessly to ensure proper navigation and state retention. 
- Implementing Room for offline data storage necessitated creating custom type converters to serialize nested JSON data and ensuring compatibility with the schema design. 
- Displaying dynamic content in RecyclerView required handling empty states, managing placeholder images for articles with missing multimedia, and ensuring efficient adapter updates. 
- Handling network failures gracefully required setting up robust error messages and retry mechanisms to provide a seamless experience for offline and online transitions.


## Resources

- [Getting Started with Navigation](https://developer.android.com/guide/navigation/navigation-getting-started)
- [Navigation UI with Bottom Navigation](https://developer.android.com/guide/navigation/navigation-ui)
- [Fragments](https://developer.android.com/guide/fragments)
- [Programmatic Navigation](https://developer.android.com/guide/navigation/navigation-programmatic)
- [AndroidX Navigation Library](https://developer.android.com/jetpack/androidx/releases/navigation)

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