package ru.kria.quizz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        final  int level = save.getInt("Level", 1);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Button buttonBack = (Button)findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent intent = new Intent(GameLevels.this, MainActivity.class);
                    startActivity(intent);//запуск активности intent
                    finish();//конец активности Intent
                }catch (Exception e){}
            }
        });

        //______________________________________________________________________________________________________

        //кнопка перехода на 1ый уровень
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    if(level>=1) {
                        Intent intent = new Intent(GameLevels.this, Level_1.class);
                        startActivity(intent);
                        finish();
                    }else {

                    }

                }catch (Exception e){}
            }
        });


        //кнопка перехода на 2ой уровень
        TextView textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    if(level>=2) {
                        Intent intent = new Intent(GameLevels.this, Level_2.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){}
            }
        });

        //кнопка перехода на 3ий уровень
        TextView textView3 = (TextView)findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    if(level>=3) {
                        Intent intent = new Intent(GameLevels.this, Level_3.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){}
            }
        });

        //кнопка перехода на 4ый уровень
        TextView textView4 = (TextView)findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    if(level>=4) {
                        Intent intent = new Intent(GameLevels.this, LevelQuizGame.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){}
            }
        });


        //кнопка перехода на 5ый уровень
        TextView textView5 = (TextView)findViewById(R.id.textView5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    if(level>=5) {
                        Intent intent = new Intent(GameLevels.this, LevelQuizGame2.class);
                        startActivity(intent);
                        finish();
                    }else{

                    }
                }catch (Exception e){}
            }
        });



        //________________________________________________________________________________________________




        // массив для замены значков Х на иконках игры на номера
        final int[] x={
                R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4, R.id.textView5,
                R.id.textView6, R.id.textView7, R.id.textView8, R.id.textView9, R.id.textView10
        };
        // цикл замены значков уровней игры
        for(int i=1; i<level; i++){
            TextView tv = findViewById(x[i]);
            tv.setText(""+(i+1));
        }

    }

    //ситсемная кноппка назад
    @Override
    public void onBackPressed(){

        try {
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent);//хапуск активности intent
            finish();//конец активности Intent
        }catch (Exception e){}
    }
}
