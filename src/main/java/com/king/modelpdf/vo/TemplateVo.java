package com.king.modelpdf.vo;

public class TemplateVo {
    //模板名称
    private String templateName;
    //调用模板次数
    private Integer num;

    public TemplateVo() {
    }

    public TemplateVo(String templateName, Integer num) {
        this.templateName = templateName;
        this.num = num;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
