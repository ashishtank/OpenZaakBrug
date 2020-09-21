package nl.haarlem.translations.zdstozgw.config.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import nl.haarlem.translations.zdstozgw.translation.zgw.model.ZgwZaak;

import java.util.List;

@Data
public class Configuratie {
    @SerializedName("requestHandlerImplementation")
    @Expose
    public String requestHandlerImplementation = null;    

    @SerializedName("organisaties")
    @Expose    
    public List<Organisatie> organisaties = null;
	
	@SerializedName("zgwRolOmschrijving")
    @Expose
    public ZgwRolOmschrijving zgwRolOmschrijving = null;	

	@SerializedName("replication")
    @Expose
    public Replication replication = null;
	
	@SerializedName("translations")
    @Expose
    public List<Translation> translations = null;

}