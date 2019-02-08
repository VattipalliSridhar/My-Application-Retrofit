
package com.example.myapplicationretrofit.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExampleFinal {

    @SerializedName("restaurants")
    @Expose
    private List<Restaurant> restaurants = null;

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }


    public class Restaurant{
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("backgroundImageURL")
        @Expose
        private String backgroundImageURL;
        @SerializedName("category")
        @Expose
        private String category;
        @SerializedName("contact")
        @Expose
        private Contact contact;
        @SerializedName("location")
        @Expose
        private Location location;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBackgroundImageURL() {
            return backgroundImageURL;
        }

        public void setBackgroundImageURL(String backgroundImageURL) {
            this.backgroundImageURL = backgroundImageURL;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public Contact getContact() {
            return contact;
        }

        public void setContact(Contact contact) {
            this.contact = contact;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }
    }

}
