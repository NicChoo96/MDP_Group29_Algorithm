package algoClient;

public enum RobotStatus {
        RTS, // ready to start
        RS, // robot started
        PLAN, // planning route to next obstacle
        MOV, // moving
        STCI, // stopped to capture image
        IC, // image captured
        C // robot has completed
}
