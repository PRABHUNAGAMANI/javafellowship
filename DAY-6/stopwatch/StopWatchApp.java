package stopwatch;

import java.util.Scanner;

public class StopWatchApp
{
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);
        StopWatchService service = new StopWatchService();
        StopWatchPrinter printer = new StopWatchPrinter();

        System.out.println("PRESS ENTER TO START STOPWATCH");
        scan.nextLine();
        long startTime = service.start();
        printer.printStartTime(startTime);

        System.out.println("PRESS ENTER TO STOP STOPWATCH");
        scan.nextLine();
        long endTime = service.stop();
        printer.printEndTime(endTime);

        double elapsed = service.elapsedSeconds(startTime, endTime);
        printer.printElapsedTime(elapsed);

        scan.close();
    }
}
