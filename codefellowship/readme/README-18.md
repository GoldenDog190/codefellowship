# Lab 18 - Spring Security against User Input

## Setup
* Continue working in your codefellowship repo.

## Resources
* [Spring Auth Cheat Sheet](https://github.com/codefellows/seattle-java-401d2/blob/master/SpringAuthCheatSheet.md)

## Feature Tasks
* Ensure that users can’t perform SQL injection or HTML injection with their posts.
* Allow users to follow other users. Following a user means that their posts show up in the logged-in user’s feed, where they can see what all of their followed users have posted recently.
  - Ensure there is some way (like a users index page) that a user can discover other users on the service.
  - On a user profile page that does NOT belong to the currently logged-in user, display a “Follow” button. When a user clicks that follow button, the logged-in user is now following the viewed-profile-page user.
  note: this will require a self-join on ApplicationUsers.
  - A user can visit a url (like /feed) to view all of the posts from the users that they follow.
    - Each post should have a link to the user profile of the user who wrote the post.

## Previous Feature Tasks
* A splash page with basic information about the site
* The ability for users to register for new accounts and log in.
* The ability for logged-in users to create posts.
* The ability to see a user’s posts, along with their profile information and a default profile picture, on their profile page.
* A pleasing design throughout the site.
* Thymeleaf templates & fragments used appropriately to keep view code DRY.
* Smooth error handling with appropriate responses to bad requests.
* Integration testing on (at minimum) the splash page, login, and sign up routes.