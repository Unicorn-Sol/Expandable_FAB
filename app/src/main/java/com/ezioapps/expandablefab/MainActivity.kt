package com.ezioapps.expandablefab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val rotateOpen:Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open) }
    private val rotateClose:Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_close) }
    private val toBottom:Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.to_bottom) }
    private val fromBottom:Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.from_bottom) }

    private var clicked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_btn.setOnClickListener {
            addClicked()
        }
        edit_btn.setOnClickListener {
            Toast.makeText(this, "Edit Button Clicked!!", Toast.LENGTH_SHORT).show()
        }
        finger_btn.setOnClickListener {
            Toast.makeText(this, "Finger button Clicked!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        setClickable(clicked)
        clicked = !clicked
    }

    private fun setAnimation(clicked : Boolean) {
        if (!clicked){

            edit_btn.startAnimation(fromBottom)
            finger_btn.startAnimation(fromBottom)
            add_btn.startAnimation(rotateOpen)
        }
        else{
            edit_btn.startAnimation(toBottom)
            finger_btn.startAnimation(toBottom)
            add_btn.startAnimation(rotateClose)
        }
    }

    private fun setVisibility(clicked : Boolean) {
        if (!clicked){
            edit_btn.visibility = View.VISIBLE
            add_btn.visibility = View.VISIBLE
        }else
        {
            edit_btn.visibility = View.INVISIBLE
            add_btn.visibility = View.INVISIBLE
        }
    }

    private fun setClickable(clicked: Boolean){
        if (!clicked){
            edit_btn.isClickable = true
            finger_btn.isClickable = true
        }else{
            edit_btn.isClickable = false
            finger_btn.isClickable = false
        }
    }
}