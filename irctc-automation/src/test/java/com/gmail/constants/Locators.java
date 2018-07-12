package com.gmail.constants;

public class Locators {

	public static final String USER_ID = "//*[@id='identifierId']";
	public static final String PASS = "//*[@name='password']";
	public static final String NEXT_BUTTON = "//*[@id='identifierNext']/content";
	public static final String PASSWORD_NEXT_BUTTON="//span[text()='Next']";
	public static final String LOGOUT_LINK="//a[@class='gb_b gb_ib gb_R']";
	public static final String SIGNOUT_BTN = "//a[@id='gb_71']";
	public static final String COMPOSE_BTN = "//div[contains(text(),'COMPOSE')]";
	public static final String RECIPIENTS_EMAIL = "//textarea[@name='to']";
	public static final String SUBJECTS="//input[@name='subjectbox']";
	public static final String BODY = "//div[@class='Am Al editable LW-avf']";
	public static final String ATTACHMENT_LINK = "//div[@class='a1 aaA aMZ']";
	public static final String SEND_BTN = "//div[contains(text(),'Send')]";
	public static final String SENT_MSG = "//div[@class='vh' and contains(text(),'Your message has been sent.')]";
}
