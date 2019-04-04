package com.example.puza.mvpapiimplementation.application.network;

import com.example.puza.mvpapiimplementation.application.network.placeDetailDao.PlaceDetail;
import com.example.puza.mvpapiimplementation.application.network.placeReviewsDao.PlaceReviews;
import com.example.puza.mvpapiimplementation.application.network.postReviewDao.ReviewResponse;
import com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.placeListDao.PlaceList;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface AppNetwork {

    @POST
    @FormUrlEncoded
    Observable<ReviewResponse> createPostReview(
            @Url String  url,
            @Field(value = "customer") String customer,
                                      @Field(value = "review") String body,
                                      @Field(value = "star") Integer star);

    @GET("products")
    Observable<PlaceList> getPlaceList();

    @GET
    Observable<PlaceDetail> getPlacedescription(@Url String url);

    @GET
    Observable<PlaceReviews> getPlaceReviews(@Url String url);
}
