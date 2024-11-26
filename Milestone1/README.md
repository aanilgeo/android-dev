# Milestone 1 - ChowSpot (Unit 7)

## Table of Contents

1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)

## Overview

### Description

*ChowSpot* is an app designed to help NJIT students discover nearby food trucks, cafes, and restaurants, especially small-scale businesses that are often overlooked. The app includes features like reviews, menu details, hours of operation, and real-time location updates for food trucks, making it easier for students to decide where to eat.

### App Evaluation

- **Category:** Food
- **Mobile:** Mobile is essential for real-time GPS-based food truck locations and push notifications for deals or operating hours. The app also uses maps and search functionality to enhance the user experience.
- **Story:** Empowers students to easily access dining options, discover hidden gems around campus, and support local food truck owners. It simplifies food choices and brings visibility to small businesses.
- **Market:** Target audience includes NJIT students, faculty, and staff. The app could scale to other Newark campuses for broader adoption.
- **Habit:** Students will frequently use the app during meal hours to decide where to eat. Notifications for deals or operating hours will drive daily engagement, especially during busy times like finals or campus events when food trucks are more active.
- **Scope:** V1 would include food truck listings, location updates, and reviews. V2 could add features like live order tracking and payment options. V3 could incorporate a loyalty rewards program for repeat purchases.

---

## Product Spec

### 1. User Features (Required and Optional)

**Required Features**
1. User authentication (Firebase Authentication for profiles).
2. Food truck listing with real-time location updates (API integration, e.g., Google Maps API).
3. Search functionality to filter food options by type, distance, or rating.
4. Reviews and ratings for food trucks/restaurants.
5. Favorites feature to bookmark preferred food trucks.
6. Push notifications for special offers, operational updates, and new listings.

**Optional Features**
1. Loyalty rewards program for frequent customers.
2. In-app ordering and payment integration.
3. Social sharing of food reviews.
4. Integration with campus dining services for meal plan options.
5. GPS-based "Eat Near Me" recommendations.

---

### 2. Screen Archetypes

- **Home Screen**
  - Displays nearby food trucks/restaurants fetched via API.
  - Includes a search bar, filter and sort buttons, and tab navigation.
  - Search results are displayed as another state of this screen.
- **Food Truck Details Screen**
  - Shows food truck name, image, menu details, reviews, operating hours, and real-time location on a map.
  - Allows users to bookmark a truck or leave a review.
- **Favorites Screen**
  - Lists bookmarked food trucks/restaurants.
  - Allows users to tap a listing to view its details.
- **Profile Screen** (includes basic settings)
  - Displays user information (e.g., name, email).
  - Includes toggles for managing notification preferences (e.g., deals, operating hours).
  - Provides a logout button.
- **Login/Signup Screen**
  - Enables user authentication and account creation with email and password.

---

### 3. Navigation

**Tab Navigation** (Tab to Screen)
* Home
* Favorites
* Profile

**Flow Navigation** (Screen to Screen)
- **Login/Signup** → Home Screen
  - User logs in or signs up, then lands on the Home Screen.

- **Home Screen** → Food Truck Details
  - Tapping on a food truck listing navigates to the Details Screen.

- **Food Truck Details** → Home Screen
  - User taps "Back" or navigates to the Home Tab.

- **Home Screen** (Search State)
  - User enters a search query or applies filters to view filtered results (same layout but updated content).

- **Favorites Tab** → Food Truck Details
  - User selects a bookmarked food truck to view its details.

- **Food Truck Details** → Favorites Tab
  - User taps "Back" to return to the Favorites Tab.

- **Profile Tab** (with Settings)
  - User manages preferences like notification settings or logs out from the Profile Screen.

---

## Wireframes

<img src="https://github.com/user-attachments/assets/1342579b-84d1-4234-bd2f-ad6c4acef03d" width=600>

---
