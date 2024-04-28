package model;

public class HardWare {
    private Integer idHardWare;
    private String tipo;

    public HardWare(Integer id, String tipo) {
        this.idHardWare = id;
        this.tipo = tipo;
    }

    public HardWare() {
    }

    public Integer getId() {
        return this.idHardWare;
    }

    public void setIdHardWare(Integer id) {
        this.idHardWare = id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        return "\nID do hardware: %d\ntipo: %s\n".formatted(this.idHardWare, this.tipo);
    }
}
