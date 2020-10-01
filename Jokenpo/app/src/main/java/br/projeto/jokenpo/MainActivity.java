package br.projeto.jokenpo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
//1 - pedra
//2 - papel
//3 - Tesoura

public class MainActivity extends AppCompatActivity {
    Random rd = new Random();
TextView txt;
int escolhaJogador = 0;
int escolhaDaMaquina = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Papel(View view){

        escolhaJogador = 1;
        ImageView img =findViewById(R.id.imageView);
        img.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.papel));

    }
    public void Pedra(View view){

        escolhaJogador = 2;
        ImageView img =findViewById(R.id.imageView);
        img.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.pedra));

    }
    public void Tesoura(View view){
        escolhaJogador = 3;
        ImageView img =findViewById(R.id.imageView);
        img.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.tesoura));

    }
    public void Jogar(View view){
        txt = findViewById(R.id.textView2);
        escolhaDaMaquina= rd.nextInt(3)+1;
        EscolhaDaMaquina();
       if(escolhaJogador >0){
           if(escolhaJogador == escolhaDaMaquina)
               txt.setText("Empate");
           else if(escolhaJogador - escolhaDaMaquina == -1 || escolhaJogador - escolhaDaMaquina == 2)
               txt.setText("Você venceu");
           else
               txt.setText("A máquina venceu");
       }else
           txt.setText("Necessário escolher uma opção!");
    }
    public  void LimparTela(View view){
        escolhaJogador = 0;
        escolhaDaMaquina = 0;
        ImageView img =findViewById(R.id.imageView3);
        txt = findViewById(R.id.textView2);
        txt.setText("");
        img.setImageDrawable(null);
        img =findViewById(R.id.imageView);
        img.setImageDrawable(null);
    }
    public  void EscolhaDaMaquina(){
        ImageView img =findViewById(R.id.imageView3);
        if(escolhaDaMaquina == 1)
            img.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.papel));
        else if(escolhaDaMaquina == 2)
            img.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.pedra));
        if(escolhaDaMaquina == 3)
            img.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.tesoura));
    }
}