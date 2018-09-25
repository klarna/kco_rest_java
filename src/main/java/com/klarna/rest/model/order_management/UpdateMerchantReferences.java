/*
 * Klarna Order Managment API
 * API to handle order lifecycle
 *
 * OpenAPI spec version: 1.0
 * Contact: developers-experience@klarna.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.klarna.rest.model.order_management;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * UpdateMerchantReferences
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-09-06T11:24:04.099Z")
public class UpdateMerchantReferences {
  @JsonProperty("merchant_reference1")
  private String merchantReference1 = null;

  @JsonProperty("merchant_reference2")
  private String merchantReference2 = null;

  public UpdateMerchantReferences merchantReference1(String merchantReference1) {
    this.merchantReference1 = merchantReference1;
    return this;
  }

   /**
   * New merchant reference 1. Old reference will be overwritten if this field is present.
   * @return merchantReference1
  **/
  @ApiModelProperty(value = "New merchant reference 1. Old reference will be overwritten if this field is present.")
  public String getMerchantReference1() {
    return merchantReference1;
  }

  public void setMerchantReference1(String merchantReference1) {
    this.merchantReference1 = merchantReference1;
  }

  public UpdateMerchantReferences merchantReference2(String merchantReference2) {
    this.merchantReference2 = merchantReference2;
    return this;
  }

   /**
   * New merchant reference 2. Old reference will be overwritten if this field is present.
   * @return merchantReference2
  **/
  @ApiModelProperty(value = "New merchant reference 2. Old reference will be overwritten if this field is present.")
  public String getMerchantReference2() {
    return merchantReference2;
  }

  public void setMerchantReference2(String merchantReference2) {
    this.merchantReference2 = merchantReference2;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateMerchantReferences updateMerchantReferences = (UpdateMerchantReferences) o;
    return Objects.equals(this.merchantReference1, updateMerchantReferences.merchantReference1) &&
        Objects.equals(this.merchantReference2, updateMerchantReferences.merchantReference2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantReference1, merchantReference2);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateMerchantReferences {\n");
    
    sb.append("    merchantReference1: ").append(toIndentedString(merchantReference1)).append("\n");
    sb.append("    merchantReference2: ").append(toIndentedString(merchantReference2)).append("\n");
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
