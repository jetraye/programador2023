
package Models;


public class Auto {
    int idAuto;
    String modeloAuto;
    int anioAuto;
    int idMarca;
    int puertasAuto;
    int estadoAuto;
    int combusAuto;

    public Auto() {
    }

    public Auto(int idAuto, String modeloAuto, int anioAuto, int idMarca, int puertasAuto, int estadoAuto, int combusAuto) {
        this.idAuto = idAuto;
        this.modeloAuto = modeloAuto;
        this.anioAuto = anioAuto;
        this.idMarca = idMarca;
        this.puertasAuto = puertasAuto;
        this.estadoAuto = estadoAuto;
        this.combusAuto = combusAuto;
    }

    public int getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(int idAuto) {
        this.idAuto = idAuto;
    }

    public String getModeloAuto() {
        return modeloAuto;
    }

    public void setModeloAuto(String modeloAuto) {
        this.modeloAuto = modeloAuto;
    }

    public int getAnioAuto() {
        return anioAuto;
    }

    public void setAnioAuto(int anioAuto) {
        this.anioAuto = anioAuto;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public int getPuertasAuto() {
        return puertasAuto;
    }

    public void setPuertasAuto(int puertasAuto) {
        this.puertasAuto = puertasAuto;
    }

    public int getEstadoAuto() {
        return estadoAuto;
    }

    public void setEstadoAuto(int estadoAuto) {
        this.estadoAuto = estadoAuto;
    }

    public int getCombusAuto() {
        return combusAuto;
    }

    public void setCombusAuto(int combusAuto) {
        this.combusAuto = combusAuto;
    }
    
    
}
