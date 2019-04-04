package com.example.puza.mvpapiimplementation.modules.main.fragment.more.moreResponse;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class FeaturedProducts implements Serializable, Parcelable
{

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private List<Message> message = null;
    public final static Creator<FeaturedProducts> CREATOR = new Creator<FeaturedProducts>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FeaturedProducts createFromParcel(Parcel in) {
            return new FeaturedProducts(in);
        }

        public FeaturedProducts[] newArray(int size) {
            return (new FeaturedProducts[size]);
        }

    }
    ;
    private final static long serialVersionUID = -1571321255164482325L;

    protected FeaturedProducts(Parcel in) {
        this.status = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        in.readList(this.message, (Message.class.getClassLoader()));
    }

    public FeaturedProducts() {
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeList(message);
    }

    public int describeContents() {
        return  0;
    }

}
