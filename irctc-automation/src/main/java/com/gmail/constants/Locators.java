package com.gmail.constants;

public class Locators {

	public static final String USER_ID = "//*[@id='identifierId']";
	public static final String PASS = "//*[@name='password']";
	public static final String NEXT_BUTTON = "//*[@id='identifierNext']/content";
	public static final String PASSWORD_NEXT_BUTTON="//span[text()='Next']";
	public static final String LOGOUT_LINK="//a[@class='gb_b gb_ib gb_R']";
	public static final String SIGNOUT_BTN = "//a[@id='gb_71']";
	public static final String COMPOSE_BTN = "//div[contains(text(),'Compose')]";
	public static final String RECIPIENTS_EMAIL = "//textarea[@name='to']";
	public static final String SUBJECTS="//input[@name='subjectbox']";
	public static final String BODY = "//div[@class='Am Al editable LW-avf']";
	public static final String ATTACHMENT_LINK = "//div[@class='a1 aaA aMZ']";
	public static final String SEND_BTN = "//div[contains(text(),'Send')]";
	public static final String SENT_MSG = "//span[@class='bAq']";
	public static final String SENT_BTN = "//a[@title='Sent']";
	public static final String SELECT_ALL_SENTMAILS="(//div[@class='J-J5-Ji J-JN-M-I-Jm'])[2]//span";
	public static final String NO_MAILS = "//td[text()='No sent messages! ']";
	public static final String DELETE_SENT_MAILS = "//div[@data-tooltip='Delete']";
	public static final String DELETE_SENT_MSG="//span[text()='Conversation moved to Trash.']";
}
