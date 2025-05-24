package com.jonhvtr.domain;

import com.google.gson.annotations.SerializedName;
import com.jonhvtr.domain.dto.ConversorDTO;

public class ConversorDomain {
    @SerializedName("base_code")
    private String base_code;
    @SerializedName("target_code")
    private String target_code;
    @SerializedName("conversion_rate")
    private double conversion_rate;
    @SerializedName("conversion_result")
    private double conversion_result;

    public ConversorDomain() {
    }

    public ConversorDomain(String base_code, String target_code, double conversion_rate, double conversion_result) {
        this.base_code = base_code;
        this.target_code = target_code;
        this.conversion_rate = conversion_rate;
        this.conversion_result = conversion_result;
    }

    public ConversorDomain(ConversorDTO conversorDTO) {
        this.base_code = conversorDTO.base_code();
        this.target_code = conversorDTO.target_code();
        this.conversion_rate = conversorDTO.conversion_rate();
        this.conversion_result = conversorDTO.conversion_result();
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }

    public void setConversion_rate(double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public double getConversion_result() {
        return conversion_result;
    }

    public void setConversion_result(double conversion_result) {
        this.conversion_result = conversion_result;
    }

    @Override
    public String toString() {
        return "ConversorDomain{" +
                "base_code='" + base_code + '\'' +
                ", target_code='" + target_code + '\'' +
                ", conversion_rate=" + conversion_rate +
                ", conversion_result=" + conversion_result +
                '}';
    }
}
