package tabian.com.actionbartest.databases;

/**
 * Created by hieuv on 7/3/2017.
 */

public class MainModel extends ProductModel {

    private String socket;
    private String ramsupport;

    public MainModel(String species, String description, Integer price, String image, String socket, String ramsupport) {
        this.species = species;
        this.description = description;
        this.price = price;
        this.image = image;
        this.socket = socket;
        this.ramsupport = ramsupport;
    }


    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getRamsupport() {
        return ramsupport;
    }

    public void setRamsupport(String ramsupport) {
        this.ramsupport = ramsupport;
    }
}
