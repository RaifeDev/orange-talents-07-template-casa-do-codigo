package br.com.zupacademy.casadocodigo.entities.respostasDto;

public class ValidationErrorResponse {

    private Integer status;
    private String mensagem;
    private String campo;

    public ValidationErrorResponse(Integer status, String mensagem, String campo) {
        this.status = status;
        this.mensagem = mensagem;
        this.campo = campo;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getCampo() {
        return campo;
    }
}
