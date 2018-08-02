package io.travelaid.util;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.concurrent.atomic.AtomicReference;

import io.travelaid.data.Driver;
import io.travelaid.data.Passenger;

/**
 * Project : max-travel-aid
 * Created by Dennis Bilson on Wed at 7:13 PM.
 * Package name : io.travelaid.util
 *
 * Stores constants and static functions
 */
public class AppUtils {
	//Database references
	public static final String TICKET_REF = "tickets";
	public static final String PASSENGER_REF = "passengers";
	public static final String DRIVER_REF = "drivers";
	public static final String RECENTS_REF = "recents";
	public static final String IMAGE_REF = "images";
	
	
	//Get current user
	@Nullable
	public static UserInfo getCurrentUser() {
		return FirebaseAuth.getInstance().getCurrentUser();
	}
	
	//True if current user is not null else false
	public static boolean isLoggedIn() {
		return getCurrentUser() != null;
	}
	
	@Nullable
	public static String getUserUID() {
		return getCurrentUser().getUid();
	}
	
	//Get the currently logged in passenger
	@Nullable
	public static Passenger getCurrentPassenger(@NonNull Activity host, @NonNull String uid) {
		AtomicReference<Passenger> passenger = null;
		FirebaseFirestore.getInstance().collection(PASSENGER_REF).document(uid)
				.get()
				.addOnCompleteListener(host, task -> {
					if (task.isSuccessful()) {
						passenger.set(task.getResult().toObject(Passenger.class));
					}
				}).addOnFailureListener(host, e -> {
			showLog(host, e.getLocalizedMessage());
		});
		
		return passenger != null ? passenger.get() : null;
	}
	
	@Nullable
	public static Driver getCurrentDriver(@NonNull Activity host, @NonNull String uid) {
		AtomicReference<Driver> driver = null;
		FirebaseFirestore.getInstance().collection(DRIVER_REF).document(uid)
				.get()
				.addOnCompleteListener(host, task -> {
					if (task.isSuccessful()) {
						driver.set(task.getResult().toObject(Driver.class));
					}
				}).addOnFailureListener(host, e -> {
			showLog(host, e.getLocalizedMessage());
		});
		
		return driver != null ? driver.get() : null;
	}
	
	//Show log messages during debugging
	private static void showLog(Activity host, String logMessage) {
		Log.d(host.getClass().getCanonicalName(), logMessage);
	}
	
}
