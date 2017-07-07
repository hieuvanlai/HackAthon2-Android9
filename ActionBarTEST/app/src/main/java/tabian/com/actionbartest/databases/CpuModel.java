package tabian.com.actionbartest.databases;

/**
 * Created by hieuv on 7/3/2017.
 */

public class CpuModel  extends ProductModel {

    private String socket;

    public CpuModel(String species, String description, Integer price, String image, String socket) {

        this.species = species;
        this.description = description;
        this.price = price;
        this.image = image;
        this.socket = socket;
    }

    public String getSocket() {
        return socket;
    }
    public void setSocket(String socket) {
        this.socket = socket;
    }
}
