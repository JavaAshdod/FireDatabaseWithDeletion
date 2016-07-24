package tomer.edu.firedemo.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by stud27 on 24/07/16.
 */
public class ShoppingList implements Parcelable {
    private String title;
    private String ownerEmail;
    private String ownerId;

    public ShoppingList() {
    }

    public ShoppingList(String title, String ownerEmail, String ownerId) {
        this.title = title;
        this.ownerEmail = ownerEmail;
        this.ownerId = ownerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "ShoppingList{" +
                "title='" + title + '\'' +
                ", ownerEmail='" + ownerEmail + '\'' +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.ownerEmail);
        dest.writeString(this.ownerId);
    }

    protected ShoppingList(Parcel in) {
        this.title = in.readString();
        this.ownerEmail = in.readString();
        this.ownerId = in.readString();
    }

    public static final Parcelable.Creator<ShoppingList> CREATOR = new Parcelable.Creator<ShoppingList>() {
        @Override
        public ShoppingList createFromParcel(Parcel source) {
            return new ShoppingList(source);
        }

        @Override
        public ShoppingList[] newArray(int size) {
            return new ShoppingList[size];
        }
    };
}
