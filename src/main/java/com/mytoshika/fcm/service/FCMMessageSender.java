package com.mytoshika.fcm.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FCMMessageSender {

	private final Set<String> tokenRegistry = new CopyOnWriteArraySet<>();

	private final FcmClient fcmClient;

	private int id = 0;

	public FCMMessageSender(FcmClient fcmClient) {
		this.fcmClient = fcmClient;
	}

	public void addToken(String token) {
		this.tokenRegistry.add(token);
	}

	public void removeToken(String token) {
		this.tokenRegistry.remove(token);
	}

	//sends a random message every 30 seconds to all registered clients.
	@Scheduled(fixedDelay = 30_000)
	void sendPushMessages() {
		for (String token : this.tokenRegistry) {
			System.out.println("Sending personal message to: " + token);
			Map<String, String> data = new HashMap<>();
			data.put("id", String.valueOf(++this.id));

			// connect DB and check message for this(token) registered message.
			data.put("text", String.valueOf(Math.random() * 1000));

			try {
				this.fcmClient.sendPushNotification(token, data);
			}
			catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

}
