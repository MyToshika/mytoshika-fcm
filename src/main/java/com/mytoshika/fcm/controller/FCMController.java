package com.mytoshika.fcm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mytoshika.fcm.service.FCMMessageSender;

@CrossOrigin
@RestController
@RequestMapping(value = {"${app.version}/fcm"})
public class FCMController {

	private final FCMMessageSender pushSender;

	public FCMController(FCMMessageSender pushSender) {
		this.pushSender = pushSender;
	}

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void register(@RequestParam("token") String token) {
		System.out.println("register: " + token);
		this.pushSender.addToken(token);
	}

	@PostMapping("/unregister")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void unregister(@RequestParam("token") String token) {
		System.out.println("unregister: " + token);
		this.pushSender.removeToken(token);
	}

}

