# FCM-Spring-boot #

## Direct messages: Server Implementation ##

- When a sender wants to send messages to a specific device, he needs to know the FCM registration token of the client. 
- The client receives that token as soon as he is registered to FCM. Then he needs to send that token to the server. 
- Controller that registers a handler for the URL /register and another handler for /unregister. 

## Firebase Cloud Messaging ##
Spring boot application with FCM 
Firebase push notification for android application

#### Prerequisites ####
* set up firebase account
* get device token from android app
* get server key from firebase account

## Place relayx-128a6-firebase-adminsdk-25qss-e36af83413.json file at server secure location and mention that path in application.properties file.. ##


