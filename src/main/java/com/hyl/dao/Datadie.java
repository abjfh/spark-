package com.hyl.dao;

import java.io.Serializable;

/**
 *
 */

public class Datadie implements Serializable {

    public Datadie() {
    }

    /**
     *
     */

    private Integer bianh;

    @Override
    public String toString() {
        return "Datadie{" +
                "bianh=" + bianh +
                ", com_name='" + com_name + '\'' +
                ", com_addr='" + com_addr + '\'' +
                ", cat='" + cat + '\'' +
                ", se_cat='" + se_cat + '\'' +
                ", com_des='" + com_des + '\'' +
                ", born_data='" + born_data + '\'' +
                ", death_data='" + death_data + '\'' +
                ", live_days=" + live_days +
                ", financing='" + financing + '\'' +
                ", total_money=" + total_money +
                ", death_reason='" + death_reason + '\'' +
                ", invest_name='" + invest_name + '\'' +
                ", ceo_name='" + ceo_name + '\'' +
                ", ceo_des='" + ceo_des + '\'' +
                '}';
    }

    public Datadie(Integer bianh, String com_name, String com_addr, String cat, String se_cat, String com_des, String born_data, String death_data, Integer live_days, String financing, Integer total_money, String death_reason, String invest_name, String ceo_name, String ceo_des) {
        this.bianh = bianh;
        this.com_name = com_name;
        this.com_addr = com_addr;
        this.cat = cat;
        this.se_cat = se_cat;
        this.com_des = com_des;
        this.born_data = born_data;
        this.death_data = death_data;
        this.live_days = live_days;
        this.financing = financing;
        this.total_money = total_money;
        this.death_reason = death_reason;
        this.invest_name = invest_name;
        this.ceo_name = ceo_name;
        this.ceo_des = ceo_des;
    }

    /**
     *
     */


    private String com_name;
    /**
     *
     */


    private String com_addr;
    /**
     *
     */


    private String cat;
    /**
     *
     */


    private String se_cat;
    /**
     *
     */


    private String com_des;
    /**
     *
     */


    private String born_data;
    /**
     *
     */


    private String death_data;
    /**
     *
     */

    private Integer live_days;
    /**
     *
     */


    private String financing;
    /**
     *
     */

    private Integer total_money;
    /**
     *
     */


    private String death_reason;
    /**
     *
     */

    private String invest_name;
    /**
     *
     */
    private String ceo_name;
    /**
     *
     */
    private String ceo_des;

    public Integer getBianh() {
        return bianh;
    }

    public void setBianh(Integer bianh) {
        this.bianh = bianh;
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public String getCom_addr() {
        return com_addr;
    }

    public void setCom_addr(String com_addr) {
        this.com_addr = com_addr;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getSe_cat() {
        return se_cat;
    }

    public void setSe_cat(String se_cat) {
        this.se_cat = se_cat;
    }

    public String getCom_des() {
        return com_des;
    }

    public void setCom_des(String com_des) {
        this.com_des = com_des;
    }

    public String getBorn_data() {
        return born_data;
    }

    public void setBorn_data(String born_data) {
        this.born_data = born_data;
    }

    public String getDeath_data() {
        return death_data;
    }

    public void setDeath_data(String death_data) {
        this.death_data = death_data;
    }

    public Integer getLive_days() {
        return live_days;
    }

    public void setLive_days(Integer live_days) {
        this.live_days = live_days;
    }

    public String getFinancing() {
        return financing;
    }

    public void setFinancing(String financing) {
        this.financing = financing;
    }

    public Integer getTotal_money() {
        return total_money;
    }

    public void setTotal_money(Integer total_money) {
        this.total_money = total_money;
    }

    public String getDeath_reason() {
        return death_reason;
    }

    public void setDeath_reason(String death_reason) {
        this.death_reason = death_reason;
    }

    public String getInvest_name() {
        return invest_name;
    }

    public void setInvest_name(String invest_name) {
        this.invest_name = invest_name;
    }

    public String getCeo_name() {
        return ceo_name;
    }

    public void setCeo_name(String ceo_name) {
        this.ceo_name = ceo_name;
    }

    public String getCeo_des() {
        return ceo_des;
    }

    public void setCeo_des(String ceo_des) {
        this.ceo_des = ceo_des;
    }
}
