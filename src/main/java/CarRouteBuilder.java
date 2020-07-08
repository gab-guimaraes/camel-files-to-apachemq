import org.apache.camel.builder.RouteBuilder;

public class CarRouteBuilder extends RouteBuilder {
    public void configure() throws Exception {
        from("file:src/data?noop=true").to("jms:cars2");
    }
}
