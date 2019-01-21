import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import enrico.entities.Episode;
import enrico.entities.Podcast;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PodcastRetriever {


    public static void main (String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Please type in what you want to search");
            String searchCriteria = sc.nextLine();
            String searchTerm = searchCriteria.replaceAll("\\s+","+");

            String url = "https://itunes.apple.com/search?term=" + searchTerm +"&entity=podcast";
            JSONObject respITunes = new JSONObject(performHTTPCall(url));
            JSONArray resultsArrayITunes = respITunes.getJSONArray("results");

            if(resultsArrayITunes.length() > 0) {
                Integer element = null;
                if(resultsArrayITunes.length() > 1) {
                    System.out.println("More than one result please select the one you're interested in");
                    for (int i = 0; i < resultsArrayITunes.length(); i++) {
                        System.out.println("[" + i +"] " + resultsArrayITunes.getJSONObject(i).get("trackName"));
                    }
                    element = Integer.valueOf(sc.nextLine());

                } else {
                    element = 0;
                }

                JSONObject object = resultsArrayITunes.getJSONObject(element);
                Podcast p = parsePodcast(object);

                String resultFeedURL = performHTTPCall(p.getFeedUrl());
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(new InputSource(new ByteArrayInputStream(resultFeedURL.getBytes("UTF-8"))));

                p.setTitle(document.getDocumentElement().getElementsByTagName("title").item(0).getFirstChild().getNodeValue());
                p.setDescription(document.getDocumentElement().getElementsByTagName("description").item(0).getFirstChild().getNodeValue());

                p.print();

                List<Episode> episodesList = new ArrayList<Episode>();
                Integer numberOfItems = document.getDocumentElement().getElementsByTagName("item").getLength();
                for (int i = 0; i < numberOfItems; i++) {
                    NodeList nodeList = document.getDocumentElement().getElementsByTagName("item").item(i).getChildNodes();
                    Episode episode = parseNodeListIntoEpisode(nodeList);
                    episodesList.add(episode);
                }

                for (Episode e : episodesList) {
                    e.print();
                }

            } else {
                System.out.println("There are no Podcasts corresponding the search criteria");
            }

            System.out.println("Do you want to perform another search?[Y/n]");
        } while (sc.nextLine().equals("Y"));
    }

    /**
     * Creates the Podcast object from the iTunes call
     * */
    private static Podcast parsePodcast(JSONObject obj) {
        Podcast podcast = new Podcast();

        if(obj.has("wrapperType")) {
            podcast.setWrapperType((String) obj.get("wrapperType"));
        }

        if(obj.has("kind")) {
            podcast.setKind((String) obj.get("kind"));
        }

        if(obj.has("artistId")) {
            podcast.setArtistId((Integer) obj.get("artistId"));
        }

        if(obj.has("collectionId")) {
            podcast.setCollectionId((Integer) obj.get("collectionId"));
        }

        if(obj.has("trackId")) {
            podcast.setTrackId((Integer) obj.get("trackId"));
        }

        if(obj.has("artistName")) {
            podcast.setArtistName((String) obj.get("artistName"));
        }

        if(obj.has("collectionName")) {
            podcast.setCollectionName((String) obj.get("collectionName"));
        }

        if(obj.has("trackName")) {
            podcast.setTrackName((String) obj.get("trackName"));
        }

        if(obj.has("collectionCensoredName")) {
            podcast.setCollectionCensoredName((String) obj.get("collectionCensoredName"));
        }

        if(obj.has("trackCensoredName")) {
            podcast.setTrackCensoredName((String) obj.get("trackCensoredName"));
        }

        if(obj.has("artistViewUrl")) {
            podcast.setArtistViewUrl((String) obj.get("artistViewUrl"));
        }

        if(obj.has("collectionViewUrl")) {
            podcast.setCollectionViewUrl((String) obj.get("collectionViewUrl"));
        }

        if(obj.has("feedUrl")) {
            podcast.setFeedUrl((String) obj.get("feedUrl"));
        }

        if(obj.has("trackViewUrl")) {
            podcast.setTrackViewUrl((String) obj.get("trackViewUrl"));
        }

        if(obj.has("artworkUrl30")) {
            podcast.setArtworkUrl30((String) obj.get("artworkUrl30"));
        }

        if(obj.has("artworkUrl60")) {
            podcast.setArtworkUrl60((String) obj.get("artworkUrl60"));
        }

        if(obj.has("artworkUrl100")) {
            podcast.setArtworkUrl100((String) obj.get("artworkUrl100"));
        }

        if(obj.has("artworkUrl600")) {
            podcast.setArtworkUrl600((String) obj.get("artworkUrl600"));
        }

        if(obj.has("releaseDate")) {
            podcast.setReleaseDate((String) obj.get("releaseDate"));
        }

        if(obj.has("country")) {
            podcast.setCountry((String) obj.get("country"));
        }

        if(obj.has("primaryGenreName")) {
            podcast.setPrimaryGenreName((String) obj.get("primaryGenreName"));
        }

        if(obj.has("genres")) {
            JSONArray genresArray = (JSONArray) obj.get("genres");List<String> genresList = new ArrayList<String>();
            for(Object o : genresArray) {
                genresList.add((String) o);
            }
            podcast.setGenres(genresList);
        }

        return podcast;
    }

    /**
     * Performs the HTTP GET against the given URL
     * */
    private static String performHTTPCall(String url) throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);

        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        return result.toString();
    }

    /**
     * Creates the Episodes of the selected podcast
     * */
    private static Episode parseNodeListIntoEpisode(NodeList nodeList) {
        Episode episode = new Episode();
        for(int j = 0; j < nodeList.getLength(); j++) {

            if(nodeList.item(j).getNodeName() == "title") {
                episode.setTitle(nodeList.item(j).getTextContent().trim());
            }

            if(nodeList.item(j).getNodeName() == "itunes:summary") {
                episode.setDescription(nodeList.item(j).getTextContent().trim());
            }

            if(nodeList.item(j).getNodeName() == "itunes:duration") {
                episode.setDuration(nodeList.item(j).getTextContent());
            }

            if(nodeList.item(j).getNodeName() == "pubDate") {
                episode.setPublicationDate(nodeList.item(j).getTextContent().trim());
            }

            if(nodeList.item(j).getNodeName() == "guid") {
                episode.setGuid(nodeList.item(j).getTextContent().trim());
            }
        }
        return episode;
    }

}

