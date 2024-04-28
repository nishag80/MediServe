package com.edu.exception;

public enum ErrorType {
	
	DATABASE_ERROR("001", "Database operation failure", "Please contact technical support."),
	VALIDATION_ERROR("002", "Validation failure", "Check the submitted data."),
	NETWORK_ERROR("003", "Network issues", "Ensure you are connected to the internet."),
	CONFIGURATION_ERROR("004", "Configuration issues", "Verify your configuration settings."),
	UNAUTHORIZED_ACCESS("005", "Unauthorized access attempt", "Please login with appropriate credentials."),
	RESOURCE_NOT_FOUND("006", "Requested resource not found", "Verify the resource identifier."),
	INTERNAL_ERROR("007", "Internal server error", "An unexpected error occurred."),
	MISSING_PARAM ("009", "Parameter Missing", "Parameter is missing in the request."),
	DECLINED("008", "Declined", "The request has been declined by the system."),
	USER_NOT_FOUND("009", "User not found", "The request has been declined by the system.");

	private final String code;
	private final String description;
	private final String userAction;

	ErrorType(String code, String description, String userAction) {
		this.code = code;
		this.description = description;
		this.userAction = userAction;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public String getUserAction() {
		return userAction;
	}

}
