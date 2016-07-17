package io.github.pedalpi.pedalpidisplay;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.github.pedalpi.pedalpidisplay.communication.Client;
import io.github.pedalpi.pedalpidisplay.communication.Message;
import io.github.pedalpi.pedalpidisplay.databinding.ComponentEffectBinding;
import io.github.pedalpi.pedalpidisplay.model.Effect;

public class EffectsActivity extends AppCompatActivity implements Client.OnMessageListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effects);

        ComponentEffectBinding binding = DataBindingUtil.setContentView(this, R.layout.component_effect);
        Effect effect = new Effect(1, "Effect Test");
        binding.setEffect(effect);

        Client client = Client.getInstance();
        client.setListener(this);
        client.connect("10.0.2.2", 10000);
    }

    @Override
    public void onMessage(Message message) {
        Log.i("TEST", message.toString());
    }
}
