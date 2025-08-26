import java.util.Scanner;
import java.util.LinkedList;
import java.util.HashMap;

public class PerformanceAnalyzer {
    public static long measureTime(Runnable task){
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        return (endTime - startTime)/1000;
    }
    public static long measureMemory(Runnable task){
        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long before = runtime.totalMemory() - runtime.freeMemory();

        task.run();

        long after = runtime.totalMemory() - runtime.freeMemory();

        return after - before;

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
                System.out.println("2 - LinkedLists");
                System.out.println("3 - Hashmaps");
                System.out.print("What datastructure would you like to pick? ");

                int izbor2 = sken.nextInt();
                switch (izbor2){
                    // ceo jedan case je za Arrays
                    case 1:
                        System.out.println("**********");
                        System.out.println("1 - Adding 1000 numbers into a Array");
                        System.out.println("2 - Removing an element from Array");
                        System.out.println("3 - Adding an element to Array");
                        System.out.print("What would you like to test? ");
                        int izbor3 = sken.nextInt();
                        switch (izbor3){
                            case 1: {
                                Long duration = measureTime(()->{
                                    array1000();
                                });
                                Long memoryUsage = measureMemory(()->{
                                    array1000();
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                                System.out.println("Memorija koju je zauzeo ovaj algoritam iznosi: " + memoryUsage + " bajta");
                                break;
                            }
                            case 2:{
                                Long duration = measureTime(()->{
                                    arrayDelete();
                                });
                                Long memoryUsage = measureMemory(()->{
                                    arrayDelete();
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                                System.out.println("Memorija koju je zauzeo ovaj algoritam iznosi: " + memoryUsage + " bajta");
                                break;
                            }
                            case 3:{
                                Long duration = measureTime(()->{
                                    arrayAdd();
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                                break;
                            }

                        }
                        break;
                        // Tek ovde pocinje ceo jedan case za LinkedLists
                    case 2:
                        System.out.println("**********");
                        System.out.println("1 - Adding 1000 numbers into a LinkedList");
                        System.out.println("2 - Removing an element from a LinkedList ");
                        System.out.println("3 - Adding an element to LinkedList");
                        System.out.print("What would you like to test? ");
                        int izbor4 = sken.nextInt();
                        switch (izbor4){
                            case 1: {
                                Long duration = measureTime(()->{
                                    linkedList1000();
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                                break;
                        }
                            case 2: {
                                Long duration = measureTime(()->{
                                    linkedListDelete();
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                                break;
                            }
                            case 3: {
                                Long duration = measureTime(()->{
                                    linkedListAdd();
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                                break;
                            }

                }
                        break;
                // ovo je case za Hashmap
                    case 3:
                        System.out.println("**********");
                        System.out.println("1 - Adding 1000 numbers into a Hashmap pairs");
                        System.out.println("2 - Removing an element from a Hashmap");
                        System.out.println("3 - Adding an element to a Hashmap");
                        System.out.print("What would you like to test? ");
                        int izbor5 = sken.nextInt();
                        switch (izbor5){
                            case 1: {
                                Long duration = measureTime(()->{
                                    hashMap1000();
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                                break;
                            }
                            case 2: {
                                Long duration = measureTime(()->{
                                    hashMapDelete();
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                                break;
                            }
                            case 3: {
                                Long duration = measureTime(()->{
                                    hashMapAdd();
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                            }
                        }








    }
        }
    }
    public static void array1000(){
        // napravimo niz od 1000 mesta
        int[] array = new int[100000];
        // popunimo ga kroz loop
        for (int i=0; i<array.length;i++){
            array[i] = i;
        }
    }
    public static void arrayDelete(){
        // napravimo dva niza, drugi je kraci za jedno mesto
        int[] array = new int[100000];
        // popunimo ga kroz loop
        for (int i=0; i<array.length;i++){
            if (i%2 != 0){
                array[i] = i;
            }

        }

    }
    public static void arrayAdd(){
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] arr2 = new int[arr.length+1];
        int x = 15;
        for (int i=0; i<arr.length; i++){
            arr2[i] = arr[i];

        }
        arr2[arr.length]=x;
    }
    public static void linkedList1000(){
        LinkedList<Integer> lista = new LinkedList<>();
        for (int i = 0; i<1000;i++){
            lista.add(i);
        }
    }
    public static void linkedListDelete(){
        LinkedList<Integer> lista = new LinkedList<>();
        for (int i = 0; i<10;i++){
            lista.add(i);

        }
        lista.removeLast();
    }
    public static void linkedListAdd(){
        LinkedList<Integer> lista = new LinkedList<>();
        for (int i = 0; i<10;i++){
            lista.add(i);

        }
        lista.add(11);
    }
    public static void hashMap1000(){
        HashMap<Integer,Integer> mapa = new HashMap<Integer, Integer>();
        for (int i=0, k=1; i<1000; i++, k++){
            mapa.put(i,k);

        }
    }
    public static void hashMapDelete(){
        HashMap<Integer,Integer> mapa = new HashMap<Integer, Integer>();
        for (int i=0, k=1; i<10; i++, k++){
            mapa.put(i,k);

        }
        mapa.remove(3);
    }
    public static void hashMapAdd(){
        HashMap<Integer,Integer> mapa = new HashMap<Integer, Integer>();
        for (int i=0, k=1; i<10; i++, k++){
            mapa.put(i,k);

        }
        mapa.put(11,12);
    }
}
