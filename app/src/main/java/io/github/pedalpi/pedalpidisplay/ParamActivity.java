package io.github.pedalpi.pedalpidisplay;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.github.pedalpi.pedalpidisplay.communication.Client;
import io.github.pedalpi.pedalpidisplay.communication.Message;
import io.github.pedalpi.pedalpidisplay.communication.ProtocolType;
import io.github.pedalpi.pedalpidisplay.databinding.ActivityParamBinding;
import io.github.pedalpi.pedalpidisplay.model.Effect;
import io.github.pedalpi.pedalpidisplay.model.Param;

public class ParamActivity extends AppCompatActivity implements Client.OnMessageListener {

    private ActivityParamBinding paramBinding;

    public static final String PARAM = "param";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_param);

        paramBinding = DataBindingUtil.setContentView(this, R.layout.activity_param);
        setParam((Param) getIntent().getExtras().getSerializable(PARAM));

        Client client = Client.getInstance();
        client.setListener(this);
    }

    @Override
    public void onMessage(Message message) {
        if (message.getType() == ProtocolType.PARAM)
            setParam(new Param(message.getContent()));

        else if (message.getType() == ProtocolType.EFFECT)
            goBack(new Effect(message.getContent()));
    }

    public void setParam(Param param) {
        this.paramBinding.setParam(param);
    }

    private void goBack(Effect effect) {
        Client.getInstance().setListener(null);

        Bundle data = new Bundle();
        data.putSerializable(EffectsActivity.EFFECT, effect);

        setResult(Activity.RESULT_OK, new Intent().putExtras(data));
        finish();
    }
}
