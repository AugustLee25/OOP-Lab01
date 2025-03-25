package DefaultPackage;

public class Cart {
    public static final int MAX_NUMBERS_ORDER = 20;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDER];
    private int qtyOrdered = 0;

    //add DVD
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if(qtyOrdered < MAX_NUMBERS_ORDER) {
            itemOrdered[qtyOrdered++] = disc;
            System.out.println("DVD has been added");
        }
        else {
            System.out.println("Your cart is full, consider removing before adding a new one");
        }
    }

    //remove DVD
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for(int i = 0;i < qtyOrdered;i++) {
            if(itemOrdered[i].getTitle().equals(disc.getTitle())) {
                for(int j = i;j < qtyOrdered-1;j++) {
                    itemOrdered[j] = itemOrdered[j+1];
                }
            }
            qtyOrdered--;
            System.out.println("DVD has been removed");
            break;
        }
    }

    //Display cart
    public void displayCart() {
        System.out.println("------- Cart Display -------");
        for (int i = 0;i <  qtyOrdered;i++) {
            System.out.printf("%-20s %-15s %-20s %-5d %-5.2f \n", itemOrdered[i].getTitle(), itemOrdered[i].getCategory(),
                    itemOrdered[i].getDirector(), itemOrdered[i].getLength(), itemOrdered[i].getCost());
        }
    }

    //sum the costs
    public double totalCost(){
        double total = 0;
        for(int i = 0;i < qtyOrdered;i++) {
            total += itemOrdered[i].getCost();
        }
        return total;
    }
}
