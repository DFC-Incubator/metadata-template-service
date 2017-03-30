package org.irods.jargon.rest.mdtemplate.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.joda.time.DateTime;

import io.swagger.annotations.ApiModelProperty;

/**
 * RestMetadataTemplate
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-03-28T12:18:38.465-04:00")

public class RestMetadataTemplate {
	private String uuid = null;

	private String name = null;

	private String description = null;

	private String author = null;

	private DateTime created = null;

	private DateTime modified = null;

	private String version = null;

	/**
	 * Gets or Sets type
	 */
	public enum TypeEnum {
		FORM_BASED("FORM_BASED"),

		GENERATED("GENERATED");

		private String value;

		TypeEnum(final String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	private List<TypeEnum> type = new ArrayList<TypeEnum>();

	/**
	 * Gets or Sets destination
	 */
	public enum DestinationEnum {
		IRODS("IRODS");

		private String value;

		DestinationEnum(final String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	private List<DestinationEnum> destination = new ArrayList<DestinationEnum>();

	private Boolean required = null;

	private List<RestMetadataTemplateElement> metadataTemplateElements = new ArrayList<RestMetadataTemplateElement>();

	public RestMetadataTemplate uuid(final String uuid) {
		this.uuid = uuid;
		return this;
	}

	/**
	 * uuid for the tamplate
	 * 
	 * @return uuid
	 **/
	@ApiModelProperty(required = true, value = "uuid for the tamplate")
	public String getUuid() {
		return uuid;
	}

	public void setUuid(final String uuid) {
		this.uuid = uuid;
	}

	public RestMetadataTemplate name(final String name) {
		this.name = name;
		return this;
	}

	/**
	 * display name of the template
	 * 
	 * @return name
	 **/
	@ApiModelProperty(required = true, value = "display name of the template")
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public RestMetadataTemplate description(final String description) {
		this.description = description;
		return this;
	}

	/**
	 * free form description
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "free form description")
	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public RestMetadataTemplate author(final String author) {
		this.author = author;
		return this;
	}

	/**
	 * author of metadata template
	 * 
	 * @return author
	 **/
	@ApiModelProperty(value = "author of metadata template")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(final String author) {
		this.author = author;
	}

	public RestMetadataTemplate created(final DateTime created) {
		this.created = created;
		return this;
	}

	/**
	 * create date of template
	 * 
	 * @return created
	 **/
	@ApiModelProperty(required = true, value = "create date of template")
	public DateTime getCreated() {
		return created;
	}

	public void setCreated(final DateTime created) {
		this.created = created;
	}

	public RestMetadataTemplate modified(final DateTime modified) {
		this.modified = modified;
		return this;
	}

	/**
	 * modification date of template
	 * 
	 * @return modified
	 **/
	@ApiModelProperty(required = true, value = "modification date of template")
	public DateTime getModified() {
		return modified;
	}

	public void setModified(final DateTime modified) {
		this.modified = modified;
	}

	public RestMetadataTemplate version(final String version) {
		this.version = version;
		return this;
	}

	/**
	 * optional version number
	 * 
	 * @return version
	 **/
	@ApiModelProperty(value = "optional version number")
	public String getVersion() {
		return version;
	}

	public void setVersion(final String version) {
		this.version = version;
	}

	public RestMetadataTemplate type(final List<TypeEnum> type) {
		this.type = type;
		return this;
	}

	public RestMetadataTemplate addTypeItem(final TypeEnum typeItem) {
		type.add(typeItem);
		return this;
	}

	/**
	 * functional type of metadata template (e.g. form versus automatic)
	 * 
	 * @return type
	 **/
	@ApiModelProperty(required = true, value = "functional type of metadata template (e.g. form versus automatic)")
	public List<TypeEnum> getType() {
		return type;
	}

	public void setType(final List<TypeEnum> type) {
		this.type = type;
	}

	public RestMetadataTemplate destination(final List<DestinationEnum> destination) {
		this.destination = destination;
		return this;
	}

	public RestMetadataTemplate addDestinationItem(final DestinationEnum destinationItem) {
		destination.add(destinationItem);
		return this;
	}

	/**
	 * disposition of metadata created by template
	 * 
	 * @return destination
	 **/
	@ApiModelProperty(required = true, value = "disposition of metadata created by template")
	public List<DestinationEnum> getDestination() {
		return destination;
	}

	public void setDestination(final List<DestinationEnum> destination) {
		this.destination = destination;
	}

	public RestMetadataTemplate required(final Boolean required) {
		this.required = required;
		return this;
	}

	/**
	 * indicates whether entry of this metadata is required
	 * 
	 * @return required
	 **/
	@ApiModelProperty(required = true, value = "indicates whether entry of this metadata is required")
	public Boolean getRequired() {
		return required;
	}

	public void setRequired(final Boolean required) {
		this.required = required;
	}

	public RestMetadataTemplate metadataTemplateElements(
			final List<RestMetadataTemplateElement> metadataTemplateElements) {
		this.metadataTemplateElements = metadataTemplateElements;
		return this;
	}

	public RestMetadataTemplate addMetadataTemplateElementsItem(
			final RestMetadataTemplateElement metadataTemplateElementsItem) {
		metadataTemplateElements.add(metadataTemplateElementsItem);
		return this;
	}

	/**
	 * Metadata Template Elements
	 * 
	 * @return metadataTemplateElements
	 **/
	@ApiModelProperty(required = true, value = "Metadata Template Elements")
	public List<RestMetadataTemplateElement> getMetadataTemplateElements() {
		return metadataTemplateElements;
	}

	public void setMetadataTemplateElements(final List<RestMetadataTemplateElement> metadataTemplateElements) {
		this.metadataTemplateElements = metadataTemplateElements;
	}

	@Override
	public boolean equals(final java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RestMetadataTemplate restMetadataTemplate = (RestMetadataTemplate) o;
		return Objects.equals(uuid, restMetadataTemplate.uuid) && Objects.equals(name, restMetadataTemplate.name)
				&& Objects.equals(description, restMetadataTemplate.description)
				&& Objects.equals(author, restMetadataTemplate.author)
				&& Objects.equals(created, restMetadataTemplate.created)
				&& Objects.equals(modified, restMetadataTemplate.modified)
				&& Objects.equals(version, restMetadataTemplate.version)
				&& Objects.equals(type, restMetadataTemplate.type)
				&& Objects.equals(destination, restMetadataTemplate.destination)
				&& Objects.equals(required, restMetadataTemplate.required)
				&& Objects.equals(metadataTemplateElements, restMetadataTemplate.metadataTemplateElements);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, name, description, author, created, modified, version, type, destination, required,
				metadataTemplateElements);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RestMetadataTemplate {\n");

		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    author: ").append(toIndentedString(author)).append("\n");
		sb.append("    created: ").append(toIndentedString(created)).append("\n");
		sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
		sb.append("    required: ").append(toIndentedString(required)).append("\n");
		sb.append("    metadataTemplateElements: ").append(toIndentedString(metadataTemplateElements)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(final java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
