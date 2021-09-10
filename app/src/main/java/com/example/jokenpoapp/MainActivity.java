package com.example.jokenpoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView pedra, papel, tesoura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pedra = findViewById(R.id.imageView2);
        papel = findViewById(R.id.imageView3);
        tesoura = findViewById(R.id.imageView4);
    }

    public void clear(){
        pedra.setImageResource(R.drawable.pedra);
        papel.setImageResource(R.drawable.papel);
        tesoura.setImageResource(R.drawable.tesoura);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
        clear();
        pedra.setImageResource(R.drawable.pedra_selecionado);
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
        clear();
        papel.setImageResource(R.drawable.papel_selecionado);
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
        clear();
        tesoura.setImageResource(R.drawable.tesoura_selecionado);
    }

    public void opcaoSelecionada(String escolhaUsuario){
        System.out.println(escolhaUsuario);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra","papel","tesoura"};
        String escolhaApp = opcoes[numero];
        System.out.println(escolhaApp);

        ImageView imageView_1 = findViewById(R.id.escolhaApp);

        switch (escolhaApp){
            case "pedra":
                imageView_1.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageView_1.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageView_1.setImageResource(R.drawable.tesoura);
                break;
        }

        TextView textView_1 = findViewById(R.id.textView2);

        if(
                (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
                (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                (escolhaApp == "pedra" && escolhaUsuario == "tesoura")
        ){
            textView_1.setText("Você perdeu! :(");
        }else if(
                (escolhaUsuario == "tesoura" && escolhaApp == "papel") ||
                (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                (escolhaUsuario == "pedra" && escolhaApp == "tesoura")
        ){
            textView_1.setText("Você ganhou! :)");
        }else{
            textView_1.setText("Empatou ;)");
        }
    }

}