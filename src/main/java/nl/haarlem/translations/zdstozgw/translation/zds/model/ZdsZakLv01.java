package nl.haarlem.translations.zdstozgw.translation.zds.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import static nl.haarlem.translations.zdstozgw.translation.zds.model.namespace.Namespace.ZKN;

@Data
@XmlRootElement(namespace = ZKN, name = "zakLv01")
@XmlAccessorType(XmlAccessType.FIELD)
public class ZdsZakLv01 {
    @XmlElement(namespace = ZKN)
    public ZdsStuurgegevens zdsStuurgegevens;

    @XmlElement(namespace = ZKN)
    public ZdsParameters zdsParameters;

    @XmlElement(namespace = ZKN)
    public ZdsGelijk zdsGelijk;
}