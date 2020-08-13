package nl.haarlem.translations.zdstozgw.converter.impl;

import nl.haarlem.translations.zdstozgw.config.model.Translation;
import nl.haarlem.translations.zdstozgw.converter.Converter;
import nl.haarlem.translations.zdstozgw.translation.zds.model.ZdsFo03;
import nl.haarlem.translations.zdstozgw.translation.zds.model.ZdsParameters;
import nl.haarlem.translations.zdstozgw.translation.zds.model.ZdsZakLa01LijstZaakdocumenten;
import nl.haarlem.translations.zdstozgw.translation.zds.model.ZdsZakLv01;
import nl.haarlem.translations.zdstozgw.translation.zds.services.ZaakService;
import nl.haarlem.translations.zdstozgw.utils.XmlUtils;

public class GeefLijstZaakdocumentenConverter extends Converter {

    public GeefLijstZaakdocumentenConverter(Translation translation, ZaakService zaakService) {
        super(translation, zaakService);
    }

    @Override
    public String convert(String request) {
        ZdsZakLv01 zdsZakLv01 = new ZdsZakLv01();
        try {
            zdsZakLv01 = (ZdsZakLv01) XmlUtils.getStUFObject(request, ZdsZakLv01.class);
            ZdsZakLa01LijstZaakdocumenten zdsZakLa01LijstZaakdocumenten = this.getZaakService().geefLijstZaakdocumenten(zdsZakLv01);
            zdsZakLa01LijstZaakdocumenten.zdsParameters = new ZdsParameters(zdsZakLv01.zdsParameters);
            return XmlUtils.getSOAPMessageFromObject(zdsZakLa01LijstZaakdocumenten, false);
        } catch (Exception ex) {
            ex.printStackTrace();
            var fo03 = new ZdsFo03(zdsZakLv01.zdsStuurgegevens);
            fo03.body = new ZdsFo03.Body(ex);
            return XmlUtils.getSOAPMessageFromObject(fo03, true);
        }
    }
}