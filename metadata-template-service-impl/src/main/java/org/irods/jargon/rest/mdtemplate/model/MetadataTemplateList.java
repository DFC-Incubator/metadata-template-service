package org.irods.jargon.rest.mdtemplate.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.irods.jargon.rest.mdtemplate.model.RestMetadataTemplate;




/**
 * MetadataTemplateList
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-03-28T12:18:38.465-04:00")

public class MetadataTemplateList   {
  private List<RestMetadataTemplate> metadataTemplate = new ArrayList<RestMetadataTemplate>();

  public MetadataTemplateList metadataTemplate(List<RestMetadataTemplate> metadataTemplate) {
    this.metadataTemplate = metadataTemplate;
    return this;
  }

  public MetadataTemplateList addMetadataTemplateItem(RestMetadataTemplate metadataTemplateItem) {
    this.metadataTemplate.add(metadataTemplateItem);
    return this;
  }

   /**
   * Metadata Template
   * @return metadataTemplate
  **/
  @ApiModelProperty(value = "Metadata Template")
  public List<RestMetadataTemplate> getMetadataTemplate() {
    return metadataTemplate;
  }

  public void setMetadataTemplate(List<RestMetadataTemplate> metadataTemplate) {
    this.metadataTemplate = metadataTemplate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MetadataTemplateList metadataTemplateList = (MetadataTemplateList) o;
    return Objects.equals(this.metadataTemplate, metadataTemplateList.metadataTemplate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadataTemplate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MetadataTemplateList {\n");
    
    sb.append("    metadataTemplate: ").append(toIndentedString(metadataTemplate)).append("\n");
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

