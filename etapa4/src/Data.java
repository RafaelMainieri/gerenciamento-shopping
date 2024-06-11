public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        if (dataValida(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("Data inválida. Definindo a data padrão: 1/1/2000.");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        }
    }

    @Override
    public String toString() {
        return  "Dia=" + dia + "\n" +
                "Mes=" + mes + "\n" +
                "Ano=" + ano;
    }

    public boolean verificaAnoBissexto() {
        if ((this.ano % 4 == 0 && this.ano % 100 != 0) || (this.ano % 100 == 0 && this.ano % 400 == 0)) return true;
        return false;
    }

    private boolean dataValida(int dia, int mes, int ano) {
        // verifica os meses (no maximo 12 [dezembro], e no minimo 1[janeiro])
        if (mes < 1 || mes > 12) {
            return false;
        }
        // verifica os dias (no maximo 31, e no minimo 1)
        if (dia < 1 || dia > 31) {
            return false;
        }

        // verifica os dias de acordo com os meses
        switch (mes) {
            // meses abril, junho, setembro e novembro (acabam no dia 30)
            case 4: case 6: case 9: case 11:
                if (dia > 30) {
                    return false;
                } break;

            // mes fevereiro + verificação bissexto
            case 2:
                if (verificaAnoBissexto()) {
                    if (dia > 29) {
                        return false;
                    }
                } else {
                    if (dia > 28) {
                        return false;
                    }
                } break;

            // resto dos meses
            default:
                if (dia > 31) {
                    return false;
                }
        }
        return true;
    }


    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }


    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }


    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
}
