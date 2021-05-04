package week1;
public class ptbachai {
    private double a,b,c,denta;
    public ptbachai(double a, double b,double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String resolve(){
        denta=b*b - 4*a*c;
        if(denta==0){
            return ("pt có nghiệm là: "+b/(2*a));
        }else if(denta > 0){
            return ("pt có 2 nghiệm là: "+ (-b+ Math.sqrt(denta))/(2*a) +" và "+ (-b-Math.sqrt(denta))/(2*a));
        }else return ("pt vô nghiệm");
    }
}
