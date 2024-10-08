package Playground;

public class JITexample {
    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            calculate();
        }
    }
    
    public static void calculate() {
        int a = 5;
        int b = 10;
        int result = a * b;
    }
}
