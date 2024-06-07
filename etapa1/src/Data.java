public class Data {
    private int dia, mes, ano;

    public Data(int dia, int mes, int ano) {
        if (verificaAnoBissexto() && mes == 2 && dia > 29) {
            System.out.println("Data Inválida");
            this.dia = 1;
            this.mes = 1;
            this.ano = 2000;
        } else {
            if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) && dia > 31) {
                System.out.println("Data Inválida");
                this.dia = 1;
                this.mes = 1;
                this.ano = 2000;
            } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
                System.out.println("Data Inválida");
                this.dia = 1;
                this.mes = 1;
                this.ano = 2000;
            } else if (mes == 2 && dia > 28) {
                System.out.println("Data Inválida");
                this.dia = 1;
                this.mes = 1;
                this.ano = 2000;
            } else {
                this.dia = dia;
                this.mes = mes;
                this.ano = ano;
            }
        }
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

    public boolean verificaAnoBissexto() {
        boolean divisivelPor4 = (this.ano % 4 == 0);
        boolean divisivelPor100 = (this.ano % 100 == 0);
        boolean divisivelPor400 = (this.ano % 400 == 0);

        if ((divisivelPor4 && !divisivelPor100) || (divisivelPor100 && divisivelPor400)) {
            return true;
        } else {
            return false;
        }
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
