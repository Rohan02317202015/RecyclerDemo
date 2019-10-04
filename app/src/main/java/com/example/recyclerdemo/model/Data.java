package com.example.recyclerdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {

    private String name;
    private String aboutYou;
    public final static Parcelable.Creator<Data> CREATOR = new Creator<Data>() {


        @SuppressWarnings({"unchecked"})
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        public Data[] newArray(int size) {
            return (new Data[size]);
        }

    };


    protected Data(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.aboutYou = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Data() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAboutYou() {
        return aboutYou;
    }

    public void setAboutYou(String aboutYou) {
        this.aboutYou = aboutYou;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(aboutYou);
    }

    public int describeContents() {
        return 0;
    }

}

