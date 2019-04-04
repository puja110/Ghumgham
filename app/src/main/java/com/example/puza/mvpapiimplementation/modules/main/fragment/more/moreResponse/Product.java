
package com.example.puza.mvpapiimplementation.modules.main.fragment.more.moreResponse;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Product implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("subcategory_id")
    @Expose
    private String subcategoryId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("views")
    @Expose
    private String views;
    @SerializedName("product_slug")
    @Expose
    private String productSlug;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("runtime")
    @Expose
    private String runtime;
    @SerializedName("adtype")
    @Expose
    private String adtype;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("image1")
    @Expose
    private String image1;
    @SerializedName("image2")
    @Expose
    private String image2;
    @SerializedName("image3")
    @Expose
    private String image3;
    @SerializedName("negotiable")
    @Expose
    private String negotiable;
    @SerializedName("product_condition")
    @Expose
    private String productCondition;
    @SerializedName("usedfor")
    @Expose
    private String usedfor;
    @SerializedName("lotno")
    @Expose
    private String lotno;
    @SerializedName("engine")
    @Expose
    private String engine;
    @SerializedName("makeyear")
    @Expose
    private String makeyear;
    @SerializedName("mileage")
    @Expose
    private String mileage;
    @SerializedName("kilometer")
    @Expose
    private String kilometer;
    @SerializedName("features")
    @Expose
    private Object features;
    @SerializedName("detailurl")
    @Expose
    private String detailurl;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("thisadd")
    @Expose
    private String thisadd;
    @SerializedName("delivery_charge")
    @Expose
    private Object deliveryCharge;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("ads_view")
    @Expose
    private String adsView;
    @SerializedName("discount")
    @Expose
    private String discount;
    @SerializedName("home_delivery")
    @Expose
    private String homeDelivery;
    @SerializedName("warranty")
    @Expose
    private String warranty;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("full_image_url")
    @Expose
    private String fullImageUrl;
    public final static Creator<Product> CREATOR = new Creator<Product>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        public Product[] newArray(int size) {
            return (new Product[size]);
        }

    }
    ;
    private final static long serialVersionUID = 767988906623325586L;

    protected Product(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.userId = ((String) in.readValue((String.class.getClassLoader())));
        this.categoryId = ((String) in.readValue((String.class.getClassLoader())));
        this.subcategoryId = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.views = ((String) in.readValue((String.class.getClassLoader())));
        this.productSlug = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.runtime = ((String) in.readValue((String.class.getClassLoader())));
        this.adtype = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.price = ((String) in.readValue((String.class.getClassLoader())));
        this.image1 = ((String) in.readValue((String.class.getClassLoader())));
        this.image2 = ((String) in.readValue((String.class.getClassLoader())));
        this.image3 = ((String) in.readValue((String.class.getClassLoader())));
        this.negotiable = ((String) in.readValue((String.class.getClassLoader())));
        this.productCondition = ((String) in.readValue((String.class.getClassLoader())));
        this.usedfor = ((String) in.readValue((String.class.getClassLoader())));
        this.lotno = ((String) in.readValue((String.class.getClassLoader())));
        this.engine = ((String) in.readValue((String.class.getClassLoader())));
        this.makeyear = ((String) in.readValue((String.class.getClassLoader())));
        this.mileage = ((String) in.readValue((String.class.getClassLoader())));
        this.kilometer = ((String) in.readValue((String.class.getClassLoader())));
        this.features = ((Object) in.readValue((Object.class.getClassLoader())));
        this.detailurl = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.thisadd = ((String) in.readValue((String.class.getClassLoader())));
        this.deliveryCharge = ((Object) in.readValue((Object.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.adsView = ((String) in.readValue((String.class.getClassLoader())));
        this.discount = ((String) in.readValue((String.class.getClassLoader())));
        this.homeDelivery = ((String) in.readValue((String.class.getClassLoader())));
        this.warranty = ((String) in.readValue((String.class.getClassLoader())));
        this.currency = ((String) in.readValue((String.class.getClassLoader())));
        this.fullImageUrl = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getProductSlug() {
        return productSlug;
    }

    public void setProductSlug(String productSlug) {
        this.productSlug = productSlug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getAdtype() {
        return adtype;
    }

    public void setAdtype(String adtype) {
        this.adtype = adtype;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getNegotiable() {
        return negotiable;
    }

    public void setNegotiable(String negotiable) {
        this.negotiable = negotiable;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public String getUsedfor() {
        return usedfor;
    }

    public void setUsedfor(String usedfor) {
        this.usedfor = usedfor;
    }

    public String getLotno() {
        return lotno;
    }

    public void setLotno(String lotno) {
        this.lotno = lotno;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getMakeyear() {
        return makeyear;
    }

    public void setMakeyear(String makeyear) {
        this.makeyear = makeyear;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getKilometer() {
        return kilometer;
    }

    public void setKilometer(String kilometer) {
        this.kilometer = kilometer;
    }

    public Object getFeatures() {
        return features;
    }

    public void setFeatures(Object features) {
        this.features = features;
    }

    public String getDetailurl() {
        return detailurl;
    }

    public void setDetailurl(String detailurl) {
        this.detailurl = detailurl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getThisadd() {
        return thisadd;
    }

    public void setThisadd(String thisadd) {
        this.thisadd = thisadd;
    }

    public Object getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(Object deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getAdsView() {
        return adsView;
    }

    public void setAdsView(String adsView) {
        this.adsView = adsView;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getHomeDelivery() {
        return homeDelivery;
    }

    public void setHomeDelivery(String homeDelivery) {
        this.homeDelivery = homeDelivery;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFullImageUrl() {
        return fullImageUrl;
    }

    public void setFullImageUrl(String fullImageUrl) {
        this.fullImageUrl = fullImageUrl;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(userId);
        dest.writeValue(categoryId);
        dest.writeValue(subcategoryId);
        dest.writeValue(title);
        dest.writeValue(views);
        dest.writeValue(productSlug);
        dest.writeValue(description);
        dest.writeValue(runtime);
        dest.writeValue(adtype);
        dest.writeValue(location);
        dest.writeValue(price);
        dest.writeValue(image1);
        dest.writeValue(image2);
        dest.writeValue(image3);
        dest.writeValue(negotiable);
        dest.writeValue(productCondition);
        dest.writeValue(usedfor);
        dest.writeValue(lotno);
        dest.writeValue(engine);
        dest.writeValue(makeyear);
        dest.writeValue(mileage);
        dest.writeValue(kilometer);
        dest.writeValue(features);
        dest.writeValue(detailurl);
        dest.writeValue(status);
        dest.writeValue(thisadd);
        dest.writeValue(deliveryCharge);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(adsView);
        dest.writeValue(discount);
        dest.writeValue(homeDelivery);
        dest.writeValue(warranty);
        dest.writeValue(currency);
        dest.writeValue(fullImageUrl);
    }

    public int describeContents() {
        return  0;
    }

}
