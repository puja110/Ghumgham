
package com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.placeListDao;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum implements Serializable
{

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("totalPrice")
    @Expose
    private Double totalPrice;

    @SerializedName("rating")
    @Expose
    private String rating;

    @SerializedName("discount")
    @Expose
    private Integer discount;
    @SerializedName("href")
    @Expose
    private Href href;

    private final static long serialVersionUID = 6051957559550664508L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Datum() {
    }

    /**
     * 
     * @param name
     * @param rating
     * @param href
     * @param discount
     * @param totalPrice
     */
    public Datum(String id, String name, Double totalPrice, String rating, Integer discount, Href href) {
        super();
        this.id = id;
        this.name = name;
        this.totalPrice = totalPrice;
        this.rating = rating;
        this.discount = discount;
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Href getHref() {
        return href;
    }

    public void setHref(Href href) {
        this.href = href;
    }

    public int describeContents() {
        return  0;
    }

}
