package com.todo.constants;

public class EnumConstants {

	public enum ResponseStatus {
		SUCCESS("SUCCESS"), FAILURE("FAILURE"), ERROR("ERROR");

		private String code;

		private ResponseStatus(String code) {
			this.code = code;
		}

		public String getCode() {
			return this.code;
		}

	}

}
