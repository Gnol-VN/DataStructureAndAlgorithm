package crackingCodingInterview;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Viagogo {
    //    public static void main(String args[] ) throws Exception {
//        Scanner scan = new Scanner(System.in);
//
//        String point1AsAString = scan.nextLine();
//        String point2AsAString = scan.nextLine();
//
//        int x1, x2,y1,y2;
//        x1 = Integer.valueOf(point1AsAString.split(" ")[0]);
//        y1 = Integer.valueOf(point1AsAString.split(" ")[1]);
//        x2 = Integer.valueOf(point2AsAString.split(" ")[0]);
//        y2 = Integer.valueOf(point2AsAString.split(" ")[1]);
//        // Need to parse each point and find the distance between them using the supplied CalculateManhattanDistance
//
//        System.out.println("0");
//    }
//
//    // The following method get the manhatten distance betwen two points (x1,y1) and (x2,y2)
//    public static int calculateManhattanDistance(int x1, int y1, int x2, int y2){
//        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
//    }
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        System.out.println(System.getProperty("LongKey"));
        System.out.println(System.getProperty("PA"));
        RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
        List<String> arguments = runtimeMxBean.getInputArguments();
        Scanner scan = new Scanner(System.in);

        int sizeOfWorld = Integer.parseInt(scan.nextLine());
        int numberOfEvents = Integer.parseInt(scan.nextLine());
        List<Event> eventList = new ArrayList<>();
        while (numberOfEvents > 0) {
            String eventLine = scan.nextLine();
            // TODO: you will need to parse and store the events

            List<Ticket> ticketPriceList = new ArrayList<>();
            for (int i = 3; i < eventLine.split(" ").length; i++) {
                int ticketPrice = Integer.valueOf(eventLine.split(" ")[i]);
                ticketPriceList.add(new Ticket(ticketPrice, Integer.valueOf(eventLine.split(" ")[0])));
            }
            Event event = new Event(Integer.valueOf(eventLine.split(" ")[0]),
                    Integer.valueOf(eventLine.split(" ")[1]),
                    Integer.valueOf(eventLine.split(" ")[2]),
                    ticketPriceList);


            eventList.add(event);
            numberOfEvents--;
        }

        int numberOfBuyers = Integer.parseInt(scan.nextLine());
        List<Buyer> buyerList = new ArrayList<>();
        while (numberOfBuyers > 0) {
            String buyerLine = scan.nextLine();
            // TODO: you will need to parse and store the buyers
            Buyer buyer = new Buyer(Integer.valueOf(buyerLine.split(" ")[0]), Integer.valueOf(buyerLine.split(" ")[1]));
            buyerList.add(buyer);
            numberOfBuyers--;
        }

        // The solution to the first sample above would be to output the following to console:
        // (Obviously, your solution will need to figure out the output and not just hard code it)
        getResults(eventList, buyerList);
    }

    private static void getResults(List<Event> eventList, List<Buyer> buyerList) {
        for (Buyer buyer : buyerList) {
            int chosenEventId = 0;
            int chosenPrice = 0;



            List<Integer> distanceList = new ArrayList<>();
            for (Event event : eventList) {
                if(event.ticketLists.size() != 0){
                    distanceList.add(calculateManhattanDistance(buyer.buyerX, buyer.buyerX, event.eventX, event.eventY));
                }
            }
            //distance to event
            if(distanceList.size() == 0){
                System.out.println("0 0");
                return;
            }
            int closestEventIndex = distanceList.indexOf(Collections.min(distanceList));

            //check event availability
            //prices of this event;
            List<Integer> priceList = new ArrayList<>();
            for (int i = 0; i < eventList.get(closestEventIndex).ticketLists.size(); i++) {
                priceList.add(eventList.get(closestEventIndex).ticketLists.get(i).price);
            }

            //find lowest price and available in this event
            int lowestPrice = Collections.min(priceList);


            //print result
            chosenEventId = eventList.get(closestEventIndex).eventId;
            chosenPrice = lowestPrice;
            System.out.println(chosenEventId + " " + chosenPrice);
            for (Ticket ticket : eventList.get(closestEventIndex).ticketLists) {
                if (ticket.price == chosenPrice) {
                    eventList.get(closestEventIndex).ticketLists.remove(ticket);
                    break;
                }
            }



        }

    }

    // The following method get the manhatten distance betwen two points (x1,y1) and (x2,y2)
    public static int calculateManhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}

class Event {
    int eventX;
    int eventY;
    int eventId;
    List<Ticket> ticketLists;

    public Event(int eventId, int eventX, int eventY, List<Ticket> ticketLists) {
        this.eventId = eventId;
        this.eventX = eventX;
        this.eventY = eventY;
        this.ticketLists = ticketLists;
    }

}

class Buyer {
    int buyerX;
    int buyerY;

    public Buyer(int buyerX, int buyerY) {
        this.buyerX = buyerX;
        this.buyerY = buyerY;
    }
}

class Ticket {
    int price;
    boolean availability;
    int eventId;

    public Ticket(int price, int eventId) {
        this.price = price;
        this.eventId = eventId;
        availability = true;
    }
}