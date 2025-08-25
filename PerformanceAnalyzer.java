import java.util.Scanner;

public class PerformanceAnalyzer {
    public static long measureTime(Runnable task){
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        return (endTime - startTime)/1000;
    }

    public static void main(String args[]){
        Scanner sken = new Scanner(System.in);

        System.out.println("**********");
        System.out.println("Welcome!");
        System.out.println("1 - Measure time of one algorithm");
        System.out.println("2 - Compare times of two algorithms");
        System.out.println("3 - Exit");
        System.out.print("Pick an option: ");

        int choice = sken.nextInt();
        // System.out.println(choice);
        switch (choice){
            case 1:
                System.out.println("**********");
                System.out.println("1 - Arrays");
                System.out.println("2 - HashMaps");
                System.out.println("3 - Linked Lists");
                System.out.print("What datastructure would you like to pick? ");

                int izbor2 = sken.nextInt();
                switch (izbor2){
                    case 1:
                        System.out.println("**********");
                        System.out.println("1 - Adding 1000 numbers into a array");
                        System.out.print("What would you like to test? ");
                        int izbor3 = sken.nextInt();
                        switch (izbor3){
                            case 1: {
                                Long duration = measureTime(()->{
                                    Array1();
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                            }
                        }
                }








    }}
    public static void Array1(){
        int[] array = new int[1000];
        for (int i=0; i<array.length;i++){
            array[i] = i;
        }
    }
}
