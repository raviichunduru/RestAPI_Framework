package healthcheck;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.mycompany.annotations.HealthCheckTest;
import org.mycompany.healthcheck.HealthCheckAPI;

@HealthCheckTest
class HealthCheckTests {
  @Test
  void assertThatRestfulBookerApplicationIsUpAndHealthy() {
    Response response = HealthCheckAPI.healthCheck();
    assertEquals(201, response.getStatusCode());
  }
}
