package ru.kria.quizz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.kria.quizz.scenario.Table3;

public class Level_3 extends AppCompatActivity {

    Table3 threeTable = new Table3();
    Delay delay = new Delay();

    public TextView textView0;
    public TextView textView1;
    public TextView textView2;
    public TextView textView3;
    public TextView textView4;
    public TextView textView5;
    public TextView textView6;
    public TextView textView7;
    public TextView textView8;
    public TextView textView9;
    public TextView textView10;
    public TextView textView11;
    public TextView textView12;
    public TextView textView13;
    public ImageView way14;
    public TextView textView15;
    public TextView textView16;
    public TextView textView17;
    public Button buttonBack18;
    public Button buttonToGo19;

    public int line = -1;
    public Animation a;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_3);

        final TextView textView0 = (TextView)findViewById(R.id.textView0);
        final TextView textView1 = (TextView)findViewById(R.id.textViewThree1);
        final TextView textView2 = (TextView)findViewById(R.id.textViewThree2);
        final TextView textView3 = (TextView)findViewById(R.id.textViewThree3);
        final TextView textView4 = (TextView)findViewById(R.id.textViewThree4);
        final TextView textView5 = (TextView)findViewById(R.id.textViewThree5);
        final TextView textView6 = (TextView)findViewById(R.id.textViewThree6);
        final TextView textView7 = (TextView)findViewById(R.id.textViewThree7);
        final TextView textView8 = (TextView)findViewById(R.id.textViewThree8);
        final TextView textView9 = (TextView)findViewById(R.id.textViewThree9);
        final TextView textView10 = (TextView)findViewById(R.id.textViewThree10);
        final TextView textView11 = (TextView)findViewById(R.id.textViewThree11);
        final TextView textView12 = (TextView)findViewById(R.id.textViewThree12);
        final TextView textView13 = (TextView)findViewById(R.id.textViewThree13);
        final ImageView way14 = (ImageView)findViewById(R.id.way14);
        final TextView textView15 = (TextView)findViewById(R.id.textViewThree15);
        final TextView textView16 = (TextView)findViewById(R.id.textViewThree16);
        final TextView textView17 = (TextView)findViewById(R.id.textViewThree17);
        final Button buttonBack18 = (Button)findViewById(R.id.buttonBack18);
        final Button buttonToGo19 = (Button)findViewById(R.id.buttonToGo19);


        textView0.setText(threeTable.three_scenariy[0]);
        textView1.setText(threeTable.three_scenariy[1]);
        textView2.setText(threeTable.three_scenariy[2]);
        textView3.setText(threeTable.three_scenariy[3]);
        textView4.setText(threeTable.three_scenariy[4]);
        textView5.setText(threeTable.three_scenariy[5]);
        textView6.setText(threeTable.three_scenariy[6]);
        textView7.setText(threeTable.three_scenariy[7]);
        textView8.setText(threeTable.three_scenariy[8]);
        textView9.setText(threeTable.three_scenariy[9]);
        textView10.setText(threeTable.three_scenariy[10]);
        textView11.setText(threeTable.three_scenariy[11]);
        textView12.setText(threeTable.three_scenariy[12]);
        textView13.setText(threeTable.three_scenariy[13]);
        // картинка way14
        textView15.setText(threeTable.three_scenariy[14]);
        textView16.setText(threeTable.three_scenariy[15]);
        textView17.setText(threeTable.three_scenariy[16]);
        // кнопки вперед и назад*/


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
        textView9.setVisibility(View.INVISIBLE);
        textView10.setVisibility(View.INVISIBLE);
        textView11.setVisibility(View.INVISIBLE);
        textView12.setVisibility(View.INVISIBLE);
        textView13.setVisibility(View.INVISIBLE);
        way14.setVisibility(View.INVISIBLE);
        textView15.setVisibility(View.INVISIBLE);
        textView16.setVisibility(View.INVISIBLE);
        textView17.setVisibility(View.INVISIBLE);
        buttonBack18.setVisibility(View.INVISIBLE);
        buttonToGo19.setVisibility(View.INVISIBLE);


        //команда для запуска AsyncTack
        delay.execute();//Запуск класса delay
    }


    //кнопка "Назад" для возврата в меню
    @Override
    public void onBackPressed(){
        delay.cancel(true);
        delay=null;
        try{
            Intent intent = new Intent(Level_3.this, MainActivity.class); // говорим что после нажатия на кнопку мы перемещаемся в другое окно - Two_level
            startActivity(intent);
            finish();
        } catch(Exception e) {}
    }


        //начало AsyncTask
    class Delay extends AsyncTask<Void, Integer, Void>{

        @Override
        protected Void doInBackground(Void... params) { // сообщение счета
            while (line<=18){
                publishProgress(line++);
                try {
                    if(isCancelled()) return null;//проверка на нажатие системной кнопки НАЗАД
                    Thread.sleep(500);
                }catch(Exception e){}
            }
            return null;
        }

        protected void onProgressUpdate(Integer... values){ //сообщение показывать


            final TextView textView0 = (TextView)findViewById(R.id.textView0);
            final TextView textView1 = (TextView)findViewById(R.id.textViewThree1);
            final TextView textView2 = (TextView)findViewById(R.id.textViewThree2);
            final TextView textView3 = (TextView)findViewById(R.id.textViewThree3);
            final TextView textView4 = (TextView)findViewById(R.id.textViewThree4);
            final TextView textView5 = (TextView)findViewById(R.id.textViewThree5);
            final TextView textView6 = (TextView)findViewById(R.id.textViewThree6);
            final TextView textView7 = (TextView)findViewById(R.id.textViewThree7);
            final TextView textView8 = (TextView)findViewById(R.id.textViewThree8);
            final TextView textView9 = (TextView)findViewById(R.id.textViewThree9);
            final TextView textView10 = (TextView)findViewById(R.id.textViewThree10);
            final TextView textView11 = (TextView)findViewById(R.id.textViewThree11);
            final TextView textView12 = (TextView)findViewById(R.id.textViewThree12);
            final TextView textView13 = (TextView)findViewById(R.id.textViewThree13);
            final ImageView way14 = (ImageView)findViewById(R.id.way14);
            final TextView textView15 = (TextView)findViewById(R.id.textViewThree15);
            final TextView textView16 = (TextView)findViewById(R.id.textViewThree16);
            final TextView textView17 = (TextView)findViewById(R.id.textViewThree17);
            final Button buttonBack18 = (Button)findViewById(R.id.buttonBack18);
            final Button buttonToGo19 = (Button)findViewById(R.id.buttonToGo19);

            final Animation a = AnimationUtils.loadAnimation(Level_3.this, R.anim.ani);

            switch (line){

                case 0: textView0.setVisibility(View.VISIBLE); textView0.startAnimation(a);break;
                case 1: textView1.setVisibility(View.VISIBLE); textView1.startAnimation(a);break;
                case 2: textView2.setVisibility(View.VISIBLE); textView2.startAnimation(a);break;
                case 3: textView3.setVisibility(View.VISIBLE); textView3.startAnimation(a);break;
                case 4: textView4.setVisibility(View.VISIBLE); textView4.startAnimation(a);break;
                case 5: textView5.setVisibility(View.VISIBLE); textView5.startAnimation(a);break;
                case 6: textView6.setVisibility(View.VISIBLE); textView6.startAnimation(a);break;
                case 7: textView7.setVisibility(View.VISIBLE); textView7.startAnimation(a);break;
                case 8: textView8.setVisibility(View.VISIBLE); textView8.startAnimation(a);break;
                case 9: textView9.setVisibility(View.VISIBLE); textView9.startAnimation(a);break;
                case 10: textView10.setVisibility(View.VISIBLE); textView10.startAnimation(a);break;
                case 11: textView11.setVisibility(View.VISIBLE); textView11.startAnimation(a);break;
                case 12: textView12.setVisibility(View.VISIBLE); textView12.startAnimation(a);break;
                case 13: textView13.setVisibility(View.VISIBLE); textView13.startAnimation(a);break;
                case 14: way14.setVisibility(View.VISIBLE); way14.startAnimation(a);break;
                case 15: textView15.setVisibility(View.VISIBLE); textView15.startAnimation(a);break;
                case 16: textView16.setVisibility(View.VISIBLE); textView16.startAnimation(a);break;
                case 17: textView17.setVisibility(View.VISIBLE); textView17.startAnimation(a);break;
                case 18: buttonToGo19.setVisibility(View.VISIBLE); buttonToGo19.startAnimation(a);

                                buttonToGo19.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        try{
                                            Intent intent = new Intent(Level_3.this, LevelQuizGame.class);
                                            startActivity(intent);
                                            finish();
                                        } catch(Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                         buttonBack18.setVisibility(View.VISIBLE);buttonBack18.startAnimation(a);

                                buttonBack18.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        try{
                                            Intent intent = new Intent(Level_3.this, LevelQuizGame.class);
                                            startActivity(intent);
                                            finish();
                                        } catch(Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });

                default:break;

            }

            //сохранение данных игры - начало
            SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
            final int level = save.getInt("Level",1);//параметр "Level" запоминает значение уровня и передает в перемеенную int level
            if(level>3){

            }else{
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("Level",4);
                editor.commit();
            }
            //сохранение данных игры - конец
        }

    }

}
