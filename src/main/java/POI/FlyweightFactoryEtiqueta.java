package POI;
import java.util.HashMap;
public class FlyweightFactoryEtiqueta {
	IFlyweightEtiqueta etiqueta;
	
	
	private static final HashMap<String,Etiqueta> MapaEtiqueta = new HashMap<String, Etiqueta>();
	
	public static Etiqueta getEtiqueta(String nombre){
		Etiqueta etiqueta=(Etiqueta)MapaEtiqueta.get(nombre);
		if(etiqueta==null){
			etiqueta=new Etiqueta(nombre);
			MapaEtiqueta.put(nombre,etiqueta);
		}
		return etiqueta;
		}

	
}

