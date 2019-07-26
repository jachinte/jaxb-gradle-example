/**
 * Contains JAXB-annotated classes to create the example.
 * @author Miguel Jimenez
 * @version $Id$
 * @since 0.1.0
 */
@XmlSchema(
    namespace = Example.NAMESPACE,
    elementFormDefault = XmlNsForm.QUALIFIED
)
package com.example;

import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
