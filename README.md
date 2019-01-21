# PodcastInformationRetriever

The method will invoke the iTunes search api using a GET Request in order to retrieve the requested podcast. Once the 
podcast is retrieved, the feedURL content will be taken from the response and it will be used to perform another GET request
in order to retrieve title, description and episodes of the podcast.

The correct execution of the application is subordinate to 2 factors:

- The searched podcast is part of the iTunes catalog
- The iTunes API is not changed [For a full reference check](https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/#searchinghttps://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/#searching)

Once the Podcast is retrieved from iTunes, it's possible to get the RSS feed associated with it and retrieve the necessary
information to populate the podcast.

