package ru.kria.quizz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;







public class Level_1 extends AppCompatActivity {



    Delay delay = new Delay();
    public Animation a;


    public TextView TextView1;
    public TextView TextView2;
    public ImageView Bomb;
    public TextView TextView4;
    public TextView TextView5;
    public TextView TextView6;
    public TextView TextView7;
    public TextView TextView8;
    public TextView TextView9;
    public TextView TextView10;
    public TextView TextView11;


    public int line = -1;
    public int end = 0;

    public InterstitialAd interstitialAd; //реклама




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_1); //сообщение телефону о экране и все что с ним происходит

        // реклама - начало
        MobileAds.initialize(this,"ca-app-pub-4175945509878375~2649090432"); // ID приложения
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712"); // ID рекламы
        AdRequest adRequest = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);
        // реклама - конец

        //Закрытие рекламы - начало
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                try {
                    Intent intent = new Intent(Level_1.this,GameLevels.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){}
            }
        });
        //Закрытие рекламы - конец






            final TextView textView1 = (TextView) findViewById(R.id.textView1);
            final TextView textView2 = (TextView) findViewById(R.id.textView2);
            final TextView textView3 = (TextView) findViewById(R.id.textView3);
            final ImageView bomb = (ImageView) findViewById(R.id.bomb);
            final TextView textView4 = (TextView) findViewById(R.id.textView4);
            final TextView textView5 = (TextView) findViewById(R.id.textView5);
            final TextView textView6 = (TextView) findViewById(R.id.textView6);
            final TextView textView7 = (TextView) findViewById(R.id.textView7);
            final TextView textView8 = (TextView) findViewById(R.id.textView8);
            final TextView textView9 = (TextView) findViewById(R.id.textView9);
            final TextView textView10 = (TextView) findViewById(R.id.textView10);
            final TextView textView11 = (TextView) findViewById(R.id.textView11);

            final Button buttonNext = (Button) findViewById(R.id.buttonNext);


            textView1.setText(R.string.line11);
            textView2.setText(R.string.line12);
            textView3.setText(R.string.line13);
            textView4.setText(R.string.line14);
            textView5.setText(R.string.line15);
            textView6.setText(R.string.line16);
            textView7.setText(R.string.line17);
            textView8.setText(R.string.line18);
            textView9.setText(R.string.line19);
            textView10.setText(R.string.line110);
            textView11.setText(R.string.line111);



            //Код который прячет текст
            textView1.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.INVISIBLE);
            textView3.setVisibility(View.INVISIBLE);
            bomb.setVisibility(View.INVISIBLE);
            textView4.setVisibility(View.INVISIBLE);
            textView5.setVisibility(View.INVISIBLE);
            textView6.setVisibility(View.INVISIBLE);
            textView7.setVisibility(View.INVISIBLE);
            textView8.setVisibility(View.INVISIBLE);
            textView9.setVisibility(View.INVISIBLE);
            textView10.setVisibility(View.INVISIBLE);
            textView11.setVisibility(View.INVISIBLE);

            buttonNext.setVisibility(View.INVISIBLE);


            //Команда запуска AsyncTask
            delay.execute();
    }



     //кнопка "Назад" для возврата в меню
    @Override
    public void onBackPressed(){
        delay.cancel(true);
        delay=null;
        if(interstitialAd.isLoaded()){
            interstitialAd.show(); // показываем рекламу
        }else {

            try {
                Intent intent = new Intent(Level_1.this, MainActivity.class); // говорим что после нажатия на кнопку мы перемещаемся в другое окно - Level_2
                startActivity(intent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
            finish();
        }
    }


         //Код начала AsyncTask
        class Delay extends AsyncTask <Void, Integer, Void>{



                @Override
                protected Void doInBackground(Void... paranms){
                    while (line<=13){

                        publishProgress(line=line+1); //отправляет значение в switch
                        try{
                            Thread.sleep(3000); // усыпляем систему на 3 сек
                            if(isCancelled()) return null;
                        }catch(Exception e){}
                    }
                    return null;
                }

                @Override
                    protected void onProgressUpdate(Integer... values){

                    final TextView textView1 = (TextView) findViewById(R.id.textView1);
                    final TextView textView2 = (TextView) findViewById(R.id.textView2);
                    final TextView textView3 = (TextView) findViewById(R.id.textView3);
                    final ImageView bomb = (ImageView) findViewById(R.id.bomb);
                    final TextView textView4 = (TextView) findViewById(R.id.textView4);
                    final TextView textView5 = (TextView) findViewById(R.id.textView5);
                    final TextView textView6 = (TextView) findViewById(R.id.textView6);
                    final TextView textView7 = (TextView) findViewById(R.id.textView7);
                    final TextView textView8 = (TextView) findViewById(R.id.textView8);
                    final TextView textView9 = (TextView) findViewById(R.id.textView9);
                    final TextView textView10 = (TextView) findViewById(R.id.textView10);
                    final TextView textView11 = (TextView) findViewById(R.id.textView11);


                    final Button buttonNext = (Button)findViewById(R.id.buttonNext);

                    final Animation a = AnimationUtils.loadAnimation(Level_1.this, R.anim.ani);



                    switch (line){

                        case 1: textView1.setVisibility(View.VISIBLE); textView1.startAnimation(a);break;
                        case 2: textView2.setVisibility(View.VISIBLE); textView2.startAnimation(a);break;
                        case 3: bomb.setVisibility(View.VISIBLE); bomb.startAnimation(a); break;
                        case 4: textView3.setVisibility(View.VISIBLE); textView3.startAnimation(a);break;
                        case 5: textView4.setVisibility(View.VISIBLE); textView4.startAnimation(a);break;
                        case 6: textView5.setVisibility(View.VISIBLE); textView5.startAnimation(a);break;
                        case 7: textView6.setVisibility(View.VISIBLE); textView6.startAnimation(a);break;
                        case 8: textView7.setVisibility(View.VISIBLE); textView7.startAnimation(a);break;
                        case 9: textView8.setVisibility(View.VISIBLE); textView8.startAnimation(a);break;
                        case 10: textView9.setVisibility(View.VISIBLE); textView9.startAnimation(a);break;
                        case 11: textView10.setVisibility(View.VISIBLE); textView10.startAnimation(a);break;
                        case 12: textView11.setVisibility(View.VISIBLE); textView11.startAnimation(a);break;
                        case 13: buttonNext.setVisibility(View.VISIBLE); buttonNext.startAnimation(a);


                       buttonNext.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                try{
                                    Intent intent = new Intent(Level_1.this, Level_2.class);
                                    startActivity(intent);
                                    finish();
                                } catch(Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                        default: break;


                    }

                    //сохранение данных игры - начало
                    SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                    final int level = save.getInt("Level",1);//параметр "Level" запоминает значение уровня и передает в перемеенную int level

                    if(level>1){

                    }else{
                        SharedPreferences.Editor editor = save.edit();
                        editor.putInt("Level",2);
                        editor.commit();
                    }
                    //сохранение данных игры - конец




                }
            }
            //конецAsyncTasK
}
