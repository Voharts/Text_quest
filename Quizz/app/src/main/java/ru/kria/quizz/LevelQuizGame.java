package ru.kria.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class LevelQuizGame extends AppCompatActivity {

    Dialog dialog;

    Dialog dialogEnd;

    public int numLeft; //переменная для левой картинки
    public int numRight; //переменная для правой картинки

    ArrayImg array = new ArrayImg(); //создали обьект класса ArrayImg

    Random random = new Random(); //генерация случайных чисел

    public int count=0; //счетчик правильных ответов


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        TextView text_levels=findViewById(R.id.text_levels);
        text_levels.setText(R.string.level1);

        final ImageView imgLeft = (ImageView)findViewById(R.id.imgLeft);
        final ImageView imgRight = (ImageView)findViewById(R.id.imgRight);

        //код для закругления углов
        imgLeft.setClipToOutline(true);
        imgRight.setClipToOutline(true);

        //путь к левой TextView
        final TextView text_left = findViewById(R.id.text_left);
        //путь к правой TextView
        final TextView text_right = findViewById(R.id.text_right);


        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        //вызов диалогового окна - начало
        dialog = new Dialog(this);//создаем новое диалогое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок окна
        dialog.setContentView(R.layout.previewdialog);//путь к макету окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон окна
        dialog.setCancelable(false);//окно нельзя закрыть кнопкой назад

        //кнопака закрытия окна
        TextView btn_close = (TextView)dialog.findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //обработка нажатия
                try{
                    //вернуться к выбопу уровня
                    Intent intent = new Intent(LevelQuizGame.this, GameLevels.class);
                    startActivity(intent);
                    finish(); //закрыть этот класс
                }catch(Exception e){}

                dialog.dismiss(); // закрываем окно
            }
        });


        //кнопка продолжить
        Button btn_continue = (Button)dialog.findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();//показать окно

        //вызов диалогового окна - конец

        //_____________________________________________

        //вызов диалогового окна в конце игры - начало
        dialogEnd = new Dialog(this);//создаем новое диалогое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок окна
        dialogEnd.setContentView(R.layout.dialogend);//путь к макету окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон окна
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);//для развертывая на весь экран
        dialogEnd.setCancelable(false);//окно нельзя закрыть кнопкой назад

        //кнопака закрытия окна
        TextView btn_close2 = (TextView)dialogEnd.findViewById(R.id.btn_close);
        btn_close2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //обработка нажатия
                try{
                    //вернуться к выбопу уровня
                    Intent intent = new Intent(LevelQuizGame.this, GameLevels.class);
                    startActivity(intent);
                    finish(); //закрыть этот класс
                }catch(Exception e){}

                dialogEnd.dismiss(); // закрываем окно
            }
        });


        //кнопка продолжить
        Button btn_continue2 = (Button)dialogEnd.findViewById(R.id.btn_continue);
        btn_continue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               try{
                   Intent intent = new Intent(LevelQuizGame.this, LevelQuizGame2.class);
                   startActivity(intent);
                   finish();
               }catch (Exception e){}
               dialogEnd.dismiss();
            }
        });


        //вызов диалогового окна в конце игры - конец

        //_____________________________________________



        //кнопка назад
        Button buttonBack = (Button)findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //вернуться назад к выбору уровня
                    Intent intent = new Intent(LevelQuizGame.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){}
            }
        });


        //массив прогресса игры
        final int[] progress={R.id.point1,R.id.point2,R.id.point3,R.id.point4,R.id.point5,R.id.point6,R.id.point7,R.id.point8,R.id.point9,R.id.point10};



        //Подключаем анимацию
        final Animation a = AnimationUtils.loadAnimation(LevelQuizGame.this, R.anim.alpha);

        numLeft = random.nextInt(10); //генерируем число от 0 до 9
        imgLeft.setImageResource(array.images1[numLeft]); //достаем из массива картинку
        text_left.setText(array.text1[numLeft]); //достаем из массива текст

        numRight =random.nextInt(10);

        //Цикл проверки равенства чисел для избежания невыполнимой операции
        while (numLeft==numRight){
            numRight =random.nextInt(10);
        }

        imgRight.setImageResource(array.images1[numRight]); //Достаем из массива картинку
        text_right.setText(array.text1[numRight]);// досмтаем из массива текст

        //обработка нажатия на ЛЕВУЮ картинку - начало
        imgLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                //условия касания картинку
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    //если коснулся картинки - начало
                    imgRight.setEnabled(false);
                    if(numLeft>numRight){
                        imgLeft.setImageResource(R.drawable.marktrue);
                    }else{
                        imgLeft.setImageResource(R.drawable.markfalse);
                    }
                    //если коснулся картинки - конец
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    //есди отпустил палец
                    if(numLeft>numRight){
                        //если левая картинка больше
                        if(count<10){
                            count=count+1;
                        }

                        //закрашиваем прогресс серым цветом - начало
                        for (int i=0; i<10; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом - конец

                        //определяем пральный ответ и закрашиваем зеленым - начало
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем пральный ответ и закрашиваем зеленым - конец
                    }else{
                        //если левая картинка меньше
                        if (count>0){
                            if(count==1){
                                count=0;
                            }else{
                                count=count-2;
                            }
                        }
                        //закрашиваем прогресс серым цветом - начало
                        for (int i=0; i<9; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом - конец

                        //определяем пральный ответ и закрашиваем зеленым - начало
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем пральный ответ и закрашиваем зеленым - конец
                    }

                    if(count==10){
                        //сохранение данных игры - начало
                        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                        final int level = save.getInt("Level",1);//параметр "Level" запоминает значение уровня и передает в перемеенную int level
                        if(level>1){

                        }else{
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level",5);
                            editor.commit();
                        }
                        //сохранение данных игры - конец
                        dialogEnd.show(); // показать диалоговое окно для выхода из уровня

                    }else{
                        numLeft = random.nextInt(10); //генерируем число от 0 до 9
                        imgLeft.setImageResource(array.images1[numLeft]); //достаем из массива картинку
                        imgLeft.startAnimation(a);
                        text_left.setText(array.text1[numLeft]); //достаем из массива текст

                        numRight =random.nextInt(10);

                        //Цикл проверки равенства чисел для избежания невыполнимой операции
                        while (numLeft==numRight){
                            numRight =random.nextInt(10);
                        }

                        imgRight.setImageResource(array.images1[numRight]); //Достаем из массива картинку
                        imgRight.startAnimation(a);
                        text_right.setText(array.text1[numRight]);// досмтаем из массива текст

                        imgRight.setEnabled(true);//включаем обратно правую картинку
                    }

                }

                return true;
            }
        });
        //обработка нажатия на ЛЕВУЮ картинку - конец

        //обработка нажатия на ПРАВУЮ картинку - начало
        imgRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                //условия касания картинку
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    //если коснулся картинки - начало
                    imgLeft.setEnabled(false);
                    if(numRight>numLeft){
                        imgRight.setImageResource(R.drawable.marktrue);
                    }else{
                        imgRight.setImageResource(R.drawable.markfalse);
                    }
                    //если коснулся картинки - конец
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    //есди отпустил палец
                    if(numRight>numLeft){
                        //если правая картинка больше
                        if(count<10){
                            count=count+1;
                        }

                        //закрашиваем прогресс серым цветом - начало
                        for (int i=0; i<10; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом - конец

                        //определяем пральный ответ и закрашиваем зеленым - начало
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем пральный ответ и закрашиваем зеленым - конец
                    }else{
                        //если правая картинка меньше
                        if (count>0){
                            if(count==1){
                                count=0;
                            }else{
                                count=count-2;
                            }
                        }
                        //закрашиваем прогресс серым цветом - начало
                        for (int i=0; i<9; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом - конец

                        //определяем пральный ответ и закрашиваем зеленым - начало
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем пральный ответ и закрашиваем зеленым - конец
                    }

                    if(count==10){
                        //сохранение данных игры - начало
                        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                        final int level = save.getInt("Level",1);//параметр "Level" запоминает значение уровня и передает в перемеенную int level
                        if(level>1){

                        }else{
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level",5);
                            editor.commit();
                        }
                        //сохранение данных игры - конец
                        dialogEnd.show(); // показать диалоговое окно для выхода из уровня

                    }else{
                        numLeft = random.nextInt(10); //генерируем число от 0 до 9
                        imgLeft.setImageResource(array.images1[numLeft]); //достаем из массива картинку
                        imgLeft.startAnimation(a);
                        text_left.setText(array.text1[numLeft]); //достаем из массива текст

                        numRight =random.nextInt(10);

                        //Цикл проверки равенства чисел для избежания невыполнимой операции
                        while (numLeft==numRight){
                            numRight =random.nextInt(10);
                        }

                        imgRight.setImageResource(array.images1[numRight]); //Достаем из массива картинку
                        imgRight.startAnimation(a);
                        text_right.setText(array.text1[numRight]);// досмтаем из массива текст

                        imgLeft.setEnabled(true);//включаем обратно левую картинку
                    }

                }

                return true;
            }
        });
        //обработка нажатия на ЛЕВУЮ картинку - конец
    }
    //системная кнопка назад
    @Override
    public void onBackPressed(){
        try {
            //вернуться назад к выбору уровня
            Intent intent = new Intent(LevelQuizGame.this, GameLevels.class);
            startActivity(intent);
            finish();
        }catch (Exception e){}
    }
}
