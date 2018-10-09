package homeaway.com.foodfinder.network;

import homeaway.com.foodfinder.model.venueModel.Response;
import homeaway.com.foodfinder.model.venueModel.Venue;
import homeaway.com.foodfinder.model.venueModel.VenueResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FourSquareService {

    // Request method and URL specified in the annotation

    //A default request to move the current user to seattle via the Foursquare API:
    // "https://api.foursquare.com/v2/venues/search?client_id=" + CLIENT_ID +
    // "&client_secret=" + CLIENT_SECRET + "&near=Seattle,+WA&query=restaurants&v=20181006";
    @GET("/v2/venues/search")
    Call<VenueResponse> searchVenues (
            @Query("client_id") String clientID,
            @Query("client_secret") String clientSecret,
            @Query("v") String date,
            @Query("near") String place,
            @Query("query") String query
    );


    //search recommendations based on user input using FourSquare API:
    // "https://api.foursquare.com/v2/venues/explore?client_id=" + CLIENT_ID +
    // "&client_secret=" + CLIENT_SECRET + "&near=Seattle,+WA&intent=tacos&v=20181007";
    @GET("/v2/venues/explore")
    Call<VenueResponse> SearchRecommendations (
            @Query("client_id") String clientID,
            @Query("client_secret") String clientSecret,
            @Query("v") String date,
            @Query("near") String place,
            @Query("intent") String userInput,
            @Query("limit") int limit
    );
}