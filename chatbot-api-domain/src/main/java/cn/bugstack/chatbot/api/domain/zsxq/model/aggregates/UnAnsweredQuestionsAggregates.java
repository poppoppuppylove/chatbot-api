package cn.bugstack.chatbot.api.domain.zsxq.model.aggregates;

import cn.bugstack.chatbot.api.domain.zsxq.model.res.RespData;

/**
 * @author 小傅哥，微信：fustack
 * @description 未回答问题的聚合信息
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
//存放聚合模型
/*在领域驱动设计（DDD，Domain-Driven Design）中，聚合（Aggregate）是一种设计模式，用
于封装一组具有共同生命周期的对象。在聚合内部，对象之间可以进行交互，而无需与聚合外部的对象进行交互。这样可以保持代码的封装性和可维护性。
 */
public class UnAnsweredQuestionsAggregates {

    private boolean succeeded;
    private RespData resp_data;

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public RespData getResp_data() {
        return resp_data;
    }

    public void setResp_data(RespData resp_data) {
        this.resp_data = resp_data;
    }

}
