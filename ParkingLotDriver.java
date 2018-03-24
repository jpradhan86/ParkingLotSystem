package ParkingSystem;
import java.io.*;
import java.util.*;

public class ParkingLotDriver {
    public static void main(String[] args) {
        if (args.length > 0) {
            ParkingLotDriver pd = new ParkingLotDriver();
            ArrayList<String> commands = new ArrayList<String>();
            pd.readCommandFromFile(args[0], commands);
            ParkingLot parkingLot = new ParkingLot();
            for (String command: commands) {
                CommandBuilder.run_cmd(parkingLot, command);
            }
        }
        else {
            System.out.println("Reading interactively");
            Scanner sc = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            ParkingLot parkingLot = new ParkingLot();
            while(true) {
                try{
                    //System.out.println(reader.readLine());
                    CommandBuilder.run_cmd(parkingLot, reader.readLine());
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }

    public void readCommandFromFile(String filename, ArrayList<String> commands) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                //System.out.println(line);
                commands.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

class CommandBuilder {
    public static void run_cmd(ParkingLot parkingLot, String command) {
        String[] valueList = command.split(" ");
        String firstValue = valueList[0];
        if (firstValue.equals("create_parking_lot")) {
            parkingLot.createParkingLot(Integer.parseInt(valueList[1]));
        }
        if (firstValue.equals("park")) {
            Vehicle vehicle = new Vehicle(valueList[1], valueList[2]);
            parkingLot.parkVehicle(vehicle);
        }
        if (firstValue.equals("leave")) {
            parkingLot.leave(Integer.parseInt(valueList[1]));
        }
        if (firstValue.equals("status")) {
            parkingLot.status();
        }
        if (firstValue.equals("registration_numbers_for_cars_with_colour")) {
            parkingLot.registrationNumbersForCarsWithColor(valueList[1]);
        }
        if (firstValue.equals("slot_numbers_for_cars_with_colour")) {
            parkingLot.slotNumbersForCarsWithColor(valueList[1]);
        }
        if (firstValue.equals("slot_number_for_registration_number")) {
            parkingLot.slotNumberForRegistrationNumber(valueList[1]);
        }
    }
}
