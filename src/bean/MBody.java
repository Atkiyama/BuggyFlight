package bean;

public class MBody {
	private String code;
	private String name;
	private int seatCount;
	private int premiumSeatCount;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSeatCount() {
		return seatCount;
	}
	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}
	public int getPremiumSeatCount() {
		return premiumSeatCount;
	}
	public void setPremiumSeatCount(int premiumSeatCount) {
		this.premiumSeatCount = premiumSeatCount;
	}
}
