/*
 * XAdES4j - A Java library for generation and verification of XAdES signatures.
 * Copyright (C) 2010 Luis Goncalves.
 *
 * XAdES4j is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or any later version.
 *
 * XAdES4j is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License along
 * with XAdES4j. If not, see <http://www.gnu.org/licenses/>.
 */
package xades4j.xml.marshalling;

import javax.xml.bind.JAXBElement;
import xades4j.properties.data.ArchiveTimeStampData;
import xades4j.xml.bind.xades.ObjectFactory;
import xades4j.xml.bind.xades.XmlUnsignedPropertiesType;
import xades4j.xml.bind.xades.XmlXAdESTimeStampType;
import xades4j.xml.marshalling.algorithms.AlgorithmsParametersMarshallingProvider;

/**
 * @author Luís
 */
class ToXmlArchiveTimeStampConverter extends ToXmlUnsignedTimeStampDataConverter<ArchiveTimeStampData>
{
    ToXmlArchiveTimeStampConverter(AlgorithmsParametersMarshallingProvider algorithmsParametersMarshallingProvider)
    {
        super(algorithmsParametersMarshallingProvider);
    }

    @Override
    protected void insertIntoObjectTree(
            XmlXAdESTimeStampType xmlTimeStamp,
            XmlUnsignedPropertiesType xmlProps,
            ArchiveTimeStampData propData)
    {
        JAXBElement<XmlXAdESTimeStampType> xmlArchTS = new ObjectFactory().createArchiveTimeStampV1_4_1(xmlTimeStamp);
        xmlProps.getUnsignedSignatureProperties().getAny().add(xmlArchTS);
    }
}