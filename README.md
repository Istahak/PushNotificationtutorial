# Push Notifications with Firebase Cloud Messaging (FCM) in  Android apps

## Introduction
  Firebase Cloud Messaging (FCM) is a powerful service provided by Google that allows you to send push notifications to Android, iOS, and web applications. FCM provides several key functionalities for push notifications:
  - **Cross-Platform Notifications:** FCM allows you to send notifications to multiple platforms, including Android, iOS, and web applications, using a single API.

  - **Notification Delivery:** FCM handles the delivery of notifications to devices, even when the app is in the background or not running. It ensures that notifications reach their intended recipients efficiently.

  - **Topic-Based Messaging:** You can subscribe devices to specific topics, allowing you to send notifications to a group of devices interested in a particular topic. Subscribing and unsubscribing from topics is flexible and easy to manage.

  - **Token Management:** FCM assigns a unique registration token to each app instance on a device. You can use these tokens to target specific devices when sending notifications. Tokens are refreshed automatically when needed.

 - **Custom Payloads:** FCM allows you to send custom data along with notifications. This data can be used to provide additional context or trigger specific actions when the notification is received.

- **Notification Types:**

   + **Notification Messages:** These are high-priority messages that FCM automatically displays to the user. You can include a title, body, and other optional data. Android handles the display of these messages.
   + **Data Messages:** These are messages with custom data payloads that don't trigger automatic display. Your app must handle the data and display the notification as needed.
- **Notification Channels:** On Android, you can categorize and prioritize notifications using notification channels. FCM supports creating and managing notification channels for Android apps.

- **Notification Analytics:** FCM provides analytics to track the performance of your notifications, such as the number of messages sent, delivered, opened, and more. This helps you evaluate the effectiveness of your messaging campaigns.

- **Notification Scheduling:** You can schedule notifications to be sent at a specific time, which is useful for sending reminders, updates, or other time-sensitive information.

- **Security:** FCM ensures that messages are sent and received securely. Messages are encrypted in transit, and authentication mechanisms prevent unauthorized access to your Firebase project.

- **Integration with Firebase Services:** FCM seamlessly integrates with other Firebase services, such as Firebase Authentication, Firebase Realtime Database, and Firebase Cloud Functions. You can trigger notifications based on events in these services.

- **Server-to-Device Messaging:** FCM allows server-side applications to send messages to specific devices directly. This is useful for sending personalized notifications based on user interactions or events.

- **Debugging Tools:** FCM provides debugging tools and logs to help you diagnose issues with message delivery or token registration.

- **Multi-Language Support:** You can send notifications in multiple languages, ensuring that users receive messages in their preferred language.

- **Notification Hubs:** FCM can be used in conjunction with Notification Hubs to send push notifications to Windows devices, extending the reach of your messaging to a wider audience.


Firebase Cloud Messaging (FCM) is a comprehensive solution for sending push notifications to mobile and web apps.In this tutorial, we will discuss only push notifications using Firebase.




## Android app connection process with Firebase

- **Step 1: Create a Firebase Project**
    + [Go](https://console.firebase.google.com/) to the Firebase Console.
    + Sign in with your Google account.
    + Click on "Add project" to create a new Firebase project or select an existing one.

- **Step 2: Add Your Android App to Firebase**
     + In your Firebase project, click on *Add app* and select the Android platform.
     + Enter your Android app's package name (usually found in your app's `build.gradle` file).
     + Optionally, enter other details like the app nickname.
     + Click *Register app.*
- **Step 3: Download and Add Configuration File**
     + After registering your app, download the `google-services.json` file.
     ![googlejsondw](./myfolder/googlejosndw.png)
     + Place the `google-services.json` file in the app directory of your Android project.

     ![google_json_file](./myfolder/googlejson1.png)

- **Step 4: Configure Your App's Build Gradle Files**
    + In your `build.gradle` files, you'll need to **add dependencies** and apply plugins.**Project-level build.gradle (usually found in the project's root directory):**
    ```kts
    plugins {
            // ...

            // Add the dependency for the Google services Gradle plugin
            id("com.google.gms.google-services")  version "4.4.0" apply false

  }
   
    ```
    ![imageview](./myfolder/rootbulid.png)

    + **App-level `build.gradle` (usually found in the app module):**

    ```kts
    plugins {
  id("com.android.application")

  // Add the Google services Gradle plugin
  id("com.google.gms.google-services")

  ...
  }

 
  dependencies {
    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:32.3.1"))


   // TODO: Add the dependencies for Firebase products you want to use
   // When using the BoM, don't specify versions in Firebase dependencies
   // https://firebase.google.com/docs/android/setup#available-libraries 
   }
   ```
   ![imageview](./myfolder/appbuild1.png)
   ![imageview2](./myfolder/appbuild2.png)
 
 



     



