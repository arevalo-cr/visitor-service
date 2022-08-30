package cr.co.arevalo.visitorservice.services.messaging;

import cr.co.arevalo.visitorservice.common.Visitor;
import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MessageListener
{
    private static final Logger LOGGER = LoggerFactory.getLogger( MessageListener.class );

    @SqsListener( value = "${queue.visitors}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS )
    public void receive( Visitor message, @Headers Map< String, String > headers )
    {
        LOGGER.info( "Message received: {}", message );
    }
}
