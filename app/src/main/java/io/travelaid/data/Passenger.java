package io.travelaid.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.iid.FirebaseInstanceId;

import io.travelaid.util.GenderType;

/**
 * Project : max-travel-aid
 * Created by Dennis Bilson on Wed at 6:46 PM.
 * Package name : io.travelaid.data
 *
 * Passenger data model
 */
public class Passenger implements Parcelable {
	private String uid;
	private String username;
	private String profile;
	private String phoneNumber;
	//Default gender is Male
	private String gender = GenderType.MALE.getType();
	private String token;
	
	//For serialization
	public Passenger() {
	}
	
	public Passenger(String uid, String username, String profile, String phoneNumber, String gender) {
		this.uid = uid;
		this.username = username;
		this.profile = profile;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.token = FirebaseInstanceId.getInstance().getToken();
	}
	
	
	protected Passenger(Parcel in) {
		uid = in.readString();
		username = in.readString();
		profile = in.readString();
		phoneNumber = in.readString();
		gender = in.readString();
		token = in.readString();
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(uid);
		dest.writeString(username);
		dest.writeString(profile);
		dest.writeString(phoneNumber);
		dest.writeString(gender);
		dest.writeString(token);
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	public static final Creator<Passenger> CREATOR = new Creator<Passenger>() {
		@Override
		public Passenger createFromParcel(Parcel in) {
			return new Passenger(in);
		}
		
		@Override
		public Passenger[] newArray(int size) {
			return new Passenger[size];
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
	
	@Override
	public String toString() {
		return "Passenger{" +
				"uid='" + uid + '\'' +
				", username='" + username + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", gender='" + gender + '\'' +
				'}';
	}
	
}
