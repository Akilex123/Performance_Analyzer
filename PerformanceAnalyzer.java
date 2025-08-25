public class PerformanceAnalyzer {
    public static long measureTime(Runnable task){
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        return (endTime - startTime)/1000;
    }

    public static void main(String args[]){
        long duration = measureTime(()->{
            Array1();
        });
        System.out.println("Ukupno vreme je: " + duration + "ms");


    }
    public static void Array1(){
        int[] array = new int[1000];
        for (int i=0; i<array.length;i++){
            array[i] = i;
        }
    }
}
