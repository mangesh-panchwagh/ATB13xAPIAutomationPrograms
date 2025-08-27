package ex_07_Payload_management.Class.tools.responsePOJO;

import java.util.LinkedHashMap;
import java.util.Map;

import ex_07_Payload_management.Class.tools.requestPOJO.Booking;

public class BookingResponse {

	private Integer bookingid;
    private Booking booking;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
    
	public Integer getBookingid() {
		return bookingid;
	}
	public void setBookingid(Integer bookingid) {
		this.bookingid = bookingid;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}
	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
    
    
}
