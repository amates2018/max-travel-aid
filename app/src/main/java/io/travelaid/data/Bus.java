package io.travelaid.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import io.travelaid.util.BusType;

/**
 * Project : max-travel-aid
 * Created by Dennis Bilson on Wed at 7:01 PM.
 * Package name : io.travelaid.data
 *
 * Bus data model
 */
public class Bus implements Parcelable {
	@NonNull
	private String number;
	private int capacity = 0;
	private List<Seat> seats = new ArrayList<>(capacity);
	@Nullable
	private long departureTime;
	//Default bus type is VIP
	private String type = BusType.VIP.getType();
	
	public Bus() {
	}
	
	public Bus(String number, int capacity, List<Seat> seats, long departureTime, String type) {
		this.number = number;
		this.capacity = capacity;
		this.seats = seats;
		this.departureTime = departureTime;
		this.type = type;
	}
	
	protected Bus(Parcel in) {
		number = in.readString();
		capacity = in.readInt();
		seats = in.createTypedArrayList(Seat.CREATOR);
		departureTime = in.readLong();
		type = in.readString();
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(number);
		dest.writeInt(capacity);
		dest.writeTypedList(seats);
		dest.writeLong(departureTime);
		dest.writeString(type);
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	public static final Creator<Bus> CREATOR = new Creator<Bus>() {
		@Override
		public Bus createFromParcel(Parcel in) {
			return new Bus(in);
		}
		
		@Override
		public Bus[] newArray(int size) {
			return new Bus[size];
		}
	};
	
	@NonNull
	public String getNumber() {
		return number;
	}
	
	public void setNumber(@NonNull String number) {
		this.number = number;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public List<Seat> getSeats() {
		return seats;
	}
	
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	
	@Nullable
	public long getDepartureTime() {
		return departureTime;
	}
	
	public void setDepartureTime(@Nullable long departureTime) {
		this.departureTime = departureTime;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Bus{" +
				"number='" + number + '\'' +
				", capacity=" + capacity +
				", departureTime=" + departureTime +
				", type='" + type + '\'' +
				'}';
	}
}
