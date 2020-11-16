package com.navita.test.desafioApiNavita.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErroResp {

    String message;
    HttpStatus status;
}
