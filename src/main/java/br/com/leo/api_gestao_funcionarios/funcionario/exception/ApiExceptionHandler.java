package br.com.leo.api_gestao_funcionarios.funcionario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<ErroResponse> tratarValidacaoException(ValidacaoException exception) {
        return construirResposta(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(FuncionarioNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> tratarFuncionarioNaoEncontradoException(
            FuncionarioNaoEncontradoException exception
    ) {
        return construirResposta(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler(FuncionarioJaExisteException.class)
    public ResponseEntity<ErroResponse> tratarFuncionarioJaExisteException(FuncionarioJaExisteException exception) {
        return construirResposta(HttpStatus.CONFLICT, exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponse> tratarException(Exception exception) {
        return construirResposta(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno inesperado.");
    }

    private ResponseEntity<ErroResponse> construirResposta(HttpStatus status, String mensagem) {
        return ResponseEntity
                .status(status)
                .body(new ErroResponse(status.value(), mensagem, LocalDateTime.now()));
    }

    private record ErroResponse(
            int status,
            String mensagem,
            LocalDateTime dataHora
    ) {
    }
}
