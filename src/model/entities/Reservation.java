package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer rooNumberInteger;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}

	public Reservation(Integer rooNumberInteger, Date checkIn, Date checkOut) {
		super();
		this.rooNumberInteger = rooNumberInteger;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}



	public Integer getRooNumberInteger() {
		return rooNumberInteger;
	}

	public void setRooNumberInteger(Integer rooNumberInteger) {
		this.rooNumberInteger = rooNumberInteger;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getChackOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room "
			+ rooNumberInteger
			+", "
			+"check-in: "
			+sdf.format(checkIn)
			+", "
			+"check-out: "
			+sdf.format(checkOut)
			+", "
			+duration()
			+" nights";
	}
}
