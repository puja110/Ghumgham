
package com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.placeListDao;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Href implements Serializable
{

    @SerializedName("link")
    @Expose
    private String link;
    public final static Creator<Href> CREATOR = new Creator<Href>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Href createFromParcel(Parcel in) {
            return new Href(in);
        }

        public Href[] newArray(int size) {
            return (new Href[size]);
        }

    }
    ;
    private final static long serialVersionUID = -4309183227193451914L;

    protected Href(Parcel in) {
        this.link = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Href() {
    }

    /**
     * 
     * @param link
     */
    public Href(String link) {
        super();
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(link);
    }

    public int describeContents() {
        return  0;
    }

}
