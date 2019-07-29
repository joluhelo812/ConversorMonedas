package com.cmaozs.punto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.*
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity() : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var mostrar : TextView
    private var monedacambio = ""
    private var moneda = ""
    lateinit var guardarspinner : String
    lateinit var valor : EditText
    private var valorcolombianos = 0.0
    private var valordolar = 0.0
    private var valoreuro = 0.0
    private var valoryen = 0.0
    private var valormexicanos = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mostrar = findViewById<TextView>(R.id.tvMostrar)
        valor = findViewById<EditText>(R.id.etValorIngresados)
        valor = etValorIngresados


        spMoneda!!.setOnItemSelectedListener(this)

        val adapter = ArrayAdapter.createFromResource(this, R.array.monedas, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spMoneda!!.setAdapter(adapter)

        btnConvertir.setOnClickListener {
            var monedas = etValorIngresados.text.toString()

            if (!monedas.equals("")){

                if (moneda.equals("Dólar estadounidense")){

                    //tvMonedaconvertida.text = monedas

                    valorcolombianos = monedas.toDouble() * 3217.90
                    valoreuro = monedas.toDouble() * 0.90
                    valoryen = monedas.toDouble() * 108.49
                    valormexicanos = monedas.toDouble() * 19.05
                    tvPrimera.text = "Euro: " + valoreuro.toString()
                    tvSegunda.text = "Peso colombiano: " + valorcolombianos.toString()
                    tvTercera.text = "Peso mexicano: " + valormexicanos.toString()
                    tvCuarto.text = "Yen: " + valoryen.toString()
                }

                else if (moneda.equals("Euro")){

                    //tvMonedaconvertida.text = monedas

                    valorcolombianos = monedas.toDouble() * 3581.68
                    valordolar = monedas.toDouble() * 1.11
                    valoryen = monedas.toDouble() * 120.82
                    valormexicanos = monedas.toDouble() * 21.20
                    tvPrimera.text = "Dolar estadounidense: " + valordolar.toString()
                    tvSegunda.text = "Peso colombiano: " + valorcolombianos.toString()
                    tvTercera.text = "Peso mexicano: " + valormexicanos.toString()
                    tvCuarto.text = "Yen: " + valoryen.toString()
                }

                else if (moneda.equals("Peso colombiano")){

                    //tvMonedaconvertida.text = monedas

                    valordolar = monedas.toDouble() * 0.00031
                    valoreuro = monedas.toDouble() * 0.00028
                    valoryen = monedas.toDouble() * 0.034
                    valormexicanos = monedas.toDouble() * 0.0059
                    tvPrimera.text = "Dolar estadounidense: " + valordolar.toString()
                    tvSegunda.text = "Euro: " + valoreuro.toString()
                    tvTercera.text = "Peso mexicano: " + valormexicanos.toString()
                    tvCuarto.text = "Yen: " + valoryen.toString()
                }

                else if (moneda.equals("Peso mexicano")){

                    //tvMonedaconvertida.text = monedas

                    valordolar = monedas.toDouble() * 0.052
                    valoreuro = monedas.toDouble() * 0.047
                    valoryen = monedas.toDouble() * 5.70
                    valorcolombianos = monedas.toDouble() * 168.89
                    tvPrimera.text = "Dolar estadounidense: " + valordolar.toString()
                    tvSegunda.text = "Euro: " + valoreuro.toString()
                    tvTercera.text = "Peso colombiano: " + valorcolombianos.toString()
                    tvCuarto.text = "Yen: " + valoryen.toString()
                }

                else{
                    valordolar = monedas.toDouble() * 0.0092
                    valoreuro = monedas.toDouble() * 0.0083
                    valormexicanos = monedas.toDouble() * 0.18
                    valorcolombianos = monedas.toDouble() * 29.63
                    tvPrimera.text = "Dolar estadounidense: " + valordolar.toString()
                    tvSegunda.text = "Euro: " + valoreuro.toString()
                    tvTercera.text = "Peso colombiano: " + valorcolombianos.toString()
                    tvCuarto.text = "Peso mexicano: " + valoryen.toString()
                }

            }
        }

    }

    override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
        mostrar!!.text  = resources.getStringArray(R.array.monedas)[position]

        moneda =  tvMostrar.text.toString()

        //tvMonedaconvertida.text  = valor.toString()
        if(!moneda.equals("")) {
            valor.visibility = View.VISIBLE
            //tvMonedaconvertida.text = etValorIngresados.toString()
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        mostrar!!.text  = ""
    }

}




