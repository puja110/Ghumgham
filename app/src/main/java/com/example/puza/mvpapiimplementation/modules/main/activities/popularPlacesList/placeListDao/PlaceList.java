
package com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.placeListDao;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlaceList implements Serializable
{

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    public final static Creator<PlaceList> CREATOR = new Creator<PlaceList>() {

        @SuppressWarnings({
            "unchecked"
        })
        public PlaceList createFromParcel(Parcel in) {
            return new PlaceList(in);
        }

        public PlaceList[] newArray(int size) {
            return (new PlaceList[size]);
        }

    }
    ;
    private final static long serialVersionUID = -4121582882356685593L;

    protected PlaceList(Parcel in) {
        in.readList(this.data, (com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.placeListDao.Datum.class.getClassLoader()));
        this.links = ((Links) in.readValue((Links.class.getClassLoader())));
        this.meta = ((Meta) in.readValue((Meta.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public PlaceList() {
    }

    /**
     * 
     * @param data
     * @param links
     * @param meta
     */
    public PlaceList(List<Datum> data, Links links, Meta meta) {
        super();
        this.data = data;
        this.links = links;
        this.meta = meta;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(data);
        dest.writeValue(links);
        dest.writeValue(meta);
    }

    public int describeContents() {
        return  0;
    }

}
