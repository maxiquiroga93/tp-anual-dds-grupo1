/*
import POI.POI;


import Geolocation.GeoLocation;
public class worckspace{
	private POI poiUno ;
	private POI poiDos;
public static void main(String[] args) {
	
		System.out.println(distanciaCoord(-34.5664823,-58.43407810000002,-34.5658341,-58.43519549999996)*1000<150);
		
		
			POI poiUno = POI.construirPOI(-34.5664823, -58.43407810000002);
			POI poiDos = POI.construirPOI(-34.5658341, -58.43519549999996);
			
			System.out.println(poiUno.estaXMetrosDePOI(125,poiDos));
			System.out.println(poiUno.distanciaCoordDosPOIs(poiUno,poiDos)*1000);
		
	 }
public static double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {  
    //double radioTierra = 3958.75;//en millas  
    double radioTierra = 6371;//en kil�metros  
    double dLat = Math.toRadians(lat2 - lat1);  
    double dLng = Math.toRadians(lng2 - lng1);  
    double sindLat = Math.sin(dLat / 2);  
    double sindLng = Math.sin(dLng / 2);  
    double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
            * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));  
    double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
    double distancia = radioTierra * va2;  

    return distancia;  
}
public POI getPoiUno() {
	return poiUno;
}
public void setPoiUno(POI poiUno) {
	this.poiUno = poiUno;
}
public POI getPoiDos() {
	return poiDos;
}
public void setPoiDos(POI poiDos) {
	this.poiDos = poiDos;
}  

}

*/