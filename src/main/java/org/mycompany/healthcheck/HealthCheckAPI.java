package org.mycompany.healthcheck;

import static io.restassured.RestAssured.given;
import static org.mycompany.auth.Scope.GUEST;

import com.typesafe.config.Config;
import io.restassured.response.Response;
import org.mycompany.basespec.SpecFactory;
import org.mycompany.config.TestConfig;

public class HealthCheckAPI {
  private static final Config CONFIG = TestConfig.getInstance().getConfig();

  public static Response healthCheck() {
    // Cookie: token={{auth_token}}
    return given()
        .spec(SpecFactory.getSpecFor(GUEST).build())
        .log()
        .ifValidationFails()
        .when()
        .get(CONFIG.getString("HEALTHCHECK_ENDPOINT"))
        .then()
        .log()
        .ifError()
        .extract()
        .response();
  }
}
