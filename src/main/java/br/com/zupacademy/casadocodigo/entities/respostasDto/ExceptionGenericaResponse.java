package br.com.zupacademy.casadocodigo.entities.respostasDto;

import java.time.LocalDateTime;

public class ExceptionGenericaResponse {

    private Integer status;
    private String mensagem;
    private LocalDateTime time;

    public ExceptionGenericaResponse(Integer status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
        this.time = LocalDateTime.now();
    }

    public Integer getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
