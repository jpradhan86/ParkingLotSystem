package com.gojek.assignment;
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
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            ParkingLot parkingLot = new ParkingLot();
            while(true) {
                try {
                		System.out.println("Input:");
                		String cmd = reader.readLine();
                		System.out.println("Output:");
                    CommandBuilder.run_cmd(parkingLot, cmd);
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
            reader.close();
        } catch (IOException e) {
            System.err.println(e);
        }   
    }  
}
