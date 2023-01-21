package br.com.projeto.springComMongoDb.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Colaborador {

    @Id
    private String codigo;
    private String nome;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd/MM/yyyy")
    private LocalDate dataNascimento;
    private BigDecimal salario;

    @DBRef
    private Colaborador supervisor;

    public Colaborador() {
    }

    private Colaborador(String codigo, String nome, LocalDate dataNascimento, BigDecimal salario, Colaborador supervisor) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
        this.supervisor = supervisor;
    }

    public static class ColaboradorBuilder {

        private String codigo;
        private String nome;
        private LocalDate dataNascimento;
        private BigDecimal salario;
        private Colaborador supervisor;

        public ColaboradorBuilder comCodigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        public ColaboradorBuilder comNome(String nome) {
            this.nome = nome;
            return this;
        }

        public ColaboradorBuilder comDataNascimento(LocalDate dataNascimento) {
            this.dataNascimento = dataNascimento;
            return this;
        }

        public ColaboradorBuilder comSalario(BigDecimal salario) {
            this.salario = salario;
            return this;
        }

        public ColaboradorBuilder comSupervisor(Colaborador supervisor) {
            this.supervisor = supervisor;
            return this;
        }

        public Colaborador construir() {
            return new Colaborador(codigo, nome, dataNascimento, salario, supervisor);
        }

    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public BigDecimal getSalario() {
        return this.salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Colaborador getSupervisor() {
        return this.supervisor;
    }

    public void setSupervisor(Colaborador supervisor) {
        this.supervisor = supervisor;
    }

    public Colaborador codigo(String codigo) {
        setCodigo(codigo);
        return this;
    }

    public Colaborador nome(String nome) {
        setNome(nome);
        return this;
    }

    public Colaborador dataNascimento(LocalDate dataNascimento) {
        setDataNascimento(dataNascimento);
        return this;
    }

    public Colaborador salario(BigDecimal salario) {
        setSalario(salario);
        return this;
    }

    public Colaborador supervisor(Colaborador supervisor) {
        setSupervisor(supervisor);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Colaborador)) {
            return false;
        }
        Colaborador colaborador = (Colaborador) o;
        return Objects.equals(codigo, colaborador.codigo) && Objects.equals(nome, colaborador.nome) && Objects.equals(dataNascimento, colaborador.dataNascimento) && Objects.equals(salario, colaborador.salario) && Objects.equals(supervisor, colaborador.supervisor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, dataNascimento, salario, supervisor);
    }

    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", nome='" + getNome() + "'" +
            ", dataNascimento='" + getDataNascimento() + "'" +
            ", salario='" + getSalario() + "'" +
            ", supervisor='" + getSupervisor() + "'" +
            "}";
    }
    
}
