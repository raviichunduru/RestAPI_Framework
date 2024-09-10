import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.typesafe.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.mycompany.annotations.FailingTest;
import org.mycompany.annotations.FlakyTest;
import org.mycompany.annotations.SmokeTest;
import org.mycompany.config.TestConfig;

@Slf4j
public class TestSandbox {
  final Config CONFIG = TestConfig.getInstance().getConfig();

  @SmokeTest
  void assertThatWeCanGetUserConfig() {

    assertAll(
        "Config Test",
        () -> assertEquals("STAGING", CONFIG.getString("TEST_ENV"), "TEST_ENV"),
        () -> assertEquals("/booking", CONFIG.getString("BOOKING_ENDPOINT"), "BOOKING_ENDPOINT"),
        () -> assertEquals("admin", CONFIG.getString("ADMIN_USERNAME"), "ADMIN_USERNAME"),
        () -> assertEquals("password123", CONFIG.getString("ADMIN_PASSWORD"), "ADMIN_PASSWORD"),
        () -> assertEquals(false, CONFIG.getBoolean("TOGGLE"), "TOGGLE"),
        () -> assertEquals(10, CONFIG.getInt("NUM_OF_USERS"), "NUM_OF_USERS"),
        () -> assertEquals(123.456, CONFIG.getDouble("PRICE"), "PRICE"));
  }

  @SmokeTest
  void assertThatTrueIsTrue() {
    assertTrue(true, "true is true");
  }

  @FailingTest
  void assertThatDayIsADay() {

    assertEquals("day", "night", "day is a  day");
  }

  @FlakyTest
  void createFlakyTest() {
    long currentTimeStamp = System.currentTimeMillis();
    log.info("currentTimeStamp : {}", currentTimeStamp);
    if (currentTimeStamp % 2 == 0) {
      assertTrue(true, "time is even");
    } else {
      assertTrue(false, "time is odd");
    }
  }

  @SmokeTest
  void testLogLevels() {
    log.info("this is info statement");
    log.debug("this is debug statement");
    log.error("this is error statement");
    log.warn("this is warn statement");
    log.trace("this is trace statement");
  }
}
