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


package com.klarna.rest.api.checkout.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * CheckoutProductV1
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-04-02T15:03:42.622Z")
public class CheckoutProductV1 {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("identifier")
  private String identifier = null;

  public CheckoutProductV1 name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Carrier product name
   * @return name
  **/
  @ApiModelProperty(value = "Carrier product name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CheckoutProductV1 identifier(String identifier) {
    this.identifier = identifier;
    return this;
  }

   /**
   * Carrier product identifier
   * @return identifier
  **/
  @ApiModelProperty(value = "Carrier product identifier")
  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckoutProductV1 productV1 = (CheckoutProductV1) o;
    return Objects.equals(this.name, productV1.name) &&
        Objects.equals(this.identifier, productV1.identifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, identifier);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckoutProductV1 {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
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

