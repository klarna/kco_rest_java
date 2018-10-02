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


package com.klarna.rest.model.payments;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * MerchantUrls
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-09-28T14:31:36.430Z")
public class MerchantUrls {
  @JsonProperty("confirmation")
  private String confirmation = null;

  @JsonProperty("notification")
  private String notification = null;

  @JsonProperty("push")
  private String push = null;

  public MerchantUrls confirmation(String confirmation) {
    this.confirmation = confirmation;
    return this;
  }

   /**
   * URL of merchant confirmation page (max 2000 characters).
   * @return confirmation
  **/
  @ApiModelProperty(required = true, value = "URL of merchant confirmation page (max 2000 characters).")
  public String getConfirmation() {
    return confirmation;
  }

  public void setConfirmation(String confirmation) {
    this.confirmation = confirmation;
  }

  public MerchantUrls notification(String notification) {
    this.notification = notification;
    return this;
  }

   /**
   * URL for notifications on pending orders (max 2000 characters).
   * @return notification
  **/
  @ApiModelProperty(value = "URL for notifications on pending orders (max 2000 characters).")
  public String getNotification() {
    return notification;
  }

  public void setNotification(String notification) {
    this.notification = notification;
  }

  public MerchantUrls push(String push) {
    this.push = push;
    return this;
  }

   /**
   * URL that will be requested when an order is completed. Should be different than checkout and confirmation URLs (max 2000 characters).
   * @return push
  **/
  @ApiModelProperty(value = "URL that will be requested when an order is completed. Should be different than checkout and confirmation URLs (max 2000 characters).")
  public String getPush() {
    return push;
  }

  public void setPush(String push) {
    this.push = push;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MerchantUrls merchantUrls = (MerchantUrls) o;
    return Objects.equals(this.confirmation, merchantUrls.confirmation) &&
        Objects.equals(this.notification, merchantUrls.notification) &&
        Objects.equals(this.push, merchantUrls.push);
  }

  @Override
  public int hashCode() {
    return Objects.hash(confirmation, notification, push);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MerchantUrls {\n");
    
    sb.append("    confirmation: ").append(toIndentedString(confirmation)).append("\n");
    sb.append("    notification: ").append(toIndentedString(notification)).append("\n");
    sb.append("    push: ").append(toIndentedString(push)).append("\n");
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
