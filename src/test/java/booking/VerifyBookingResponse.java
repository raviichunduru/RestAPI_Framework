package booking;

import asserts.VerifyResponse;
import io.restassured.response.Response;
import org.mycompany.booking.Booking;
import org.mycompany.booking.BookingResponse;

public class VerifyBookingResponse extends VerifyResponse<VerifyBookingResponse> {
  private VerifyBookingResponse(Response response) {
    super(VerifyBookingResponse.class, response);
  }

  public static VerifyBookingResponse assertThat(Response response) {
    return new VerifyBookingResponse(response);
  }

  public VerifyBookingResponse postHasBooking(Booking expectedBooking) {
    BookingResponse bookingResponse =
        response.then().extract().response().as(BookingResponse.class);

    softAssertions
        .assertThat(bookingResponse.getBooking())
        .describedAs("booking")
        .isEqualTo(expectedBooking);

    return this;
  }

  public VerifyBookingResponse hasBooking(Booking expectedBooking) {
    Booking bookingResponse = response.then().extract().response().as(Booking.class);

    softAssertions.assertThat(bookingResponse).describedAs("booking").isEqualTo(expectedBooking);

    return this;
  }
}
