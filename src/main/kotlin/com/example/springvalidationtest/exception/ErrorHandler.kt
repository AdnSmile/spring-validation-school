package com.example.springvalidationtest.exception

import com.example.springvalidationtest.dto.response.BaseResponse
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
class ErrorHandler {

    @ExceptionHandler(NotFoundException::class)
    fun notFound(notFoundException: NotFoundException): ResponseEntity<BaseResponse<Any>> {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            BaseResponse(
                status = "F",
                message = notFoundException.message,
                data = null
            )
        )
    }

    @ExceptionHandler(DuplicateException::class)
    fun duplicate(exception: DuplicateException): ResponseEntity<BaseResponse<Any>> {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            BaseResponse(
                status = "F",
                message = exception.message,
                data = null
            )
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleArgumentNotValidException(exception: MethodArgumentNotValidException) : ResponseEntity<Any> {

        val errors = mutableListOf<String>()
        exception.bindingResult.fieldErrors.forEach {
            errors.add(it.defaultMessage!!)
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            BaseResponse(
                status = "F",
                message = exception.message,
                data = null
            )
        )

    }

}