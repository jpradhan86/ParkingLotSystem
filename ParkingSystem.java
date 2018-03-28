package com.jitendra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ParkingSystem {
	public void processThroughFile(String filePath) {
    	ArrayList<String> commands = new ArrayList<String>();
    	readCommandsFromFile(filePath, commands);
    	ParkingLot parkingLot = new ParkingLot();
        for (String command: commands) {
            System.out.println(CommandBuilder.run_cmd(parkingLot, command));
        }   
    }
    
    public void processThroughUserInput() {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ParkingLot parkingLot = new ParkingLot();
        while(true) {
            try {
            	System.out.println("Input:");
                String cmd = reader.readLine();
                System.out.println("Output:");
                System.out.println(CommandBuilder.run_cmd(parkingLot, cmd));
            } catch (IOException e) {
                System.err.println(e);
            }   
        }
    }

    public void readCommandsFromFile(String filename, ArrayList<String> commands) {
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
