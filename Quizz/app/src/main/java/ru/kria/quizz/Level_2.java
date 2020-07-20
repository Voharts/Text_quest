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

import ru.kria.quizz.scenario.Table2;

public class Level_2 extends AppCompatActivity {


    Delay delay = new Delay();
    MediaPlayer mPlayer;
    MediaPlayer mPlayer1;
    public TextView TextViewTwo0;
    public TextView TextViewTwo1;
    public TextView TextViewTwo2;
    public TextView TextViewTwo3;
    public TextView TextViewTwo4;
    public TextView TextViewTwo5;
    public TextView TextViewTwo6;
    public TextView TextViewTwo7;
    public TextView TextViewTwo8;
    public Button button_yes0;
    public Button button_no0;
    public TextView TextViewTwo10;
    public TextView TextViewTwo11;
    public TextView TextViewTwo12;
    public TextView TextViewTwo13;
    public TextView TextViewTwo14;
    public Button button_yes1;
    public Button button_no1;
    public TextView TextViewTwo16;
    public ImageView imageTwo17;
    public TextView TextViewTwo18;
    public TextView TextViewTwo19;
    public ImageView imageTwo20;
    public TextView TextViewTwo21;
    public Button two_button_next_level;

    public Animation a;
    public int line = -1; //для счетчика, он будет использовать только целые числа
    public int counterFirstLineChoice=0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_2); //сообщение телефону о экране и все что с ним происходит


        mPlayer= MediaPlayer.create(this, R.raw.strongwind); //загрузка нужной музыки
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });
        mPlayer1 = MediaPlayer.create(this, R.raw.distantdogbarking); //загрузка нужной музыки
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });

        final TextView textView0 = (TextView) findViewById(R.id.textViewTwo0);
        final TextView textView1 = (TextView) findViewById(R.id.textViewTwo1);
        final TextView textView2 = (TextView) findViewById(R.id.textViewTwo2);
        final TextView textView3 = (TextView) findViewById(R.id.textViewTwo3);
        final TextView textView4 = (TextView) findViewById(R.id.textViewTwo4);
        final TextView textView5 = (TextView) findViewById(R.id.textViewTwo5);
        final TextView textView6 = (TextView) findViewById(R.id.textViewTwo6);
        final TextView textView7 = (TextView) findViewById(R.id.textViewTwo7);
        final TextView textView8 = (TextView) findViewById(R.id.textViewTwo8);
        final Button button_yes0 = (Button) findViewById(R.id.button_yes0);
        final Button button_no0 = (Button) findViewById(R.id.button_no0);
        final TextView textView10 = (TextView) findViewById(R.id.textViewTwo10);
        final TextView textView11 = (TextView) findViewById(R.id.textViewTwo11);
        final TextView textView12 = (TextView) findViewById(R.id.textViewTwo12);
        final TextView textView13 = (TextView) findViewById(R.id.textViewTwo13);
        final TextView textView14 = (TextView) findViewById(R.id.textViewTwo14);
        final TextView textView15 = (TextView) findViewById(R.id.textViewTwo15);
        final TextView textView16 = (TextView) findViewById(R.id.textViewTwo16);
        final TextView textView17 = (TextView) findViewById(R.id.textViewTwo17);
        final TextView textView18 = (TextView) findViewById(R.id.textViewTwo18);
        final TextView textView19 = (TextView) findViewById(R.id.textViewTwo19);
        final TextView textView20 = (TextView) findViewById(R.id.textViewTwo20);
        final Button buttonNext = (Button) findViewById(R.id.buttonNext);

        textView0.setText(R.string.line21);
        textView1.setText(R.string.line22);
        textView2.setText(R.string.line23);
        textView3.setText(R.string.line24);
        textView4.setText(R.string.line25);
        textView5.setText(R.string.line26);
        textView6.setText(R.string.line27);
        textView7.setText(R.string.line28);
        textView8.setText(R.string.line29);
        textView10.setText(R.string.line210);
        textView11.setText(R.string.line211);
        textView12.setText(R.string.line212);
        textView13.setText(R.string.line213);
        textView14.setText(R.string.line214);
        textView15.setText(R.string.line215);
        textView16.setText(R.string.line216);
        textView17.setText(R.string.line217);
        textView18.setText(R.string.line218);
        textView19.setText(R.string.line219);
        textView20.setText(R.string.line220);

        //код прячущий текст
        textView0.setVisibility(View.INVISIBLE);
        textView1.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);
        textView4.setVisibility(View.INVISIBLE);
        textView5.setVisibility(View.INVISIBLE);
        textView6.setVisibility(View.INVISIBLE);
        textView7.setVisibility(View.INVISIBLE);
        textView8.setVisibility(View.INVISIBLE);
        button_yes0.setVisibility(View.INVISIBLE);
        button_no0.setVisibility(View.INVISIBLE);
        textView10.setVisibility(View.INVISIBLE);
        textView11.setVisibility(View.INVISIBLE);
        textView12.setVisibility(View.INVISIBLE);
        textView13.setVisibility(View.INVISIBLE);
        textView14.setVisibility(View.INVISIBLE);
        textView15.setVisibility(View.INVISIBLE);
        textView16.setVisibility(View.INVISIBLE);
        textView17.setVisibility(View.INVISIBLE);
        textView18.setVisibility(View.INVISIBLE);
        textView19.setVisibility(View.INVISIBLE);
        textView20.setVisibility(View.INVISIBLE);
        buttonNext.setVisibility(View.INVISIBLE);

        //команда для запуска AsyncTack
        delay.execute();//Запуск класса delay
    }


    //----------------------------------------
    // НАЧАЛО - музыка
    private void stopPlay(){
        mPlayer.stop();
        mPlayer1.stop();
        try {
            mPlayer.prepare();
            mPlayer.seekTo(0);
            mPlayer1.prepare();
            mPlayer1.seekTo(0);
        }
        catch (Throwable t) {
            Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPlayer.isPlaying()) {
            stopPlay();
        }
        if (mPlayer1.isPlaying()) {
            stopPlay();
        }
    }
    //КОНЕЦ - музыка
    //---------------------------------------------------


    //кнопка "Назад" для возврата в меню
    @Override
    public void onBackPressed(){
        delay.cancel(true);
        delay=null;
        try{
            Intent intent = new Intent(Level_2.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch(Exception e) {
            }
    }


    //начало работы AsyncTask


    class Delay extends AsyncTask<Void, Integer, Void> {

        @Override
        public Void doInBackground(Void... params) { //считает строки

            while (line<=21){
                if(counterFirstLineChoice==0 & line==9){
                    line=9;
                    if(isCancelled()) return null;
                }else{

                publishProgress(line=line+1);
                    try{
                        Thread.sleep(3000);
                        if(isCancelled()) return null;
                    }catch(Exception e){}
            }}
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) { //показывает строки


            final TextView textView0 = (TextView) findViewById(R.id.textViewTwo0);
            final TextView textView1 = (TextView) findViewById(R.id.textViewTwo1);
            final TextView textView2 = (TextView) findViewById(R.id.textViewTwo2);
            final TextView textView3 = (TextView) findViewById(R.id.textViewTwo3);
            final TextView textView4 = (TextView) findViewById(R.id.textViewTwo4);
            final TextView textView5 = (TextView) findViewById(R.id.textViewTwo5);
            final TextView textView6 = (TextView) findViewById(R.id.textViewTwo6);
            final TextView textView7 = (TextView) findViewById(R.id.textViewTwo7);
            final TextView textView8 = (TextView) findViewById(R.id.textViewTwo8);
            final Button button_yes0 = (Button) findViewById(R.id.button_yes0);
            final Button button_no0 = (Button) findViewById(R.id.button_no0);
            final TextView textView10 = (TextView) findViewById(R.id.textViewTwo10);
            final TextView textView11 = (TextView) findViewById(R.id.textViewTwo11);
            final TextView textView12 = (TextView) findViewById(R.id.textViewTwo12);
            final TextView textView13 = (TextView) findViewById(R.id.textViewTwo13);
            final TextView textView14 = (TextView) findViewById(R.id.textViewTwo14);
            final TextView textView15 = (TextView) findViewById(R.id.textViewTwo15);
            final TextView textView16 = (TextView) findViewById(R.id.textViewTwo16);
            final TextView textView17 = (TextView) findViewById(R.id.textViewTwo17);
            final TextView textView18 = (TextView) findViewById(R.id.textViewTwo18);
            final TextView textView19 = (TextView) findViewById(R.id.textViewTwo19);
            final TextView textView20 = (TextView) findViewById(R.id.textViewTwo20);
            final Button buttonNext = (Button) findViewById(R.id.buttonNext);

            //добавляем анимацию
            final Animation a = AnimationUtils.loadAnimation(Level_2.this, R.anim.ani);

            switch (line){

                case 0: textView0.setVisibility(View.VISIBLE); mPlayer.start(); textView0.startAnimation(a);break;
                case 1: textView1.setVisibility(View.VISIBLE); textView1.startAnimation(a);break;
                case 2: textView2.setVisibility(View.VISIBLE); textView2.startAnimation(a);break;
                case 3: textView3.setVisibility(View.VISIBLE); textView3.startAnimation(a);break;
                case 4: textView4.setVisibility(View.VISIBLE); textView4.startAnimation(a);break;
                case 5: textView5.setVisibility(View.VISIBLE); mPlayer1.start();textView5.startAnimation(a);break;
                case 6: textView6.setVisibility(View.VISIBLE); textView6.startAnimation(a);break;
                case 7: textView7.setVisibility(View.VISIBLE); textView7.startAnimation(a);break;
                case 8: textView8.setVisibility(View.VISIBLE); mPlayer.stop(); textView8.startAnimation(a);break;
                case 9: button_yes0.setVisibility(View.VISIBLE); button_yes0.startAnimation(a);
                            button_yes0.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    try{
                                        if(counterFirstLineChoice==0){
                                        counterFirstLineChoice=1;

                                        }
                                    }catch (Exception e){

                                    }
                                }
                            });

                        button_no0.setVisibility(View.VISIBLE); button_no0.startAnimation(a);
                            button_no0.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    try{
                                        if(counterFirstLineChoice==0) {

                                            counterFirstLineChoice = 1;
                                            textView10.setVisibility(View.GONE);
                                            textView11.setVisibility(View.GONE);
                                            line = line + 2;
                                        }
                                    }catch (Exception e){

                                    }
                                }
                            }); break;

                case 10: textView10.setVisibility(View.VISIBLE); textView10.startAnimation(a);break;
                case 11: textView11.setVisibility(View.VISIBLE); textView11.startAnimation(a);
                         textView12.setVisibility(View.GONE);
                         textView13.setVisibility(View.GONE);
                         line=line+2;break;
                case 12: textView12.setVisibility(View.VISIBLE); textView12.startAnimation(a);break;
                case 13: textView13.setVisibility(View.VISIBLE); textView13.startAnimation(a);break;
                case 14: textView14.setVisibility(View.VISIBLE); textView14.startAnimation(a);mPlayer1.stop();break;
                case 15: textView15.setVisibility(View.VISIBLE); textView15.startAnimation(a);break;
                case 16: textView16.setVisibility(View.VISIBLE); textView16.startAnimation(a);break;
                case 17: textView17.setVisibility(View.VISIBLE); textView17.startAnimation(a);break;
                case 18: textView18.setVisibility(View.VISIBLE); textView18.startAnimation(a);break;
                case 19: textView19.setVisibility(View.VISIBLE); textView19.startAnimation(a);break;
                case 20: textView20.setVisibility(View.VISIBLE); textView20.startAnimation(a);break;
                case 21: buttonNext.setVisibility(View.VISIBLE); buttonNext.startAnimation(a);
                    buttonNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try{
                                Intent intent = new Intent(Level_2.this, Level_3.class);
                                startActivity(intent);
                                finish();
                            } catch(Exception e) {

                            }
                        }
                    });

                default: break;

            }


            //сохранение данных игры - начало
            SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
            final int level = save.getInt("Level",1);//параметр "Level" запоминает значение уровня и передает в перемеенную int level
            if(level>2){

            }else{
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("Level",3);
                editor.commit();
            }
            //сохранение данных игры - конец
        }
    }

}

