package com.example.matheusssantos35.promoum;

import android.animation.ArgbEvaluator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.mes, "PROMOÇÃO DE MAIO", "Confira as promoções do mês de maio!"));
        models.add(new Model(R.drawable.bannerpromocao,"EVENTOS","Venha há SmokeHoot curtir MC João"));
        models.add(new Model(R.drawable.fidelidad, "FIDELIDADE", "Junta 10 cupons e ganha uma seção gratis"));
        models.add(new Model(R.drawable.cupons, "CUPONS DE DESCONTO", "Ganhe cupons de desconto nas compras na nossa tabaria"));


        adapter = new Adapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);


        Integer[] colors_temp = {
                getResources().getColor(R.color.color5),
                getResources().getColor(R.color.color9),
                getResources().getColor(R.color.color7),
                getResources().getColor(R.color.color8)
        };
        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                if (i < (adapter.getCount() - 1) && i < (colors.length - 1)) {
                    viewPager.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(
                                    v,
                                    colors[i],
                                    colors[i + 1]
                            )
                    );
                } else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);

                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }
}
