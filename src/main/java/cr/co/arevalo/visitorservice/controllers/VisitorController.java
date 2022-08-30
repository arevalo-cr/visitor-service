package cr.co.arevalo.visitorservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/visitors" )
public class VisitorController
{
    public static final String PONG = "Pong.";

    private static final Logger LOGGER = LoggerFactory.getLogger( VisitorController.class );

    @GetMapping( "/ping" )
    public String ping ()
    {
        LOGGER.info( "Pinged." );
        return PONG;
    }
}
