package cr.co.arevalo.visitorservice.services.messaging;

import cr.co.arevalo.app.common.Visitor;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class MessageService
{
    private static final Logger LOGGER = LoggerFactory.getLogger( MessageService.class );

    private static final long TIMEOUT = 5000;

    private final String queueName;

    private final QueueMessagingTemplate queueMessagingTemplate;

    @Autowired
    public MessageService( @Value( "${queue.fifo}" ) final String queueName,
            final QueueMessagingTemplate queueMessagingTemplate )
    {
        this.queueName = queueName;
        this.queueMessagingTemplate = queueMessagingTemplate;
    }

    public void send( final Visitor messagePayload )
    {
        Message< Visitor > message = MessageBuilder.withPayload( messagePayload ).build();
        queueMessagingTemplate.convertAndSend( queueName, message );
        LOGGER.info( "Message sent: {}", messagePayload );
    }

    public void sendFifo( final Visitor messagePayload, final String messageGroupID, final String messageDedupID )
    {
        Message< Visitor > message = MessageBuilder.withPayload( messagePayload )
                                                   .setHeader( "message-group-id", messageGroupID )
                                                   .setHeader( "message-deduplication-id", messageDedupID )
                                                   .build();
        queueMessagingTemplate.convertAndSend( queueName, message );
        LOGGER.info( "Message sent: {}", messagePayload );
    }
}
