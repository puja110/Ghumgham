
package com.example.puza.mvpapiimplementation.application.network.ProductCategoriesDAO;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ProductCategories implements Serializable, Parcelable
{

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private List<Message> message = null;
    public final static Creator<ProductCategories> CREATOR = new Creator<ProductCategories>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ProductCategories createFromParcel(Parcel in) {
            return new ProductCategories(in);
        }

        public ProductCategories[] newArray(int size) {
            return (new ProductCategories[size]);
        }

    }
    ;
    private final static long serialVersionUID = 7769063929867528573L;

    protected ProductCategories(Parcel in) {
        this.status = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        in.readList(this.message, (com.example.puza.mvpapiimplementation.application.network.ProductCategoriesDAO.Message.class.getClassLoader()));
    }

    public ProductCategories() {
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
