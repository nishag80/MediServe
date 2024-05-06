package com.edu.exception;

public enum ErrorType {
	
	DATABASE_ERROR("ERROR", "DataBase Error", "Database operation failure,Please contact technical support."),
	VALIDATION_ERROR("ERROR", "Validation failure", "Check the submitted data."),
	NETWORK_ERROR("ERROR", "Network issues", "Ensure you are connected to the internet."),
	CONFIGURATION_ERROR("ERROR", "Configuration issues", "Verify your configuration settings."),
	UNAUTHORIZED_ACCESS("ERROR", "Unauthorized access attempt", "Please login with appropriate credentials."),
	RESOURCE_NOT_FOUND("FAILD", "Requested resource not found", "Verify the resource identifier."),
	INTERNAL_ERROR("ERROR", "Internal server error", "An unexpected error occurred."),
	MISSING_PARAM ("FAILD", "Parameter Missing", "Parameter is missing in the request."),
	DECLINED("DECLIEND", "Declined", "The request has been declined by the system."),
	INVALID_MEDINCINE_ID("FAILD", "Invalid Medicine Id", "Medicine doesn't exist"),
	INVALID_REQUEST("ERROR", "Invalid Request", "Check Request Parameters"),
	USER_NOT_FOUND("FAILD", "User not found", "The request has been declined by the system."),
	NOT_FOUND("FAILD", "No Data Found", "The request has been declined by the system.");

	private final String code;
	private final String name;
	private final String description;

	ErrorType(String code, String name, String description) {
		this.code = code;
		this.name = name;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

}
