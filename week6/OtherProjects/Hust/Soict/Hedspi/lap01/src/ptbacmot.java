package week1;
public class ptbacmot {
    private int a, b;
    public ptbacmot(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String resolve(){
        if(a==0 && b==0) return("pt vô nghiệm");
        else if (a!=0) return("pt có nghiệm là: "+ -(double)b/a);
        else return null;
    }
}
