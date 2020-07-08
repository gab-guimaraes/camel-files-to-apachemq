import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class CarRouteBuilder extends RouteBuilder {
    public void configure() throws Exception {
        from("file:src/data?noop=true").to("jms:cars2").process(new Processor() {
            public void process(Exchange exchange) throws Exception {
                System.out.println("Name" + exchange.getIn().getHeader("CamelFileName"));
            }
        });
    }
}
