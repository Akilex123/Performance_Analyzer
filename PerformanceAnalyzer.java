import java.util.Scanner;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Random;

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
                System.out.println("4 - Sorting algotithms");
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
                                    array1m();
                                });
                                Long memoryUsage = measureMemory(()->{
                                    array1m();
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
                                Long memoryUsage = measureMemory(()->{
                                    arrayAdd();
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                                System.out.println("Memorija koju je zauzeo ovaj algoritam iznosi: " + memoryUsage + " bajta");
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
                                    linkedList1m();
                                });
                                Long memoryUsage = measureMemory(()->{
                                    array1m();
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                                System.out.println("Memorija koju je zauzeo ovaj algoritam iznosi: " + memoryUsage + " bajta");
                                break;
                        }
                            case 2: {
                                Long duration = measureTime(()->{
                                    linkedListDelete();
                                });
                                Long memoryUsage = measureMemory(()->{
                                    array1m();
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                                System.out.println("Memorija koju je zauzeo ovaj algoritam iznosi: " + memoryUsage + " bajta");
                                break;
                            }
                            case 3: {
                                Long duration = measureTime(()->{
                                    linkedListAdd();
                                });
                                Long memoryUsage = measureMemory(()->{
                                    array1m();
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                                System.out.println("Memorija koju je zauzeo ovaj algoritam iznosi: " + memoryUsage + " bajta");
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
                                    hashMap1m();
                                });
                                Long memoryUsage = measureMemory(()->{
                                    array1m();
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                                System.out.println("Memorija koju je zauzeo ovaj algoritam iznosi: " + memoryUsage + " bajta");
                                break;
                            }
                            case 2: {
                                Long duration = measureTime(()->{
                                    hashMapDelete();
                                });
                                Long memoryUsage = measureMemory(()->{
                                    array1m();
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                                System.out.println("Memorija koju je zauzeo ovaj algoritam iznosi: " + memoryUsage + " bajta");
                                break;
                            }
                            case 3: {
                                Long duration = measureTime(()->{
                                    hashMapAdd();
                                });
                                Long memoryUsage = measureMemory(()->{
                                    array1m();
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                                System.out.println("Memorija koju je zauzeo ovaj algoritam iznosi: " + memoryUsage + " bajta");
                            }


                        }
                     // case za sorting algoritme
                    case 4:
                        System.out.println("**********");
                        System.out.println("1 - Bubble Sort");
                        System.out.println("2 - Removing an element from a Hashmap");
                        System.out.println("3 - Adding an element to a Hashmap");
                        System.out.print("What would you like to test? ");
                        int izbor6 = sken.nextInt();
                        switch (izbor6){
                            case 1: {
                                Long duration = measureTime(()->{
                                    bubbleSort();
                                });
                                Long memoryUsage = measureMemory(()->{
                                    bubbleSort();
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                                System.out.println("Memorija koju je zauzeo ovaj algoritam iznosi: " + memoryUsage + " bajta");
                                break;
                            }
                            case 2: {
                                Long duration = measureTime(()->{
                                    hashMapDelete();
                                });
                                Long memoryUsage = measureMemory(()->{
                                    array1m();
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                                System.out.println("Memorija koju je zauzeo ovaj algoritam iznosi: " + memoryUsage + " bajta");
                                break;
                            }
                            case 3: {
                                Long duration = measureTime(()->{
                                    hashMapAdd();
                                });
                                Long memoryUsage = measureMemory(()->{
                                    array1m();
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                                System.out.println("Memorija koju je zauzeo ovaj algoritam iznosi: " + memoryUsage + " bajta");
                            }}








    }
        }
    }
    public static void array1m(){
        // napravimo niz od 100000 mesta
        int[] array = new int[1000000];
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
            array[i] = i;

        }
        int[] newArray = new int[array.length-1];
        int j = 3;
        for (int i=0, k=0; i<array.length; i++){
            if (i!=j){
                newArray[k] = array[i];
                k++; // pravimo jednostavan algoritam za pravljenje novog niza, samo sto preskacemo broj koji zelimo da obrisemo
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
    public static void linkedList1m(){
        LinkedList<Integer> lista = new LinkedList<>();
        for (int i = 0; i<1000000;i++){
            lista.add(i);
        }
    }
    public static void linkedListDelete(){
        LinkedList<Integer> lista = new LinkedList<>();
        for (int i = 0; i<1000000;i++){
            lista.add(i);

        }
        lista.removeLast();
    }
    public static void linkedListAdd(){
        LinkedList<Integer> lista = new LinkedList<>();
        for (int i = 0; i<1000000;i++){
            lista.add(i);

        }
        lista.add(10000000);
    }
    public static void hashMap1m(){
        HashMap<Integer,Integer> mapa = new HashMap<Integer, Integer>();
        for (int i=0, k=1; i<1000000; i++, k++){
            mapa.put(i,k);

        }
    }
    public static void hashMapDelete(){
        HashMap<Integer,Integer> mapa = new HashMap<Integer, Integer>();
        for (int i=0, k=1; i<1000; i++, k++){
            mapa.put(i,k);

        }
        mapa.values().removeIf(v->v%2 ==0); // omogucava nam da iteriramo kroz vrednosti mape i obrisemo parne brojeve
    }
    public static void hashMapAdd(){
        HashMap<Integer,Integer> mapa = new HashMap<Integer, Integer>();
        for (int i=0, k=1; i<1000; i++, k++){
            mapa.put(i,k);

        }
        mapa.put(1001,1002);
    }
    /////////////////// sorting algos
    public static void bubbleSort(){
        int[] arr = new int[100];
        int n = arr.length; // iniciramo n koje ce nam kasnije biti poslednji broj u nizu
        Random random = new Random();
        for (int i=0; i<arr.length; i++){
            arr[i] = random.nextInt(100000);
        } // pravimo niz koji ima 100 vrednosti, svaka je random u opsegu 0 do ovaj broj iznad
        int i,j,temp; // iniciramo dve varijable za prolazak kroz niz i jednu kako bismo mogli da sortujemo niz tj da swapujemo vrednosti
        boolean swapped; // indikator iliti zastavica da vidimo da li se promena desila ili ne
        for (i = 0; i<n-1; i++){ // idemo do jednog broja pre kraja kako bismo mogli da ga zamenimo sa poslednjim, ovo je pokazatelj koliko puta idemo kroz niz, ovde se i menja samo kada se zavrsi ceo for loop unutar njega tj kada najveci broj bude na kraju liste
            swapped = false;
            for (j=0; j<n-i-1; j++){ // ovo je unutrasnji loop koji se izvrsava dok najveci broj ne bude na kraju, on se izvrsava sa sve manjim obimom svaki put jer su najveci brojevi vec pogurani na kraj
                if (arr[j]>arr[j+1]){ // proveravamo da li je broj na jednoj poziciji veci od broja na sledecoj
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true; // ako jeste odradjujemo swap i menjamo indikator da je swap izvrsen, ako nije j se samo pomera za jedno mesto i uporedjuje sa sledecim brojem, tim putem se najveci gura na kraj
                }
            }
            if (swapped == false) break;
        }

    }

}
