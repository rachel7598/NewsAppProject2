package com.example.android.newsappproject;

import android.util.Log;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Helper methods related to requesting and receiving article information from the Guardian api
 */
public final class QueryUtils {

    /** Sample JSON response for a Guardian query */
    private static final String SAMPLE_JSON_RESPONSE = "{\"response\":{\"status\":\"ok\",\"userTier\":\"external\",\"total\":18769,\"startIndex\":1,\"pageSize\":10,\"currentPage\":1,\"pages\":1877,\"orderBy\":\"relevance\",\"results\":[{\"id\":\"education/2020/dec/03/gavin-williamson-in-eton-mess-as-he-pitches-into-no-girls-policy\",\"type\":\"article\",\"sectionId\":\"education\",\"sectionName\":\"Education\",\"webPublicationDate\":\"2020-12-03T20:01:32Z\",\"webTitle\":\"Eton College head denies stifling debate after teacher's dismissal\",\"webUrl\":\"https://www.theguardian.com/education/2020/dec/03/gavin-williamson-in-eton-mess-as-he-pitches-into-no-girls-policy\",\"apiUrl\":\"https://content.guardianapis.com/education/2020/dec/03/gavin-williamson-in-eton-mess-as-he-pitches-into-no-girls-policy\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"commentisfree/2020/dec/30/the-guardian-view-on-the-brexit-debate-no-scrutiny-no-choice\",\"type\":\"article\",\"sectionId\":\"commentisfree\",\"sectionName\":\"Opinion\",\"webPublicationDate\":\"2020-12-30T18:56:29Z\",\"webTitle\":\"The Guardian view on the Brexit debate: no scrutiny, no choice | Editorial\",\"webUrl\":\"https://www.theguardian.com/commentisfree/2020/dec/30/the-guardian-view-on-the-brexit-debate-no-scrutiny-no-choice\",\"apiUrl\":\"https://content.guardianapis.com/commentisfree/2020/dec/30/the-guardian-view-on-the-brexit-debate-no-scrutiny-no-choice\",\"isHosted\":false,\"pillarId\":\"pillar/opinion\",\"pillarName\":\"Opinion\"},{\"id\":\"environment/2020/aug/20/time-for-real-debate-on-river-regulation\",\"type\":\"article\",\"sectionId\":\"environment\",\"sectionName\":\"Environment\",\"webPublicationDate\":\"2020-08-20T17:35:28Z\",\"webTitle\":\"Time for real debate on river regulation\",\"webUrl\":\"https://www.theguardian.com/environment/2020/aug/20/time-for-real-debate-on-river-regulation\",\"apiUrl\":\"https://content.guardianapis.com/environment/2020/aug/20/time-for-real-debate-on-river-regulation\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"politics/video/2020/nov/23/boris-johnson-presents-tougher-tiered-restrictions-for-england-video\",\"type\":\"video\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2020-11-23T18:25:32Z\",\"webTitle\":\"Boris Johnson sets out 'tougher' tiered restrictions for England during Commons debate – video\",\"webUrl\":\"https://www.theguardian.com/politics/video/2020/nov/23/boris-johnson-presents-tougher-tiered-restrictions-for-england-video\",\"apiUrl\":\"https://content.guardianapis.com/politics/video/2020/nov/23/boris-johnson-presents-tougher-tiered-restrictions-for-england-video\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"politics/2020/oct/08/belgian-ambassador-throws-king-charles-ii-treaty-into-eu-fishing-debate\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2020-10-08T16:53:01Z\",\"webTitle\":\"Belgian ambassador throws King Charles II treaty into EU fishing debate\",\"webUrl\":\"https://www.theguardian.com/politics/2020/oct/08/belgian-ambassador-throws-king-charles-ii-treaty-into-eu-fishing-debate\",\"apiUrl\":\"https://content.guardianapis.com/politics/2020/oct/08/belgian-ambassador-throws-king-charles-ii-treaty-into-eu-fishing-debate\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"commentisfree/2020/sep/30/trump-biden-debate-britain-special-relationship\",\"type\":\"article\",\"sectionId\":\"commentisfree\",\"sectionName\":\"Opinion\",\"webPublicationDate\":\"2020-09-30T17:02:42Z\",\"webTitle\":\"The Trump-Biden debate revealed the dangers of Britain's 'special relationship' | Martin Kettle\",\"webUrl\":\"https://www.theguardian.com/commentisfree/2020/sep/30/trump-biden-debate-britain-special-relationship\",\"apiUrl\":\"https://content.guardianapis.com/commentisfree/2020/sep/30/trump-biden-debate-britain-special-relationship\",\"isHosted\":false,\"pillarId\":\"pillar/opinion\",\"pillarName\":\"Opinion\"},{\"id\":\"business/2020/sep/18/mps-to-debate-arm-holdings-40bn-sale-despite-nvidia-bosss-guarantees\",\"type\":\"article\",\"sectionId\":\"business\",\"sectionName\":\"Business\",\"webPublicationDate\":\"2020-09-18T15:05:00Z\",\"webTitle\":\"MPs to debate Arm Holdings $40bn sale despite Nvidia boss's guarantees\",\"webUrl\":\"https://www.theguardian.com/business/2020/sep/18/mps-to-debate-arm-holdings-40bn-sale-despite-nvidia-bosss-guarantees\",\"apiUrl\":\"https://content.guardianapis.com/business/2020/sep/18/mps-to-debate-arm-holdings-40bn-sale-despite-nvidia-bosss-guarantees\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"commentisfree/2020/oct/26/ffree-school-meals-row-debate-poverty-desperate-situations\",\"type\":\"article\",\"sectionId\":\"commentisfree\",\"sectionName\":\"Opinion\",\"webPublicationDate\":\"2020-10-26T15:52:07Z\",\"webTitle\":\"The free school meals row should open up a debate about poverty itself  | Jack Monroe\",\"webUrl\":\"https://www.theguardian.com/commentisfree/2020/oct/26/ffree-school-meals-row-debate-poverty-desperate-situations\",\"apiUrl\":\"https://content.guardianapis.com/commentisfree/2020/oct/26/ffree-school-meals-row-debate-poverty-desperate-situations\",\"isHosted\":false,\"pillarId\":\"pillar/opinion\",\"pillarName\":\"Opinion\"},{\"id\":\"politics/2020/sep/14/keir-starmer-to-miss-crucial-brexit-debate-due-to-self-isolation-coronavirus\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2020-09-14T12:04:26Z\",\"webTitle\":\"Keir Starmer to miss crucial Brexit debate due to self-isolation\",\"webUrl\":\"https://www.theguardian.com/politics/2020/sep/14/keir-starmer-to-miss-crucial-brexit-debate-due-to-self-isolation-coronavirus\",\"apiUrl\":\"https://content.guardianapis.com/politics/2020/sep/14/keir-starmer-to-miss-crucial-brexit-debate-due-to-self-isolation-coronavirus\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"politics/2020/aug/28/barnier-flabbergasted-uk-attempt-reopen-brexit-specialty-food-drink-debate\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2020-08-28T13:58:33Z\",\"webTitle\":\"Barnier 'flabbergasted' at UK attempt to reopen Brexit specialty food debate\",\"webUrl\":\"https://www.theguardian.com/politics/2020/aug/28/barnier-flabbergasted-uk-attempt-reopen-brexit-specialty-food-drink-debate\",\"apiUrl\":\"https://content.guardianapis.com/politics/2020/aug/28/barnier-flabbergasted-uk-attempt-reopen-brexit-specialty-food-drink-debate\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"}]}}";
    //* Create a private constructor because no one should ever create a {@link QueryUtils} object.
     //* This class is only meant to hold static variables and methods, which can be accessed
     //* directly from the class name QueryUtils (and an object instance of QueryUtils is not needed).
     //*/
    private QueryUtils() {
    }

    /**
     * Return a list of {@link article objects that has been built up from
     * parsing a JSON response.
     */
    public static ArrayList<article> extractArticles() {

        // Create an empty ArrayList that we can start adding articles to
        ArrayList<article> articles = new ArrayList<>();

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            //create the root JSON object, parse the JSON response and store it in a variable
            // called baseJSONResponse
            JSONObject baseJsonResponse = new JSONObject(SAMPLE_JSON_RESPONSE);
            // call the getJSONArray method on the baseJsonResponse object, passing in the
            // response key as a string, and storing the result in the articleArray variable
            // which is of the data type JSONArray
            JSONArray articleArray = baseJsonResponse.getJSONArray("results");

            // loop through each article in the article array
            // as long as i is less than the number of articles in the array...
            for( int i = 0; i< articleArray.length(); i++){

                // pull out the JSON object at the specific position on the articleArray
                JSONObject currentArticle = articleArray.getJSONObject(i);
                // extract the JSONObject associated with the results key
                JSONObject results = currentArticle.getJSONObject("results");
                // get the data we need
                String articleHeadline = results.getString("webTitle");
                String articleSection = results.getString("sectionId");
                String articleDate = results.getString("webPublicationDate");

                article article = new article(articleHeadline, articleSection, articleDate);
                articles.add(article);
            }


        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the article JSON results", e);
        }


        // Return the list of earthquakes
        return articles;
    }

}