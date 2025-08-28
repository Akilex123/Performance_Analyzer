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
    public static void compareAlgorithms(Runnable alg1, Runnable alg2){
        long time1 = measureTime(alg1);
        long time2 = measureTime(alg2);

        long mem1 = measureMemory(alg1);
        long mem2 = measureMemory(alg2);
        System.out.println("Results:");
        if (time1<time2){
            System.out.println("First algorithm is faster.");
        } else if (time2>time1) {
            System.out.println("Second algorithm is faster.");
        }
        else {
            System.out.println("They are equaly fast");
        }
        if (mem1<mem2){
            System.out.println("First algorithm takes less space.");
        }
        else if (mem2>mem1) {
            System.out.println("Second algorithm takes less space.");
        }
        else {
            System.out.println("They both take equal amount of space.");
        }
    }
    public static Runnable getAlgorithm(int choice){
        switch (choice){
            case 1: return ()-> array1m();
            case 2: return ()-> arrayDelete();
            case 3: return ()-> arrayAdd();
            case 4: return ()-> linkedList1m();
            case 5: return ()-> linkedListDelete();
            case 6: return ()-> linkedListAdd();
            case 7: return ()-> hashMap1m();
            case 8: return ()-> hashMapDelete();
            case 9: return ()-> hashMapAdd();
            case 10: return ()-> bubbleSort();
            case 11: return ()-> insertionSort();
            case 12: return ()-> selectionSort();
            case 13: return ()-> binarySearch(50);
            case 14: return ()-> linearSearch(50);
            default: return null;
        }
    }

    public static void main(String args[]){
        Scanner sken = new Scanner(System.in);
        boolean running = true;
        while(running){

        System.out.println("**********");
        System.out.println("Welcome!");
        System.out.println("1 - Measure time and memory usage of one algorithm");
        System.out.println("2 - Compare two algorithms");
        System.out.println("3 - Exit");
        System.out.print("Pick an option: ");

        int choice = sken.nextInt();
        // System.out.println(choice);
        switch (choice){
            // case 1 za pojedinacno gledanje vremena i memorije koju zauzima
            case 1:
                    System.out.println("**********");
                    System.out.println("1 - Arrays");
                    System.out.println("2 - LinkedLists");
                    System.out.println("3 - Hashmaps");
                    System.out.println("4 - Sorting algotithms");
                    System.out.println("5 - Searching algotithms");
                    System.out.println("6 - Back");
                    System.out.print("What datastructure or algorithm would you like to pick? ");



                int izbor2 = sken.nextInt();
                switch (izbor2){
                    // ceo jedan case je za Arrays
                    case 1:
                        System.out.println("**********");
                        System.out.println("1 - Adding 1m numbers into a Array");
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
                        System.out.println("1 - Adding 1m numbers into a LinkedList");
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
                        System.out.println("1 - Adding 1m numbers into a Hashmap pairs");
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
                        System.out.println("2 - Selection Sort");
                        System.out.println("3 - Insertion Sort");
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
                                    selectionSort();
                                });
                                Long memoryUsage = measureMemory(()->{
                                    selectionSort();
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                                System.out.println("Memorija koju je zauzeo ovaj algoritam iznosi: " + memoryUsage + " bajta");
                                break;
                            }
                            case 3: {
                                Long duration = measureTime(()->{
                                    insertionSort();
                                });
                                Long memoryUsage = measureMemory(()->{
                                    insertionSort();
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                                System.out.println("Memorija koju je zauzeo ovaj algoritam iznosi: " + memoryUsage + " bajta");
                            }}
                        // case za search algoritme
                    case 5:
                        System.out.println("**********");
                        System.out.println("1 - Linear Search");
                        System.out.println("2 - Binary Search");
                        System.out.print("What would you like to test? ");
                        int izbor7 = sken.nextInt();
                        switch (izbor7){
                            case 1: {
                                Long duration = measureTime(()->{
                                    linearSearch(50);
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
                                    selectionSort();
                                });
                                Long memoryUsage = measureMemory(()->{
                                    binarySearch(15);
                                });
                                System.out.println("Vreme koje je potrebno za ovaj algoritam je: " + duration + "ms");
                                System.out.println("Memorija koju je zauzeo ovaj algoritam iznosi: " + memoryUsage + " bajta");
                                break;
                            }
                            }









    }
            case 2:
                System.out.println("Izaberite 2 algoritma");
                System.out.println("1 - Adding 1m numbers into a Array");
                System.out.println("2 - Removing an element from Array");
                System.out.println("3 - Adding an element to Array");
                System.out.println("***********");
                System.out.println("4 - Adding 1m numbers into a LinkedList");
                System.out.println("5 - Removing an element from a LinkedList ");
                System.out.println("6 - Adding an element to LinkedList");
                System.out.println("***********");
                System.out.println("7 - Adding 1m numbers into a Hashmap pairs");
                System.out.println("8 - Removing an element from a Hashmap");
                System.out.println("9 - Adding an element to a Hashmap");
                System.out.println("***********");
                System.out.println("10 - Bubble Sort");
                System.out.println("11 - Selection Sort");
                System.out.println("12 - Insertion Sort");
                System.out.println("***********");
                System.out.println("13 - Linear Search");
                System.out.println("14 - Binary Search");
                System.out.println("***********");

                System.out.print("Pick first algorithm: ");
                int alg1Choice = sken.nextInt();
                Runnable alg1 = getAlgorithm(alg1Choice);

                System.out.print("Pick second algorithm: ");
                int alg2Choice = sken.nextInt();
                Runnable alg2 = getAlgorithm(alg2Choice);

                if (alg1 != null && alg2 != null){
                    compareAlgorithms(alg1,alg2);
                }
                else {
                    System.out.println("You didn't pick the correct numbers.");
                }
            case 3:
                System.out.println("Thanks for using this little application :D ");
                running = false;
                break;
        }


    }}
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
    public static void selectionSort(){
        int[] arr = new int[100];
        Random random = new Random();
        for (int i=0; i<arr.length; i++){
            arr[i] = random.nextInt(100000);
        }
        int n = arr.length;
        for (int i = 0; i<n-1; i++){
            int min = i; // iniciramo minimum vrednost jer predopostavljamo da je najmanja vrednost na prvom mestu, kasnije koristimo za poziciju
            for (int j = i+1; j<n; j++){ // ovaj for loop sluzi samo da nadje najmanju vrednost zapravo
                if (arr[j]<arr[min]){// loop krece od prve pozicije u nizu posle prve i proverava vrednosti da li su manje od prve
                    min = j; // ako jesu minimum index vrednost prebacujemo u tu vrednost
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        } // zatim koristimo taj index gde smo nasli najmanju vrednost da ga prebacimo na prvo mesto i zatim se tek spoljni loop prebacuje na sledecu poziciju
    }
    public static void insertionSort(){
        int[] arr = new int[100];
        Random random = new Random();
        for (int i=0; i<arr.length; i++){
            arr[i] = random.nextInt(100000);
        }
        for (int i = 1; i<arr.length; i++){ // krecemo se redom pozicijama u nizu
            int key = arr[i]; // pravimo predpostavku da je prvi element na mestu na kom treba da bude, tj key nam sluzi da ubacimo narednu sortiranu vrednost u niz
            int j = i-1; // vrednost j krece od jednog mesta ranije, iniciramo ga sa prvom pozicijom u nizu
            while(j>=0 && arr[j]>key){ // zatim gledamo da ako je trenutni element veci od key treba da izvrsimo sledeci kod
                arr[j+1] = arr[j]; // pomeramo element udesno, znaci ovo nije swap vec samo pomeranje kako bismo key stavili na pravu poziciju
                j = j-1; // index pomeramo NALEVO zato sto time proveravamo sve vrednosti od ranije da li su vece od key kako bismo znali gde da ga stavimo
            } // kada se petlja zavrsi ili smo dosli do kraja liste nalevo (j==-1) ili ili smo nasli element koji je manji od key
            arr[j+1] = key; // sada postavljamo key na poziciju koja nam je slobodna jer smo je oslobodili gore, kada se ovo zavrsi i se povecava i gleda narednu poziciju
        }
    }
    //////////////// search algos

    public static int linearSearch(int a){
        int[] arr = new int[100];
        Random random = new Random();
        for (int i=0; i<arr.length; i++){
            arr[i] = i;
        }
        int x = random.nextInt(100);
        for (int i=0; i<arr.length; i++){
            if (arr[i] ==x){
                return i;
            }

        }
        return -1;
    }
    public static int binarySearch(int a){
        int[] arr = new int[100];
        Random random = new Random();
        for (int i=0; i<arr.length; i++){
            arr[i] = i;
        }
        int x = random.nextInt(100);
        int l=0;
        int r=arr.length;
        while (l<=r){
            int m = (l+r)/2;
            if (arr[m]==x){
                return m;
            }
            else if(arr[m]>x){
                r=m-1;
            }
            else {
                l = m+1;
            }


        }
        return -1;
    }
}
