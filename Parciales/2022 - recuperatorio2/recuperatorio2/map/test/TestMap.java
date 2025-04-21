package test;

import net.datastructures.ArrayList;
import net.datastructures.ChainHashMap;
import net.datastructures.Entry;
import net.datastructures.List;
import net.datastructures.Map;

public class TestMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vuelo vuelos[] = new Vuelo[5];

		vuelos[0] = new Vuelo(5565, "PMY", "AEP", 8000);
		vuelos[1] = new Vuelo(2335, "PMY", "CRD", 4500);
		vuelos[2] = new Vuelo(2447, "AEP", "PMY", 7500);
		vuelos[3] = new Vuelo(5778, "PMY", "AEP", 8500);
		vuelos[4] = new Vuelo(7889, "AEP", "IGR", 6500);

		List<String> destinos;		
		Map<String, List<String>> map = new ChainHashMap<String, List<String>>();
		for (Vuelo v : vuelos) {
			destinos = map.get(v.getCodigoOrigen());
			if (destinos == null) {
				destinos = new ArrayList<String>();
				destinos.add(0, v.getCodigoDestino());
				map.put(v.getCodigoOrigen(), destinos);
			} else if (!destinos.contains(v.getCodigoDestino()))
				destinos.add(0, v.getCodigoDestino());

		}

		for (Entry<String, List<String>> e : map.entrySet())
			System.out.println(e);
	}

}
