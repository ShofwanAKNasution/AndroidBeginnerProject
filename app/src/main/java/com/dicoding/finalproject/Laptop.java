package com.dicoding.finalproject;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Laptop implements Parcelable {
    private String Name;
    private String Price;
    private String Specification;
    private String Link;

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    private Integer Picture;

    protected Laptop(Parcel in) {
        Name = in.readString();
        Price = in.readString();
        Specification = in.readString();
        Link = in.readString();
        Picture = in.readInt();
    }

    public static final Parcelable.Creator<Laptop> CREATOR = new Parcelable.Creator<Laptop>() {
        @Override
        public Laptop createFromParcel(Parcel in) {
            return new Laptop(in);
        }

        @Override
        public Laptop[] newArray(int size) {
            return new Laptop[size];
        }
    };

    public Laptop() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getSpecification() {
        return Specification;
    }

    public void setSpecification(String specification) {
        Specification = specification;
    }

    public Integer getPicture() {
        return Picture;
    }

    public void setPicture(Integer picture) {
        Picture = picture;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.Name);
        parcel.writeString(this.Price);
        parcel.writeString(this.Specification);
        parcel.writeString(this.Link);
        parcel.writeInt(this.Picture);
    }
}
