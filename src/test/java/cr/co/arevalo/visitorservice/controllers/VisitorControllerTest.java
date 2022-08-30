package cr.co.arevalo.visitorservice.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisitorControllerTest
{
    private VisitorController visitorController;

    @Test
    void ping()
    {
        assertEquals( visitorController.ping(), VisitorController.PONG );
    }
}