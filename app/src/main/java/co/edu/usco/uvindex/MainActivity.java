package co.edu.usco.uvindex;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.design.widget.FloatingActionButton;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ConstraintSet information = new ConstraintSet();
    ConstraintSet full = new ConstraintSet();
    ConstraintSet noti = new ConstraintSet();
    ConstraintLayout mainLayout;
    FloatingActionButton fab, fab2, fab3;
    Boolean estado = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full);

        information.clone(this,R.layout.activity_main);
        noti.clone(this,R.layout.activity_notifi);
        mainLayout=findViewById(R.id.main);
        full.clone(mainLayout);

        fab=findViewById(R.id.fab);
        fab.setOnClickListener(this);

        fab2=findViewById(R.id.fab2);
        fab2.setOnClickListener(this);

        fab3=findViewById(R.id.fab3);
        fab3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.fab){
            TransitionManager.beginDelayedTransition(mainLayout);
            fab2.setVisibility(fab2.getVisibility()==View.VISIBLE?View.GONE:View.VISIBLE);
            fab3.setVisibility(fab3.getVisibility()==View.VISIBLE?View.GONE:View.VISIBLE);
        }

        if(view.getId()==R.id.fab2){
            TransitionManager.beginDelayedTransition(mainLayout);
            //fab3.setVisibility(fab3.getVisibility()==View.VISIBLE?View.GONE:View.VISIBLE);
            if(estado){
                information.applyTo(mainLayout);
            }
            else {
                full.applyTo(mainLayout);
            }
            estado=!estado;

        }

        if (view.getId()==R.id.fab3){
            TransitionManager.beginDelayedTransition(mainLayout);
            //fab.setVisibility(fab.getVisibility()==View.VISIBLE?View.GONE:View.VISIBLE);
            //fab2.setVisibility(fab2.getVisibility()==View.VISIBLE?View.GONE:View.VISIBLE);
            if(estado){
                noti.applyTo(mainLayout);
            }
            else {
                full.applyTo(mainLayout);
            }
            estado=!estado;


        }


    }
}

