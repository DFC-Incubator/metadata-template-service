package org.irods.jargon.rest.mdtemplate.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * MetadataTemplateElement
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-03-27T11:39:55.216-04:00")

public class MetadataTemplateElement   {
  private String uuid = null;

  private String name = null;

  private String i18nName = null;

  private String description = null;

  private String i18nDescription = null;

  private Boolean required = null;

  /**
   * Gets or Sets elementType
   */
  public enum ElementTypeEnum {
    RAW_STRING("RAW_STRING"),
    
    RAW_TEXT("RAW_TEXT"),
    
    RAW_URL("RAW_URL"),
    
    RAW_INT("RAW_INT"),
    
    RAW_FLOAT("RAW_FLOAT"),
    
    RAW_BOOLEAN("RAW_BOOLEAN"),
    
    RAW_DATE("RAW_DATE"),
    
    RAW_TIME("RAW_TIME"),
    
    RAW_DATETIME("RAW_DATETIME"),
    
    REF_IRODS_QUERY("REF_IRODS_QUERY"),
    
    REF_IRODS_CATALOG("REF_IRODS_CATALOG"),
    
    REF_URL("REF_URL"),
    
    LIST_STRING("LIST_STRING"),
    
    LIST_INT("LIST_INT"),
    
    LIST_FLOAT("LIST_FLOAT");

    private String value;

    ElementTypeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private List<ElementTypeEnum> elementType = new ArrayList<ElementTypeEnum>();

  /**
   * Gets or Sets validationStyle
   */
  public enum ValidationStyleEnum {
    DEFAULT("DEFAULT"),
    
    IS("IS"),
    
    IN_LIST("IN_LIST"),
    
    IN_RANGE("IN_RANGE"),
    
    IN_RANGE_EXCLUSIVE("IN_RANGE_EXCLUSIVE"),
    
    REGEX("REGEX"),
    
    FOLLOW_REF("FOLLOW_REF"),
    
    DO_NOT_VALIDATE("DO_NOT_VALIDATE");

    private String value;

    ValidationStyleEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private List<ValidationStyleEnum> validationStyle = new ArrayList<ValidationStyleEnum>();

  private List<String> validationOptions = new ArrayList<String>();

  private List<String> defaultValue = new ArrayList<String>();

  private List<String> currentValue = new ArrayList<String>();

  public MetadataTemplateElement uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * uuid for the element
   * @return uuid
  **/
  @ApiModelProperty(required = true, value = "uuid for the element")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public MetadataTemplateElement name(String name) {
    this.name = name;
    return this;
  }

   /**
   * display name of the element
   * @return name
  **/
  @ApiModelProperty(required = true, value = "display name of the element")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MetadataTemplateElement i18nName(String i18nName) {
    this.i18nName = i18nName;
    return this;
  }

   /**
   * display name of the element as an internationalized property
   * @return i18nName
  **/
  @ApiModelProperty(required = true, value = "display name of the element as an internationalized property")
  public String getI18nName() {
    return i18nName;
  }

  public void setI18nName(String i18nName) {
    this.i18nName = i18nName;
  }

  public MetadataTemplateElement description(String description) {
    this.description = description;
    return this;
  }

   /**
   * free form description in English for user prompt
   * @return description
  **/
  @ApiModelProperty(required = true, value = "free form description in English for user prompt")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public MetadataTemplateElement i18nDescription(String i18nDescription) {
    this.i18nDescription = i18nDescription;
    return this;
  }

   /**
   * free form description as an internationalized property
   * @return i18nDescription
  **/
  @ApiModelProperty(required = true, value = "free form description as an internationalized property")
  public String getI18nDescription() {
    return i18nDescription;
  }

  public void setI18nDescription(String i18nDescription) {
    this.i18nDescription = i18nDescription;
  }

  public MetadataTemplateElement required(Boolean required) {
    this.required = required;
    return this;
  }

   /**
   * if set this element is required in the template
   * @return required
  **/
  @ApiModelProperty(required = true, value = "if set this element is required in the template")
  public Boolean getRequired() {
    return required;
  }

  public void setRequired(Boolean required) {
    this.required = required;
  }

  public MetadataTemplateElement elementType(List<ElementTypeEnum> elementType) {
    this.elementType = elementType;
    return this;
  }

  public MetadataTemplateElement addElementTypeItem(ElementTypeEnum elementTypeItem) {
    this.elementType.add(elementTypeItem);
    return this;
  }

   /**
   * describes the data type the element contains, for validation and UI hints
   * @return elementType
  **/
  @ApiModelProperty(required = true, value = "describes the data type the element contains, for validation and UI hints")
  public List<ElementTypeEnum> getElementType() {
    return elementType;
  }

  public void setElementType(List<ElementTypeEnum> elementType) {
    this.elementType = elementType;
  }

