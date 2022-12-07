package com.hotel.controller;

import com.hotel.controller.action.Action;
import com.hotel.controller.action.HotelIdPWAction;
import com.hotel.controller.action.HotelLoginAction;
import com.hotel.controller.action.HotelMainPageForm;
import com.hotel.controller.action.HotelRegisterAction;
import com.hotel.controller.action.HotelRegisterIdCheckAction;
import com.hotel.controller.action.HotelRegisterSuccessForm;

public class ActionFactory {
	// 싱글톤
	private ActionFactory() {}
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println(command);
		if (command.equals("login_page")) {
			action = new HotelLoginAction();
		} else if (command.equals("hotel_register_form")) {
			action = new HotelRegisterAction();
		} else if (command.equals("hotel_register")) {
			action = new HotelRegisterSuccessForm();
		} else if (command.equals("hotel_id/pw_form")) {
			action = new HotelIdPWAction();
		} else if (command.equals("hotel_main_page_form")) {
			action = new HotelMainPageForm();
		} else if (command.equals("hotel_id_check_form")) {
			action = new HotelRegisterIdCheckAction();
		}

		return action;

	}

}
