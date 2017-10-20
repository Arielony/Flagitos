package cl.flagare.flagitos.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import cl.flagare.flagitos.R;

/**
 * Created by arielsalas on 20-10-17.
 */

public class WelcomeActivity extends AppCompatActivity {

    private ImageView imgLogo;
    private TextView txtProgress, txtTitulo;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set Layout
        setContentView(R.layout.welcomeactivity_layout);

        // User Interface
        imgLogo = (ImageView) findViewById(R.id.welcomeactivity_img_logo);
        txtTitulo = (TextView) findViewById(R.id.welcomeactivity_txt_titulo);
        txtProgress = (TextView) findViewById(R.id.welcomeactivity_txt_progress);
        progressBar = (ProgressBar) findViewById(R.id.welcomeactivity_prog_bar);


        // Mostramos animación de bienvenida
        bienvenido();

        // Instanciamos Handler post-animacion
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {

                overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);

                Intent i =  new Intent(getApplicationContext(), Profile.class);
                startActivity(i);
                finish();
            }
        }, 7000);
    }

    /* Inicia animaciones de bienvenida */
    private void bienvenido() {

        // Animacion de entrada
        Animation fade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        Animation zoom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);

        imgLogo.startAnimation(fade);
        txtProgress.startAnimation(fade);
        progressBar.startAnimation(fade);
        txtTitulo.startAnimation(fade);

        imgLogo.startAnimation(zoom);

        // Iteración de mensajes
        cambiarMensajes();

    }

    /* Cambiar mensajes asociados a la barra de progreso */
    private void cambiarMensajes() {

        // Instanciamos Handler post-animacion
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                txtProgress.setText("Cargando datos innecesarios...");
            }
        }, 1000);

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                txtProgress.setText("Prendiendose en llamas...");
            }
        }, 2000);

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                txtProgress.setText("Contando ovejas...");
            }
        }, 3000);

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                txtProgress.setText("Hackeando la NASA...");
            }
        }, 4000);

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                txtProgress.setText("DROP DATABASE...");
            }
        }, 5000);

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                txtProgress.setText("Accediendo!");
            }
        }, 6000);

    }
}