  public MetadataTemplateElement validationStyle(List<ValidationStyleEnum> validationStyle) {
    this.validationStyle = validationStyle;
    return this;
  }

  public MetadataTemplateElement addValidationStyleItem(ValidationStyleEnum validationStyleItem) {
    this.validationStyle.add(validationStyleItem);
    return this;
  }

   /**
   * describes how validation will be done on the element
   * @return validationStyle
  **/
  @ApiModelProperty(required = true, value = "describes how validation will be done on the element")
  public List<ValidationStyleEnum> getValidationStyle() {
    return validationStyle;
  }

  public void setValidationStyle(List<ValidationStyleEnum> validationStyle) {
    this.validationStyle = validationStyle;
  }

  public MetadataTemplateElement validationOptions(List<String> validationOptions) {
    this.validationOptions = validationOptions;
    return this;
  }

  public MetadataTemplateElement addValidationOptionsItem(String validationOptionsItem) {
    this.validationOptions.add(validationOptionsItem);
    return this;
  }

   /**
   * additional validation information allowing specification of the options for an element.  For example, these can be shown in a drop down list of the element must be in-list
   * @return validationOptions
  **/
  @ApiModelProperty(value = "additional validation information allowing specification of the options for an element.  For example, these can be shown in a drop down list of the element must be in-list")
  public List<String> getValidationOptions() {
    return validationOptions;
  }

  public void setValidationOptions(List<String> validationOptions) {
    this.validationOptions = validationOptions;
  }

  public MetadataTemplateElement defaultValue(List<String> defaultValue) {
    this.defaultValue = defaultValue;
    return this;
  }

  public MetadataTemplateElement addDefaultValueItem(String defaultValueItem) {
    this.defaultValue.add(defaultValueItem);
    return this;
  }

   /**
   * defines the default value for this element. Ref query dot notation appears here, signaling the default will be derived from information held elsewhere in the catalog
   * @return defaultValue
  **/
  @ApiModelProperty(value = "defines the default value for this element. Ref query dot notation appears here, signaling the default will be derived from information held elsewhere in the catalog")
  public List<String> getDefaultValue() {
    return defaultValue;
  }

  public void setDefaultValue(List<String> defaultValue) {
    this.defaultValue = defaultValue;
  }

  public MetadataTemplateElement currentValue(List<String> currentValue) {
    this.currentValue = currentValue;
    return this;
  }

  public MetadataTemplateElement addCurrentValueItem(String currentValueItem) {
    this.currentValue.add(currentValueItem);
    return this;
  }

   /**
   * defines the current value of this element in a retrieved and resolved instance of the metadata template. That is, after a merge of templates and stored metadata values is done
   * @return currentValue
  **/
  @ApiModelProperty(value = "defines the current value of this element in a retrieved and resolved instance of the metadata template. That is, after a merge of templates and stored metadata values is done")
  public List<String> getCurrentValue() {
    return currentValue;
  }

  public void setCurrentValue(List<String> currentValue) {
    this.currentValue = currentValue;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MetadataTemplateElement metadataTemplateElement = (MetadataTemplateElement) o;
    return Objects.equals(this.uuid, metadataTemplateElement.uuid) &&
        Objects.equals(this.name, metadataTemplateElement.name) &&
        Objects.equals(this.i18nName, metadataTemplateElement.i18nName) &&
        Objects.equals(this.description, metadataTemplateElement.description) &&
        Objects.equals(this.i18nDescription, metadataTemplateElement.i18nDescription) &&
        Objects.equals(this.required, metadataTemplateElement.required) &&
        Objects.equals(this.elementType, metadataTemplateElement.elementType) &&
        Objects.equals(this.validationStyle, metadataTemplateElement.validationStyle) &&
        Objects.equals(this.validationOptions, metadataTemplateElement.validationOptions) &&
        Objects.equals(this.defaultValue, metadataTemplateElement.defaultValue) &&
        Objects.equals(this.currentValue, metadataTemplateElement.currentValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, name, i18nName, description, i18nDescription, required, elementType, validationStyle, validationOptions, defaultValue, currentValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MetadataTemplateElement {\n");
    
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    i18nName: ").append(toIndentedString(i18nName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    i18nDescription: ").append(toIndentedString(i18nDescription)).append("\n");
    sb.append("    required: ").append(toIndentedString(required)).append("\n");
    sb.append("    elementType: ").append(toIndentedString(elementType)).append("\n");
    sb.append("    validationStyle: ").append(toIndentedString(validationStyle)).append("\n");
    sb.append("    validationOptions: ").append(toIndentedString(validationOptions)).append("\n");
    sb.append("    defaultValue: ").append(toIndentedString(defaultValue)).append("\n");
    sb.append("    currentValue: ").append(toIndentedString(currentValue)).append("\n");
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

