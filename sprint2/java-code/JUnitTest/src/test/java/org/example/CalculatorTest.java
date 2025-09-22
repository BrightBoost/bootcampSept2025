package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class CalculatorTest {
    private Calculator calc=null;
    @BeforeAll
    static void beforeAll(){
        System.out.println("Executes Before All");
    }
    @AfterAll
    static void afterAll(){
        System.out.println("Executes After All");
    }
    @BeforeEach
    void setup(){
        System.out.println("Executes Before Each");
        calc=new Calculator();
    }
    @AfterEach
    void tearDown(){
        System.out.println("Executes After Each");
        calc=null;
    }
    @Test
    void testAddPositiveNumbers(){
        assertEquals(10,calc.add(7,3));
        System.out.println("Test 1 Executed");
    }
    @Test
    void testAddNegativeNumbers(){
        assertEquals(-10,calc.add(-7,-3));
        System.out.println("Test 2 Executed");
    }
    @Test
    void testDivPositiveNumbers(){
        assertEquals(5,calc.add(10,2));
        System.out.println("Test 3 Executed");
    }
    @Test
    void testDivideByZero(){
        assertThrows(ArithmeticException.class,()->calc.div(10,0));
    }
}
