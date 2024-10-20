package com.ex.recyclerview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class detalhes_estado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes_estado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val estado = intent.getParcelableExtra<Estado>("estado")

        if (estado != null) {
            val bandeiraImageView: ImageView = findViewById(R.id.imageViewBandeiraDetalhe)
            val nomeTextView: TextView = findViewById(R.id.textViewNomeEstadoDetalhe)
            val capitalTextView: TextView = findViewById(R.id.textViewCapital)
            val populacaoTextView: TextView = findViewById(R.id.textViewPopulacao)
            val regiaoTextView: TextView = findViewById(R.id.textViewRegiao)

            bandeiraImageView.setImageResource(estado.bandeira)
            nomeTextView.text = estado.nome
            capitalTextView.text = "Capital: ${estado.capital}"
            populacaoTextView.text = "População: ${estado.populacao}"
            regiaoTextView.text = "Região: ${estado.regiao}"
        }
    }
}