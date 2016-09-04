package poi;
import java.util.HashMap;
public class FlyweightFactoryEtiqueta {
	IFlyweightEtiqueta etiqueta;
	
	
	private static final HashMap<String,Etiqueta> mapaEtiqueta = new HashMap<String, Etiqueta>();
	
	public static Etiqueta getEtiqueta(String nombre){
		Etiqueta etiqueta=(Etiqueta)mapaEtiqueta.get(nombre);
		if(etiqueta==null){
			etiqueta=new Etiqueta(nombre);
			mapaEtiqueta.put(nombre,etiqueta);
		}
		return etiqueta;
		}

	
}

