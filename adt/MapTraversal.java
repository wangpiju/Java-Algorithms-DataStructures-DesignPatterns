package adt;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
//insert delete search O(logn)
public class MapTraversal {

	public static void main(String[] args) {
		//HashMap  
		System.out.println("------HashMap unordered output------");  
		HashMap hsMap=new HashMap();  
		hsMap.put("3", "Value3");  
		hsMap.put("1", "Value1");  
		hsMap.put("2", "Value2");  
		hsMap.put("b", "ValueB");  
		hsMap.put("a", "ValueA");  
		Iterator it = hsMap.entrySet().iterator();
		
		while (it.hasNext()) {  
			Map.Entry e = (Map.Entry) it.next();  
			System.out.println("Key: " + e.getKey() + "--Value: "  
			+ e.getValue());  
		}  
		  
		//TreeMap  
		System.out.println("------TreeMap ordered output------");  
		TreeMap teMap=new TreeMap();  
		teMap.put("3", "Value3");  
		teMap.put("1", "Value1");  
		teMap.put("2", "Value2");  
		teMap.put("b", "ValueB");  
		teMap.put("a", "ValueA");  
		Iterator tit = teMap.entrySet().iterator();  
		while (tit.hasNext()) {  
			Map.Entry e = (Map.Entry) tit.next();  
			System.out.println("Key: " + e.getKey() + "--Value: "  
			+ e.getValue());  
		}  
		  
		//LinkedHashMap  
		System.out.println("--LinkedHashMap output order by input order--");  
		LinkedHashMap lhsMap=new LinkedHashMap();  
		lhsMap.put("3", "Value3");  
		lhsMap.put("1", "Value1");  
		lhsMap.put("2", "Value2");  
		lhsMap.put("b", "ValueB");  
		lhsMap.put("a", "ValueA");  
		Iterator lit = lhsMap.entrySet().iterator();  
		while (lit.hasNext()) {  
			Map.Entry e = (Map.Entry) lit.next();  
			System.out.println("Key: " + e.getKey() + "--Value: "  
			+ e.getValue());  
		}  
	}

}