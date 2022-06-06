package kr.co.ffm.system.feeding;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import kr.co.ffm.system.control.ControlServiceImpl;
import kr.co.ffm.system.watertank.Watertank;
import kr.co.ffm.system.watertank.WatertankMapper;
import okhttp3.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class FeedingServiceImpl implements FeedingService {

    @Autowired
    private FeedingMapper feedingMapper;
    @Autowired
    private WatertankMapper watertankMapper;

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    private Logger logger = LogManager.getLogger(ControlServiceImpl.class);

    @Override
    public List<Feeding> viewFeedingList(Watertank watertank) {
        return feedingMapper.selectAll(watertank);
    }

    @Override
    public void receiveFeeding(Feeding feeding) {
        Watertank watertank = new Watertank();
        watertank.setId(feeding.getWatertankId());

        if (watertankMapper.selectById(watertank) != null) {
            feedingMapper.insert(feeding);
        }
    }

    @Override
    public String sendFeeding(Watertank watertank) {
        Watertank controlTank = watertankMapper.selectById(watertank);

        Gson gson = new Gson();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", controlTank.getId());

        // String url = "http://" + controlWatertank.getAgentIpAddress() + "/feeding";
        String url = "http://172.16.28.34/feeding";
        String responseCode = null;

        try {
            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), gson.toJson(jsonObject));

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

            if ("200".equals(responseCode.split(":")[1].split("\"")[1])) {
                logger.info("----------INFO----------");
                logger.info("| Send Control is Success |");
                logger.info("-------------------------");
            } else {
                logger.error("**********ERROR**********");
                logger.error("* " + responseCode.split(":")[2].split("\"")[1] + " *");
                logger.error("*************************");
            }

            logger.info("----------INFO----------");
            logger.info("| " + responseCode + " |");
            logger.info("------------------------");

        } catch (Exception e) {
            logger.info("----------INFO----------");
            logger.info("| Exception Occurred in method sendControl |");
            logger.info("------------------------");
        }

        return responseCode;
    }
}
