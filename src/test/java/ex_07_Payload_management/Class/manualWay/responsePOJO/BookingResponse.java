package ex_07_Payload_management.Class.manualWay.responsePOJO;

import ex_07_Payload_management.Class.manualWay.requestPOJO.Booking;

/*
{
    "bookingid": 1948,
    "booking": {
        "firstname": "mangesh",
        "lastname": "Panchwagh",
        "totalprice": 3000,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2025-07-22",
            "checkout": "2025-07-27"
        },
        "additionalneeds": "Breakfast"
    }
}
*/

public class BookingResponse {

	private Integer bookingId;
	private Booking booking;
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
}
