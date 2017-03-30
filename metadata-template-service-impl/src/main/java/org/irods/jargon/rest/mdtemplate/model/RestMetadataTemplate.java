package org.irods.jargon.rest.mdtemplate.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplateElement;
import org.joda.time.DateTime;




/**
 * RestMetadataTemplate
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-03-28T12:18:38.465-04:00")

public class RestMetadataTemplate   {
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

    TypeEnum(String value) {
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

    DestinationEnum(String value) {
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

  public RestMetadataTemplate uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * uuid for the tamplate
   * @return uuid
  **/
  @ApiModelProperty(required = true, value = "uuid for the tamplate")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public RestMetadataTemplate name(String name) {
    this.name = name;
    return this;
  }

   /**
   * display name of the template
   * @return name
  **/
  @ApiModelProperty(required = true, value = "display name of the template")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RestMetadataTemplate description(String description) {
    this.description = description;
    return this;
  }

   /**
   * free form description
   * @return description
  **/
  @ApiModelProperty(value = "free form description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public RestMetadataTemplate author(String author) {
    this.author = author;
    return this;
  }

   /**
   * author of metadata template
   * @return author
  **/
  @ApiModelProperty(value = "author of metadata template")
  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public RestMetadataTemplate created(DateTime created) {
    this.created = created;
    return this;
  }

   /**
   * create date of template
   * @return created
  **/
  @ApiModelProperty(required = true, value = "create date of template")
  public DateTime getCreated() {
    return created;
  }

  public void setCreated(DateTime created) {
    this.created = created;
  }

  public RestMetadataTemplate modified(DateTime modified) {
    this.modified = modified;
    return this;
  }

   /**
   * modification date of template
   * @return modified
  **/
  @ApiModelProperty(required = true, value = "modification date of template")
  public DateTime getModified() {
    return modified;
  }

  public void setModified(DateTime modified) {
    this.modified = modified;
  }

  public RestMetadataTemplate version(String version) {
    this.version = version;
    return this;
  }

   /**
   * optional version number
   * @return version
  **/
  @ApiModelProperty(value = "optional version number")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public RestMetadataTemplate type(List<TypeEnum> type) {
    this.type = type;
    return this;
  }

  public RestMetadataTemplate addTypeItem(TypeEnum typeItem) {
    this.type.add(typeItem);
    return this;
  }

   /**
   * functional type of metadata template (e.g. form versus automatic)
   * @return type
  **/
  @ApiModelProperty(required = true, value = "functional type of metadata template (e.g. form versus automatic)")
  public List<TypeEnum> getType() {
    return type;
  }

  public void setType(List<TypeEnum> type) {
    this.type = type;
  }

  public RestMetadataTemplate destination(List<DestinationEnum> destination) {
    this.destination = destination;
    return this;
  }

  public RestMetadataTemplate addDestinationItem(DestinationEnum destinationItem) {
    this.destination.add(destinationItem);
    return this;
  }

   /**
   * disposition of metadata created by template
   * @return destination
  **/
  @ApiModelProperty(required = true, value = "disposition of metadata created by template")
  public List<DestinationEnum> getDestination() {
    return destination;
  }

  public void setDestination(List<DestinationEnum> destination) {
    this.destination = destination;
  }

  public RestMetadataTemplate required(Boolean required) {
    this.required = required;
    return this;
  }

   /**
   * indicates whether entry of this metadata is required
   * @return required
  **/
  @ApiModelProperty(required = true, value = "indicates whether entry of this metadata is required")
  public Boolean getRequired() {
    return required;
  }

  public void setRequired(Boolean required) {
    this.required = required;
  }

  public RestMetadataTemplate metadataTemplateElements(List<RestMetadataTemplateElement> metadataTemplateElements) {
    this.metadataTemplateElements = metadataTemplateElements;
    return this;
  }

  public RestMetadataTemplate addMetadataTemplateElementsItem(RestMetadataTemplateElement metadataTemplateElementsItem) {
    this.metadataTemplateElements.add(metadataTemplateElementsItem);
    return this;
  }

   /**
   * Metadata Template Elements
   * @return metadataTemplateElements
  **/
  @ApiModelProperty(required = true, value = "Metadata Template Elements")
  public List<RestMetadataTemplateElement> getMetadataTemplateElements() {
    return metadataTemplateElements;
  }

  public void setMetadataTemplateElements(List<RestMetadataTemplateElement> metadataTemplateElements) {
    this.metadataTemplateElements = metadataTemplateElements;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestMetadataTemplate restMetadataTemplate = (RestMetadataTemplate) o;
    return Objects.equals(this.uuid, restMetadataTemplate.uuid) &&
        Objects.equals(this.name, restMetadataTemplate.name) &&
        Objects.equals(this.description, restMetadataTemplate.description) &&
        Objects.equals(this.author, restMetadataTemplate.author) &&
        Objects.equals(this.created, restMetadataTemplate.created) &&
        Objects.equals(this.modified, restMetadataTemplate.modified) &&
        Objects.equals(this.version, restMetadataTemplate.version) &&
        Objects.equals(this.type, restMetadataTemplate.type) &&
        Objects.equals(this.destination, restMetadataTemplate.destination) &&
        Objects.equals(this.required, restMetadataTemplate.required) &&
        Objects.equals(this.metadataTemplateElements, restMetadataTemplate.metadataTemplateElements);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, name, description, author, created, modified, version, type, destination, required, metadataTemplateElements);
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

