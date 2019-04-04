
package com.example.puza.mvpapiimplementation.application.network.postReviewDao;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Errors implements Serializable
{

    @SerializedName("star")
    @Expose
    private List<String> star = null;
    @SerializedName("review")
    @Expose
    private List<String> review = null;
    private final static long serialVersionUID = -5795568951001074733L;

    public List<String> getStar() {
        return star;
    }

    public void setStar(List<String> star) {
        this.star = star;
    }

    public List<String> getReview() {
        return review;
    }

    public void setReview(List<String> review) {
        this.review = review;
    }

}
