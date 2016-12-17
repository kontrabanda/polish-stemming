import java.io.IOException;
import java.util.Locale;

import morfologik.stemming.WordData;
import morfologik.stemming.polish.*;

public class FirstTest {
	public static void main(String[] args) {
		PolishStemmer stemmer = new PolishStemmer();

		String in = "Nie zabrakło oczywiście wpadek. Największym zaskoczeniem okazał się dla nas strój Katarzyny Zielińskiej, której ewidentnie o coś chodziło, ale wciąż nie wiemy o co.";
		in = "Skoro umywa ręce to mogę zaproponować solidarne ucięcie Hydrze łba";
		in = "Litwo! Ojczyzno moja! ty jesteś jak zdrowie. Ile cię trzeba cenić, ten tylko się dowie, Kto cię stracił. Dziś piękność twą w całej ozdobie Widzę i opisuję, bo tęsknię po tobie. Panno Święta, co jasnej bronisz Częstochowy I w Ostrej świecisz Bramie! Ty, co gród zamkowy Nowogródzki ochraniasz z jego wiernym ludem! Jak mnie dziecko do zdrowia powróciłaś cudem (Gdy od płaczącej matki pod Twoją opiekę Ofiarowany, martwą podniosłem powiekę I zaraz mogłem pieszo do Twych świątyń progu Iść za wrócone życie podziękować Bogu), Tak nas powrócisz cudem na Ojczyzny łono. Tymczasem przenoś moję duszę utęsknioną Do tych pagórków leśnych, do tych łąk zielonych, Szeroko nad błękitnym Niemnem rozciągnionych;Do tych pól malowanych zbożem rozmaitem, Wyzłacanych pszenicą, posrebrzanych żytem; Gdzie bursztynowy świerzop, gryka jak śnieg biała, Gdzie panieńskim rumieńcem dzięcielina pała, A wszystko przepasane, jakby wstęgą, miedzą Zieloną, na niej z rzadka ciche grusze siedzą. Śród takich pól przed laty, nad brzegiem ruczaju, Na pagórku niewielkim, we brzozowym gaju Stał dwór szlachecki, z drzewa, lecz podmurowany; Świeciły się z daleka pobielane ściany, Tym bielsze, że odbite od ciemnej zieleni Topoli, co go bronią od wiatrów jesieni. Dóm mieszkalny niewielki, lecz zewsząd chędogi, I stodołę miał wielką, i przy niej trzy stogi Użątku, co pod strzechą zmieścić się nie może;Widać, że okolica obfita we zboże,I widać z liczby kopic, co wzdłuż i wszerz smugówŚwiecą gęsto jak gwiazdy, widać z liczby pługówOrzących wcześnie łany ogromne ugoru,Czarnoziemne, zapewne należne do dworu,Uprawne dobrze na kształt ogrodowych grządek: Że w tym domu dostatek mieszka i porządek. Brama na wciąż otwarta przechodniom ogłasza, Że gościnna i wszystkich w gościnę zaprasza.";
		for (String t : in.toLowerCase(new Locale("pl")).split("[\\s\\.\\,]+")) {
		  System.out.println("> '" + t + "'");
		  for (WordData wd : stemmer.lookup(t)) {
		    System.out.print(
		        "  - " + 
		        (wd.getStem() == null ? "<null>" : wd.getStem()) + ", " + 
		        wd.getTag());
		  }
		  System.out.println();
		}
	}
};