package bean;

import java.time.LocalDate;
import java.time.LocalTime;

public class DFlight {
	private LocalDate flightDate;
	private String flightNo;
	private String originCode;
	private LocalTime departureTime;
	private String destinationCode;
	private LocalTime arrivalTime;
	public LocalDate getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getOriginCode() {
		return originCode;
	}
	public void setOriginCode(String originCode) {
		this.originCode = originCode;
	}
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	public String getDestinationCode() {
		return destinationCode;
	}
	public void setDestinationCode(String destinationCode) {
		this.destinationCode = destinationCode;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getBodyCode() {
		return bodyCode;
	}
	public void setBodyCode(String bodyCode) {
		this.bodyCode = bodyCode;
	}
	private String bodyCode;
}
