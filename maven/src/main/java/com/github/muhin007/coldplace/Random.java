import java.util.Random;

class random{
    public static void main(String[] args){
        Random r = new Random();
        for (int i = 0; i < 1; i++) {
            int q = r.nextInt(101) - 50;
            System.out.println(q);
        }
    }
}
