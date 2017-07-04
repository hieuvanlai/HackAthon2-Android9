package tabian.com.actionbartest.databases;

/**
 * Created by hieuv on 7/4/2017.
 */

public class ProductModel {
    public String species;
    public String description;
    public Integer price;
    public String image;

    public ProductModel(String species, String description, Integer price, String image) {
        this.species = species;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public ProductModel() {
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
