package io.github.pedalpi.pedalpidisplay;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.github.pedalpi.pedalpidisplay.databinding.ComponentEffectBinding;
import io.github.pedalpi.pedalpidisplay.model.Effect;

public class EffectsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effects);

        ComponentEffectBinding binding = DataBindingUtil.setContentView(this, R.layout.component_effect);
        Effect effect = new Effect(1, "Effect Test");
        binding.setEffect(effect);
    }
}
