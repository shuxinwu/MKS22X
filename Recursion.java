public class Recursion{

  public int fact(int n){
    if (n < 0){
      throw new IllegalArgumentException();
    }
    return factHelp(n, 1);
  }

  public int factHelp(int n, int f){
    if (n < 0){
      throw new IllegalArgumentException();
    }
    if (n == 0){
      return f;
    }
    return factHelp(n - 1, f * n);
  }

  public int fib(int n){
    if (n < 0){
      throw new IllegalArgumentException();
    }
    return fibHelp(n, 0, 1);
  }

  public int fibHelp(int n, int a, int b){
    if (n < 0){
      throw new IllegalArgumentException();
    }
    if (n == 0){
      return 0;
    }
    if (n == 1){
      return 1;
    }
    if (n == 2){
      return a + b;
    }
    return fibHelp(n - 1, b, a + b);
  }

  public double sqrt(double n){
    if (n < 0){
      throw new IllegalArgumentException();
    }
    return sqrtHelp(n, n / 2, n * 100);
  }

  public double sqrtHelp(double n, double g, double h){
    double diff = (Math.abs(g - h)) / h;
    if (diff < 0.000001){
      return g;
    }
    double ng = (n / g + g) / 2;
    return sqrtHelp(n, ng, g);
  }

}
