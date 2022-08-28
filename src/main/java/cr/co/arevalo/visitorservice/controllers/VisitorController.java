package cr.co.arevalo.visitorservice.controllers;

import cr.co.arevalo.app.common.Visitor;
import cr.co.arevalo.app.services.messaging.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "${path.api}/visitor/" )
public class VisitorController
{
    private static final Logger LOGGER = LoggerFactory.getLogger( VisitorController.class );

    private final MessageService messageService;

    @Autowired
    public VisitorController( MessageService messageService )
    {
        this.messageService = messageService;
    }

    @GetMapping( "/ping/" )
    public String ping ()
    {
        LOGGER.info( "Pinged." );

        Visitor pong = new Visitor( "Pong", "Pongerson", "Pong." );
        messageService.sendFifo( pong, "ping", "ping" );
        return "Pong.";
    }
}
