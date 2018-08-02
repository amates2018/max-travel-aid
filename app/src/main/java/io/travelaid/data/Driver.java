package io.travelaid.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.iid.FirebaseInstanceId;

import io.travelaid.util.GenderType;

/**
 * Project : max-travel-aid
 * Created by Dennis Bilson on Wed at 7:00 PM.
 * Package name : io.travelaid.data
 *
 * Driver data model
 */
public class Driver implements Parcelable {
	private String uid;
	private String username;
	private String profile;
	private String phoneNumber;
	//Default gender is Male
	private String gender = GenderType.MALE.getType();
	private String token;
	private Bus bus;
	private boolean online = true;
	
	public Driver() {
	}
	
	public Driver(String uid, String username, String profile, String phoneNumber, String gender, Bus bus, boolean online) {
		this.uid = uid;
		this.username = username;
		this.profile = profile;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.token = FirebaseInstanceId.getInstance().getToken();
		this.bus = bus;
		this.online = online;
	}
	
	protected Driver(Parcel in) {
		uid = in.readString();
		username = in.readString();
		profile = in.readString();
		phoneNumber = in.readString();
		gender = in.readString();
		token = in.readString();
		bus = in.readParcelable(Bus.class.getClassLoader());
		online = in.readByte() != 0;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(uid);
		dest.writeString(username);
		dest.writeString(profile);
		dest.writeString(phoneNumber);
		dest.writeString(gender);
		dest.writeString(token);
		dest.writeParcelable(bus, flags);
		dest.writeByte((byte) (online ? 1 : 0));
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	public static final Creator<Driver> CREATOR = new Creator<Driver>() {
		@Override
		public Driver createFromParcel(Parcel in) {
			return new Driver(in);
		}
		
		@Override
		public Driver[] newArray(int size) {
			return new Driver[size];
		}
	};
	
	public String getToken() {
		return token;
	}
	
	public String getUid() {
		return uid;
	}
	
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getProfile() {
		return profile;
	}
	
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Bus getBus() {
		return bus;
	}
	
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	public boolean isOnline() {
		return online;
	}
	
	public void setOnline(boolean online) {
		this.online = online;
	}
	
	@Override
	public String toString() {
		return "Driver{" +
				"uid='" + uid + '\'' +
				", username='" + username + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", gender='" + gender + '\'' +
				", online=" + online +
				'}';
	}
}
