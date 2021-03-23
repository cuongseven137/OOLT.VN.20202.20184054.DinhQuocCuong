

public class Order {
    public static final int MAX_LIMITTED_ORDERS = 5;
    public static final int MAX_NUMBERS_ORDERED = 10;
    
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    
    private static int nbOrders = 0;
    private int qtyOrdered = 0;
    private float ttCost;
    private MyDate dateOrdered;
    
    private Order() {
        dateOrdered = new MyDate();
    }
   
    public static Order getInstanceOrder() { //
        if(nbOrders < MAX_LIMITTED_ORDERS)
        {
            nbOrders++;
            Order newOrder = new Order();
            return newOrder;
        }
        else {
            System.out.println("The numbers of orders is almost max.");
            return null;
        }    
    }
    
    public int getQtyOrdered() {
        return qtyOrdered;
    }
    
    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if(qtyOrdered < MAX_NUMBERS_ORDERED){
            this.itemsOrdered[this.qtyOrdered++] = disc;
            System.out.printf("The disc %s has been added.\n",disc.getTitle());
        }
        else System.out.println("The order is almost full.");
    }
    public void addDigitalVideoDisc(DigitalVideoDisc ... dvdlist) {
        if(qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The order is almost full.");
            return;
        }
        
        for (DigitalVideoDisc dvdlist1 : dvdlist) {
            addDigitalVideoDisc(dvdlist1);
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if(qtyOrdered > 0 ){
            for(int i=0; i<qtyOrdered; i++){
                if(disc.equals(itemsOrdered[i])) 
                {
                    for(int j=i; j<qtyOrdered-1; j++) {
                        itemsOrdered[j] = itemsOrdered[j+1];
                    }
                    itemsOrdered[--qtyOrdered] = null;
                    break;
                }
            }
            System.out.printf("The disc %s has been removed.\n",disc.getTitle());
        }
        else System.out.println("The order is almost empty.");
    }
    
    public float totalCost() {
        ttCost = 0;
        for(int i = 0; i < qtyOrdered; i++){
            ttCost += itemsOrdered[i].getCost(); 
        }
        return ttCost;
    }
    public void printOrdered() {
        System.out.println("***********************Order***********************");
        System.out.print("Date: ");
        dateOrdered.print();
        System.out.print("\nOrdered Items:\n");
        
        for(int i=0;i<qtyOrdered;i++) {
            System.out.printf("%d. DVD - " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() +
                    " - " + itemsOrdered[i].getDirector() + " - %d: %.2f $\n",i+1,itemsOrdered[i].getLength(),itemsOrdered[i].getCost());
        }
        System.out.printf("Total cost: %.2f\n", totalCost());
        System.out.println("***************************************************");
    }
}