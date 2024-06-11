import java.util.Arrays;

public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    public Shopping(String nome, Endereco endereco, int qntdMaxLojas) {
        this.nome = nome;
        this.endereco = endereco;
        this.lojas = new Loja[qntdMaxLojas];
    }

    @Override
    public String toString() {
        return "Shopping(nome = " + nome + ", endereco = " + endereco +", lojas = " + Arrays.toString(lojas) + ")";
    }

    public boolean insereLoja(Loja loja) {
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] == null) {
                lojas[i] = loja;
                return true;
            }
        }
        return false;
    }

    public boolean removeLoja(String nomeLoja) {
        for (int i = 0; i < lojas.length; i++) {
            Loja loja = lojas[i];
            if (loja != null && loja.getNome().equals(nomeLoja)) {
                lojas[i] = null;
                return true;
            }
        }
        return false;
    }

    public int quantidadeLojasPorTipo(String tipoLoja) {
        int contador = 0;

        // se o tipoLoja nao for nenhuma loja existente, retorna -1
        if (tipoLoja == null) {
            return -1;
        }

        // loop para evitar erro nullPointer, onde caso tenha algum espaço em branco na lista, ele é pulado
        for (int i = 0; i < lojas.length; i++) {
            if (lojas[i] == null) {
                continue;
            }

            // verifica do tipo da loja e incrementa o contador caso a loja seja uma instancia da loja informada
            switch (tipoLoja.toLowerCase()) {
                case "cosmético":
                    if (lojas[i] instanceof Cosmetico) {
                        contador++;
                    }
                    break;
                case "vestuário":
                    if (lojas[i] instanceof Vestuario) {
                        contador++;
                    }
                    break;
                case "bijuteria":
                    if (lojas[i] instanceof Bijuteria) {
                        contador++;
                    }
                    break;
                case "alimentação":
                    if (lojas[i] instanceof Alimentacao) {
                        contador++;
                    }
                    break;
                case "informática":
                    if (lojas[i] instanceof Informatica) {
                        contador++;
                    }
                    break;
                default:
                    return -1;
            }
        }
        return contador;
    }

    public Informatica lojaSeguroMaisCaro() {
        Informatica lojaSeguroMaisCaro = null;
        double seguroMaisCaro = 0;

        for (Loja loja : lojas) {
            if (loja instanceof Informatica) {
                Informatica lojaInformatica = (Informatica) loja;
                double seguroAtual = lojaInformatica.getSeguroEletronicos();
                if (seguroAtual > seguroMaisCaro) {
                    lojaSeguroMaisCaro = lojaInformatica;
                    seguroMaisCaro = seguroAtual;
                }
            }
        }
        return lojaSeguroMaisCaro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }
}
