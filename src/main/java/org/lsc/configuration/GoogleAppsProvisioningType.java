//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.17 at 11:13:13 PM CEST 
//


package org.lsc.configuration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for googleAppsProvisioningType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="googleAppsProvisioningType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UserAccounts"/>
 *     &lt;enumeration value="Groups"/>
 *     &lt;enumeration value="OrganizationUnits"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "googleAppsProvisioningType")
@XmlEnum
public enum GoogleAppsProvisioningType {

    @XmlEnumValue("UserAccounts")
    USER_ACCOUNTS("UserAccounts"),
    @XmlEnumValue("Groups")
    GROUPS("Groups"),
    @XmlEnumValue("OrganizationUnits")
    ORGANIZATION_UNITS("OrganizationUnits");
    private final String value;

    GoogleAppsProvisioningType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GoogleAppsProvisioningType fromValue(String v) {
        for (GoogleAppsProvisioningType c: GoogleAppsProvisioningType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}