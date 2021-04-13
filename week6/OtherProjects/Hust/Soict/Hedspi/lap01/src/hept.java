package week1;
public class hept {
    private int a11,a12,a21,a22,b1,b2;
    private int d,d1,d2;
    public hept(int a11, int a12,int a21,int a22,int b1,int b2) {
        this.a11 = a11;
        this.a12 = a12;
        this.a21 = a21;
        this.a22 = a22;
        this.b1 = b1;
        this.b2 = b2;
    }

    public String resolve(){
        d=a11*a22-a21*a12;
        d1=b1*a22-b2*a12;
        d2=a11*b2-a21*b1;
        if(this.d==0){
            if(this.d1==0){
                if(this.d2==0) return("pt vô số nghiệm");
                else return("pt vô nghiệm");
            }else return("pt vô nghiệm");
        }else return("hệ pt có nghiệm (x1,x2)=( "+d1/d+","+d2/d+" )");
    }
}