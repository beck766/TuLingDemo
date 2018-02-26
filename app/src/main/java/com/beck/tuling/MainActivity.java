package com.beck.tuling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.beck.tuling.contract.ChatContract;
import com.beck.tuling.model.http.entity.TuLingResponse;
import com.beck.tuling.presenter.ChatPresenter;
import com.beck.tuling.view.adapter.ChatMessageAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ChatContract.View {

    @BindView(R.id.et_send_message)
    EditText etSendMessage;

    @BindView(R.id.list_item)
    ListView listItem;

    private ChatContract.Presenter presenter;
    private ChatMessageAdapter chatMessageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new ChatPresenter(this,this);
        presenter.subscribe();
    }

    @OnClick(R.id.bt_send_message)
    public void onViewClicked() {
        String toMsg = etSendMessage.getText().toString();
        if (TextUtils.isEmpty(toMsg)) {
            Toast.makeText(MainActivity.this, "请输入你想对小希说的话",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        presenter.input(etSendMessage.getText().toString());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void setPresenter(ChatContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public ChatContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void displayMessage(List<TuLingResponse> tuLingResponses) {
        ChatMessageAdapter chatMessageAdapter = new ChatMessageAdapter(this, tuLingResponses);
        listItem.setAdapter(chatMessageAdapter);
    }
}
