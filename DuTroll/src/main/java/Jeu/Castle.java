package Jeu;

public class Castle {
    private int id;
    private int stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Castle(int stock) {
        this.stock = stock;
    }
    public Castle(int stock, int id) {
        this.stock = stock;
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
