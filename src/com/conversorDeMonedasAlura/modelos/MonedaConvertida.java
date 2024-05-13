package com.conversorDeMonedasAlura.modelos;

public class MonedaConvertida {
    private String base_code;
    private String target_code;
    private double conversion_rate;
    private double conversion_result;

    public MonedaConvertida(Moneda nuevaMoneda) {
        this.base_code=nuevaMoneda.base_code();
        this.target_code=nuevaMoneda.target_code();
        this.conversion_result=Double.valueOf(nuevaMoneda.conversion_result());
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
        return this.conversion_result+" "+this.target_code;
    }
}
