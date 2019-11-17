package TipoCola;

import java.util.ArrayList;
import java.util.List;

public class Cashier {
    private int number;
    private List<String> attended;

    public Cashier(int number) {
        this.number = number;
        attended = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public List<String> getAttended() {
        return attended;
    }

    public void setAttended(String turn) {
        attended.add(turn);
    }
}
