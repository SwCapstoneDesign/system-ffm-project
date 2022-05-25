package kr.co.ffm.system.control;

import com.google.gson.Gson;
import kr.co.ffm.system.watertank.Watertank;
import kr.co.ffm.system.watertank.WatertankMapper;
import okhttp3.*;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class ControlServiceImpl implements ControlService {

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    @Autowired
    private WatertankMapper watertankMapper;

    @Override
    public String sendControl(Watertank watertank, Control control) {
        Watertank controlWatertank = watertankMapper.selectById(watertank);
        Gson gson = new Gson();

        String url = "http://" + controlWatertank.getAgentIpAddress() + "/agent";
        String responseCode = null;

        try {
            RequestBody body = RequestBody.create(gson.toJson(control), JSON);

            OkHttpClient client = new OkHttpClient()
                    .newBuilder()
                    .readTimeout(1, TimeUnit.MINUTES)
                    .build();

            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                responseCode = response.body() != null
                        ? response.body().string()
                        : null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseCode;
    }
}
