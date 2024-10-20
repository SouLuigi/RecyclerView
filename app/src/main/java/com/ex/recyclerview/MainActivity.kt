package com.ex.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val estados = listOf(
            Estado("Acre", "Rio Branco", "0.9 milhões", "Norte", R.drawable.ac),
            Estado("Alagoas", "Maceió", "3.3 milhões", "Nordeste", R.drawable.al),
            Estado("Amapá", "Macapá", "0.8 milhões", "Norte", R.drawable.ap),
            Estado("Amazonas", "Manaus", "4.2 milhões", "Norte", R.drawable.am),
            Estado("Bahia", "Salvador", "15.2 milhões", "Nordeste", R.drawable.ba),
            Estado("Ceará", "Fortaleza", "9.2 milhões", "Nordeste", R.drawable.ce),
            Estado("Distrito Federal", "Brasília", "3.0 milhões", "Centro-Oeste", R.drawable.df),
            Estado("Espírito Santo", "Vitória", "4.0 milhões", "Sudeste", R.drawable.es),
            Estado("Goiás", "Goiânia", "7.2 milhões", "Centro-Oeste", R.drawable.go),
            Estado("Maranhão", "São Luís", "7.1 milhões", "Nordeste", R.drawable.ma),
            Estado("Mato Grosso", "Cuiabá", "3.5 milhões", "Centro-Oeste", R.drawable.mt),
            Estado("Mato Grosso do Sul", "Campo Grande", "2.8 milhões", "Centro-Oeste", R.drawable.ms),
            Estado("Minas Gerais", "Belo Horizonte", "21.3 milhões", "Sudeste", R.drawable.mg),
            Estado("Pará", "Belém", "8.7 milhões", "Norte", R.drawable.pa),
            Estado("Paraíba", "João Pessoa", "4.0 milhões", "Nordeste", R.drawable.pb),
            Estado("Paraná", "Curitiba", "11.5 milhões", "Sul", R.drawable.pr),
            Estado("Pernambuco", "Recife", "9.6 milhões", "Nordeste", R.drawable.pe),
            Estado("Piauí", "Teresina", "3.3 milhões", "Nordeste", R.drawable.pi),
            Estado("Rio de Janeiro", "Rio de Janeiro", "17.4 milhões", "Sudeste", R.drawable.rj),
            Estado("Rio Grande do Norte", "Natal", "3.5 milhões", "Nordeste", R.drawable.rn),
            Estado("Rio Grande do Sul", "Porto Alegre", "11.3 milhões", "Sul", R.drawable.rs),
            Estado("Rondônia", "Porto Velho", "1.8 milhões", "Norte", R.drawable.ro),
            Estado("Roraima", "Boa Vista", "0.6 milhões", "Norte", R.drawable.rr),
            Estado("Santa Catarina", "Florianópolis", "7.3 milhões", "Sul", R.drawable.sc),
            Estado("São Paulo", "São Paulo", "45.9 milhões", "Sudeste", R.drawable.sp),
            Estado("Sergipe", "Aracaju", "2.3 milhões", "Nordeste", R.drawable.se),
            Estado("Tocantins", "Palmas", "1.6 milhões", "Norte", R.drawable.to)

        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewEstados)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EstadoAdapter(estados) { estado ->
            val intent = Intent(this, detalhes_estado::class.java)
            intent.putExtra("estado", estado)
            startActivity(intent)
        }
    }
}

