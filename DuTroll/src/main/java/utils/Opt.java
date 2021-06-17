package utils;

public class Opt {
    int pertej1;
    int pertej2;
    int dplTroll;

    public Opt(int pertej1, int pertej2, int dplTroll) {
        this.pertej1 = pertej1;
        this.pertej2 = pertej2;
        this.dplTroll = dplTroll;
    }

    public void setPertej1(int pertej1) {
        this.pertej1 = pertej1;
    }

    public void setPertej2(int pertej2) {
        this.pertej2 = pertej2;
    }

    public void setDplTroll(int dplTroll) {
        this.dplTroll = dplTroll;
    }

    public int getPertej1() {
        return pertej1;
    }

    public int getPertej2() {
        return pertej2;
    }

    public int getDplTroll() {
        return dplTroll;
    }
}
