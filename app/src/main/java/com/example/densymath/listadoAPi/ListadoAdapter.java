package com.example.densymath.listadoAPi;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.densymath.R;

import java.util.ArrayList;

public class ListadoAdapter extends RecyclerView.Adapter<ListadoAdapter.ViewHolder> {

    private ArrayList<ListadoAPI> direcionApi;

    public ListadoAdapter(ArrayList<ListadoAPI> direcionApi, Activity activity) {
        this.direcionApi = direcionApi;


    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nombreValor;
        public TextView nombreValor1;
        public TextView nombreValor2;
        public TextView nombreValor3;
        public TextView nombreValor4;
        public TextView nombreValor5;
        public TextView nombreValor6;
        public TextView nombreValor7;
        public TextView nombreValor8;
        public TextView nombreValor9;
        public TextView nombreValor10;
        public TextView nombreValor11;
        public TextView nombreValor12;
        public TextView nombreValor13;
        public TextView nombreValor14;
        public TextView nombreValor15;
        public TextView nombreValor16;
        public TextView nombreValor17;
        public TextView nombreValor18;
        public TextView nombreValor19;
        public TextView nombreValor20;
        public TextView nombreValor21;
        public TextView nombreValor22;
        public TextView nombreValor23;
        public TextView nombreValor24;
        public TextView nombreValor25;
        public TextView nombreValor26;
        public TextView nombreValor27;
        public TextView nombreValor28;
        public TextView nombreValor29;
        public TextView ApiValor;
        public TextView ApiValor1;
        public TextView ApiValor2;
        public TextView ApiValor3;
        public TextView ApiValor4;
        public TextView ApiValor5;
        public TextView ApiValor6;
        public TextView ApiValor7;
        public TextView ApiValor8;
        public TextView ApiValor9;
        public TextView ApiValor10;
        public TextView ApiValor11;
        public TextView ApiValor12;
        public TextView ApiValor13;
        public TextView ApiValor14;
        public TextView ApiValor15;
        public TextView ApiValor16;
        public TextView ApiValor17;
        public TextView ApiValor18;
        public TextView ApiValor19;
        public TextView ApiValor20;
        public TextView ApiValor21;
        public TextView ApiValor22;
        public TextView ApiValor23;
        public TextView ApiValor24;
        public TextView ApiValor25;
        public TextView ApiValor26;
        public TextView ApiValor27;
        public TextView ApiValor28;
        public TextView ApiValor29;

        public ViewHolder(View itemView) {
            super(itemView);
            nombreValor = itemView.findViewById(R.id.txtProducto);
            nombreValor1 = itemView.findViewById(R.id.txtproducto);
            nombreValor2 = itemView.findViewById(R.id.txtproducto1);
            nombreValor3 = itemView.findViewById(R.id.txtproducto2);
            nombreValor4 = itemView.findViewById(R.id.txtproducto3);
            nombreValor5 = itemView.findViewById(R.id.txtproducto4);
            nombreValor6 = itemView.findViewById(R.id.txtproducto5);
            nombreValor7 = itemView.findViewById(R.id.txtproducto6);
            nombreValor8 = itemView.findViewById(R.id.txtproducto7);
            nombreValor9 = itemView.findViewById(R.id.txtproducto8);
            nombreValor10 = itemView.findViewById(R.id.txtproducto9);
            nombreValor11 = itemView.findViewById(R.id.txtproducto10);
            nombreValor12 = itemView.findViewById(R.id.txtproducto11);
            nombreValor13 = itemView.findViewById(R.id.txtproducto12);
            nombreValor14 = itemView.findViewById(R.id.txtproducto13);
            nombreValor15 = itemView.findViewById(R.id.txtproducto14);
            nombreValor16 = itemView.findViewById(R.id.txtproducto15);
            nombreValor17 = itemView.findViewById(R.id.txtproducto16);
            nombreValor18 = itemView.findViewById(R.id.txtproducto17);
            nombreValor19 = itemView.findViewById(R.id.txtproducto18);
            nombreValor20 = itemView.findViewById(R.id.txtproducto19);
            nombreValor21 = itemView.findViewById(R.id.txtproducto20);
            nombreValor22 = itemView.findViewById(R.id.txtproducto21);
            nombreValor23 = itemView.findViewById(R.id.txtproducto22);
            nombreValor24 = itemView.findViewById(R.id.txtproducto23);
            nombreValor25 = itemView.findViewById(R.id.txtproducto24);
            nombreValor26 = itemView.findViewById(R.id.txtproducto25);
            nombreValor27 = itemView.findViewById(R.id.txtproducto26);
            nombreValor28 = itemView.findViewById(R.id.txtproducto27);
            nombreValor29 = itemView.findViewById(R.id.txtproducto28);
            ApiValor = itemView.findViewById(R.id.txtAPI);
            ApiValor1 = itemView.findViewById(R.id.txtAPI0);
            ApiValor2 = itemView.findViewById(R.id.txtAPI1);
            ApiValor3 = itemView.findViewById(R.id.txtAPI2);
            ApiValor4 = itemView.findViewById(R.id.txtAPI3);
            ApiValor5 = itemView.findViewById(R.id.txtAPI4);
            ApiValor6 = itemView.findViewById(R.id.txtAPI5);
            ApiValor7 = itemView.findViewById(R.id.txtAPI6);
            ApiValor8 = itemView.findViewById(R.id.txtAPI7);
            ApiValor9 = itemView.findViewById(R.id.txtAPI8);
            ApiValor10 = itemView.findViewById(R.id.txtAPI9);
            ApiValor11 = itemView.findViewById(R.id.txtAPI10);
            ApiValor12 = itemView.findViewById(R.id.txtAPI11);
            ApiValor13 = itemView.findViewById(R.id.txtAPI12);
            ApiValor14 = itemView.findViewById(R.id.txtAPI13);
            ApiValor15 = itemView.findViewById(R.id.txtAPI14);
            ApiValor16 = itemView.findViewById(R.id.txtAPI15);
            ApiValor17 = itemView.findViewById(R.id.txtAPI16);
            ApiValor18 = itemView.findViewById(R.id.txtAPI17);
            ApiValor19 = itemView.findViewById(R.id.txtAPI18);
            ApiValor20 = itemView.findViewById(R.id.txtAPI19);
            ApiValor21 = itemView.findViewById(R.id.txtAPI20);
            ApiValor22= itemView.findViewById(R.id.txtAPI21);
            ApiValor23 = itemView.findViewById(R.id.txtAPI22);
            ApiValor24 = itemView.findViewById(R.id.txtAPI23);
            ApiValor25 = itemView.findViewById(R.id.txtAPI24);
            ApiValor26 = itemView.findViewById(R.id.txtAPI25);
            ApiValor27 = itemView.findViewById(R.id.txtAPI26);
            ApiValor28 = itemView.findViewById(R.id.txtAPI27);
            ApiValor29 = itemView.findViewById(R.id.txtAPI28);

        }

    }





