package Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Product {
    int id;
    String title;


    String description;
    Float price;
    Float discountPercentaje;
    Float rating;
    int stock;
    String brand;
    String category;
    String thumbnail;
    String [] images;

    public  Product (JSONObject data) throws JSONException {
        id =  Integer.parseInt( data.getString("id"));
        title =  data.getString("title");
        description = data.getString("description");
        price = Float.parseFloat( data.getString("price"));
        discountPercentaje =  Float.parseFloat(data.getString("discountPercentage"));
        rating =  Float.parseFloat(data.getString("rating"));
        stock =  Integer.parseInt( data.getString("stock"));
        brand =  data.getString("brand");
        category =  data.getString("category");
        thumbnail =  data.getString("thumbnail");
        images = new String[data.getJSONArray("images").length()];
        JSONArray images_data = data.getJSONArray("images");
        for (int index = 0; index < images_data.length(); index++){
            images[index] = images_data.get(index).toString();
        }
    }



    public static ArrayList<Product> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Product> products = new ArrayList<Product>();
        for (int i = 0; i < datos.length(); i++) {
            products.add(new Product(datos.getJSONObject(i)));
        }
        return products;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getDiscountPercentaje() {
        return discountPercentaje;
    }

    public void setDiscountPercentaje(Float discountPercentaje) {
        this.discountPercentaje = discountPercentaje;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String [] images) {
        this.images = images;
    }
}
