/*
 * 
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.klarna.rest.model.checkout;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Gui
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-09-06T10:31:49.433Z")
public class Gui {
  @JsonProperty("options")
  private List<String> options = null;

   /**
   * An array of options to define the checkout behaviour. Supported options: &lt;b&gt;disable_autofocus&lt;/b&gt;, &lt;b&gt;minimal_confirmation&lt;/b&gt;.
   * @return options
  **/
  @ApiModelProperty(example = "[\"disable_autofocus\"]", value = "An array of options to define the checkout behaviour. Supported options: <b>disable_autofocus</b>, <b>minimal_confirmation</b>.")
  public List<String> getOptions() {
    return options;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Gui gui = (Gui) o;
    return Objects.equals(this.options, gui.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(options);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Gui {\n");
    
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
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
