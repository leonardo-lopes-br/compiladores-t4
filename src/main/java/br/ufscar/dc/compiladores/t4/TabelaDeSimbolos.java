package br.ufscar.dc.compiladores.t4;

// Importações
import java.util.HashMap;
import java.util.Map;
import static br.ufscar.dc.compiladores.t4.ParserUtils_T4.procFuncNome;

// Classe baseada em código disponibilizado de exemplo pelo professor
public class TabelaDeSimbolos {

    private final Map<String, EntradaTabelaDeSimbolos> tabela;
    
    public TabelaDeSimbolos() {
        this.tabela = new HashMap<>();
    }

    public enum Tipos {
        INTEIRO,
        REAL,
        LITERAL,
        LOGICO,
        VOID,
        REGISTRO,
        INVALIDO
    }

    public enum TipoEntrada {
        VARIAVEL,
        PROCEDIMENTO,
        FUNCAO
    }

    static class EntradaTabelaDeSimbolos {
        String nome;
        Tipos tipo;
        TipoEntrada tipoE;

        private EntradaTabelaDeSimbolos(String nome, Tipos tipo, TipoEntrada tipoE) {
            this.nome = nome;
            this.tipo = tipo;
            this.tipoE = tipoE;
        }
    }

    public Tipos verificar(String nome) {
        nome = procFuncNome(nome, "[");
        return tabela.get(nome).tipo;
    }

    public void adicionar(String nome, Tipos tipo, TipoEntrada tipoEntrada) {
        nome = procFuncNome(nome, "[");
        tabela.put(nome, new EntradaTabelaDeSimbolos(nome, tipo, tipoEntrada));
    }    

    public boolean existe(String nome) {
        nome = procFuncNome(nome, "[");
        return tabela.containsKey(nome);
    }
}
