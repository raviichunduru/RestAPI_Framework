package asserts;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.function.Predicate;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

public abstract class VerifyResponse<SELF_TYPE extends VerifyResponse<?>> {
  protected SELF_TYPE selfType;
  protected Response response;
  protected SoftAssertions softAssertions;

  protected VerifyResponse(Class<SELF_TYPE> selfType, Response response) {
    this.selfType = selfType.cast(this);
    this.response = response;
    this.softAssertions = new SoftAssertions();
  }

  public SELF_TYPE statusCodeIs(int statusCode) {
    Assertions.assertThat(response.getStatusCode()).describedAs("statusCode").isEqualTo(statusCode);

    return selfType;
  }

  public SELF_TYPE contentTypeIs(ContentType contentType) {
    softAssertions
        .assertThat(response.getContentType())
        .as("Content Type validation")
        .isEqualTo(contentType.toString());
    return selfType;
  }

  public SELF_TYPE matchingRule(Predicate<Response> condition, String errorMessage) {
    softAssertions.assertThat(condition).withFailMessage(errorMessage).accepts(response);
    return selfType;
  }

  public SELF_TYPE hasKeyWithValue(String key, String expectedValue) {
    String actualValue = response.jsonPath().getString(key);
    softAssertions
        .assertThat(actualValue)
        .as("body node validation in response")
        .isEqualTo(expectedValue);
    return selfType;
  }

  public SELF_TYPE containsValue(String value) {
    softAssertions
        .assertThat(response.getBody().asString())
        .describedAs("responseBody")
        .contains(value);

    return selfType;
  }

  public SELF_TYPE doesNotContains(String value) {
    softAssertions
        .assertThat(response.body().asString())
        .as("Body node validation in response")
        .doesNotContain(value);
    return selfType;
  }

  public SELF_TYPE matchesSchema(String fileClassPath) {
    softAssertions
        .assertThat(response.then().body(matchesJsonSchemaInClasspath(fileClassPath)))
        .describedAs("Schema validation")
        .getWritableAssertionInfo();

    return selfType;
  }

  public void assertAll() {
    softAssertions.assertAll();
  }
}
