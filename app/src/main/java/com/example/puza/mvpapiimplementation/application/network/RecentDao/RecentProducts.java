
package com.example.puza.mvpapiimplementation.application.network.RecentDao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class RecentProducts implements Serializable, Parcelable
{

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private List<Message> message = null;
    public final static Creator<RecentProducts> CREATOR = new Creator<RecentProducts>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RecentProducts createFromParcel(Parcel in) {
            return new RecentProducts(in);
        }

        public RecentProducts[] newArray(int size) {
            return (new RecentProducts[size]);
        }

    }
    ;
    private final static long serialVersionUID = -7986984554482711726L;

    protected RecentProducts(Parcel in) {
        this.status = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        in.readList(this.message, (com.example.puza.mvpapiimplementation.application.network.RecentDao.Message.class.getClassLoader()));
    }

    public RecentProducts() {
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
