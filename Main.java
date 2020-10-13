import java.lang.Math;

class Main {
  public static void main(String[] args) {
    task1();

  }


  public static void task1(){
    System.out.println("Hello world!");
    int n = 4; 
    double center = 0;
    double p = 0;
    double c[][] = {{5,3,1,7} , {0.3,0.2,0.3,0.2}};
    for(int k = 0; k<n; k++){
      p += c[0][k];
      System.out.println("p"+k+": "+ p);
    }
    p = p/n;
    System.out.println("p: "+p);

    for(int i=0; i<n; i++){
      //w (x - c)

        center += c[1][i] * Math.abs(c[0][i] - p); 
        System.out.println("center"+i+": "+center);
    }

    System.out.println("center: "+center);
  }
}