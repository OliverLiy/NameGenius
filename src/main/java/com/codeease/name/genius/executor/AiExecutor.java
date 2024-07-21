package com.codeease.name.genius.executor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.codeease.name.genius.config.OkHttpClientSingleton;
import com.codeease.name.genius.constant.ModelConstant;
import com.codeease.name.genius.model.ChatRoleModel;
import com.codeease.name.genius.model.RoleContentModel;
import com.codeease.name.genius.window.ApiSettingState;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.codeease.name.genius.constant.ModelConstant.*;

/**
 * @author by: 神秘的鱼仔
 * @ClassName: AiExecutor
 * @Description: 和AI相关的功能
 * @Date: 2024/7/20 下午11:51
 */
public class AiExecutor {

    public String getMethodNameByOllama(String name,String prompt){
        OkHttpClient client = OkHttpClientSingleton.getInstance();
        ChatRoleModel chatRoleModel = new ChatRoleModel();
        chatRoleModel.setModel(LLAMA);
        chatRoleModel.setStream(false);
        chatRoleModel.setMessages(buildRoleContentModel(name,prompt));
        String api = ApiSettingState.getInstance().api;

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), JSON.toJSONString(chatRoleModel));
        Request request = new Request.Builder()
                .url(api)
                .post(requestBody)
                .build();
        try (Response response = client.newCall(request).execute()) {
            // 处理响应
            if (response.isSuccessful()) {
                ResponseBody responseBody = response.body();
                String string = responseBody.string();
                JSONObject jsonObject = JSON.parseObject(string);
                JSONObject messageJson = jsonObject.getJSONObject(MESSAGE);
                return messageJson.getString(CONTENT);
            } else {
                // 请求失败
                System.out.println("请求失败，响应码: " + response.code());
                return "请求失败，响应码: " + response.code();
            }
        } catch (IOException e) {
            // 发生异常
            e.printStackTrace();
        }
        return "请求失败";

    }

    public static List<RoleContentModel> buildRoleContentModel(String name,String prompt){
        List<RoleContentModel> modelList = new ArrayList<>(initRole(prompt));
        RoleContentModel model = new RoleContentModel();
        model.setRole(ModelConstant.USER_ROLE);
        model.setContent(name);
        modelList.add(model);
        return modelList;
    }

    private static List<RoleContentModel> initRole(String prompt) {
        List<RoleContentModel> initModelList = new ArrayList<>();
        RoleContentModel model = new RoleContentModel();
        model.setRole(ModelConstant.SYSTEM);
        model.setContent(prompt);
        initModelList.add(model);
        return initModelList;
    }
}
