# ParkingLotSystem
The repository is available at github.com:jpradhan86/ParkingLotSystem.git

The Solution contains 6 java files

1. Vehicle.java
    Represents the vehicle 

2. ParkingSlot.java
    Represent each parking spot

3. ParkingLot.java
    This class contains all the business logic for each command.

4. CommandBuilder.java
    This class contains the business logic for which method to call for each command.

5. ParkingSystem.java

    This class contains the logic for user input or file input.

6. ParkingLotDriver.java
    
    This class contains the main method


To run the code

1. Run using jar file 

    java -cp target/ParkingLotSystem-1.0.jar com.jitendra.ParkingLotDriver file_inputs.txt (File input)

    java -cp target/ParkingLotSystem-1.0.jar com.jitendra.ParkingLotDriver (Interactive)

2. Run using the shell script

    ./parking_lot file_inputs.txt(File input)

    ./parking_lot(Interactive)

