Leftronic Java API
==================

This is a simple Java API that wraps the [Leftronic](http://leftronic.com/) REST APIs documented [here](https://beta.leftronic.com/api/).

Downloading
-----------

The easiest way to get started is to just add this dependency in to your Maven build:

```xml
<dependency>
    <groupId>biz.neustar</groupId>
    <artifactId>leftronic</artifactId>
    <version>1.0-beta-1</version>
</dependency>
```

If you don't use Maven, you can still find the jars in the central Maven repository. You'll also need the following dependencies:

 - [Jackson](http://jackson.codehaus.org/) 1.8.5 or later
 - [Apache HttpClient](http://hc.apache.org/httpcomponents-client-ga/) 4.1.2 or later
 - [JSR 330](http://code.google.com/p/atinject/) (aka javax.inject) for easy CI integration

Using
-----

The API is pretty straight forward if you've read the Leftronic API docs:

```java
LeftronicClient client = new LeftronicClient("access_key", 4);

client.sendNumber("Number-Stream", 300);

client.sendGeoPoint("Geo-Stream", 45.8, -115.6);

Random r = new Random();
client.sendLeaderboard("Leader-Stream",
        new LeaderboardEntry("Ian", r.nextInt(100)),
        new LeaderboardEntry("Patrick", r.nextInt(100)),
        new LeaderboardEntry("Barney", r.nextInt(100)));

client.sendList("Test-Stream", "Fe", "Fi", "Fo", "Fum");

client.sendText("Test-Stream", "Custom Title", "This is a new message");
```

You can also wire up the LeftronicClient using dependency injection frameworks such as Guice. The three constructor parameters are bound to the following @Named parameter:

 - @Named("leftronic.accessKey")

Note: The client *always uses SSL* to make it's HTTP requests and until we hear a good reason we won't be offering an option to change this.

License
-------

This project is licensed under the [Apache 2.0](http://www.apache.org/licenses/LICENSE-2.0.html) license.