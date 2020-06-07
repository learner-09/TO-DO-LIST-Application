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

	public enum SortType {

		ASCENDING("asc"), DESCENDING("desc");

		private String code;

		private SortType(String code) {
			this.code = code;
		}

		public String getCode() {
			return this.code;
		}
	}

	public enum GeneralTypeId {

		TASK_STATUS("TKSTA"), TASK_TAG("TKTAG"), TASK_COL("TKCOL");

		private String code;

		private GeneralTypeId(String code) {
			this.code = code;
		}

		public String getCode() {
			return this.code;
		}
	}

}
