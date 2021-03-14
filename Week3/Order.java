public class Order {
    public static final int MAX_NUMBERS_ORDERED = 10;

    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    private int qtyOrdered;

    public Order() {
    }

    public Order(int qtyOrdered) {
        super();
        this.qtyOrdered = qtyOrdered;
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int qtyOdered) {
        this.qtyOrdered = qtyOdered;
    }

    void addDigitalVideoDisc(DigitalVideoDisc disc) {
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
    }

    int search(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (disc == itemsOrdered[i]) {
                return i;
            }
        }
        return -1;
    }

    void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (search(disc) >= 0) {
            for (int i = search(disc); i < qtyOrdered; i++) {
                itemsOrdered[i] = itemsOrdered[i + 1];
            }
            qtyOrdered--;
        } else
            System.out.println("khong co gia tri");
    }

    float totalCost() {
        float sum = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println(itemsOrdered[i].getTitle() + "-" + itemsOrdered[i].getCategory() + "-"
                    + itemsOrdered[i].getDirector() + "-" + itemsOrdered[i].getLength() + "-"
                    + itemsOrdered[i].getCost());
        }
        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost();

        }
        return sum;
    }
}