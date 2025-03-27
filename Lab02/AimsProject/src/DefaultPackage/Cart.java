package DefaultPackage;

public class Cart {
    //11. Create the Cart class to work with DigitalVideoDisc
    public static final int MAX_NUMBERS_ORDER = 20;
    private final DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDER];
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

    //14. Working with method overloading
    //14.1 Overloading by differing types of parameter
//    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
//        if (qtyOrdered + dvdList.length <= MAX_NUMBERS_ORDER) {
//            for (DigitalVideoDisc disc : dvdList) {
//                itemOrdered[qtyOrdered] = disc;
//                qtyOrdered++;
//            }
//            System.out.println(dvdList.length + " discs have been added.");
//        } else {
//            System.out.println("Not enough space in the cart for all discs.");
//        }
//    }

    // pass an arbitrary number of arguments for dvd
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        if (qtyOrdered + dvds.length <= MAX_NUMBERS_ORDER) {
            for (DigitalVideoDisc disc : dvds) {
                itemOrdered[qtyOrdered] = disc;
                qtyOrdered++;
            }
            System.out.println(dvds.length + " discs added via varargs.");
        } else {
            System.out.println("Cart full. Only " + (MAX_NUMBERS_ORDER - qtyOrdered) + " slots left.");
        }
    }

    // 14.2 Overloading by differing the number of parameters
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 2 <= MAX_NUMBERS_ORDER) {
            itemOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            itemOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("Two discs \"" + dvd1.getTitle() + "\" and \"" + dvd2.getTitle() + "\" have been added.");
        } else {
            System.out.println("The cart cannot hold two more discs.");
        }
    }

    //13. Removing items from the cart
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
