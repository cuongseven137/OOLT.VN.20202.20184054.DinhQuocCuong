package week4;
import java.util.*;

public class Order {
    public static final int MAX_NUMBERS_ORDERED = 3;
    public static final int MAX_LIMITTED_ORDERS = 2;
    private static int nbOrder=0;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int dem=0;
    private int stt=0;
    boolean cont=true;
    Scanner sc = new Scanner(System.in);

    public Order(){
        nbOrder++;
    }

    public void qtyOrdered(){
        if(dem<MAX_NUMBERS_ORDERED-1) System.out.println("Đã được thêm vào Order");
        if(dem==MAX_NUMBERS_ORDERED-1) System.out.println("Đã được thêm vào Order,Order sắp đầy"); 
        if(dem==MAX_NUMBERS_ORDERED) System.out.println("Đã được thêm vào Order,Order đã đầy"); 
        if(dem>MAX_NUMBERS_ORDERED) System.out.println("Đã đầy, không thể thêm");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        dem++;
        System.out.println(dem + ". DVD - " + disc.getTitle() + " - " + disc.getCategory() + " - " + disc.getDirector() + " - " + disc.getLength() + " - " + disc.getCost());
        qtyOrdered();
        if(dem<=10) {
            itemsOrdered[dem-1]=disc;
        }else {
            System.out.println("Đã xóa");
            dem--;
        }           
    }

    public void addDigitalVideoDiscmang(DigitalVideoDisc[] disc){
        if(nbOrder<=MAX_LIMITTED_ORDERS){
            itemsOrdered = disc;
            while(cont){
                dem++;
                stt++;
                System.out.println(stt + ". DVD - " + disc[dem-1].getTitle() + " - " + disc[dem-1].getCategory() + " - " + disc[dem-1].getDirector() + " - " + disc[dem-1].getLength() + " - " + disc[dem-1].getCost());
                qtyOrdered();
                if(dem>MAX_NUMBERS_ORDERED){
                    int chon;
                    int nhapDVD;
                    boolean a=true;
                    System.out.println("Bạn có muốn xóa 1 DVD đã chọn để thay thế DVD này");
                    System.out.println("1.có\n2.không");  
                do{
                    System.out.print("Bạn chọn: "); chon=sc.nextInt();
                    switch(chon){
                        case 1:
                        System.out.print("Nhập DVD bạn muốn xóa: "); nhapDVD=sc.nextInt();
                        removeDigitalVideoDisc(disc[nhapDVD-1]);
                        System.out.println("DVD" + nhapDVD + " đã xóa khỏi danh sách");
                        System.out.println("DVD"+ stt + " đã được thêm vào danh sách");
                        a = false;
                        break;
                        case 2:
                        System.out.println("DVD" + stt +" đã xóa khỏi danh sách");
                        a = false;
                        break;
                        default:
                        System.out.println("Bạn chọn sai, hãy chọn lại");
                        break;
                    }
                }while(a);
                }
                if(stt == disc.length) cont=false;
            } 
        }else System.out.println("Đã quá giới hạn cho phép");
    }

    public float totalCost(DigitalVideoDisc[] disc){
        float tong=0;
        if(dem>MAX_NUMBERS_ORDERED){
            for(int i=0;i<MAX_NUMBERS_ORDERED ;i++){
                tong +=disc[i].getCost();
            }
        } else{
            for(int i=0;i<dem ;i++){
                tong +=disc[i].getCost();
            }
        }
        return tong;
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        for(int i=0;i<=dem - 1;i++){
            if(itemsOrdered[i]==disc){
                itemsOrdered[i]=itemsOrdered[i+1];
            }        
        } 
    }
}
