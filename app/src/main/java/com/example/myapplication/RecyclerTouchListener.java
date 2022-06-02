package com.example.myapplication;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {
    private ClickListener clickListener;
    private GestureDetector gestureDetector;

    public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener ){
        this.clickListener=clickListener;
        // Monitoreamos las acciones del dedo
        this.gestureDetector= new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {


            @Override
            // método para pulsado simple
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }

            // método para pulsado largo
            @Override
            public void onLongPress(MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if(child!=null && clickListener!=null){
                    clickListener.onLongClick(child,recyclerView.getChildPosition(child));
                }

            }

        });
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        View child = recyclerView.findChildViewUnder(motionEvent.getX(),motionEvent.getY());
        if(child !=null && clickListener!=null && gestureDetector.onTouchEvent(motionEvent)){
            clickListener.onClick(child,recyclerView.getChildAdapterPosition(child));

        }

        return false;

    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {


    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
    public interface ClickListener{
        void onClick(View view , int position);
        void onLongClick(View view, int position);
    }
}