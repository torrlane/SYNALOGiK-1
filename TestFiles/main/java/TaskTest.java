package main.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    //Test the example provided on the instruction sheet
    @Test
    public void testSynalogikExample(){
        String[] args = {"sample.txt"};
        Task.main(args);
        assertEquals(9, Task.totalWords);
        assertEquals(4.556, Task.averageWordLength);
    }

    //If the space is missing after a full stop, does it correctly detect two separate words?
    @Test
    public void testFullStopsNoSpaces(){
        String[] args = {"missingSpaces.txt"};
        Task.main(args);
        assertEquals(9, Task.totalWords);
        assertEquals(3.889, Task.averageWordLength);
    }

    //Blank text file should output correctly
    @Test
    public void blankTextFile(){
        String[] args = {"blank.txt"};
        Task.main(args);
        assertEquals(0, Task.totalWords);
        assertEquals(0, Task.averageWordLength);
    }




}