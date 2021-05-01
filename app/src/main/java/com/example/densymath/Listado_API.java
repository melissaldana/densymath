package com.example.densymath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.densymath.listadoAPi.ListadoAPI;
import com.example.densymath.listadoAPi.ListadoAdapter;

import java.util.ArrayList;

public class Listado_API extends AppCompatActivity {
   private ArrayList<ListadoAPI> densidad;
    private RecyclerView recyclerApi;
    private ListadoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado__a_p_i);
        recyclerApi = findViewById(R.id.recyclerApi);
        getSupportActionBar().hide();




        densidad = new ArrayList<>();

        ListadoAPI prueba = new ListadoAPI();
        prueba.setnombre("AGUA");
        prueba.setValorApi1("10");
        prueba.setValorApi2("11");
        prueba.setValorApi3("12");
        prueba.setValorApi4 ("13");
        prueba.setNombre4("BUNKER");
        prueba.setValorApi5("14");
        prueba.setValorApi6("15");
        prueba.setNombre6("CRUDO XAN");
        prueba.setValorApi7("16");
        prueba.setValorApi8("17");
        prueba.setValorApi9("18");
        prueba.setValorApi10("19");
        prueba.setValorApi11("20");
        prueba.setValorApi12("21");
        prueba.setValorApi13("22");
        prueba.setValorApi14("23");
        prueba.setValorApi15("24");
        prueba.setValorApi16("25");
        prueba.setValorApi17("26");
        prueba.setValorApi18("27");
        prueba.setValorApi19("28");
        prueba.setValorApi20("29");
        prueba.setValorApi21("30");
        prueba.setValorApi22("31");
        prueba.setValorApi23("32");
        prueba.setValorApi24("33");
        prueba.setNombre24("DIESEL");
        prueba.setValorApi25("34");
        prueba.setValorApi26("35");
        prueba.setValorApi27("36");
        prueba.setValorApi28("37");
        densidad.add(prueba);


        ListadoAPI prueba2 = new ListadoAPI();
        prueba2.setValorApi("38");
        prueba2.setValorApi1("39");
        prueba2.setValorApi2("40");
        prueba2.setValorApi3("41");
        prueba2.setValorApi4("42");
        prueba2.setValorApi5("43");
        prueba2.setNombre5("KEROSINA");
        prueba2.setValorApi6("44");
        prueba2.setValorApi7("45");
        prueba2.setValorApi8("46");
        prueba2.setValorApi9("47");
        prueba2.setValorApi10("48");
        prueba2.setValorApi11("49");
        prueba2.setValorApi12("50");
        prueba2.setValorApi13("51");
        prueba2.setValorApi14("52");
        prueba2.setValorApi15("53");
        prueba2.setValorApi16("54");
        prueba2.setValorApi17("55");
        prueba2.setNombre17("GAS. SUPER");
        prueba2.setValorApi18("56");
        prueba2.setValorApi19("57");
        prueba2.setNombre19("GAS.REG.");
        prueba2.setValorApi20("58");
        prueba2.setValorApi21("59");
        prueba2.setValorApi22("60");
        prueba2.setValorApi23("61");
        prueba2.setValorApi24("62");
        prueba2.setValorApi25("63");
        prueba2.setValorApi26("64");
        prueba2.setValorApi27("65");
        prueba2.setValorApi28("66");
        densidad.add(prueba2);

        ListadoAPI prueba3 = new ListadoAPI();
        prueba3.setnombre("GAS. AVIA.");
        prueba3.setValorApi1("67");
        prueba3.setValorApi2("68");
        prueba3.setValorApi3("69");
        prueba3.setValorApi4("70");
        prueba3.setValorApi5("71");
        prueba3.setValorApi6("72");
        prueba3.setValorApi7("73");
        prueba3.setValorApi8("74");
        prueba3.setValorApi9("75");
        prueba3.setValorApi10("76");
        prueba3.setValorApi11("77");
        prueba3.setValorApi12("78");
        prueba3.setValorApi13("79");
        prueba3.setValorApi14("80");
        prueba3.setNombre14("GAS.NATUR.");
        prueba3.setValorApi15("81");
        prueba3.setValorApi16("82");
        prueba3.setValorApi17("83");
        prueba3.setValorApi18("84");
        prueba3.setValorApi19("85");
        prueba3.setValorApi20("86");
        prueba3.setValorApi21("87");
        prueba3.setValorApi22("88");
        prueba3.setValorApi23("89");
        prueba3.setValorApi24("90");
        prueba3.setValorApi25("91");
        prueba3.setValorApi26("92");
        prueba3.setValorApi27("93");
        prueba3.setValorApi28("94");
        densidad.add(prueba3);

        ListadoAPI prueba4 = new ListadoAPI();
        prueba4.setValorApi("95");
        prueba4.setValorApi1("96");
        prueba4.setValorApi2("97");
        prueba4.setValorApi3("98");
        prueba4.setValorApi4("99");
        prueba4.setValorApi5("100");
        prueba4.setValorApi6("101");
        prueba4.setValorApi7("102");
        prueba4.setValorApi8("103");
        prueba4.setValorApi9("104");
        prueba4.setValorApi10("105");
        prueba4.setValorApi11("106");
        prueba4.setValorApi12("117");
        prueba4.setValorApi13("108");
        prueba4.setValorApi14("109");
        prueba4.setValorApi15("110");
        prueba4.setNombre15("BUTANO");
        prueba4.setValorApi16("111");
        prueba4.setValorApi17("112");
        prueba4.setValorApi18("113");
        prueba4.setValorApi19("114");
        prueba4.setValorApi20("115");
        prueba4.setValorApi21("116");
        prueba4.setValorApi22("117");
        prueba4.setValorApi23("118");
        prueba4.setValorApi24("119");
        prueba4.setNombre24("ISO-BUTANO");
        prueba4.setValorApi25("120");
        prueba4.setValorApi26("121");
        prueba4.setValorApi27("122");
        prueba4.setValorApi28("123");
        densidad.add(prueba4);

        ListadoAPI prueba5 = new ListadoAPI();
        prueba5.setValorApi("124");
        prueba5.setValorApi1("125");
        prueba5.setValorApi2("126");
        prueba5.setValorApi3("127");
        prueba5.setValorApi4("128");
        prueba5.setValorApi5("129");
        prueba5.setValorApi6("130");
        prueba5.setValorApi7("131");
        prueba5.setValorApi8("132");
        prueba5.setValorApi9("133");
        prueba5.setValorApi10("134");
        prueba5.setValorApi11("135");
        prueba5.setValorApi12("136");
        prueba5.setValorApi13("137");
        prueba5.setValorApi14("138");
        prueba5.setValorApi15("139");
        prueba5.setValorApi16("140");
        prueba5.setValorApi17("141");
        prueba5.setValorApi18("142");
        prueba5.setValorApi19("143");
        prueba5.setValorApi20("144");
        prueba5.setValorApi21("145");
        prueba5.setValorApi22("146");
        prueba5.setValorApi23("147");
        prueba5.setValorApi24("148");
        prueba5.setValorApi25("149");
        prueba5.setNombre25("PROPANO");
        prueba5.setValorApi26("150");
        densidad.add(prueba5);




        adapter = new ListadoAdapter(densidad, this);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerApi.setLayoutManager(manager);
        recyclerApi.setItemAnimator(new DefaultItemAnimator());
        recyclerApi.setAdapter(adapter);


    }
}