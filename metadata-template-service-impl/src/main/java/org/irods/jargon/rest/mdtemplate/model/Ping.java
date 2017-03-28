package org.irods.jargon.rest.mdtemplate.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * Ping
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-03-27T21:38:56.734-04:00")

public class Ping {
	private Float pingTime = null;

	public Ping pingTime(Float pingTime) {
		this.pingTime = pingTime;
		return this;
	}

	/**
	 * milliseconds to connect to iRODS and get a response from the perspective
	 * of the mid-tier service
	 * 
	 * @return pingTime
	 **/
	@ApiModelProperty(value = "milliseconds to connect to iRODS and get a response from the perspective of the mid-tier service")
	public Float getPingTime() {
		return pingTime;
	}

	public void setPingTime(Float pingTime) {
		this.pingTime = pingTime;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Ping ping = (Ping) o;
		return Objects.equals(this.pingTime, ping.pingTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pingTime);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Ping {\n");

		sb.append("    pingTime: ").append(toIndentedString(pingTime)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