    //Va a crear nuestros items en base a una vista
    @NonNull
    @Override
    public ListadoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_listado, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

     //Se encargara de la creacion con ese item
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListadoAPI listado = direcionApi.get(position);

        holder.nombreValor1.setText(listado.getnombre());
        holder.nombreValor2.setText(listado.getNombre1());
        holder.nombreValor3.setText(listado.getNombre2());
        holder.nombreValor4.setText(listado.getNombre3());
        holder.nombreValor5.setText(listado.getNombre4());
        holder.nombreValor6.setText(listado.getNombre5());
        holder.nombreValor7.setText(listado.getNombre6());
        holder.nombreValor8.setText(listado.getNombre7());
        holder.nombreValor9.setText(listado.getNombre8());
        holder.nombreValor10.setText(listado.getNombre9());
        holder.nombreValor11.setText(listado.getNombre10());
        holder.nombreValor12.setText(listado.getNombre11());
        holder.nombreValor13.setText(listado.getNombre12());
        holder.nombreValor14.setText(listado.getNombre13());
        holder.nombreValor15.setText(listado.getNombre14());
        holder.nombreValor16.setText(listado.getNombre15());
        holder.nombreValor17.setText(listado.getNombre16());
        holder.nombreValor18.setText(listado.getNombre17());
        holder.nombreValor19.setText(listado.getNombre18());
        holder.nombreValor20.setText(listado.getNombre19());
        holder.nombreValor21.setText(listado.getNombre20());
        holder.nombreValor22.setText(listado.getNombre21());
        holder.nombreValor23.setText(listado.getNombre22());
        holder.nombreValor24.setText(listado.getNombre23());
        holder.nombreValor25.setText(listado.getNombre24());
        holder.nombreValor26.setText(listado.getNombre25());
        holder.nombreValor27.setText(listado.getNombre26());
        holder.nombreValor28.setText(listado.getNombre27());
        holder.nombreValor29.setText(listado.getNombre28());

        holder.ApiValor.setText(listado.getValorApi());
        holder.ApiValor1.setText(listado.getValorApi1());
        holder.ApiValor2.setText(listado.getValorApi2());
        holder.ApiValor3.setText(listado.getValorApi3());
        holder.ApiValor4.setText(listado.getValorApi4());
        holder.ApiValor5.setText(listado.getValorApi5());
        holder.ApiValor6.setText(listado.getValorApi6());
        holder.ApiValor7.setText(listado.getValorApi7());
        holder.ApiValor8.setText(listado.getValorApi8());
        holder.ApiValor9.setText(listado.getValorApi9());
        holder.ApiValor10.setText(listado.getValorApi10());
        holder.ApiValor11.setText(listado.getValorApi11());
        holder.ApiValor12.setText(listado.getValorApi12());
        holder.ApiValor13.setText(listado.getValorApi13());
        holder.ApiValor14.setText(listado.getValorApi14());
        holder.ApiValor15.setText(listado.getValorApi15());
        holder.ApiValor16.setText(listado.getValorApi16());
        holder.ApiValor17.setText(listado.getValorApi17());
        holder.ApiValor18.setText(listado.getValorApi18());
        holder.ApiValor19.setText(listado.getValorApi19());
        holder.ApiValor20.setText(listado.getValorApi20());
        holder.ApiValor21.setText(listado.getValorApi21());
        holder.ApiValor22.setText(listado.getValorApi22());
        holder.ApiValor23.setText(listado.getValorApi23());
        holder.ApiValor24.setText(listado.getValorApi24());
        holder.ApiValor25.setText(listado.getValorApi25());
        holder.ApiValor26.setText(listado.getValorApi26());
        holder.ApiValor27.setText(listado.getValorApi27());
        holder.ApiValor28.setText(listado.getValorApi28());

    }


    //Cuantos items va a tener nuestro RecyclerView
    @Override
    public int getItemCount() {
        return direcionApi.size();
    }
}
