import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;

public class CarsExternalRoute {
    public static void main(String args[]) throws Exception {
        CamelContext context = new DefaultCamelContext();
        System.out.println("started process with external RouteBuilder");
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        context.addRoutes(new CarRouteBuilder());

        context.start();
        Thread.sleep(10000);
        context.stop();
    }

}
