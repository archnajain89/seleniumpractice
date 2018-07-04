package com.irctc.constants;

public class Locators {

	public static final String USER_ID = "//*[@id='identifierId']";
	public static final String PASS = "//*[@name='password']";
	public static final String NEXT_BUTTON = "//*[@id='identifierNext']/content";
	public static final String PASSWORD_NEXT_BUTTON="//span[text()='Next']";
	public static final String LOGOUT_LINK="//a[@class='gb_b gb_ib gb_R']";
	public static final String SIGNOUT_BTN = "//a[@id='gb_71']";
	public static final String COMPOSE_BTN = "//div[contains(text(),'COMPOSE')]";
	public static final String RECIPIENTS_EMAIL = "//*[@id=':fu']";
	public static final String SUBJECTS="//input[@name='subjectbox']";
	public static final String BODY = "//*[@id=':gh']";
	public static final String ATTACHMENT_LINK = "//div[@id=':h2']";
	public static final String SEND_BTN = "//div[@id=':f2' and contains(text(),'Send')]";
	public static final String SENT_MSG = "//div[@class='vh' and contains(text(),'Your message has been sent.')]";
}
