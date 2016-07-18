package io.github.pedalpi.pedalpidisplay;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.github.pedalpi.pedalpidisplay.communication.Client;
import io.github.pedalpi.pedalpidisplay.communication.Message;
import io.github.pedalpi.pedalpidisplay.communication.ProtocolType;
import io.github.pedalpi.pedalpidisplay.databinding.ComponentEffectBinding;
import io.github.pedalpi.pedalpidisplay.model.Effect;
import io.github.pedalpi.pedalpidisplay.model.Param;

public class EffectsActivity extends AppCompatActivity implements Client.OnMessageListener {

    private ComponentEffectBinding effectComponent;

    public static final String EFFECT = "effect";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effects);

        this.effectComponent = DataBindingUtil.setContentView(this, R.layout.component_effect);

        Client client = Client.getInstance();
        client.setListener(this);
        client.connect("10.0.2.2", 10000);
    }

    @Override
    public void onMessage(Message message) {
        if (message.getType() == ProtocolType.EFFECT)
            setEffect(new Effect(message.getContent()));

        else if (message.getType() == ProtocolType.PARAM)
            goToParamActivity(new Param(message.getContent()));
    }

    private void setEffect(Effect effect) {
        effectComponent.setEffect(effect);
    }

    private void goToParamActivity(Param param) {
        Client.getInstance().setListener(null);

        Bundle data = new Bundle();
        data.putSerializable(ParamActivity.PARAM, param);

        Intent intent = new Intent(this, ParamActivity.class).putExtras(data);

        startActivityForResult(intent, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Client.getInstance().setListener(this);
        Effect effect = (Effect) data.getExtras().getSerializable(EFFECT);
        setEffect(effect);
    }
}
