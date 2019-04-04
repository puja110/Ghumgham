
package com.example.puza.mvpapiimplementation.modules.main.fragment.more.moreResponse;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Message implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("added_date")
    @Expose
    private String addedDate;
    @SerializedName("product")
    @Expose
    private Product product;
    public final static Creator<Message> CREATOR = new Creator<Message>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        public Message[] newArray(int size) {
            return (new Message[size]);
        }

    }
    ;
    private final static long serialVersionUID = -1855251378804263673L;

    protected Message(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.productId = ((String) in.readValue((String.class.getClassLoader())));
        this.addedDate = ((String) in.readValue((String.class.getClassLoader())));
        this.product = ((Product) in.readValue((Product.class.getClassLoader())));
    }

    public Message() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(productId);
        dest.writeValue(addedDate);
        dest.writeValue(product);
    }

    public int describeContents() {
        return  0;
    }

}
