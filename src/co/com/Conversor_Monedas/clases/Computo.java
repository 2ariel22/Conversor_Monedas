package co.com.Conversor_Monedas.clases;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import co.com.Conversor_Monedas.enums.Nombre_Monedas;

public class Computo {
	
	
	private static Map<Nombre_Monedas, BigDecimal> TasasCambio;

	public Computo() {
		
	}
    public static void initExchangeRates() {
    	
        TasasCambio = new HashMap<>();
        TasasCambio.put(Nombre_Monedas.PESO_COLOMBIANO,BigDecimal.valueOf(3907.77));
        TasasCambio.put(Nombre_Monedas.DOLAR, BigDecimal.valueOf(1));
        TasasCambio.put(Nombre_Monedas.EUROS, BigDecimal.valueOf(0.91));
        TasasCambio.put(Nombre_Monedas.LIBRA_ESTERLINA, BigDecimal.valueOf(0.78));
        TasasCambio.put(Nombre_Monedas.YEN_JAPONES, BigDecimal.valueOf(142.81));
        TasasCambio.put(Nombre_Monedas.WON_SULCOREANO, BigDecimal.valueOf(1282.13));//won -sulcoreano
    }


	
	public static BigDecimal convert(Nombre_Monedas MonedaActual, Nombre_Monedas MonedaCambio, BigDecimal valor) {
		
		BigDecimal fromRate = TasasCambio.get(MonedaActual);
        BigDecimal toRate = TasasCambio.get(MonedaCambio);

        return valor.multiply(toRate).divide(fromRate, 5, BigDecimal.ROUND_HALF_UP);
    }
	
}
